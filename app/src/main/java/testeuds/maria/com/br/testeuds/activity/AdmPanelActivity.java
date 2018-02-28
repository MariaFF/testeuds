package testeuds.maria.com.br.testeuds.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.adapter.PersonAdapter;
import testeuds.maria.com.br.testeuds.dao.PersonDao;
import testeuds.maria.com.br.testeuds.modelo.Person;

public class AdmPanelActivity extends AppCompatActivity {

    private ListView listPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_panel);
        setTitle("Painel adm");
        listPerson = (ListView) findViewById(R.id.adm_panel_list);
        carregaLista();

    }

    private void carregaLista() {
        PersonDao dao = new PersonDao(this);
        List<Person> persons = dao.findPerson();
        PersonAdapter adapter = new PersonAdapter(persons, this);
        listPerson.setAdapter(adapter);
    }
}
