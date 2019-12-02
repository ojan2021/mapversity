package com.example.mapversitydemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class NavScreen extends Fragment {

    private static final String[] ROOMS = new String[]{"A210", "A209", "A202", "A201",
            "Locker Room", "WC", "Seminar Rooms", "Elevators"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PhotoView photoView = view.findViewById(R.id.mapA201);
        photoView.setImageResource(R.drawable.a201lala);

        AutoCompleteTextView srcPointView = view.findViewById(R.id.SourcePoint);
        ArrayAdapter<String> srcAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,ROOMS);
        srcPointView.setAdapter(srcAdapter);

        AutoCompleteTextView destPointView = view.findViewById(R.id.DestinationPoint);
        ArrayAdapter<String> destAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,ROOMS);
        destPointView.setAdapter(destAdapter);


    }
}
