package com.example.alex.vogella;


import android.os.Bundle;
import android.app.Activity;


public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener, DetailFragment.mandaOk {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);
    }

    @Override
    public void onRssItemSelected(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setText(link);

    }

    @Override
    public void Okeymakey(String link) {
        MyListFragment fragment2 = (MyListFragment) getFragmentManager().findFragmentById(R.id.listFragment);
        fragment2.setText(link);

    }

}


