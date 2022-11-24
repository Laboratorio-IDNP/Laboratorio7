package com.example.laboratorio7.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laboratorio7.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    Button bMostrar, bOcultar;
    EditText nom,ap;
    String nomS,apS;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        nom = v.findViewById(R.id.nombre);
        ap = v.findViewById(R.id.numero);

        bMostrar = v.findViewById(R.id.mostrarF1);
        bOcultar = v.findViewById(R.id.ocultarF1);

        LinearLayout l = v.findViewById(R.id.Fragmento2);

        bMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction t = getChildFragmentManager().beginTransaction();
                nomS = nom.getText().toString();
                apS = ap.getText().toString();

                if(nomS.equals(" ")|| apS.equals(" ")){
                    Toast.makeText(getContext(),"Debe ingresar su nombre y apellidos",Toast.LENGTH_SHORT).show();
                }
                else {
                    SegundoFragmento f = SegundoFragmento.newInstance(nomS, apS);

                    t.replace(R.id.Fragmento2, f);
                    t.commit();

                    nom.setText(" ");
                    ap.setText(" ");

                    if(l.getVisibility() == View.GONE){
                        l.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        bOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.GONE);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }
}