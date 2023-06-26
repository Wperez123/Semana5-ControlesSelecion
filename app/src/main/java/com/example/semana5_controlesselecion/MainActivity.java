package com.example.semana5_controlesselecion;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Datos
        final String[] datos = new
                String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        final String[] listaAmigos = new
                String[]{"Moncho","Melanie","Jose","Mirandaaa","moncho23"};
        //Adaptador
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, listaAmigos);
        //Asignar el Adaptador a la vista(Spinner)
         Spinner cmbOpciones = (Spinner)findViewById(R.id.cblista);
         adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(this);
        ListView lstOpciones = (ListView) findViewById(R.id.lslista);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        TextView txtItem = (TextView)findViewById(R.id.txtitem);
        txtItem.setText("Seleccionado: " + adapterView.getItemAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView txtItem = (TextView) findViewById(R.id.txtitem);
        txtItem.setText("Invita al cine: " + adapterView.getItemAtPosition(i));
    }
}