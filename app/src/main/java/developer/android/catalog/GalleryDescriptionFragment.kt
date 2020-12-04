package developer.android.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class GalleryDescriptionFragment(var city: City) : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_gallery_description, parent, false)
        var rv = view.findViewById<RecyclerView>(R.id.gallery_recycle_view)
        val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv.layoutManager = sglm


        val igka = GalleryImageAdapter(city.gallery)
        rv.adapter = igka
        return view
    }

}