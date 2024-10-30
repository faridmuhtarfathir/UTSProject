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
            Food("Original", "Kue pancong Betawi, berbahan tepung beras, kelapa, dan santan, bertekstur renyah dan gurih manis", R.drawable.original),
            Food("Cokelat", "memiliki tekstur renyah lembut dengan perpaduan rasa gurih dan manis cokelat", R.drawable.cokelat),
            Food("Oreo", "bertekstur renyah lembut dengan perpaduan rasa gurih dan manis khas biskuit Oreo", R.drawable.oreo),
            Food("Matcha", "bertekstur renyah lembut dengan perpaduan rasa gurih dan manis beraroma teh hijau", R.drawable.matcha),
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