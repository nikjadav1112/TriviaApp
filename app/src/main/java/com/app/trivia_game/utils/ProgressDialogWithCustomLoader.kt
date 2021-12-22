package com.app.trivia_game.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog

import com.app.trivia_game.R
import kotlinx.android.synthetic.main.dialog_progress_with_content.view.*



object ProgressDialogWithCustomLoader {

    var alertDialog: AlertDialog? = null

    fun showProgressDialog(
        context: Context,
        isCancelable: Boolean
    ) {
        dismissProgressDialog()
        createProgressDialog(context, isCancelable)
     //  createProgressDialog(context, isCancelable)
        alertDialog!!.show()

    }
    private fun createProgressDialog(
        context: Context,
        isCancelable: Boolean
    ) {

         val dialogBuilder = AlertDialog.Builder(context, R.style.DialogTheme)

        val dialogView =
            LayoutInflater.from(context).inflate(R.layout.dialog_progress_with_content, null)
        dialogView.txtProgressTitle.visibility = View.VISIBLE
        dialogView.txtProgressMessage.visibility = View.VISIBLE
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(isCancelable)
        alertDialog = dialogBuilder.create()
        alertDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


    }



        fun dismissProgressDialog() {
            if (alertDialog != null) {
                if (alertDialog!!.isShowing)
                    alertDialog!!.dismiss()
                alertDialog = null
            }
        }


    }

