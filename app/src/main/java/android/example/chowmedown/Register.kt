package android.example.chowmedown

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        buttonRegister.setOnClickListener {

            performRegister()
        }

        textViewalreayhaveAcct.setOnClickListener {
            Log.d("Register", "try to show login activity")
            val intent = Intent(this, LoginAct::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister() {
        val email = editTextEmailReg.text.toString()
        val password = edittextPassReg.text.toString()
        val username = editTextusernameReg.text.toString()

        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("Register", "email is: " + email)
        Log.d("Register", "password is:  $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                //else if successful
                Log.d("Register", "successfully created user with UID: ${it.result?.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Register", "failed to create user: ${it.message}")
            }
        saveUserToFireBaseDataBase()
    }

    private fun saveUserToFireBaseDataBase() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid, editTextusernameReg.text.toString())
        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("register", "finally we saved user to firebae database")

                val intent = Intent(this, profileAct::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            .addOnFailureListener {
                Log.d("register", "did not save user to firebae database")
            }
    }
}

    class User(val uid: String, val username: String)


