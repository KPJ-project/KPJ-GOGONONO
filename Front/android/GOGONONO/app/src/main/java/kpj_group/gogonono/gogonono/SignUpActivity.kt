package kpj_group.gogonono.gogonono

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    companion object {
        const val INTENT_USER_ID = "intent_user_id"
        const val INTENT_PASSWORD = "intent_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button_next.setOnClickListener {

            if(editText_password.text.toString()==editText_confirmpassword.text.toString() && editText_password.text.toString()!="" && editText_confirmpassword.text.toString()!=""){
                var intent= Intent(this,SignUpActivity2::class.java)
                intent.putExtra(INTENT_USER_ID,editText_id.text.toString())
                intent.putExtra(INTENT_PASSWORD,editText_password.text.toString())
                startActivityForResult(intent,1)
            } else{
                Toast.makeText(this,"ㄴㄴ", Toast.LENGTH_SHORT).show()
            }

            //startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==1){
            finish()
        }
    }
}
