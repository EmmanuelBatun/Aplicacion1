package com.example.aplicacion1.fragmentos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.aplicacion1.fragmentos.SumasActivity
import com.example.aplicacion1.databinding.MateriasFragmentBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.materias_fragment.*
import android.content.Intent as Intent1
import com.example.aplicacion1.R
import androidx.fragment.app.FragmentTransaction






class MateriasFragmento : Fragment()  {


private lateinit var binding: MateriasFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.materias_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val conec = view.findViewById(R.id.imageButton4) as ImageButton
        conec.setOnClickListener(View.OnClickListener {
            val fr = RestasFragmento()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.view, fr)
                .addToBackStack(null)
                .commit()
        })

        val Bmeters = view.findViewById(R.id.imageButton) as ImageButton
        Bmeters.setOnClickListener(View.OnClickListener {
            val fr = SumasActivity()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.view, fr)
                .addToBackStack(null)
                .commit()
        })
    }
}

