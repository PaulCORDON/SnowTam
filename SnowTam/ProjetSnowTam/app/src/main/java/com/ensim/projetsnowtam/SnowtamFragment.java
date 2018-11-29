package com.ensim.projetsnowtam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SnowtamFragment extends Fragment {
    private static final String TAG = "SnowtamFragment";
    public SnowtamFragment() {
        // Required empty public constructor
    }
    public static SnowtamFragment newInstance(String title,String snowtamBrut, String snowtamDecoded) {
        SnowtamFragment fragment = new SnowtamFragment();
        Bundle args = new Bundle();
        Log.d(TAG,title);
        Log.d(TAG,snowtamBrut);
        Log.d(TAG,snowtamDecoded);
        args.putString("title", title);
        args.putString("SnowtamBrut",snowtamBrut);
        args.putString("SnowtamDecoded",snowtamDecoded);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_snowtam, container, false);

        final Button decodedBtn = (Button) view.findViewById(R.id.decodeBtn);
        final Button rawBtn = (Button)view.findViewById(R.id.brutBtn);

        final TextView title =(TextView) view.findViewById(R.id.title);
        final TextView decodeText = (TextView) view.findViewById(R.id.textDecoded);
        final TextView rawText = (TextView) view.findViewById(R.id.textRaw);
        String title1 = getArguments().getString("title");
        String snowtamBrut = getArguments().getString("SnowtamBrut");
        String snowtamDecoded = getArguments().getString("SnowtamDecoded");
        title.setText(title1);
        rawText.setText(snowtamBrut);
        decodeText.setText(snowtamDecoded);
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
