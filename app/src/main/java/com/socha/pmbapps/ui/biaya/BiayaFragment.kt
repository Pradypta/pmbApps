package com.socha.pmbapps.ui.biaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.socha.pmbapps.R

class BiayaFragment : Fragment() {

    private lateinit var sendViewModel: BiayaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(BiayaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_biaya, container, false)
//        val textView: TextView = root.findViewById(R.id.text_send)
//        sendViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}