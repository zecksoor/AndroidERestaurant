package fr.isen.mairel.androiderestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class MenuAdapter(private val dishes: ArrayList<String>) :  //val onDishClickListener: () -> Unit)
    RecyclerView.Adapter<MenuAdapter.LunchViewHolder>() {  //LunchViewHolder remplace recyclerView

    class LunchViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val dishName : TextView = view.findViewById(R.id.dishName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell,parent,false)
        return LunchViewHolder(view)
    }

    override fun getItemCount(): Int = dishes.size

    override fun onBindViewHolder(holder: LunchViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishName.text = dish


    }


    /**
     *
     * //val textPlat = findViewById<TextView>(R.id.textPlat) grace a binding cette ligne degage
    binding.textPlat.setOnClickListener{
    // Code pour créer une nouvelle page ou activité
    val intent = Intent(this, MenuActivity::class.java)
    startActivity(intent)
    }
     */

}