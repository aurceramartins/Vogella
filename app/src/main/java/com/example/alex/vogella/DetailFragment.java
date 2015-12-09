package com.example.alex.vogella;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private mandaOk listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,
                container, false);
        Button b2 = (Button) view.findViewById(R.id.botonOK);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok();
            }
        });
        return view;
    }

    public void setText(String url) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(url);
    }

    public interface mandaOk {
        public void Okeymakey(String link);

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof mandaOk) {
            listener = (mandaOk) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement DetailFragment.mandaOk");
        }
    }

    public void ok() {
        listener.Okeymakey("Ok");
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText("Okey ya lo he entendido");
    }
}
