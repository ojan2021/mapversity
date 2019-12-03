package com.example.mapversitydemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
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

        final AutoCompleteTextView srcPointView = view.findViewById(R.id.SourcePointText);
        ArrayAdapter<String> srcAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,ROOMS);
        srcPointView.setAdapter(srcAdapter);

        final AutoCompleteTextView destPointView = view.findViewById(R.id.DestinationPointText);
        ArrayAdapter<String> destAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,ROOMS);
        destPointView.setAdapter(destAdapter);


        final ImageView pin1 = view.findViewById(R.id.sourcePin);
        pin1.setVisibility(View.INVISIBLE);

        final ImageView pin2 = view.findViewById(R.id.destinationPin);
        pin2.setVisibility(View.INVISIBLE);

        final ImageView path0 = view.findViewById(R.id.path0);
        path0.setVisibility(View.INVISIBLE);

        final ImageView path1 = view.findViewById(R.id.path1);
        path1.setVisibility(View.INVISIBLE);

        final ImageView path2 = view.findViewById(R.id.path2);
        path2.setVisibility(View.INVISIBLE);

        final View pathChooser = view.findViewById(R.id.pathChooser);
        pathChooser.setVisibility(View.VISIBLE);

        final Button startNavButton = view.findViewById(R.id.startNavigationButton);
        startNavButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pin1.setVisibility(View.VISIBLE);
                pin2.setVisibility(View.VISIBLE);

                path0.setVisibility(View.VISIBLE);
                path1.setVisibility(View.VISIBLE);
                path2.setVisibility(View.VISIBLE);

                pathChooser.setVisibility(View.INVISIBLE);


                startNavButton.setVisibility(View.INVISIBLE);
            }
        });

    }


}
