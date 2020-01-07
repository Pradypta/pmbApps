package com.socha.pmbapps.ui.pendaftaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.socha.pmbapps.R

class PendaftaranFragment : Fragment() {

    private lateinit var pendafaranViewModel: PendaftatanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pendafaranViewModel =
            ViewModelProviders.of(this).get(PendaftatanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pendaftaran, container, false)
//        val textView: TextView = root.findViewById(R.id.text_gallery)
//        galleryViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}