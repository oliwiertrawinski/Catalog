package developer.android.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AttractionsDescriptionFragment(val city: City) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_attractions_description, container, false)

        view.findViewById<TextView>(R.id.attractions_text_view).setText(city.touristAttractions)
        return view
    }

}