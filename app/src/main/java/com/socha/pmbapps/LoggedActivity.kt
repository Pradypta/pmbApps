package com.socha.pmbapps

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.internal.service.Common
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthProvider
import kotlinx.android.synthetic.main.activity_logged.*

class LoggedActivity : AppCompatActivity() {

    lateinit var dotsLayout:LinearLayout
    lateinit var mPager :ViewPager
    var path :IntArray = intArrayOf(R.drawable.bg_custom1, R.drawable.bg_custom2, R.drawable.bg_custom3 )
    lateinit var dots : Array<ImageView>
    var adapter :PageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)
        mPager = findViewById(R.id.pager) as ViewPager
 }

    }

//    private fun signOut() {
//
//        FirebaseAuth.getInstance().currentUser == null
//
//
//        val intent = Intent(this@LoggedActivity, MainActivity::class.java)
//        intent.flags =Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
//
//        finish()
//    }
//}


