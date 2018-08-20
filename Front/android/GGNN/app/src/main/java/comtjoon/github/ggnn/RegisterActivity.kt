package comtjoon.github.ggnn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import comtjoon.github.ggnn.SignupActivity.Companion.INTENT_PASSWORD
import comtjoon.github.ggnn.SignupActivity.Companion.INTENT_USER_ID
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {


    var clubs = arrayOf("굴렁쇠", "난장", "사통백이", "산소래", "산지니", "어진바람", "자올소리")
    var ranks = arrayOf("재학생", "주체", "선배", "졸선")

    var userid: String? = null
    var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_register)

        userid = intent.getStringExtra(INTENT_USER_ID)
        password = intent.getStringExtra(INTENT_PASSWORD)

        Toast.makeText(this, userid + " " + password, Toast.LENGTH_SHORT).show()


        val clubsaa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, clubs)
        clubsaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_club.adapter = clubsaa

        val ranksaa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ranks)
        ranksaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_rank.adapter = ranksaa

        button_go_register.setOnClickListener {
            createEmailId()
        }
    }

    fun createEmailId() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userid.toString(), password.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                        setResult(1)
                        finish()
                    } else {
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
    }


}
