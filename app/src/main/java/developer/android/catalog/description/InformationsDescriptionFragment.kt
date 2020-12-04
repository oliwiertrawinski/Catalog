package developer.android.catalog.description

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import developer.android.catalog.cities.City
import developer.android.catalog.R

class InformationsDescriptionFragment(var city: City) : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_informations_description, container, false)
        view.findViewById<ImageView>(R.id.imageInformations).setImageResource(city.image)
        view.findViewById<TextView>(R.id.nameInformations).setText(city.name.toUpperCase())
        view.findViewById<TextView>(R.id.categoryInformations).setText(city.category.toString())
        view.findViewById<TextView>(R.id.informationsTextView).setText(city.informations)

        return view
    }
}