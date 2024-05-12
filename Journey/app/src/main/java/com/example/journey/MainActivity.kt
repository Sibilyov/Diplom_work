package com.example.journey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.journey.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.journey.HomeFragment
import com.example.journey.NotesFragment
import com.example.journey.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.baseline_home_24 -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.baseline_notes_24 -> {
                    replaceFragment(NotesFragment())
                    true
                }
                R.id.baseline_settings_24 ->{
                    replaceFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.bottom_navigation, fragment).commit()

    }


}

