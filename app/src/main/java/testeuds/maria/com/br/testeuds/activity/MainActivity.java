package testeuds.maria.com.br.testeuds.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.dao.PersonDao;
import testeuds.maria.com.br.testeuds.modelo.Person;

public class MainActivity extends AppCompatActivity {


    private EditText fieldName;
    private EditText fieldEmail;
    private EditText fieldPassword;
    private EditText fieldPassword1;
    private Button btRegister;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        person = new Person();
        setContentView(R.layout.activity_main);

        fieldName = (EditText) findViewById(R.id.register_name);
        fieldEmail = (EditText) findViewById(R.id.register_email);
        fieldPassword = (EditText) findViewById(R.id.register_password);
        fieldPassword1 = (EditText) findViewById(R.id.register_password1);


        btRegister = (Button) findViewById(R.id.register_bt_register);

        /**
         * Após ter sucesso no
         cadastro, o aplicativo deve fazer login automático e já armazenar os dados no banco de
         dados local, para que seja liberada as funcionalidades completas do sistema mesmo
         estando offline. É através do cadastro que será gerado o Código de Vínculo (conforme
         descrito na RN 002 )

         senha composta por no minimo 6 caracteres
         verificar se o email já existe
         */

        //Boãto para se cadastrar
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PersonDao dao = new PersonDao(MainActivity.this);

                //APARENTEMENTE A VALIDAÇÃO DE CAMPO OBRIGATORIO E MININO DE 6 CARACTERES E SALVAR ESTÃO FUNCIONANDO
                if (!fieldName.getText().toString().isEmpty()) {
                    if (!fieldEmail.getText().toString().isEmpty()) {
                        //o campo precisa ser diferente de vazio e maior que 6 caracteres
                        if (!fieldPassword.getText().toString().isEmpty()) {
                            if (fieldPassword.getText().toString().length() > 5) {
                                if (fieldPassword1.getText().toString().equals(fieldPassword.getText().toString())) {
                                    String checkEmail = dao.checkRegisterEmail(fieldEmail.getText().toString());
                                    if (checkEmail.equals("ok")) {
                                        //tudo ok com os campos
                                        //método para salvar no banco
                                        getPerson();
                                        dao.insere(person);
                                        dao.close();
                                        Toast.makeText(MainActivity.this, "Person " + person.getName() + " salvo!", Toast.LENGTH_SHORT).show();
                                        Intent goToControle = new Intent(MainActivity.this, ControlActivity.class);
                                        startActivity(goToControle);

                                    } else {
                                        fieldEmail.setError("Email já existente");
                                    }
                                } else {
                                    fieldPassword1.setError("As senhas não correspondem");
                                }

                            } else {
                                fieldPassword.setError("Minimo 6 caracteres");
                            }

                        } else {
                            fieldPassword.setError("Campo obrigatório");
                        }
                    } else {
                        fieldEmail.setError("Campo obrigatório");
                    }

                } else {
                    fieldName.setError("Campo obrigatório");
                }

                //Logar

            }
        });
    }

    /* Função para verificar existência de conexão com a internet
     */
    /*public  boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }*/

    private void getPerson() {
        person.setName(fieldName.getText().toString());
        person.setEmail(fieldEmail.getText().toString());
        person.setPassword(fieldPassword.getText().toString());
    }
}
