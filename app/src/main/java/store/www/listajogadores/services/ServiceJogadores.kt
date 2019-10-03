package store.www.listajogadores.services


import retrofit2.Call
import retrofit2.http.GET
import store.www.listajogadores.model.ListJogador



interface ServiceJogadores {


        @GET("jogador/lista")
        fun getjogadores(): Call<ListJogador>
    }
