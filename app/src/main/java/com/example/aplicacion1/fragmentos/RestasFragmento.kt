package com.example.aplicacion1.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import com.example.aplicacion1.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.config_fragmento.*


class RestasFragmento :Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.restas_fragment, container, false)

    }
}



