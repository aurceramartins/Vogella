package com.example.alex.vogella;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });
        Button b2 = (Button) view.findViewById(R.id.boton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrar("");
            }
        });
        return view;
    }

    public void setText(String text) {
        TextView view = (TextView) getView().findViewById(R.id.holatexto);
        view.setText(text);
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(String uri) {
        String newTime = String.valueOf(System.currentTimeMillis());
        listener.onRssItemSelected(newTime);
    }

    public void borrar(String url) {
        TextView view = (TextView) getView().findViewById(R.id.holatexto);
        view.setText("");
        listener.onRssItemSelected("");

    }

}
