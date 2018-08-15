package kpj_group.gogonono.gogonono

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var authStateListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_login)

        // 로그인 세션을 체크하는 부분분
        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            var user= firebaseAuth.currentUser
            if (user != null) {
                startActivity(Intent(this, InitialLoginActivity::class.java))
            }
        }

        button_login.setOnClickListener {
            loginId()
        }

        button_register.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    fun loginId() {
        if (editText_email.text.toString() == "" || editText_password.text.toString() == "") {
            Toast.makeText(this, "제대로 입력하세요.", Toast.LENGTH_SHORT).show()
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(editText_email.text.toString(), editText_password.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
        }

    }

    override fun onResume() {
        super.onResume()
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener!!)
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener(authStateListener!!)
    }
}
