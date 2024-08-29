package com.gamzecoskun.switchboard

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gamzecoskun.switchboard.common.viewBinding
import com.gamzecoskun.switchboard.databinding.ActivityMainBinding
import com.gamzecoskun.switchboard.ui.healthcontrol.HealthControlViewModel
import com.gamzecoskun.switchboard.ui.healthcontrol.NavigationItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var navController: NavController

    private lateinit var bottomNav: BottomNavigationView

    private val viewModel: HealthControlViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        bottomNav = binding.bottomNav

        viewModel.addedItemsOrder.observe(this, Observer { updatedOrder ->
            updateBottomNavigationView(updatedOrder)
            Log.e("addedItems", updatedOrder.toString())
        })

        viewModel.healthControlChecked.observe(this, Observer { isChecked ->
            bottomNavVisibility(isChecked)
        })
    }

    private fun updateBottomNavigationView(order: List<NavigationItem>) {
        val menu = bottomNav.menu
        menu.clear()

        val healthControlItem = NavigationItem.HEALTHCONTROL
        menu.add(Menu.NONE, healthControlItem.fragmentId, Menu.NONE, "Health Control")
            .setIcon(healthControlItem.iconRes)

        var addedItemCount = 1
        var toastShown = false

        order.forEach { item ->
            if (addedItemCount < 5) {
                menu.add(Menu.NONE, item.fragmentId, addedItemCount, item.name)
                    .setIcon(item.iconRes)
                addedItemCount++
            } else if (!toastShown) {
                Toast.makeText(
                    this,
                    getString(R.string.limit_five),
                    Toast.LENGTH_SHORT
                ).show()
                toastShown = true
            }
        }
    }

    private fun bottomNavVisibility(healtControlChecked: Boolean) {
        if (healtControlChecked) {
            binding.bottomNav.visibility = View.GONE
        } else {
            binding.bottomNav.visibility = View.VISIBLE
        }
    }
}








