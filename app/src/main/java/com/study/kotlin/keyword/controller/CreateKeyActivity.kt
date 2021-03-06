package com.study.kotlin.keyword.controller

import android.os.Bundle
import android.view.View
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.application.KeywordApplication
import com.study.kotlin.keyword.application.Menssager
import com.study.kotlin.keyword.controller.base.BaseActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.create_key.*

class CreateKeyActivity : BaseActivity() {

    private var keyId: Int = -1
    var selectedKey = KeyListActivity.selectedItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_key)
        setupThis();
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun setupThis() {

        keyId = intent.getIntExtra("index", -1);

        if (selectedKey != null) {

            editTextName.setText(selectedKey!!.title)
            editTextLogin.setText(selectedKey!!.login)
            editTextPassword.setText(selectedKey!!.password)
        }

        progressBar2.visibility = View.GONE

    }

    public fun onSavePress(view: View) {
        try {
            isInProgress(true);

            val name = editTextName.text.toString()
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()


            var id = selectedKey?.id ?: -1

            var key = KeyVO(
                id,
                name,
                login,
                password
            )

            if (key != null) {

                Thread(Runnable {

                    var message = "";

                    if (KeywordApplication.instance.database!!.saveKey(key)) {
                        message = "Chave ${key.title} foi salva com Sucesso"
                    } else {
                        message = "Chave ${key.title} não foi salva ;-;"
                    }

                    runOnUiThread {
                        progressBar2.visibility = View.GONE
                        Menssager.showDialog(
                            this,
                            "Armazenamento",
                            message,
                            message,
                            ""
                        )
                       // finish()
                    }
                }).start()
            }
        } catch (ex: Exception) {

            ex.printStackTrace();
        }
    }

    public fun onDeletePress(view: View) {

        try {

            isInProgress(true)

            if (selectedKey != null) {

                Thread(Runnable {

                    var message = "";

                    if (KeywordApplication.instance.database?.deleteKey(selectedKey!!.id ?: -1)!!) {
                        message = "Chave ${selectedKey?.title} foi excluida com Sucesso"
                    } else {
                        message = "Chave ${selectedKey?.title} não foi excluida ;-;"
                    }

                    runOnUiThread {

                        isInProgress(false)
                        Menssager.showDialog(
                            this,
                            "Armazenamento",
                            message,
                            message,
                            ""
                        )
                        finish()
                    }
                }).start()
            } else {
                isInProgress(false)
                Menssager.showMessage(
                    this,
                    "Armazenamento",
                    "Não foi Possível Deletar",
                )
            }

        } catch (ex: Exception) {

            ex.printStackTrace();
        }
    }

    private fun isInProgress(Is: Boolean) {

        if (Is) {
            progressBar2.visibility = View.VISIBLE
        } else {
            progressBar2.visibility = View.GONE
        }
    }
}