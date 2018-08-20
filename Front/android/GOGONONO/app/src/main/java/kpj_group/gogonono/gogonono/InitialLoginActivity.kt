package kpj_group.gogonono.gogonono

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_initial_login.*

class InitialLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_login)

        button_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }

        button_pass.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
