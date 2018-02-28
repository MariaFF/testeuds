package testeuds.maria.com.br.testeuds.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.activity.ControlActivity;
import testeuds.maria.com.br.testeuds.dao.PersonDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText fieldEmail;
    private EditText fieldPassword;

    private Button btLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        fieldEmail = (EditText) view.findViewById(R.id.login_email);
        fieldPassword = (EditText) view.findViewById(R.id.login_password);

        btLogin = (Button) view.findViewById(R.id.login_bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LOGAR
                PersonDao dao = new PersonDao(getContext());
                String resultcheckLogin = dao.validateLogin(fieldEmail.getText().toString(), fieldPassword.getText().toString());
                if(resultcheckLogin.equals("ok")){
                    Intent goToControl = new Intent(getActivity(), ControlActivity.class);
                    startActivity(goToControl);
                    dao.close();
                }else {

                    fieldEmail.setError("Email inválido");
                }


            }
        });

        return view;
    }


}
