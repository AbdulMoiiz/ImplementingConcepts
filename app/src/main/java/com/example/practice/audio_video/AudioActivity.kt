package com.example.practice.audio_video

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityAudioBinding

class AudioActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var binding: ActivityAudioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_audio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mediaPlayer = MediaPlayer.create(this, R.raw.aud_song)

        mediaPlayer.setOnCompletionListener {
            releaseMediaPlayer()
        }

        binding.btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying)
                mediaPlayer.start()
        }
        binding.btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying)
                mediaPlayer.pause()
        }

        binding.btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.prepare()
            }
        }
    }

    private fun releaseMediaPlayer() {
        // late init property initialize check method
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}