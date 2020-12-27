package android.example.com

import android.content.Context
import android.example.com.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Rahul Priyadarshi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
        binding.button.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
//        val textEdit = findViewById<EditText>(R.id.nickname_edit)
//        val textView = findViewById<TextView>(R.id.nickname_text)

//        textView.text = textEdit.text
//        textEdit.visibility = View.GONE
//        view.visibility = View.GONE
//        textView.visibility = View.VISIBLE

        binding.apply {
//            nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
