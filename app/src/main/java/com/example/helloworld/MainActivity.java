package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private boolean secondScreen = false;

    // Фотографії з Wikimedia Commons

    private final String heroImage =
            "https://commons.wikimedia.org/wiki/Special:FilePath/Ukrainian%20Christmas.jpg?width=1400";

    private final String dinnerImage =
            "https://commons.wikimedia.org/wiki/Special:FilePath/Christmas%20new%20year%20holidays%20table.%20Ukraine.jpg?width=1200";

    private final String didukhImage =
            "https://commons.wikimedia.org/wiki/Special:FilePath/Decoration%20made%20from%20wheat,%20so%20called%20didukh.%20(Ukrainian%20Christmas%20traditions.).jpg";

    private final String starImage =
            "https://commons.wikimedia.org/wiki/Special:FilePath/Bright%20handmade%20star%20in%20front%20of%20Christmas%20tree.jpg?width=1200";

    private final String carolImage =
            "https://commons.wikimedia.org/wiki/Special:FilePath/Kolyadky%20in%20Dnipro.jpg?width=1200";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showMainScreen();
    }

    // ПЕРШИЙ ЕКРАН

    private void showMainScreen() {

        setContentView(R.layout.activity_main);
        secondScreen = false;

        ImageView imgHero = findViewById(R.id.imgHero);
        ImageView imgPreview = findViewById(R.id.imgPreview);

        Button btnExplore = findViewById(R.id.btnExplore);

        Glide.with(this)
                .load(heroImage)
                .centerCrop()
                .into(imgHero);

        Glide.with(this)
                .load(dinnerImage)
                .centerCrop()
                .into(imgPreview);

        btnExplore.setOnClickListener(v -> showTraditionsScreen());
    }

    // ДРУГИЙ ЕКРАН

    private void showTraditionsScreen() {

        setContentView(R.layout.activity_traditions);
        secondScreen = true;

        ImageView imgDidukh = findViewById(R.id.imgDidukh);
        ImageView imgStar = findViewById(R.id.imgStar);
        ImageView imgCarolers = findViewById(R.id.imgCarolers);

        Button btnDiscover = findViewById(R.id.btnDiscover);

        RadioGroup traditionGroup =
                findViewById(R.id.traditionGroup);

        Glide.with(this)
                .load(didukhImage)
                .centerCrop()
                .into(imgDidukh);

        Glide.with(this)
                .load(starImage)
                .centerCrop()
                .into(imgStar);

        Glide.with(this)
                .load(carolImage)
                .centerCrop()
                .into(imgCarolers);

        btnDiscover.setOnClickListener(v -> {

            int selectedId =
                    traditionGroup.getCheckedRadioButtonId();

            String message;

            if (selectedId == R.id.radioDidukh) {
                message = "Твій вибір - різдвяний дідух! ✨";
            } else if (selectedId == R.id.radioStar) {
                message = "Твій вибір - різдвяна зірка! ⭐";
            } else {
                message = "Твій вибір - колядки та вертеп! 🎄";
            }

            Toast.makeText(
                    MainActivity.this,
                    message,
                    Toast.LENGTH_LONG
            ).show();

        });
    }

    @Override
    public void onBackPressed() {

        if (secondScreen) {
            showMainScreen();
        } else {
            super.onBackPressed();
        }
    }
}