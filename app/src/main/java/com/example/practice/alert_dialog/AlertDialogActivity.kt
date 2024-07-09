package com.example.practice.alert_dialog

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practice.R

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_dialog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
//        alertDialog.setTitle("Terms & Conditions")
//        alertDialog.setIcon(R.drawable.baseline_assignment_late_24)
//        alertDialog.setMessage("Have you read the terms and conditions")
//        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes i have read", DialogInterface.OnClickListener { dialog, which ->
//            dialog.dismiss()
//        })
//        alertDialog.show()


        val delDialog: AlertDialog.Builder=AlertDialog.Builder(this)
        delDialog.setTitle("Delete?")
        delDialog.setCancelable(false)
        delDialog.setIcon(R.drawable.baseline_auto_delete_24)
        delDialog.setMessage("Are you sure you want to delete this?")
        delDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        delDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        delDialog.show()
    }

    override fun onBackPressed() {
        val delDialog: AlertDialog.Builder=AlertDialog.Builder(this)
        delDialog.setTitle("Exit?")
        delDialog.setIcon(R.drawable.baseline_arrow_back_24)
        delDialog.setMessage("Are you sure you want to exit?")
        delDialog.setCancelable(false)
        delDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            super.onBackPressed()
        })
        delDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            })

        delDialog.setNeutralButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        delDialog.show()



    }
}