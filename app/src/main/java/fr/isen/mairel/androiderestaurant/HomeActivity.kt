/**
 * action :appelle web service
 */

package fr.isen.mairel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import fr.isen.mairel.androiderestaurant.databinding.ActivityHomeBinding
 

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.textEntree.setOnClickListener {
            // Code pour créer une nouvelle page ou activité
            Log.d("MainActivity", "Vous avez cliquer sur le bouton entree")
            /**
            Toast.makeText(this, "vous avez cliquer"), Toast.LENGHT_SHORT).show()
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("category", getString(R.string.text_entree))  //text_entre dans code activity_home.xml
            startActivity(intent)
             */

            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("menu", "Entrées")//faire passer en parametre
            startActivity(intent)
        }


        //val textPlat = findViewById<TextView>(R.id.textPlat) grace a binding cette ligne degage
        binding.textPlat.setOnClickListener{
            // Code pour créer une nouvelle page ou activité
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("menu", "Plats")//faire passer en parametre
            startActivity(intent)
            //Toast.makeText(this, "Go Plat",Toa)
        }

        //val textDessert = findViewById<TextView>(R.id.textDessert)
        //textDessert.setOnClickListener{
        // Code pour créer une nouvelle page ou activité
        //  val intent = Intent(this, MenuActivity::class.java)
        //   startActivity(intent)
        // }

        val dessertsButton = findViewById<TextView>(R.id.textDessert)
        dessertsButton.setOnClickListener {
            Toast.makeText(this, "Liste Desserts", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("menu", "Desserts")//faire passer en parametre
            startActivity(intent)



        }
    }







}

