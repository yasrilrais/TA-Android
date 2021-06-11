package com.example.tugasakhirapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasakhirapps.model.DataItem
import com.example.tugasakhirapps.model.Staff
import com.example.tugasakhirapps.presenter.CrudView
import com.example.tugasakhirapps.presenter.Presenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = Presenter(this)

        btnLogin.onClick {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()
            presenter.login(email, password)
        }
        btnRegist.onClick{
            startActivity<RegisterActivity>()
        }
    }
    override fun onSuccessLogin(msg: String?, data: Staff?) {
        alert {
            title = "Information"
            message = "Login Success"
        }.show()
        startActivity<Homepage>()
        finish()

    }

    override fun onFailedLogin(msg: String?) {
        alert {
            title = "Information"
            message = "Login Failed Silahkan Cek Email Password"
        }.show()
    }

    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }

    override fun successAdd(msg: String) {
    }

    override fun errorAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessRegister(msg: String?) {
    }

    override fun onFailedRegister(msg: String?) {
    }
}