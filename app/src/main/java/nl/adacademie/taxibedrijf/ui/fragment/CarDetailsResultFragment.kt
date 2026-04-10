package nl.adacademie.taxibedrijf.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nl.adacademie.taxibedrijf.R

class CarDetailsResultFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kenteken = arguments?.getString("kenteken")

        view.findViewById<TextView>(R.id.tv_car_details_kenteken).text = getString(R.string.kenteken_result_text, kenteken)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_details_result, container, false)
    }

}
