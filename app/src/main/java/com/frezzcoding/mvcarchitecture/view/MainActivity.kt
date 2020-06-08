package com.frezzcoding.mvcarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.frezzcoding.mvcarchitecture.model.Model
import com.frezzcoding.mvcarchitecture.R
import java.util.*

class MainActivity : AppCompatActivity(), Observer, BaseView{

    private lateinit var model : Model
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button

    /*
    controllers dont extend android classes, since controller updates view
    controller needs to hold reference to the view, this can be done by extending a baseview
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = Model()
        model.addObserver(this)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        setListeners()
    }

    override fun update(o: Observable?, arg: Any?) {
        btn1.text = "count : ${model.getValueAtIndex(0)}"
        btn2.text = "count : ${model.getValueAtIndex(1)}"
        btn3.text = "count : ${model.getValueAtIndex(2)}"
    }

    fun setListeners(){
        btn1.setOnClickListener{
            model.setValueAtIndex(0)
        }
        btn2.setOnClickListener{
            model.setValueAtIndex(1)
        }
        btn3.setOnClickListener{
            model.setValueAtIndex(2)
        }

    }
}
