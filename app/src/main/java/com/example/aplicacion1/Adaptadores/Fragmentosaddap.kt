package com.example.aplicacion1.Adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aplicacion1.fragmentos.ConfigFragmento
import com.example.aplicacion1.fragmentos.HomeFragmento
import com.example.aplicacion1.fragmentos.MateriasFragmento
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.*
import java.text.FieldPosition

class Fragmentosaddap (fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                HomeFragmento()
            }
            1->{
                MateriasFragmento()
            }
            2->{
                ConfigFragmento()
            }
            else->{
                Fragment()
            }

        }
    }
}


