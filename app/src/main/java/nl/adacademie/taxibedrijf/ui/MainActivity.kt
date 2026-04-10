package nl.adacademie.taxibedrijf.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import nl.adacademie.taxibedrijf.R
import nl.adacademie.taxibedrijf.domain.Car
import nl.adacademie.taxibedrijf.ui.fragment.CarDetailsResultFragment

class MainActivity : AppCompatActivity() {

    private lateinit var licensePlateTextField: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        licensePlateTextField = findViewById(R.id.et_kenteken)
        submitButton = findViewById(R.id.b_search_button)

        submitButton.setOnClickListener {
            handleSearch()
        }

        val apiUrl = $$"https://opendata.rdw.nl/resource/m9d7-ebf2.json?$limit=20" // Gelimiteerd op 20, omdat hij anders te lang doet over laden.
        val cars = mutableListOf<Car>()
        val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)

        // Request aanmaken.
        val request = JsonArrayRequest(
            apiUrl,
            { response ->
                val gson = Gson()

                for (index in 0 until response.length()) { // Loopen over elke entry.
                    val car = gson.fromJson( // JSONObject omzetten naar een Car.
                        response.getJSONObject(index).toString(),
                        Car::class.java
                    )
                    cars.add(car)
                }

                val arrayAdapter = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_list_item_1,
                    cars
                )

                // Adapter instellen binnen de list view.
                val listView = findViewById<ListView>(R.id.lv_cars)
                listView.adapter = arrayAdapter
                listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    val intent = Intent(applicationContext, CarDetailsActivity::class.java)
                    intent.putExtra("car", cars[position])
                    startActivity(intent)
                }
            },
            { error -> println(error) }
        )

        requestQueue.add(request) // Request uitvoeren.
    }

    private fun handleSearch() {
        if (licensePlateTextField.text.isNotBlank()) {
            // Fragment aanmaken.
            val fragment = CarDetailsResultFragment().apply {
                arguments = Bundle().apply {
                    putString("kenteken", licensePlateTextField.text.toString())
                }
            }

            // Fragment plaatsen op scherm.
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcw_car_details_fragment, fragment)
                .commit()
        }
    }

}
