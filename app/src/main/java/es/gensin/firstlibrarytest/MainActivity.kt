package es.gensin.firstlibrarytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import es.gensin.firstlibrary.UserModel
import es.gensin.firstlibrary.UsersDBHelper
import es.gensin.firstlibrary.ValidateSomething
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var validator: ValidateSomething
    private lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validator = ValidateSomething()
        usersDBHelper = UsersDBHelper(this)

        button.setOnClickListener {
            addUser()
        }

        button2.setOnClickListener {
            showAllUsers()
        }
    }

    fun addUser(){
        var userid = this.edittext_userid.text.toString()
        var name = this.edittext_name.text.toString()
        var age = this.edittext_age.text.toString()
        var result = usersDBHelper.insertUser(UserModel(userid = userid,name = name,age = age))
        //clear all edittext s
        this.edittext_age.setText("")
        this.edittext_name.setText("")
        this.edittext_userid.setText("")
        Toast.makeText(this, "Added user: " + result, Toast.LENGTH_SHORT).show()
    }

    fun showAllUsers(){
        var users = usersDBHelper.readAllUsers()
        Toast.makeText(this, "Fetched " + users.size + " users", Toast.LENGTH_SHORT).show()
    }
}
