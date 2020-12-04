package developer.android.catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.adapter.FragmentStateAdapter

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        //intent.getExtra() -> przekazalismy sobie miasta
        var city =  intent.getSerializableExtra(R.string.EXTRA_CITY.toString()) as? City

        var viewPager = findViewById<ViewPager2>(R.id.pager)
        viewPager.adapter = city?.let { DescriptionAdapter(this, it) }



    }


    class DescriptionAdapter(fa: FragmentActivity, var city: City): FragmentStateAdapter(fa) {

        //to przekazujemy do kazdego fragmentu
        var fragmentList = mutableListOf<Fragment>(InformationsDescriptionFragment(city), GalleryDescriptionFragment(city), AttractionsDescriptionFragment(city))

        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList.get(position)
        }

    }
}