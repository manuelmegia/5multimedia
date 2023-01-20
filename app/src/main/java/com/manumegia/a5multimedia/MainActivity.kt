package com.manumegia.a5multimedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var eT1 = findViewById<EditText>(R.id.ediText)
        var eT2 = findViewById<EditText>(R.id.ediText2)
        var tV = findViewById<TextView>(R.id.textView2)
        var bt = findViewById<Button>(R.id.button)

        eT1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bt.isEnabled = eT1.text.toString() != "" && eT2.text.toString() != ""
            }
        })

        eT2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bt.isEnabled = eT1.text.toString() != "" && eT2.text.toString() != ""
            }
        })

        eT1.setOnFocusChangeListener { _, focus ->
            if (focus)
                tV.text = eT1.tag.toString()
            else
                tV.text = ""
        }

        eT2.setOnFocusChangeListener { _, focus ->
            if (focus)
                tV.text = eT2.tag.toString()
            else
                tV.text = ""
        }

        bt.setOnClickListener {
           eT1.setText(eT1.text.toString() + eT2.text.toString())
            eT2.text.clear()
        }
    }
}