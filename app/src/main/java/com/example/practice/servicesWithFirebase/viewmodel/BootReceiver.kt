package com.example.practice.servicesWithFirebase.viewmodel

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class BootReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent!!.action) {
            val serviceIntent = Intent(context, TimeService::class.java)
            context!!.startForegroundService(serviceIntent)
        }
    }
}
