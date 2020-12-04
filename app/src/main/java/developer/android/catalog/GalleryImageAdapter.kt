package developer.android.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.gallery_item.view.*

class GalleryImageAdapter( private val images: ArrayList<Int>) :
        RecyclerView.Adapter<GalleryImageAdapter.ColorViewHolder>() {


  override fun getItemCount(): Int {
    return images.size
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
    return ColorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false))
  }

  override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
      val path = images[position]
      var imageView = holder.iv
      imageView.setImageResource(path)

      holder.iv.setOnClickListener {
      //handle click event on image
      }
  }

  class ColorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val iv = view.iv as ImageView
  }
}
