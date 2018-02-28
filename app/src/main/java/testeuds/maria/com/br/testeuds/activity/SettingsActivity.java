package testeuds.maria.com.br.testeuds.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import testeuds.maria.com.br.testeuds.R;

public class SettingsActivity extends AppCompatActivity {

    private TextView fieldVersionApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Configurações");

        fieldVersionApp = findViewById(R.id.setting_version_app);
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //VER SE FUNCIONOU
        fieldVersionApp.setText(pInfo.versionName + pInfo.versionCode);
    }
}
