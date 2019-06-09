package mch.pavel.tabl;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    PersonAdapter personAdapter;
    Boolean charactersAlive = true;
    ArrayList<Person> persons;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain = (RecyclerView)findViewById(R.id.rvRecyclerView);
        persons = getPersons();
        personAdapter = new PersonAdapter(persons);

//тут проблема, не знаю почему
        personAdapter.setOnItemClickListener(new PersonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick( View v, int position) {
                ItemDialog(position);
            }
        });
        rvMain.setAdapter(personAdapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }
// сначала хотел через кнопку сделать удаление, потом решил через диалоговое окно
    private void ItemDialog(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] actions = { "Delete"};
        builder.setTitle("Choose action: ").setItems(actions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){

                    case 1:
                        DeleteItem(position);
                        break;
                }
            }
        }).show();
    }



    private void DeleteItem(int position){
        personAdapter.deleteItem(position);
        personAdapter.notifyItemRemoved(position);
    }

    public ArrayList<Person> getPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        Person John = new Person();
        John.name = "John";
        Person Pavel = new Person();
        Pavel.name = "Pavel";
        Person Olga = new Person();
        Olga.name= "Olga";
        Person Mike = new Person();
        Mike.name= "Mike";
        Person Ben = new Person();
        Ben.name= "Ben";

        persons.add(John);
        persons.add(Pavel);
        persons.add(Olga);
        persons.add(Mike);
        persons.add(Ben);
        return persons;
    }
}
