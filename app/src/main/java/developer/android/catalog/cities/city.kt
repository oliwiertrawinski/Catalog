package developer.android.catalog.cities

import java.io.Serializable

enum class Category{
    POLSKA, NIEMCY, WLOCHY
}

enum class FilterCategory{
    POLSKA, NIEMCY, WLOCHY, LIKED, NOTHING
}

class City (
    var name: String,
    var image: Int,
    var category: Category,
    var informations: String,
    var touristAttractions: String,
    var isLiked: Boolean,
    var gallery: ArrayList<Int>
): Serializable