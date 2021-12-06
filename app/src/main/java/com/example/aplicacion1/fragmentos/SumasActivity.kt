package com.example.aplicacion1.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.aplicacion1.R

class SumasActivity : Fragment()  {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_sumas,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Cambio = view.findViewById(R.id.ButtonEjerciSumas) as Button
    Cambio.setOnClickListener(View.OnClickListener {
        val fr = EjerciciosSumas()
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.view, fr)
            .addToBackStack(null)
            .commit()
    })
    }
}