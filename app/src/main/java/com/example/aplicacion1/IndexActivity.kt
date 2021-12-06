package com.example.aplicacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.aplicacion1.Adaptadores.Fragmentosaddap

import com.google.android.material.tabs.TabLayout

import com.google.android.material.tabs.TabLayoutMediator

class IndexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)


        //setup
        setup()
    }
    private fun setup() {
        title = "Inicio"

        /*val transaccion=supportFragmentManager.beginTransaction()
        transaccion.replace(R.id.view_pager_2,HomeFragmento())
        transaccion.addToBackStack(null)*/


        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter=Fragmentosaddap(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter




        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="HOME"


                }
                1->{
                    tab.text="MATERIAS"

                }
                2->{
                    tab.text="Configuracion"



                }
            }
        }.attach()


    }
}






