package store.www.listajogadores.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import store.www.listajogadores.app.AulaRetrofitApp
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    companion object {
        private val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().also {  it.level = HttpLoggingInterceptor.Level.BODY })
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
        }

    }


    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(AulaRetrofitApp.URL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
 //   nossaaaaa
    // fun serviceTime(): ServiceTime {
 //       return retrofit.create(ServiceTime::class.java)
   // }

   fun serviceJogadores(): ServiceJogadores {
       return retrofit.create(ServiceJogadores::class.java)
   }


}