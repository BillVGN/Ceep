package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

    private val client by lazy {
        val logger = HttpLoggingInterceptor()
        logger.level = BASIC
        OkHttpClient.Builder().addInterceptor(logger).build()
    }


    private val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://192.168.0.27:8080/") /* prompt */
        .baseUrl("http://172.20.19.159:8080/") /* wsl (atualiza toda vez */
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val notaService = retrofit.create(NotaService::class.java)
}