package store.www.listajogadores.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import store.www.listajogadores.R



import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

import store.www.listajogadores.model.ListJogador
import store.www.listajogadores.services.RetrofitInitializer
import store.www.listajogadores.ui.activities.adapters.JogadorAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getListaTime()
    }

    fun getListaTime(){

        var s = RetrofitInitializer().serviceJogadores()

        var call = s.getjogadores()

        call.enqueue(object: retrofit2.Callback<ListJogador>{

            override fun onResponse(call: Call<ListJogador>?, response: Response<ListJogador>?) {

                response.let {

                    if(it!!.code() == 200){

                        lista.adapter = JogadorAdapter(this@MainActivity, it.body().lista)

                    }

                }

            }

            override fun onFailure(call: Call<ListJogador>?, t: Throwable?) {

                Toast.makeText(this@MainActivity, "Erro!!!", Toast.LENGTH_LONG).show()

            }

        })

    }
}