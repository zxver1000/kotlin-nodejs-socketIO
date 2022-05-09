package com.example.socket

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

import com.google.android.material.bottomnavigation.BottomNavigationView
import main_fragment.*

class Main : AppCompatActivity() {

   private val fl: FrameLayout by lazy{
       findViewById(R.id.fl_container)
   }
    private val bn: BottomNavigationView by lazy{
        findViewById(R.id.bnv_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main2)
        supportFragmentManager.beginTransaction().add(fl.id,homeFragment()).commit()
   bn.setOnNavigationItemSelectedListener { item ->
       when(item.itemId){
           R.id.first->{
               supportFragmentManager.beginTransaction().replace(fl.id,homeFragment()).commit()
               true
           }
           R.id.second->{
               supportFragmentManager.beginTransaction().replace(fl.id,badgeFragment()).commit()
               true
           }
           R.id.third->{
               supportFragmentManager.beginTransaction().replace(fl.id,youtubeFragment()).commit()
               true

           }
           R.id.fourth->{
               supportFragmentManager.beginTransaction().replace(fl.id,boardFragment()).commit()
               true
           }

           else -> {
               supportFragmentManager.beginTransaction().replace(fl.id, cameraFragment()).commit()
           true
           }

           }


   }
init()


    }
    fun init(){

    }

}

