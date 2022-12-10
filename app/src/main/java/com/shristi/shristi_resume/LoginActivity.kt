package com.shristi.shristi_resume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.shristi.shristi_resume.Constant.SHARED_PREF_NAME
import com.shristi.shristi_resume.Constant.USER_EMAIL
import com.shristi.shristi_resume.Constant.USER_PASSWORD
import com.shristi.shristi_resume.Constant.IS_LOGGED_IN
import com.shristi.shristi_resume.Constant.USER_NAME

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //init shared preference operations
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME,0)
        if (sharedPref.getBoolean(IS_LOGGED_IN, false)) {
            openMainActivity()
        }else {
            initSharedPreference()
        }

        //init views
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener(this)

    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSharedPreference() {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
        val editor = sharedPref.edit()
        editor.putString(USER_EMAIL, "shristigautam@miu.edu")
        editor.putString(USER_PASSWORD, "Shristi@123")
        editor.putString(USER_NAME, "Shristi Gautam")
        editor.putBoolean(IS_LOGGED_IN, false)
        editor.apply()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.login_button -> {
                if (validateFields()) {
                    if (checkAuthorization()) {
                        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
                        val editor = sharedPref.edit()
                        editor.putBoolean(IS_LOGGED_IN, true)
                        editor.apply()
                        openMainActivity()
                    }else {
                        Toast.makeText(this,"Either email or password is incorrect!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkAuthorization(): Boolean {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME,0)
        val email = sharedPref.getString(USER_EMAIL,"")
        val password = sharedPref.getString(USER_PASSWORD,"")
        Log.v("LoginActivity", "$email : $password")
        if (emailEditText.text.toString().trim() != email || passwordEditText.text.toString().trim() != password) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (emailEditText.text.isEmpty()) {
            emailEditText.error = "Email can not be empty!"
            emailEditText.requestFocus()
            return false
        } else if (passwordEditText.text.isEmpty()) {
            passwordEditText.error = "Password can not be empty!"
            passwordEditText.requestFocus()
            return false;
        }

        return true
    }

}