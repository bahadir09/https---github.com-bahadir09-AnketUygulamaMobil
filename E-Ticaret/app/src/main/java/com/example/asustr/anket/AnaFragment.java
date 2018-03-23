package com.example.asustr.anket;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by kadir on 26.11.2017.
 */

public class AnaFragment extends Fragment {

    Spinner spinner;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.ana_layout, container, false);

        Button btnEkle = (Button) myView.findViewById(R.id.btnEkle);

        spinner = (Spinner) myView.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(myView.getContext(), R.array.Soru_Tipi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                /*String[] diziSorutipi = getResources().getStringArray(R.array.Soru_Tipi);
                if (i == 1) {
                    Intent ıntent = new Intent(myView.getContext(), AnketCoktanSecmeli.class);
                    startActivity(ıntent);
                }*/
                DataStore.SoruTipi=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnEkle.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View view) {

                startActivity(new Intent(myView.getContext(), SoruEkle.class));
            }
        });

        return myView;

    }
}



