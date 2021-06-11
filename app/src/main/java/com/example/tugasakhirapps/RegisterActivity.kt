package com.example.tugasakhirapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasakhirapps.adapter.DataAdapter
import com.example.tugasakhirapps.model.DataItem
import com.example.tugasakhirapps.model.Staff
import com.example.tugasakhirapps.presenter.CrudView
import com.example.tugasakhirapps.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter : Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = Presenter(this)
        btnRegister.onClick {
            val nama = registerName.text.toString()
            val nim = registerNim.text.toString()
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()


            presenter.register(nama, nim, email, password)
        }
    }
    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Success Register"
        }.show()
    }

    override fun onFailedRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = msg.toString()
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
    override fun onSuccessLogin(msg: String?, data: Staff?) {
    }

    override fun onFailedLogin(msg: String?) {
    }
}