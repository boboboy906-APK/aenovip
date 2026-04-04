package com.aeno.vip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(MainActivity.this, "指纹认证成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(MainActivity.this, "认证失败", Toast.LENGTH_SHORT).show();
            }
        });

        BiometricPrompt.PromptInfo info = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("AenoVIP 解锁")
                .setSubtitle("请验证指纹进入")
                .setNegativeButtonText("取消")
                .build();

        biometricPrompt.authenticate(info);

        Button btnPhoto = findViewById(R.id.btnPhoto);
        Button btnVideo = findViewById(R.id.btnVideo);
        Button btnBrowser = findViewById(R.id.btnBrowser);

        btnPhoto.setOnClickListener(v -> startActivity(new Intent(this, PhotoAlbumActivity.class)));
        btnVideo.setOnClickListener(v -> startActivity(new Intent(this, VideoDownloadActivity.class)));
        btnBrowser.setOnClickListener(v -> startActivity(new Intent(this, BrowserActivity.class)));
    }
}
