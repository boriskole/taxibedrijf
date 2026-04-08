package nl.adacademie.taxibedrijf

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var licensePlateTextField: EditText
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        licensePlateTextField = findViewById(R.id.et_kenteken)
        submitButton = findViewById(R.id.b_search_button)
        resultTextView = findViewById(R.id.tv_result_text)

        submitButton.setOnClickListener {

            if (licensePlateTextField.text.isNotBlank()) {
                resultTextView.text = licensePlateTextField.text
            }

        }

    }

}