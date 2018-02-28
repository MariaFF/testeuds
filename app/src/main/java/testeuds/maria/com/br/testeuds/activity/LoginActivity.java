package testeuds.maria.com.br.testeuds.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.dao.PersonDao;

public class LoginActivity extends AppCompatActivity {

    private EditText fieldEmail, fieldPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fieldEmail = (EditText) findViewById(R.id.login_email);
        fieldPassword = (EditText) findViewById(R.id.login_password);

        btLogin = (Button) findViewById(R.id.login_bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LOGAR
                PersonDao dao = new PersonDao(LoginActivity.this);
                String resultcheckLogin = dao.validateLogin(fieldEmail.getText().toString(), fieldPassword.getText().toString());
                if(resultcheckLogin.equals("ok")){
                    Intent goToControl = new Intent(LoginActivity.this, ControlActivity.class);
                    startActivity(goToControl);
                }else {
                    fieldEmail.setError("Email inválido");
                }


            }
        });
    }
}
