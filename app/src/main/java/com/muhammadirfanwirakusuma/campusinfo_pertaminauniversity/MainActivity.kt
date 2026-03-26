package com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.muhammadirfanwirakusuma.campusinfo_pertaminauniversity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavHostFragment dari layout
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Ambil NavController
        val navController = navHostFragment.navController

        // Hubungkan BottomNavigationView dengan NavController
        binding.bottomNav.setupWithNavController(navController)
    }
}