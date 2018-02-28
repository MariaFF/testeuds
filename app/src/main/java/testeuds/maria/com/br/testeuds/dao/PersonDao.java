package testeuds.maria.com.br.testeuds.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import testeuds.maria.com.br.testeuds.modelo.Person;

/**
 * Created by maria on 26/02/2018.
 */

public class PersonDao extends SQLiteOpenHelper {

    public PersonDao(Context context) {
        super(context, "UdsTeste", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Person" +
                "(id INTEGER PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "password TEXT NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insere(Person person) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getDataPerson(person);
        db.insert("Person", null, dados);

    }

    public void altera(Person person) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getDataPerson(person);

        String[] params = {person.getId().toString()};
        db.update("Person", dados, "id = ?", params);
    }

    private ContentValues getDataPerson(Person person) {
        ContentValues dados = new ContentValues();
        dados.put("name", person.getName());
        dados.put("email", person.getEmail());
        dados.put("password", person.getPassword());

        return dados;
    }

    public List<Person> findPerson(){
        String sql = ("SELECT * FROM Person");
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Person> persons = populaPerson(c);
        c.close();

        return persons;
    }

    private List<Person> populaPerson(Cursor c) {
        List<Person> listPerson = new ArrayList<Person>();
        while (c.moveToNext()){
            Person person = new Person();
            person.setId(c.getString(c.getColumnIndex("id")));
            person.setName(c.getString(c.getColumnIndex("name")));
            person.setEmail(c.getString(c.getColumnIndex("email")));
            person.setPassword(c.getString(c.getColumnIndex("password")));

            listPerson.add(person);
        }
        return listPerson;
    }

    public String checkRegisterEmail(String email){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Person WHERE email=?", new String[]{email});
        if(c.getCount() != 0){
            //significa que tem email igual no banco
            return "erro";
        }else {
            return "ok";
        }
    }

    //mudar o nome
    public String validateLogin(String email, String password) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Person WHERE email=? AND password=?", new String[]{email, password});
        //se ele for diferente de zero é pq tem email correspondente
        if (c.getCount() != 0)
            return "ok";
        else
            return "erro";
    }


}
