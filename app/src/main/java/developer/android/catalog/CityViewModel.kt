package developer.android.catalog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class CityViewModel(application: Application) : AndroidViewModel(application) {

    var mutableCityList: MutableLiveData<MutableList<City>>
    private var defaultList: MutableList<City>

    init{
        val wroclawInfo = "Wrocław, stolica Dolnego Śląska, jest jednym z najstarszych i najpiękniejszych miast w Polsce.\n" +
                "Położony u podnóża Sudetów, nad rzeką Odrą , poprzecinany jej licznymi dopływami i kanałami, jest wyjątkowym miastem 12 wysp i ponad stu mostów.Goście Wrocławia wspominają go przede wszystkim jako prężny ośrodek kultury.\n" +
                "Teatry, opera, teatr muzyczny, filharmonia i liczne kluby, muzea i galerie zapewniają nieprzerwany ciąg wydarzeń artystycznych."
        val poznanInfo = "Poznań, stolica Wielkopolski jest piątym pod względem liczby ludności miasto w Polsce. Położone na Pojezierzu Wielkopolskim, nad rzeką Wartą, oferuje wiele niezapomnianych atrakcji.\n"+
                "Poznań jest na czwartym miejscu pod względem odwiedzin przez turystów miastem w Polsce. "
        val florencjaInfo = "Florencja, miasto sztuki (to tu narodził się włoski Renesans) i pięknej zabudowy, dla wielu miejsce swoim urokiem przebijające nawet Rzym. Stolica Toskanii jest niemal zawsze zatłoczona, ma jednak \"to coś\", co pozwala zapomnieć o tysiącach innych odwiedzających i cieszyć się wąskimi uliczkami, pałacami oraz nieustannym harmidrem.\n" +
                "\n" +
                "Florencja oferuje tak wiele atrakcji i niesamowitych widoków, że przed przyjazdem powinniśmy bardzo dobrze ułożyć plan dnia, uwzględniając kolejki i godziny otwarcia atrakcji - dzięki czemu wykorzystamy naszą wizytę w pełni."
        val neapolInfo = "Neapol (wł. Napoli, ang. Naples) to miasto kontrastów i stereotypów. W świadomości wielu osób z nazwą Neapol wpierw kojarzą się słowa mafia, brud, śmieci, bezpieczeństwo, ale także zabytki, wulkan Wezuwiusz, Pompeje i oczywiście pizza. Czy jednak Johann Wolfgang Goethe mylił się, pisząc „Zobaczyć Neapol i umrzeć”? "
        val palermoInfo = "Palermo to największe miasto na Sycylii i prawdopodobnie jedno z najbardziej różnorodnych w całych Włoszech. Jest to miejsce pełne kontrastów. Na targowiskach możemy poczuć się tak, jakbyśmy przenieśli się na inny kontynent. Z kolei barokowe kościoły i pałace mogą być stawiane na równi z największymi dziełami sztuki spotykanymi w miastach takich jak Genua, Florencja czy Rzym."
        val mediolanInfo = "Mediolan (wł. Milano), stolica mody, finansów i zarazem najbogatsze miasto Włoch. Położony jest w Lombardii na północno-zachodnim skraju Niziny Padańskiej. Stanowi doskonałe miejsce, skąd można zwiedzić Bergamo, jezioro Como, Turyn, czy też wyskoczyć w Alpy. Wydawałoby się, że Mediolan to idealne miasto na spędzenie ciekawego weekendu."
        val heidelbergInfo = "Heidelberg jest siedzibą najstarszego uniwersytetu w Niemczech. Miasto zostało poważnie zniszczone w czasie XVII-wiecznych wojen i w XVIII wieku odbudowane w barokowym stylu. Przechadzka przez zabytkowe ulice historycznego centrum miasta jest bardzo przyjemna. Koniecznie trzeba odwiedzić zamek Heidelberg, symboliczne centrum miasta, Alte Brucke, przepiękny XVIII-wieczny most oraz Studentenkarzer." +
                " Wybudowany w XVI wieku, był aresztem dla rozrabiających studentów, których zatrzymywano tu na okres od trzech dni do miesiąca. Tradycje imprez studenckich sięgają zamierzchłych czasów!"
        val wiesbadenInfo = "Miasto Wiesbaden będące stolicą Hesji, przycupnięte w uroczej dolinie pomiędzy Renem i pasmem gór Taunus, od wielu lat, bo aż od czasów panowania rzymskiego (zwane wówczas Aquae Mattiacorum) jest ośrodkiem uzdrowiskowym o dużym znaczeniu. W XIX w. Wiesbaden zyskało sobie również popularność jako „jaskinia hazardu”."


        val wroclawAttrac = "+ Hala Stulecia \n" + "+ Stare Miasto\n" + "+ Ostrów Tumski \n"+ "+ Panorama Racłwwicka\n"+ "+ Wrocławska Fontanna Multimedialna\n"+
                "+ Ogród zoologiczny\n+ Narodowe Forum Muzyki\n+ Pooooliiinkaaa"
        val poznanAttrac = "+ Stary Rynek \n" + "+ Stare Miasto\n" + "+ Ostrów Tumski \n"+ "+ Dzielnica Cesarska\n"+ "+ Fara i dawne kolegium jezuickie\n"+
                "+ Malta \n+ Stary Browar\n+ Palmiarnia Poznańska"
        val florencjaAttrac = "+ Katedra Santa Maria del Fiore \n" + "+ dzwonnica Giotta di Bondone\n" + "+ baptysterium San Giovanni \n"+ "+ Galeria Uffizi\n"+
                "+ Palazzo Vecchio\n"+ "+ Ponte Vecchio\n+ plac Piazza della Signoria\n+ Ogród Boboli"
        val neapolAttrac = "+ Muzeum Kaplica Sansevero \n" + "+ Katedra w Neapolu\n" + "+ Kościół Gesù Nuovo \n"+ "+ Palazzo Reale di Napoli\n"+ "+ Galleria Borbonica\n"+
                "+ Katakumby \n+ Cmentarz Fontanelle\n+ „Stacje Sztuki” w Metrze"
        val palermoAttrac = "+ Quattro Canti\n" + "+ Piazza Pretoria\n" + "+ Piazza Bellini\n"+ "+ Via Marqueda i Teatro Massimo\n"+ "+ Pobliska miejscowość Monreale\n"+
                "+ Chiesa del Gesù \n+ Pałac Mitro"
        val mediolanAttrac = "+ „Ostatnia Wieczerza” w Santa Maria delle Grazie\n" + "+ Galeria Wiktora Emanuela II\n" + "+ Katedra w Mediolanie\n"+ "+ Kościół św. Maurycego\n"+ "+ Pinakoteka Brera\n"+
                "+ Zamek Sforzów \n+ Park Sempione\n+ Cmentarz Monumentalny"
        val heidelbergAttrac = "+ Kościół św. Ducha\n" + "+ Ratusz\n" + "+ Kamienica Haus zum Ritter\n"+ "+Kornmarkt\n"+ "+ Zamek\n"+
                "+ Ścieżka filozofów – Philosophenweg \n+ Zabytkowy Stary Most"
        val wiesbadenAttrac = "+ Kurhaus\n" + "+ Heidenmauer\n" + "+  Pomnik Holokaustu\n"+ "+  Cerkiew św. Elżbiety\n"+ "+ Nerotal Park\n"+
                "+ Rotunda Neroberg \n+ Kochbrunnen"

        defaultList = mutableListOf(
            City("Wrocław", R.drawable.drawable_wroclaw, Category.POLSKA, wroclawInfo,wroclawAttrac,false,getGallery(4)),
            City("Poznań", R.drawable.drawable_poznan, Category.POLSKA, poznanInfo, poznanAttrac, false, getGallery(4)),
            City("Florencja", R.drawable.drawable_florencja, Category.WLOCHY, florencjaInfo, florencjaAttrac,false,getGallery(4)),
            City("Neapol", R.drawable.drawable_neapol, Category.WLOCHY, neapolInfo, neapolAttrac,false,getGallery(6)),
            City("Palermo", R.drawable.drawable_palermo, Category.WLOCHY, palermoInfo, palermoAttrac,false,getGallery(4)),
            City("Mediolan", R.drawable.drawable_mediolan, Category.WLOCHY, mediolanInfo, mediolanAttrac,false,getGallery(6)),
            City("Heidelberg", R.drawable.drawable_heidelberg, Category.NIEMCY, heidelbergInfo, heidelbergAttrac,false,getGallery(4)),
            City("Wiesbaden", R.drawable.drawable_wiesbaden, Category.NIEMCY, wiesbadenInfo, wiesbadenAttrac,false,getGallery(12)))


        mutableCityList = MutableLiveData()
        mutableCityList.value = defaultList
    }

    fun deleteCity(position:Int){
        var cities = mutableCityList.value
        if (cities != null) {
            defaultList.remove(cities.removeAt(position))
        }
        mutableCityList.value = cities
    }

    fun likeCity(city: City){
        city.isLiked = !city.isLiked
        mutableCityList.value = mutableCityList.value
    }

    fun filter(filterCategory: FilterCategory){
        when (filterCategory){
            FilterCategory.NOTHING -> mutableCityList.value = defaultList
            FilterCategory.LIKED -> {
                var cities  = mutableCityList.value
                var result = mutableListOf<City>()
                if (cities != null) {
                    for (city in cities){
                        if(city.isLiked){
                            result.add(city)
                        }
                    }
                }
                mutableCityList.value = result
            }
            FilterCategory.NIEMCY -> filterCountry(Category.NIEMCY)
            FilterCategory.POLSKA -> filterCountry(Category.POLSKA)
            FilterCategory.WLOCHY -> filterCountry(Category.WLOCHY)
        }
    }

    private fun filterCountry(category: Category){
        var cities  = mutableCityList.value
        var result = mutableListOf<City>()
        if (cities != null) {
            for (city in cities){
                if(city.category == category){
                    result.add(city)
                }
            }
        }
        mutableCityList.value = result
    }

    private fun getGallery(elements: Int): ArrayList<Int> {
        val imageList = mutableListOf(R.drawable.drawable_florencja,R.drawable.drawable_heidelberg,R.drawable.drawable_poznan,R.drawable.drawable_wroclaw,
            R.drawable.drawable_neapol,R.drawable.drawable_mediolan,R.drawable.drawable_palermo,R.drawable.drawable_wiesbaden)
        val toReturn: ArrayList<Int> = ArrayList()
        for (i in 1..elements) {
            imageList.shuffle()
            toReturn.add(imageList.first())
        }
        return toReturn
    }
}