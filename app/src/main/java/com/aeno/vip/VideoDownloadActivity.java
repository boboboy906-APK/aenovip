package com.aeno.vip;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class VideoDownloadActivity extends AppCompatActivity {
    private Button btnDownload, btnCompress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_download);

        btnDownload = findViewById(R.id.btnDownload);
        btnCompress = findViewById(R.id.btnCompress);

        btnDownload.setOnClickListener(v -> {
            // 超级下载逻辑
        });

        btnCompress.setOnClickListener(v -> {
            try {
                UltimateEngine engine = new UltimateEngine();
                File input = new File(getExternalFilesDir(null), "video.mp4");
                File output = new File(getExternalFilesDir(null), "video_compressed.bin");
                engine.compress(new FileInputStream(input), new FileOutputStream(output), System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
