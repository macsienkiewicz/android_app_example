package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fg_container) as NavHostFragment

        val navController = navHostFragment.navController

        val bnNavView = findViewById<View>(R.id.bottom_nav) as BottomNavigationView
        bnNavView.setOnItemSelectedListener { item ->


            when (item.itemId) {
                R.id.bn_1 -> navController.navigate(R.id.fragment_1)
                R.id.bn_2 -> navController.navigate(R.id.fragment_2)
                R.id.bn_3 -> navController.navigate(R.id.fragment_3)
                R.id.bn_4 -> navController.navigate(R.id.fragment_4)
            }

            true


        }

    }







}