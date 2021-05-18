package android.example.chowmedown

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner

class test_main2 : AppCompatActivity() {

    val vegetables = arrayOf("Kale", "carrots", "Spinach", "Celery")
    val dairy = arrayOf("Yogurt", "Egg")
    val fruit = arrayOf("Apple", "Cranberries", "Blueberries")
    val grains = arrayOf("White Rice", "Brown Rice", "Quinoa", "Oats")
    val meats = arrayOf("Red Meat", "Chicken", "Turkey", "Venison")
    val soups = arrayOf("Beef Broth", "Chicken Broth", "Veggie Stock", "Beef Stock")

    val selecteditems = arrayListOf<String>()
    var isselected = booleanArrayOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.example.chowmedown.R.layout.activity_main2)


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


    }

    }