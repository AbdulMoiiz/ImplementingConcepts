package com.example.practice.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.custom_toast.CustomToastActivity
import com.example.practice.databinding.ActivityNotificationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NotificationActivity : AppCompatActivity() {
    companion object{
        const val CHANEL_ID:String="channel"
        const val NOTIFICATION_ID:Int=100
        const val REQ_CODE:Int=100
    }

    lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_notification)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawable: Drawable? =ResourcesCompat.getDrawable(resources,R.drawable.ab,null)
        val icon: Bitmap?=drawable?.toBitmap()

        val nm: NotificationManager = getSystemService(NotificationManager::class.java)

        val notify:Intent=Intent(applicationContext,NotificationActivity::class.java)
        notify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent:PendingIntent= PendingIntent.getActivity(this,REQ_CODE,notify,PendingIntent.FLAG_IMMUTABLE)

//        big picture style
        val bigPictureStyle:NotificationCompat.BigPictureStyle=NotificationCompat.BigPictureStyle()
            .bigPicture(ResourcesCompat.getDrawable(resources,R.drawable.f,null)?.toBitmap())
            .bigLargeIcon(icon)
            .setSummaryText("summary")
            .setBigContentTitle("big content title")

        val bigTextStyle:NotificationCompat.BigTextStyle=NotificationCompat.BigTextStyle()
            .bigText("big text Lorem Ipsum text is " +
                "a widely used placeholder in graphic " +
                "design, publishing, and web development" +
                " industries. It's a sample text that creates" +
                " a natural language rhythm and layout without " +
                "revealing any actual content. The text was " +
                "originally created in the 1960s by a professor " +
                "named Mark Simonson as a way to preview typesetting" +
                " equipment and displays without having to use real " +
                "text. It has since become a standard for testing " +
                "and prototyping design and layout, and it's commonly" +
                " used in templates, websites, and other media.")
            .setBigContentTitle("big content title")
            .setSummaryText("summary")

        val inboxStyle:NotificationCompat.InboxStyle=NotificationCompat.InboxStyle()
            .addLine("line 1")
            .addLine("line 2")
            .addLine("line 3")
            .addLine("line 4")
            .addLine("line 5")
            .addLine("line 6")
            .addLine("line 7")
            .addLine("line 8")
            .addLine("line 9")
            .addLine("line 10")
            .setBigContentTitle("big content title")
            .setSummaryText("summary")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANEL_ID, "Channel Name", NotificationManager.IMPORTANCE_HIGH)
            nm.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(this, CHANEL_ID)
            .setLargeIcon(icon)
            .setContentTitle("title")
            .setContentText("content")
            .setSubText("subtext")
            .setSmallIcon(R.drawable.b)
            .setContentInfo("info")
            .setContentIntent(pendingIntent)
            .setAutoCancel(false)
            .setStyle(inboxStyle)


        binding.button.setOnClickListener {
            startActivity(Intent(this,CustomToastActivity::class.java))
        }

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                nm.notify(NOTIFICATION_ID, notificationBuilder.build())
                delay(4000)
            }
        }

    }
}