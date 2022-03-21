package com.saurav.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saurav.recordkeeper.databinding.ActivityMainBinding as ActivityMainBinding1

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityMainBinding1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding1.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.nav_running){
            onRunningClicked()
            return true
        }else if (item.itemId == R.id.nav_cycling){
            onCylcingClicked()
            return true
        }else{
            return false
        }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
    }

    private fun onCylcingClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
    }


}