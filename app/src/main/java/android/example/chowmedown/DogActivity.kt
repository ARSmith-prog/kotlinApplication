package android.example.chowmedown

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.*
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.register.*
import java.util.*
import java.util.Calendar.getInstance
import java.util.Currency.getInstance


@Suppress("DEPRECATION")
class DogActivity : AppCompatActivity() {

    private lateinit var dogName: EditText
    private lateinit var dogAge: EditText
    private lateinit var dogWeight: EditText
    private lateinit var meals_Daily: AppCompatSpinner
//    private lateinit var special_needs: AppCompatSpinner

    private lateinit var add_another_dog: Button
    private lateinit var save_button: Button
    private lateinit var back_button: Button
    private lateinit var selectPhoto: Button

    val mealAmount = arrayOf("1", "2", "3", "4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.example.chowmedown.R.layout.dogs)

        val storage = Firebase.storage

        dogName = findViewById(R.id.name_input)
        dogAge = findViewById(R.id.age_input)
        dogWeight = findViewById(R.id.weight_input)
        meals_Daily = findViewById(R.id.dailyspin)
//        special_needs = findViewById(R.id.dietspin)

        add_another_dog = findViewById(R.id.add_dog_button)
        save_button = findViewById(R.id.save_button)
        back_button = findViewById(R.id.back_button)
        selectPhoto = findViewById(R.id.select_photo_button)

        val amountSpin =
            findViewById<AppCompatSpinner>(android.example.chowmedown.R.id.dailyspin) as Spinner

        val amountAdapter =
            ArrayAdapter(
                this@DogActivity,
                android.R.layout.simple_spinner_dropdown_item,
                mealAmount
            )

        amountSpin.adapter = amountAdapter

        amountSpin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                showToast(message = "Nothing selected")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                Toast.makeText(this@MainActivity2,"You have Selected "+vegetables[p2],Toast.LENGTH_LONG).show()

            }
        }

        save_button.setOnClickListener {
            performSave()
        }

        add_another_dog.setOnClickListener {
            val intent = Intent(this, newDogAdd::class.java)
            startActivity(intent)
        }

        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        selectPhoto.setOnClickListener{
            Log.d( "DogActivity", "try and show photo selector")
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent , 0 )

        }
    }
    var selectedPhotoUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            Log.d("DogActivity", "photo was selcted")

            selectedPhotoUri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
            val bitmapDrawable = BitmapDrawable(bitmap)
            selectPhoto.setBackgroundDrawable(bitmapDrawable)

        }
    }

    private fun performSave() {

        val dogname = dogName.text.toString()
        val dogage = dogAge.text.toString()
        val dogweight = dogWeight.text.toString()
        val meals_daily = meals_Daily.toString()
//        val specialneeds = special_needs.toString()


        if (dogname.isEmpty() || dogage.isEmpty() || dogweight.isEmpty() || meals_daily.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            return
            //makes sure user enters each field so app does not crash
        } else {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        Log.d("DogActivity", "Dog name: " + dogname)
        Log.d("DogActivity", "Dog age: " + dogage)
        Log.d("DogActivity", "Dog weight: " + dogweight)
        Log.d("DogActivity", "meals daily: " + meals_daily)
//        Log.d("DogActivity", "special needs: " + specialneeds)

//        FirebaseAuth.getInstance().add

        uploadImageToFirebaseStorage()


    }

    private fun  uploadImageToFirebaseStorage() {
        if (selectedPhotoUri == null) return
        val filename = UUID.randomUUID().toString()   //gives a really long string
       val ref = FirebaseStorage.getInstance().getReference("/images/$filename")

        ref.putFile(selectedPhotoUri!!)
            .addOnSuccessListener { Log.d("DogActivity", "successfully uploaded image: ${it.metadata?.path}")
            ref.downloadUrl.addOnSuccessListener {
                it.toString()
                Log.d("DogActivity", "File Location:  $it")

                saveUserToDatabase(it.toString())
                }

            }
            .addOnFailureListener {
                //do some logging here
            }

    }

   private fun saveUserToDatabase(profileimageUrl: String) {
      val uid=  FirebaseAuth.getInstance().uid ?: ""
      val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
       val user = User(uid, editTextusernameReg.text.toString())

       ref.setValue(user)
           .addOnSuccessListener {
               Log.d("DogActivity", "finally we saved user to firebae database")
           }
           .addOnFailureListener {
               //do some logging here
           }

   }

}

class Doginfo(val uid: String, val profileimageUrl:String, val dogname: String)





