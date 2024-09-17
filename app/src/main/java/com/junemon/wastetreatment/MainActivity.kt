package com.junemon.wastetreatment

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.junemon.wastetreatment.base.BaseActivity
import com.junemon.wastetreatment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val DELAY = 10L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        disableNightMode()
        askNotificationPermission()
        initView()

    }

    private fun initView() {
        setupNavigationController()
    }

    private fun setupNavigationController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.mainNavHostFragment.id) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(binding.bottomNavigationView.id)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            lifecycleScope.launch {
                when (destination.id) {
                    R.id.fragmentLogin -> {
                        delay(DELAY)
                        disableBottomNav()
                    }

                    R.id.fragmentHome -> {
                        delay(DELAY)
                        enableBottomNav()
                    }

                    R.id.fragmentHistory -> {
                        delay(DELAY)
                        enableBottomNav()
                    }

                    R.id.fragmentProfile -> {
                        delay(DELAY)
                        enableBottomNav()
                    }

                    else -> {
                        delay(DELAY)
                        enableWithoutBottomNav()
                    }
                }
            }
        }
    }


    private fun enableBottomNav() {
        binding.llMainApp.visibility = View.VISIBLE
        binding.viewShadow.visibility = View.VISIBLE
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun enableWithoutBottomNav() {
        binding.llMainApp.visibility = View.VISIBLE
        binding.viewShadow.visibility = View.GONE
        binding.bottomNavigationView.visibility = View.GONE
    }

    private fun disableBottomNav() {
        binding.llMainApp.visibility = View.GONE
        binding.viewShadow.visibility = View.GONE
        binding.bottomNavigationView.visibility = View.GONE
    }


    // Declare the launcher at the top of your Activity/Fragment:
    private val requestNotificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (!isGranted) {
            showMaterialDialog(
                title = getString(R.string.notification_permission),
                message = getString(R.string.permission_not_granted_message)
            )
                .setPositiveButton(getString(R.string.positive_button_message)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }


    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (isShowRequestPermissionRationaleForTiramisu()) {
                showMaterialDialog(
                    title = getString(R.string.notification_permission),
                    message = getString(R.string.first_permission_message)
                )
                    .setNegativeButton(getString(R.string.negative_button_message)) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(getString(R.string.positive_button_message)) { dialog, _ ->
                        requestNotificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        dialog.dismiss()
                    }
                    .show()
            }

            if (!isPermissionGrantedForTiramisu()) {
                requestNotificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }


}