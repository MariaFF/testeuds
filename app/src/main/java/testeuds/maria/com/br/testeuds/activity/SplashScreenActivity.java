package testeuds.maria.com.br.testeuds.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import testeuds.maria.com.br.testeuds.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int time = 1000; //1 seg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainTabsActivity.class);
                startActivity(i);
                finish();

            }
        }, time);
    }
}
