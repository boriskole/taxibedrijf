package nl.adacademie.taxibedrijf.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import nl.adacademie.taxibedrijf.R
import nl.adacademie.taxibedrijf.domain.Car

class CarDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        val car: Car = intent.getSerializableExtra("car") as Car

        findViewById<TextView>(R.id.tv_car_details_screen_kenteken).text = getString(R.string.car_details_kenteken, car.kenteken)
        findViewById<TextView>(R.id.tv_car_details_screen_merk).text = getString(R.string.car_details_merk, car.merk)
        findViewById<TextView>(R.id.tv_car_details_screen_voertuigsoort).text = getString(R.string.car_details_voertuigsoort, car.voertuigsoort)
        findViewById<TextView>(R.id.tv_car_details_screen_kleur).text = getString(R.string.car_details_kleur, car.eerste_kleur)
        findViewById<TextView>(R.id.tv_car_details_screen_aantal_zitplaatsen).text = getString(R.string.car_details_aantal_zitplaatsen, "" + car.aantal_zitplaatsen)
        findViewById<TextView>(R.id.tv_car_details_screen_aantal_cilinders).text = getString(R.string.car_details_aantal_cilinders, "" + car.aantal_cilinders)
        findViewById<TextView>(R.id.tv_car_details_screen_cilinder_inhoud).text = getString(R.string.car_details_cilinderinhoud, "" + car.cilinderinhoud)
    }

}