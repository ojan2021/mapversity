package com.example.mapversitydemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class EventScreen extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ListView eventListView = view.findViewById(R.id.eventList);
        final ArrayList<String> events = new ArrayList<>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(),android.R.layout.simple_list_item_1,events);

        final EditText eventName = view.findViewById(R.id.eventName);
        final EditText eventTime = view.findViewById(R.id.eventTime);
        final EditText eventPlace = view.findViewById(R.id.eventPlace);
        final EditText eventNotes = view.findViewById(R.id.eventNotes);


        final View deneme = view.findViewById(R.id.eventCreator);
        deneme.setVisibility(View.INVISIBLE);

        Button addEvent = view.findViewById(R.id.addEvent);
        addEvent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                deneme.setVisibility(View.VISIBLE);
            }
        });

        Button doneEvent = view.findViewById(R.id.doneEvent);
        doneEvent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                deneme.setVisibility(View.INVISIBLE);
                events.add(eventName.getText().toString()+"\n"+eventTime.getText().toString()+"\n"
                +eventPlace.getText().toString()+"\n"+eventNotes.getText().toString());
                eventListView.setAdapter(arrayAdapter);
            }
        });



    }
}
