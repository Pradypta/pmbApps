package com.socha.pmbapps.ui.beasiswa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.socha.pmbapps.R

class BeasiswaFragment : Fragment() {

    private lateinit var beasiswaViewModel: BeasiswaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beasiswaViewModel =
            ViewModelProviders.of(this).get(BeasiswaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_beasiswa, container, false)
//        val textView: TextView = root.findViewById(R.id.text_slideshow)
//        beasiswaViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}