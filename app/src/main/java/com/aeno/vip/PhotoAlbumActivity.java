package com.aeno.vip;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PhotoAlbumActivity extends AppCompatActivity {
    private GridView gridView;
    private List<String> photoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_album);

        gridView = findViewById(R.id.gridView);
        // 模拟 30 页 × 20 张图
        for (int page = 0; page < 30; page++) {
            for (int i = 0; i < 20; i++) {
                photoList.add("Page " + (page+1) + " - Photo " + (i+1));
            }
        }
        // 适配器 + 压缩逻辑（调用 UltimateEngine）
        PhotoAdapter adapter = new PhotoAdapter(this, photoList);
        gridView.setAdapter(adapter);
    }
}
