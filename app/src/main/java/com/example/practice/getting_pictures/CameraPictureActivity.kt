package com.example.practice.getting_pictures

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityCameraPictureBinding

class CameraPictureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraPictureBinding
    private lateinit var cameraActivityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var galleryActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera_picture)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupResultLaunchers()

        binding.btnCamera.setOnClickListener {
            val iCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraActivityResultLauncher.launch(iCamera)

//            deprecated
//            startActivityForResult(iCamera, 1)
        }

        binding.btnGallery.setOnClickListener {
            val iGallery = Intent(Intent.ACTION_PICK).apply {
//                type = "image/*"
//                setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            }
            galleryActivityResultLauncher.launch(iGallery)
        }
    }

    private fun setupResultLaunchers() {
        cameraActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val imageBitmap = it.data?.extras?.get("data") as? Bitmap
                if (imageBitmap != null) {
                    binding.imageCamera.setImageBitmap(imageBitmap)
                }
            }
        }

        galleryActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val imageUri = it.data?.data
                if (imageUri != null) {
                    binding.imageCamera.setImageURI(imageUri)
                }
            }
        }
    }


/*
    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val imageUri = data?.data
            if (imageUri != null) {
                binding.imageCamera.setImageURI(imageUri)
            }

        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            if (imageBitmap != null) {
                binding.imageCamera.setImageBitmap(imageBitmap)
            }
        }
    }*/
}
