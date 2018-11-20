package com.ensim.projetsnowtam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SnowtamFragment extends Fragment {


    public SnowtamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_snowtam, container, false);

        final Button decodedBtn = (Button) view.findViewById(R.id.decodeBtn);
        final Button rawBtn = (Button)view.findViewById(R.id.brutBtn);

        final TextView title =(TextView) view.findViewById(R.id.title);
        final TextView decodeText = (TextView) view.findViewById(R.id.textDecoded);
        final TextView rawText = (TextView) view.findViewById(R.id.textRaw);
        String i = getArguments().getString("position");
        title.setText(i);


        decodedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.VISIBLE);
                rawText.setVisibility(View.GONE);
            }
        });
        rawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decodeText.setVisibility(View.GONE);
                rawText.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

}
