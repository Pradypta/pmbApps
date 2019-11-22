package com.socha.pmbapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.ClientInfoStatus

class MainActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(p0: ConnectionResult) {
        Toast.makeText(this,""+p0.errorMessage,Toast.LENGTH_SHORT).show()
    }

    companion object{
        private val PERMISSION_CODE = 6969
    }
    lateinit var mGoogleApiClient:GoogleApiClient

    lateinit var firebaseAuth: FirebaseAuth


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode ==PERMISSION_CODE){
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if(result.isSuccess){

                val account = result.signInAccount
                val idToken= account!!.idToken

                val credential = GoogleAuthProvider.getCredential(idToken,null)
                firebaseAuthWithGoogle(credential)
            }else{
                Log.d("LOGIN_ERROR","Login Unsuccessful")
                Toast.makeText(this,"Login Unsuccessful",Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun firebaseAuthWithGoogle(credential:AuthCredential?) {
        firebaseAuth!!.signInWithCredential(credential!!)
            .addOnSuccessListener { authResult ->
                val logged_email = authResult.user.email
                val loggedActivity = Intent(this@MainActivity, LoggedActivity::class.java)
                loggedActivity.putExtra("email",logged_email)
                startActivity(loggedActivity)
            }
            .addOnFailureListener{
                Toast.makeText(this,"Login Unsucsessful",Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureGoogleCLient()
        firebaseAuth = FirebaseAuth.getInstance()


        btn_sign_in.setOnClickListener{
            sign_in()
        }
    }

    private fun sign_in() {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(intent, PERMISSION_CODE)
    }

    private fun configureGoogleCLient() {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this,this)
            .addApi(Auth.GOOGLE_SIGN_IN_API,options)
            .build()
        mGoogleApiClient.connect()

    }
}
