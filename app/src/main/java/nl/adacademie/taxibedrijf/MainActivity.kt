package nl.adacademie.taxibedrijf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
                val intent = Intent(this, CardDetailsActivity::class.java)
                intent.putExtra("kenteken", licensePlateTextField.text.toString())
                startActivity(intent)
            }

        }

    }

}