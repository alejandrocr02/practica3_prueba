package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityScrollingBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.CentroComercial


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    //val openURL = Intent(intent.action)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bonaire = CentroComercial(1, "Aldaia", "CC Bonaire", "https://agendadeisa.com/wp-content/uploads/2019/11/P3270155-1024x625.jpg", "200")
        var nuevoCentro = CentroComercial(2, "Valencia", "CC Nuevo Centro", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Centro_Comercial_Nuevo_Centro.jpg/245px-Centro_Comercial_Nuevo_Centro.jpg", "255")
        var Aqua = CentroComercial(3, "Valencia", "CC Aqua", "https://agendadeisa.com/wp-content/uploads/2019/11/P3270155-1024x625.jpg", "156")
        var Arena = CentroComercial(4, "Alboraya", "CC Arena", "https://agendadeisa.com/wp-content/uploads/2021/10/9DxNi4hOSmmB4ERO8KpfA_thumb_abb8-1.jpg", "205")

        binding.content.nombre2.text = bonaire.nombre
        binding.content.nombre1.text = nuevoCentro.nombre
        binding.content.nombre3.text = Aqua.nombre
        binding.content.nombre4.text = Arena.nombre

        binding.content.nombre12.text = bonaire.direccion
        binding.content.nombre22.text = nuevoCentro.direccion
        binding.content.nombre32.text = Aqua.direccion
        binding.content.nombre42.text = Arena.direccion

        binding.content.numtiendas.text = bonaire.numtiendas
        binding.content.numtiendas2.text = nuevoCentro.numtiendas
        binding.content.numtiendas3.text = Aqua.numtiendas
        binding.content.numtiendas4.text = Arena.numtiendas

        image(nuevoCentro.imagen, binding.content.img)
        image(bonaire.imagen, binding.content.img2)
        image(Aqua.imagen, binding.content.img3)
        image(Arena.imagen, binding.content.img4)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun image(
        url: String="",
        imgView: ImageView){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(imgView)
    }
}