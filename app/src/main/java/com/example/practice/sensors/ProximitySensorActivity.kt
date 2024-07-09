package com.example.practice.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityProximitySensorBinding

class ProximitySensorActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    lateinit var binding: ActivityProximitySensorBinding
    private var proximitySensor: Sensor? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_proximity_sensor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sensorManager=getSystemService(SENSOR_SERVICE) as SensorManager
           proximitySensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY,false)

        if(proximitySensor!=null){
            sensorManager.registerListener(this,proximitySensor,SensorManager.SENSOR_DELAY_NORMAL)
        }
        else{
            binding.title.text="No Proximity Sensor Detected"
        }


    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type==Sensor.TYPE_PROXIMITY){
            // Handle proximity sensor event
            val distance = event.values[0]
            binding.title.text="Proximity Sensor: $distance"
            // 'distance' is the proximity value
            // Typically, '0' means near and 'maximumRange' means far
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        proximitySensor.also {
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
}