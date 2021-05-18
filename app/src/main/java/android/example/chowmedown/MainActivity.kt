package android.example.chowmedown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var get_started: Button
    private lateinit var add_dog: Button
    private lateinit var Welcome: TextView
    private lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var veg_list = MutableList.Strings = ArrayList()


        get_started = findViewById(R.id.get_started)
        add_dog = findViewById(R.id.add_dog)
        Welcome = findViewById(R.id.Welcome)
        description = findViewById(R.id.description)


        get_started.setOnClickListener {
            var intent = Intent( this,Register::class.java)
            startActivity(intent)
        }

        add_dog.setOnClickListener {
            var intent = Intent( this,DogActivity::class.java)
            startActivity(intent)
        }


    }

}

