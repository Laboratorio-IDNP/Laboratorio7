package com.example.laboratorio7.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.laboratorio7.R;
public class SegundoFragmento extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String nom;
    private String ap;

    TextView t1;
    TextView t2;

    public SegundoFragmento() {
    }

    public static SegundoFragmento newInstance(String nombre, String apellido) {
        SegundoFragmento fragment = new SegundoFragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre);
        args.putString(ARG_PARAM2, apellido);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nom = getArguments().getString(ARG_PARAM1);
            ap = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.fragment_segundo, container, false);
        t1 = v2.findViewById(R.id.nombre);
        t1.setText(nom);
        t2 = v2.findViewById(R.id.apellido);
        t2.setText(ap);
        return v2;
    }
}