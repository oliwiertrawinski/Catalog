package developer.android.catalog.cities

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import developer.android.catalog.R
import developer.android.catalog.description.DescriptionActivity

class CityAdapter: RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    lateinit var cityViewModel: CityViewModel
    var data: MutableList<City>
    init{
        data = mutableListOf()

    }

    fun setCityData(newData:MutableList<City>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_item, parent, false)
        return  CityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cityImegaView: ImageView
        var nameTextView: TextView
        var categoryTextView: TextView
        var likeImageButton: ImageButton

        init{
            cityImegaView = itemView.findViewById<ImageView>(R.id.imageImageView)
            nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
            categoryTextView = itemView.findViewById<TextView>(R.id.categoryTextView)
            likeImageButton = itemView.findViewById<ImageButton>(R.id.likeImageButton)
        }

        fun bind(city: City){

            cityImegaView.setImageResource(city.image)
            nameTextView.setText(city.name)
            categoryTextView.setText(city.category.toString())

            likeImageButton.setOnClickListener {
                cityViewModel.likeCity(city)
            }
            if (city.isLiked){
                likeImageButton.setImageDrawable(ContextCompat.getDrawable(likeImageButton.context,android.R.drawable.btn_star_big_on));
            }else{
                likeImageButton.setImageDrawable(ContextCompat.getDrawable(likeImageButton.context,android.R.drawable.btn_star_big_off));
            }
            itemView.setOnClickListener {
//                Toast.makeText(nameTextView.context, nameTextView.text, Toast.LENGTH_SHORT).show()
                val intent = Intent(nameTextView.context, DescriptionActivity::class.java)
                intent.putExtra(R.string.EXTRA_CITY.toString(), city)
                nameTextView.context.startActivity(intent)
            }
        }
    }

}