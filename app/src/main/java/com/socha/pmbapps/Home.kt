package com.socha.pmbapps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.system.Os.bind
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_contact.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.android.gms.auth.api.signin.GoogleSignInApi


class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var mGoogleApiClient: GoogleApiClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


//        button = findViewById(R.id.btn_wa) as Button
//
//        button.setOnClickListener { view ->
//            val i = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("https://api.whatsapp.com/send?phone=6282244445828&text=Halo%20mau%20putsal%20gan")
//            )
//            startActivity(i)
//        }


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@Home, MainActivity::class.java))

            finish()

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_pendaftaran, R.id.nav_beasiswa,
                R.id.nav_kontak, R.id.nav_share, R.id.nav_biaya
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.home, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    // Fungsi Button
    fun wa(view: View) {
        btn_wa.setOnClickListener{
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://api.whatsapp.com/send?phone=62817 410 6654&text=Bisa%20minta%20info%20pendaftarannya?")
            )
            startActivity(i)
        }

    }


    fun email(view: View) {
        btn_wa.setOnClickListener{
            val mIntent = Intent(Intent.ACTION_SEND)

            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://api.whatsapp.com/send?phone=62817 410 6654&text=Bisa%20minta%20info%20pendaftarannya?")
            )
            startActivity(i)
        }
    }}
