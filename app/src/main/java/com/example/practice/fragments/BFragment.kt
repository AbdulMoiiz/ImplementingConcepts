package com.example.practice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.R
import com.example.practice.databinding.FragmentBBinding

class BFragment : Fragment() {
    lateinit var binding: FragmentBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }

}