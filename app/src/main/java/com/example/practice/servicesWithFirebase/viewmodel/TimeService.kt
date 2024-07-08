package com.example.practice.servicesWithFirebase.viewmodel

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import com.google.firebase.database.DatabaseReference
import android.os.Handler
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.practice.R
import com.example.practice.servicesWithFirebase.model.TimeModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class TimeService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + Job())
    private val userModel = TimeModel()
    private val db = Firebase.firestore

    override fun onCreate() {
        super.onCreate()

    }

    private fun startRecordingTime() {
        coroutineScope.launch(Dispatchers.IO) {
            while (isActive) {
                val currentTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                userModel.time = currentTime

                db.collection("users").document("AbdulMoiz")
                    .set(userModel)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->
                    }

                delay(2000)
            }
        }
    }

    private fun startForegroundService() {
        val channelId = "TimeServiceChannel"
        val channelName = "TimeService Channel"

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle("TimeService Running")
            .setContentText("Recording time...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            getSystemService(NotificationManager::class.java)?.createNotificationChannel(channel)
        }

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForegroundService()
        startRecordingTime()
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    companion object {
        private const val NOTIFICATION_ID = 101
    }

}
