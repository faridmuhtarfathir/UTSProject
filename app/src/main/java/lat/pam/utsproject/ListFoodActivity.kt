package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity(), FoodAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Original", "Teh original ini kaya rasa dan aroma alami tanpa tambahan apa pun, memberikan sensasi tenang dan menyegarkan.", R.drawable.tehori),
            Food("Teh Tarik", "Teh hitam dicampur susu yang dituang berulang hingga berbusa, menghasilkan rasa manis dan creamy khas Malaysia dan Indonesia.", R.drawable.tehtarik),
            Food("Green Tea", "Teh hijau tanpa susu yang segar dan ringan, dibuat dari daun teh muda, memiliki aroma khas dan cita rasa agak pahit dengan sedikit rasa manis alami.", R.drawable.ijo),
            Food("Thai Tea", "Minuman teh hitam khas Thailand dengan campuran susu kental manis dan gula, berwarna oranye dan bercita rasa manis, creamy, serta sedikit rempah.", R.drawable.thai),
            Food("Lychee Tea", "Teh hitam atau hijau yang dicampur dengan sirup leci atau buah leci, menciptakan rasa manis dan segar dengan aroma buah leci yang khas.", R.drawable.leci),


            )

        adapter = FoodAdapter(
            foodList,
            this
        )
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemClick(food: Food) {
        val intent = Intent(this, OrderActivity::class.java).apply {
            putExtra("FOOD_NAME", food.name)
            putExtra("FOOD_DESCRIPTION", food.description)
        }
        startActivity(intent)
    }

}