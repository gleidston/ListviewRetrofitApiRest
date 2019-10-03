package store.www.listajogadores.ui.activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import store.www.listajogadores.R
import store.www.listajogadores.model.Jogador

class JogadorAdapter(var context: Context, var lista: List<Jogador>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflater.inflate(R.layout.item_jogador, null)

        var escudo = view.findViewById<ImageView>(R.id.foto)
        var nome = view.findViewById<TextView>(R.id.nome)
        var estado = view.findViewById<TextView>(R.id.time)

        nome.text = lista[position].nome
        estado.text = lista[position].time

        Glide.with(context)
            .load(lista[position].foto)
            .into(escudo)

        return view

    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return lista.size
    }
}