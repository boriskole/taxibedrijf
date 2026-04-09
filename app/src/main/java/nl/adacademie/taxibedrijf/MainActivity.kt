package nl.adacademie.taxibedrijf

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import nl.adacademie.taxibedrijf.fragment.CarDetailsResultFragment

class MainActivity : AppCompatActivity() {

    private lateinit var licensePlateTextField: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        licensePlateTextField = findViewById(R.id.et_kenteken)
        submitButton = findViewById(R.id.b_search_button)

        submitButton.setOnClickListener {

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

        // Opdracht 5:
        val requestQueue: RequestQueue = Volley.newRequestQueue(applicationContext)
        val request = StringRequest(
            "https://opendata.rdw.nl/resource/m9d7-ebf2.json",
            { response -> println(response) },
            { error -> println(error) }
        )

        requestQueue.add(request)
    }

}
