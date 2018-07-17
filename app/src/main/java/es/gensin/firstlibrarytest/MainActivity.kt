package es.gensin.firstlibrarytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.gensin.firstlibrary.ValidateSomething
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var validator: ValidateSomething

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validator = ValidateSomething()

        button.setOnClickListener {
            Toast.makeText(this, "Validation: " + validator.ValidateString(userText.text.toString()), Toast.LENGTH_SHORT).show()
        }
    }
}
