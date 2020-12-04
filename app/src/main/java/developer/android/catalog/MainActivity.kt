package developer.android.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var cityViewModel: CityViewModel
    lateinit var cityAdapter: CityAdapter

    var flag: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
//        recyclerView.setDrawingCacheEnabled(true)
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH)
        cityAdapter = CityAdapter()
        recyclerView.adapter = cityAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        cityViewModel = CityViewModel(application)
        cityViewModel.mutableCityList.observe(this, Observer {
            cityAdapter.setCityData(it)
        })

        var itemTouchHelper = ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                cityViewModel.deleteCity(viewHolder.adapterPosition)
            }
        })

        itemTouchHelper.attachToRecyclerView(recyclerView)
        cityAdapter.cityViewModel = cityViewModel

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        cityViewModel.filter(FilterCategory.NOTHING)
        return when (item.itemId) {
            R.id.nothing_filter -> {
                cityViewModel.filter(FilterCategory.NOTHING)
                true
            }
            R.id.liked_filter -> {
                cityViewModel.filter(FilterCategory.LIKED)
                true
            }
            R.id.poland_filter -> {
                cityViewModel.filter(FilterCategory.POLSKA)
                true
            }
            R.id.italy_filter -> {
                cityViewModel.filter(FilterCategory.WLOCHY)
                true
            }
            R.id.germany_filter -> {
                cityViewModel.filter(FilterCategory.NIEMCY)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        /*
        if(flag)
            cityViewModel.filter(FilterCategory.LIKED)
        else
            cityViewModel.filter(FilterCategory.NOTHING)
        flag = !flag
        */

//        intent = Intent(this, DescriptionActivity::class.java)
//        startActivity(intent)
    }
}