package testeuds.maria.com.br.testeuds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import testeuds.maria.com.br.testeuds.R;
import testeuds.maria.com.br.testeuds.modelo.Person;

/**
 * Created by maria on 27/02/2018.
 */

public class PersonAdapter extends BaseAdapter{
    private final List<Person> persons;
    private final Context context;

    public PersonAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        Person person = persons.get(position);

        TextView fieldName = view.findViewById(R.id.list_item_name);
        fieldName.setText(person.getName().toString());
        TextView fieldEmail = view.findViewById(R.id.list_item_email);
        fieldEmail.setText(person.getEmail().toString());
        TextView fieldPassword = view.findViewById(R.id.list_item_password);
        fieldPassword.setText(person.getPassword().toString());

        return view;
    }
}
