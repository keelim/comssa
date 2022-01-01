/*
 * Designed and developed by 2021 keelim (Jaehyun Kim)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keelim.comssa.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.keelim.comssa.databinding.ActivitySplashBinding
import com.keelim.comssa.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplash()
    }

    private fun initSplash() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            permissions.plus(Manifest.permission.FOREGROUND_SERVICE)
        }
        if (hasPermissions(permissions)) { // 권한이 있는 경우
            goNext()
        } else {
            ActivityCompat.requestPermissions(this, permissions, MULTIPLE_PERMISSIONS)
        }
    }

    private fun hasPermissions(permissions: Array<String>): Boolean {
        permissions.forEach { permission ->
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            )
                return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            MULTIPLE_PERMISSIONS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initSplash()
                }
            }
        }
    }

    private fun goNext() = lifecycleScope.launch{
        delay(3000)
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {}

    companion object {
        const val MULTIPLE_PERMISSIONS = 8888
    }
}
