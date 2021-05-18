package android.example.chowmedown

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner


class MainActivity2:  AppCompatActivity() {


    lateinit var tell: TextView
    lateinit var ingredients: TextView
    private lateinit var back: Button
    private lateinit var save: Button
    private lateinit var next: Button

    val vegetables = arrayOf("Kale", "carrots", "Spinach", "Celery")
    val dairy = arrayOf("Yogurt", "Egg")
    val fruit = arrayOf("Apple", "Cranberries", "Blueberries")
    val grains = arrayOf("White Rice", "Brown Rice", "Quinoa", "Oats")
    val meats = arrayOf("Red Meat", "Chicken", "Turkey", "Venison")
    val soups = arrayOf("Beef Broth", "Chicken Broth", "Veggie Stock", "Beef Stock")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.example.chowmedown.R.layout.activity_main2)


        tell = findViewById(android.example.chowmedown.R.id.tell) as TextView
        ingredients = findViewById(android.example.chowmedown.R.id.ingredients) as TextView
        back = findViewById(android.example.chowmedown.R.id.back_button)
        save = findViewById(android.example.chowmedown.R.id.save_button)
        next = findViewById(android.example.chowmedown.R.id.next_button)


        val spinner =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.vegetables) as Spinner
        val spinner2 =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.other) as Spinner
        val spinner3 =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.fruits) as Spinner
        val spinner4 =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.grains) as Spinner
        val spinner5 =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.meats) as Spinner
        val spinner6 =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.soups) as Spinner


        val adapter = ArrayAdapter(
            this@MainActivity2,
            android.R.layout.simple_spinner_dropdown_item,
            vegetables
        )

        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+vegetables[p2],Toast.LENGTH_LONG).show()

            }

        }


        val adapter2 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, dairy)

        spinner2.adapter = adapter2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+dairy[p2],Toast.LENGTH_LONG).show()

            }

        }

        val adapter3 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, fruit)

        spinner3.adapter = adapter3

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+fruit[p2],Toast.LENGTH_LONG).show()
            }

        }

        val adapter4 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, grains)

        spinner4.adapter = adapter4

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+grains[p2],Toast.LENGTH_LONG).show()
            }

        }

        val adapter5 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, meats)

        spinner5.adapter = adapter5

        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+meats[p2],Toast.LENGTH_LONG).show()
            }

        }

        val adapter6 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, soups)

        spinner6.adapter = adapter6

        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+soups[p2],Toast.LENGTH_LONG).show()
            }

        }

        back.setOnClickListener {
            val intent = Intent(this, DogActivity::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            val intent = Intent(this, recipies::class.java)
            startActivity(intent)
        }
    }
}