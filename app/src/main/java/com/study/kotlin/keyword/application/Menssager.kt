package com.study.kotlin.keyword.application

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.study.kotlin.keyword.interfaces.Function

object Menssager {

    fun showDialog(
        context:Context,
        title:String,
        message:String,
        positiveButtonMessage:String,
        negativeButtonMessage:String,
    ){

        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(context,
                positiveButtonMessage, Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(context,
                negativeButtonMessage, Toast.LENGTH_SHORT).show()
        }

        builder.show();
    }

    fun showActionDialog(
        context:Context,
        title:String,
        message:String,
        positiveButtonAction:Function,
        negativeButtonAction:Function,
    ){

        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            positiveButtonAction.run();
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            negativeButtonAction.run()
        }

        builder.show();
    }
}