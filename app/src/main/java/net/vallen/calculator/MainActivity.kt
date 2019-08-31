package net.vallen.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.lang.Integer.parseInt

const val EXTRA_MESSAGE = "net.vallen.calculator.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val plusNumber1String = findViewById<EditText>(R.id.plusNumber1).text.toString()
        var plusNumber1Int : Int = 0
        if (isInt(plusNumber1String)) plusNumber1Int = plusNumber1String.toInt()

        val plusNumber2String = findViewById<EditText>(R.id.plusNumber2).text.toString()
        var plusNumber2Int : Int = 0
        if (isInt(plusNumber2String)) plusNumber2Int = plusNumber2String.toInt()

        val multiplyNumberString = findViewById<EditText>(R.id.multiplyNumber).text.toString()
        var multiplyNumberInt : Int = 0
        if (isInt(multiplyNumberString)) multiplyNumberInt = multiplyNumberString.toInt()

        val message = plusNumber1Int + plusNumber2Int * multiplyNumberInt
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message.toString())
        }
        startActivity(intent)
    }

    private fun isInt (string : String) : Boolean {
        try {
            parseInt(string)
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }
}
