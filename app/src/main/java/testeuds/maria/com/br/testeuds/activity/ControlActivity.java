package testeuds.maria.com.br.testeuds.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import testeuds.maria.com.br.testeuds.R;

public class ControlActivity extends AppCompatActivity {

    //private Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        setTitle("Controle");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_control, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                //abrir a tela de configurações
                Intent goToSettings = new Intent(ControlActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
                break;

            case R.id.menu_doubts:
                //ir para o site
                Intent intentSite = new Intent(Intent.ACTION_VIEW);

                String site = "digipower.com.br/contato-2/";
                if (!site.startsWith("http://")) {
                    site = "http://" + site;
                }
                intentSite.setData(Uri.parse(site));
                startActivity(intentSite);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
