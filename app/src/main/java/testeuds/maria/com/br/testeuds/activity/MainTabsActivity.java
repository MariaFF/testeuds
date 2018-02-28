package testeuds.maria.com.br.testeuds.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.adapter.TabsAdapter;
import testeuds.maria.com.br.testeuds.helper.SlidingTabLayout;

public class MainTabsActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);
        getSupportActionBar().hide();

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.maintab_stl);
        viewPager = (ViewPager) findViewById(R.id.maintab_vp);

        slidingTabLayout.setDistributeEvenly(true);
        //mudar a cor do sublinhado
        //slidingTabLayout.setSelectedIndicatorColors();
        slidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);


        //Configurar o adapter
        //obj que vai gerenciar os fragment
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(tabsAdapter);

        slidingTabLayout.setViewPager(viewPager);
    }


}
