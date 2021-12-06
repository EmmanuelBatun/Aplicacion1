package com.example.aplicacion1


import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentActivity

import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FIREBASE REALTIME DATABASE
        // mandamos a llamar la clase MateriasDao
        val objAsignaturasDao=AsignaturasDao()
        // traer la lista de playas de firebase
        objAsignaturasDao.actualizarDatos()

        //FIREBASE ANALYTICS
        val analitycs: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase")
        analitycs.logEvent("InitScreen", bundle)

        //Setup
        setup()
    }
    //FIREBASE AUTHENTICATION
    private fun setup() {
        title = "Inicio de sesion"
        //Inicio de sesion Firebase
        val buttonRegistar = findViewById<Button>(R.id.buttonRegistar)
        buttonRegistar.setOnClickListener {
            if (!(!EmailEdittext.text.isNotEmpty() || !PasswordEditText.text.isNotEmpty())){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    EmailEdittext.text.toString(),
                    PasswordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Showhome()
                        Toast.makeText(this, "Usuario Registrado con exito",Toast.LENGTH_SHORT).show()
                    } else {
                        ShowAlert()
                    }
                }
            }
        }
        ButtonIniciar.setOnClickListener {
            if (!(!EmailEdittext.text.isNotEmpty() || !PasswordEditText.text.isNotEmpty())){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    EmailEdittext.text.toString(),
                    PasswordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Showhome()
                    } else {
                        ShowAlert()
                    }
                }
            }
        }

    }

    private fun ShowAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage("Los datos son Invalidos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun Showhome() {
        val homeintent = Intent(this, IndexActivity::class.java)
        startActivity(homeintent)
    }


}
