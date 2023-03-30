package fr.isen.mairel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.mairel.androiderestaurant.databinding.ActivityMenuBinding
import org.json.JSONObject
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.mairel.androidrestaurant.model.DataResul

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding  // Le prof a appeler Category a la place de Menu


    private lateinit var categoryTitle: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishes = resources.getStringArray(R.array.dishes).toList() as ArrayList // Dishes = plats en français
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)  // Tout en linéaire
        binding.menuRecyclerView.adapter = MenuAdapter(dishes)

        categoryTitle = intent.getStringExtra("menu").toString()
        //{
         //   val intent = Intent(this,DetailActivity::class.java)
        //    intent.putExtra("dish",it)
        //startActivity(intent)
       // }


        //holder.itemView.setOnClickListener{
           // val intent = Intent(this, DetailActivity::class.java)
         //   startActivity(intent)

        //binding.MenuActivity
        fetchMenuItems()

    }


    private fun fetchMenuItems() {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val requestBody = JSONObject().apply {
            put("id_shop", 1)
        }

        val request = JsonObjectRequest(Request.Method.POST, url, requestBody,
            { response ->
                // Traitement de la réponse JSON

                Log.d("MenuActivity", "ça marche : $response" )
                val data = Gson().fromJson(response.toString(), DataResul::class.java)
                val dishes = data.data.firstOrNull {

                    it.nameFr == categoryTitle
                }?.items?.map { it.nameFr ?: "" }?.toList() as ArrayList
                (binding.menuRecyclerView.adapter as MenuAdapter).updateDishes(dishes)

                //val data = Gson().fromJson(response.toString(), DataResult::class.java)
               // val dishes = data.data.firstOrNull{it.nameFr == categoryTitle}?.items?.map{it.nameFr ?: ""}?.toList() as ArrayList //filtrer par categorie ici (a faire)
               // (binding.menuRecyclerView.adapter as MenuAdapter).updateDishes(dishes)

            },
            { error ->
                // Traitement de l'erreur
                Log.d("MenuActivity",error.toString())
            })

        Volley.newRequestQueue(this).add(request)
    }
}