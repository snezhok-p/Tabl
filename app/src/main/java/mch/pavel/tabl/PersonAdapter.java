package mch.pavel.tabl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class PersonViewHolder extends RecyclerView.ViewHolder {
    public TextView item;
    public TextView tvSurname;

    public PersonViewHolder(View itemView){
        super(itemView);
        item = (TextView)itemView.findViewById(R.id.item);

    }
}


public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private ArrayList<Person> persons;


    public PersonAdapter(ArrayList<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i){
        Person currentPerson = persons.get(i);
        personViewHolder.item.setText(currentPerson.name);

    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new PersonViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return persons.size();
    }

    public class OnItemClickListener {
    }

    public void addItem(int position, Person person){
        this.persons.add(position, person);
    }

    public void deleteItem(int position){
        this.persons.remove(position);
        super.notifyItemRemoved(position);
}
}

