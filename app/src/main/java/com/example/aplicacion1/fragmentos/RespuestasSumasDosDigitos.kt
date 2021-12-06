package com.example.aplicacion1.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.fragment.app.Fragment
import com.example.aplicacion1.R
import com.example.aplicacion1.databinding.EjerciciosFragmentBinding


class RespuestasSumasDosDigitos :Fragment() {

    private lateinit var binding: EjerciciosFragmentBinding



override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.respuestasdossum_fragment, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}




