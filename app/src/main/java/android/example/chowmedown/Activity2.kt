//package android.example.chowmedown
////
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.*
//import androidx.appcompat.widget.AppCompatSpinner
//
//class Activity2: AppCompatActivity() {
//
//    lateinit var tell: TextView
//    lateinit var ingredients: TextView
//    private lateinit var back: Button
//    private lateinit var save: Button
//
//    val vegetables = arrayOf("Kale", "carrots", "Spinach", "Celery")
//    val dairy = arrayOf("Yogurt", "Egg")
//    val fruit = arrayOf("Apple", "Cranberries", "Blueberries")
//    val grains = arrayOf("White Rice", "Brown Rice", "Quinoa", "Oats")
//    val meats = arrayOf("Red Meat", "Chicken", "Turkey", "Venison")
//    val soups = arrayOf("Beef Broth", "Chicken Broth", "Veggie Stock", "Beef Stock")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//
//
//        tell = findViewById(R.id.tell) as TextView
//        ingredients = findViewById(R.id.ingredients) as TextView
//        back = findViewById(R.id.back)
//        save = findViewById(R.id.save)
//
//
//
//        val spinner = findViewById<AppCompatSpinner>(R.id.vegetables) as Spinner
//        val spinner2 = findViewById<AppCompatSpinner>(R.id.dairy) as Spinner
//        val spinner3 = findViewById<AppCompatSpinner>(R.id.fruits) as Spinner
//        val spinner4 = findViewById<AppCompatSpinner>(R.id.grains) as Spinner
//        val spinner5 = findViewById<AppCompatSpinner>(R.id.meats) as Spinner
//        val spinner6 = findViewById<AppCompatSpinner>(R.id.soups) as Spinner
//
//
//val adapter = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, vegetables)
//
//spinner.adapter = adapter
//
//
//spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+vegetables[p2],Toast.LENGTH_LONG).show()
//
//    }
//
//}
//
//
//val adapter2 = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, dairy)
//
//spinner2.adapter = adapter2
//
//spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+dairy[p2],Toast.LENGTH_LONG).show()
//
//    }
//
//}
//
//val adapter3 = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, fruit)
//
//spinner3.adapter = adapter3
//
//spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+fruit[p2],Toast.LENGTH_LONG).show()
//    }
//
//}
//
//val adapter4 = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, grains)
//
//spinner4.adapter = adapter4
//
//spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+grains[p2],Toast.LENGTH_LONG).show()
//    }
//
//}
//
//val adapter5 = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, meats)
//
//spinner5.adapter = adapter5
//
//spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+meats[p2],Toast.LENGTH_LONG).show()
//    }
//
//}
//
//val adapter6 = ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_dropdown_item, soups)
//
//spinner6.adapter = adapter6
//
//spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onNothingSelected(p0: AdapterView<*>?) {
////                showToast(message = "Nothing selected")
//    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
////                Toast.makeText(this@MainActivity2,"You have Selected "+soups[p2],Toast.LENGTH_LONG).show()
//    }
//
//}
//
//back.setOnClickListener {
//    val intent = Intent(this, MainActivity::class.java)
//    startActivity(intent)
//}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//

//        val options = arrayOf("Kale", "Carrots", "Sweet Potato", "Green Beans")
//
//        option.adapter = ArrayAdapter<String>(this,android.R.layout.activity_list_item, options)
//
//        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                result.text = "Vegetables"
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                result.text = options.get(position)
//            }
//        }






