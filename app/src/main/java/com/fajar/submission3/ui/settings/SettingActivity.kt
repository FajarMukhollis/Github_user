package com.fajar.submission3.ui.settings

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.fajar.submission3.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private val viewModel: SettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            viewModel.saveThemeSetting(isChecked)
        }

        viewModel.getThemeSetting().observe(this) { isDarkModeActive ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switchTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switchTheme.isChecked = false
            }
        }


    }
}