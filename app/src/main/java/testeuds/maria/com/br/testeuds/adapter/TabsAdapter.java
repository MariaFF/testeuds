package testeuds.maria.com.br.testeuds.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import testeuds.maria.com.br.testeuds.fragment.LoginFragment;
import testeuds.maria.com.br.testeuds.fragment.RegisterFragment;

/**
 * Created by maria on 27/02/2018.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {
    private Context context;
    //O ARRAY NA POSIÇÃO 0 VAI POR O REGISTER
    private String[] titleTabs = {"CADASTRAR", "LOGIN"};


    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new RegisterFragment();

                break;
            case 1:
                fragment = new LoginFragment();
                break;
        }
        //retorna qual fragment vai ser carregado no viewpage
        return fragment;
    }

    @Override
    public int getCount() {

        //retornando o tamanho do array
        return titleTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titleTabs[position];
    }
}
