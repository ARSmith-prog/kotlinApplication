package android.example.chowmedown

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.logingact.*
import kotlinx.android.synthetic.main.register.*

class LoginAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logingact)

        buttonLogin.setOnClickListener {

            performSave()
        }

        textViewbacktoReg.setOnClickListener {

            finish()
//            Log.d("loginAct", "try to show login activity")
//            val intent = Intent(this, LoginAct::class.java)
//            startActivity(intent)
        }


    }
        private fun performSave() {

            val email = editTextEmailLogin.text.toString()
            val password = edittextPassLogin.text.toString()
            val username = editTextusernameLogin.text.toString()

            if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return
            } else {
                    var intent = Intent(this, DogActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
            }

                Log.d("loginAct", "email is: " + email)
                Log.d("loginAct", "password is:  $password")

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)

                        .addOnCompleteListener {
                            if (!it.isSuccessful) return@addOnCompleteListener

                            //else if successful
                            Log.d("loginAct", "successfully logged in user with UID: ${it.result?.user?.uid}")
                        }
                        .addOnFailureListener {
                            Log.d("loginAct", "failed login user: ${it.message}")
                        }
            }


        }
