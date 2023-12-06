package br.com.alura.ceep.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.migrations.migration_1_2
import br.com.alura.ceep.model.Nota

private const val TAG = "AppDatabase"
@Database(
    version = 2,
    entities = [Nota::class],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notaDao(): NotaDao

    companion object {
        @Volatile
        private var db: AppDatabase? = null

        fun instancia(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "ceep.db"
                ).addMigrations(migration_1_2)
                    .build()
        }
    }

}