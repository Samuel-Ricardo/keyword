package com.study.kotlin.keyword.application

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

class Menssager {

    fun showDialog(
        context:Context,
        title:String,
        message:String,
        positiveButtonMessage:String,
        negativeButton:String,
    ){

        val builder = AlertDialog.Builder(this)

        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(context,
                positiveButtonMessage, Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(context,
                negativeButton, Toast.LENGTH_SHORT).show()
        }

        builder.show();
    }
}