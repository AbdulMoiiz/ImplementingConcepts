package com.example.practice.Topics

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat
import com.example.practice.MainActivity
import com.example.practice.R

class MusicService : Service() {

    private lateinit var mplayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        mplayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mplayer.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            mplayer.start()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_MUTABLE)
        } else {
            PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, "MusicServiceChannel")
            .setContentTitle("Music Service")
            .setContentText("Playing music...")
            .setSmallIcon(R.drawable.ab)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_STICKY
    }

    override fun onDestroy() {
        if (this::mplayer.isInitialized) {
            mplayer.stop()
            mplayer.release()
        }
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                "MusicServiceChannel",
                "Music Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}
