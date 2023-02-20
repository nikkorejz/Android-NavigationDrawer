package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var config: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Включаем гамбургер (настраиваем toolbar)
        setSupportActionBar(binding.toolbarContainer.toolbar)
        navController = findNavController(R.id.fragmentContainerView)
        config = AppBarConfiguration(
            setOf(
                R.id.fragment1,
                R.id.fragment2,
            ),
            binding.Drawer
        )
        setupActionBarWithNavController(navController, config)

        // Включение навигации
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(config) || super.onSupportNavigateUp()
    }
}