package com.example.tugasakhirapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasakhirapps.model.DataItem
import com.example.tugasakhirapps.presenter.CrudView
import com.example.tugasakhirapps.presenter.Presenter
import kotlinx.android.synthetic.main.activity_update_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {


    private lateinit var presenter: Presenter
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = Presenter(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null){
            btnAction.text = "Tambah"
            btnAction.onClick {
                presenter.addData(
                        etName.text.toString(),
                        etKeluhan.text.toString(),
                        etFakultas.text.toString(),
                        etPenerima.text.toString(),
                        etTanggal.text.toString(),
                        etTipe.text.toString(),
                        etTindakan.text.toString())
            }

        }else if (itemDataItem != null){
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etName.setText(item?.staffName.toString())
            etKeluhan.setText(item?.staffKeluhan.toString())
            etFakultas.setText(item?.staffFakultas.toString())
            etPenerima.setText(item?.staffPenerima.toString())
            etTanggal.setText(item?.staffTanggal.toString())
            etTipe.setText(item?.staffTipe.toString())
            etTindakan.setText(item?.staffTindakan.toString())
            btnAction.onClick {
                presenter.updateData(
                        item?.staffId ?: "",
                        etName.text.toString(),
                        etKeluhan.text.toString(),
                        etFakultas.text.toString(),
                        etPenerima.text.toString(),
                        etTanggal.text.toString(),
                        etTipe.text.toString(),
                        etTindakan.text.toString())
                finish()
            }

        }
    }



    override fun successAdd(msg: String) {
        startActivity<MainActivity>()
        finish()
    }

    override fun errorAdd(msg: String) {}

    override fun onSuccessUpdate(msg: String) {
        startActivity<MainActivity>()
        finish()
    }

    override fun onErrorUpdate(msg: String) {}

    override fun onSuccessGet(data: List<DataItem>?) {}

    override fun onFailedGet(msg: String) {}

    override fun onSuccessDelete(msg: String) {}

    override fun onErrorDelete(msg: String) {}
}