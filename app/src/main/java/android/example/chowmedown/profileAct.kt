package android.example.chowmedown

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth

class profileAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_act)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

    verifyuserisloggedin()
}

private fun verifyuserisloggedin() {

    //checking if user is logged if, if not goes to main page
    val uid = FirebaseAuth.getInstance().uid
    if (uid == null) {
        val intent = Intent(this, MainActivity::class.java)
        //clearing off back space
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when (item?.itemId) {
        R.id.menu_sign_out -> {
            //put code here
            FirebaseAuth.getInstance().signOut()
            //bringing back to main page
            val intent = Intent(this, MainActivity::class.java)
            //clearing off back space
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
    return super.onOptionsItemSelected(item)
}

override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.nav_menu, menu)
    return super.onCreateOptionsMenu(menu)
}
}