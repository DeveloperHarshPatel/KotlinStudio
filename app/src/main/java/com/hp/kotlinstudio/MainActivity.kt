package com.hp.kotlinstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hp.kotlinstudio.adapter.TitleAdapter
import com.hp.kotlinstudio.model.Title
import com.hp.kotlinstudio.utils.affectOnItemClicks
import com.hp.kotlinstudio.utils.letsToastShort
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val arrTitle: ArrayList<Title> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTopics()

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = TitleAdapter(arrTitle, this)
        recyclerView.affectOnItemClicks { position, _ ->
            startActivity(Intent(applicationContext, arrTitle[position].className::class.java))
            letsToastShort(this,arrTitle[position].name)
        }
    }

    private fun addTopics() {

        arrTitle.add(
            Title("TextView - EditText - Button - OptionMenu",
                TextViewAndEditText())
        )
        arrTitle.add(
            Title("Custom Toast",
                CustomToast())
        )
    }


}
