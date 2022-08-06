package com.xayah.databackup.activity.guide

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.xayah.databackup.App
import com.xayah.databackup.R
import com.xayah.databackup.activity.main.MainActivity
import com.xayah.databackup.databinding.ActivityGuideBinding
import com.xayah.databackup.util.GlobalString
import com.xayah.databackup.util.readInitializedVersionName

class GuideActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuideBinding
    private lateinit var viewModel: GuideViewModel
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityGuideBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[GuideViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        judgePage()

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_guide) as NavHostFragment
        navController = navHostFragment.navController

        viewModel.btnOnClick.observe(this) {
            binding.materialButton.setOnClickListener(it)
        }
        viewModel.navigation.observe(this) {
            navController.navigate(it)
        }
        viewModel.finish.observe(this) {
            if (it) toMain()
        }
    }

    private fun toMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun judgePage() {
        if (App.globalContext.readInitializedVersionName().isNotEmpty()) {
            if (App.globalContext.readInitializedVersionName() == App.versionName) {
                toMain()
            } else {
                viewModel.navigation.postValue(R.id.action_guideOneFragment_to_guideUpdateFragment)
                viewModel.btnText.postValue(GlobalString.finish)
            }
        }
    }
}