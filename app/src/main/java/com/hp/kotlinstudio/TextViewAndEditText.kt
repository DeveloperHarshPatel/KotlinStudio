package com.hp.kotlinstudio

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.hp.kotlinstudio.utils.letsToastShort
import kotlinx.android.synthetic.main.activity_text_view_and_edit_text.*

class TextViewAndEditText : AppCompatActivity() {

    var typingStarted: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_and_edit_text)
        supportActionBar?.subtitle = "Online"

        btn_click_me.setOnClickListener {
            val mInput: String = editText.text.toString()

            if (TextUtils.isEmpty(mInput)){
                letsToastShort(this, "Please enter name!")
            }else{
                tv_output.setText("Welcome $mInput").toString()
                editText.setText("")
            }
        }

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                val mInput: String = editText.text.toString()
                if (!TextUtils.isEmpty(mInput) && mInput.trim().length == 1) {
                    typingStarted = true
                    supportActionBar?.subtitle = "Typing..."
                } else if (mInput.trim().isEmpty() && typingStarted) {
                    typingStarted = false
                    supportActionBar?.subtitle = "Online"
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_reset,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.action_reset -> {
                editText.setText("")
                tv_output.text = ""
                letsToastShort(this,"View Reset")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
