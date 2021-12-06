package com.example.aplicacion1

import android.util.Log
import com.example.aplicacion1.AsignaturasDao.Singleton.basededatos
import com.example.aplicacion1.AsignaturasDao.Singleton.listaAsignaturas
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AsignaturasDao {

    object Singleton { // patrón de diseño para conexión única
        // conectadose a la referencia "Playas" de la bd
        val basededatos = FirebaseDatabase.getInstance().getReference("Asignaturas")
        // lista que contendra la lista de playas
        val listaAsignaturas = arrayListOf<Asignaturas>()
    }
    fun actualizarDatos(){
        // traer los datos desde la referencia
        basededatos.addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(datosbd: DataSnapshot) {
                listaAsignaturas.clear()
                // obtener la lista de firebase
                for(infoAsignatura in datosbd.children){
                    // crea un objeto de playas con los datos de la bd
                    val Asignatura=infoAsignatura.getValue(Asignaturas::class.java)
                    // verificamos que la Materias no tenga datos vacío
                    if(Asignatura!=null){
                        // lo agregamos al arrayList (Arreglo)
                        listaAsignaturas.add(Asignatura)
                    }
                }
           // esto es para ver en el Logcat los datos
                for (datox in listaAsignaturas) {
                    Log.i("Firebase",datox.nombre)
                    Log.i("Firebase",datox.descripcion)
                }
            }
            override fun onCancelled(pO: DatabaseError) {
                //
            }
            })
    }

}
