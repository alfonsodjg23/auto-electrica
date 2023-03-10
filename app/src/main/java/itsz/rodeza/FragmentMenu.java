package itsz.rodeza;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMenu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMenu newInstance(String param1, String param2) {
        FragmentMenu fragment = new FragmentMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_menu,menu);
        
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_menu, container, false); //Se enlaza el fragmento a inflar

        root.findViewById(R.id.btnCerrarSesion).setOnClickListener(new View.OnClickListener() { //Metodo para boyton cerrar sesion
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut(); //Se instancia el metodo signOut para cerrar sesion
                Intent intent=new Intent(getContext(),LoginActivity.class); //Se ejecutan las lineas para que nos lleve a la actividad Login
                getActivity().onBackPressed();
                startActivity(intent);
            }
        });

        //Metodo que muestra la alerta en el boton informacion de la empresa
        root.findViewById(R.id.btnInformacion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog= new AlertDialog.Builder(getContext());
                dialog.setMessage("Esta empresa se dedica a comercializar productos y refacciones para automoviles\n" +
                                "para mayor informacion puede comunicarse a los numeros:\n" +
                                "\n" +
                                "22322123\n" +
                                "6252416173").setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                AlertDialog alertDialog=dialog.create();
                alertDialog.setTitle("Informacion de la empresa");
                alertDialog.show();
            }
        });
        //Metodo ubicacion de la empresa
        root.findViewById(R.id.btnUbicacion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Aqui se ingresa la url de la ubicacion de la empresa
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com.mx/maps/place/Auto+El%C3%A9ctrica+Rodeza/@18.8398204,-97.1221414,17z/data=!4m12!1m6!3m5!1s0x85c50314eb630355:0x32ff3a56d44a8fce!2sAuto+El%C3%A9ctrica+Rodeza!8m2!3d18.8398263!4d-97.1199529!3m4!1s0x85c50314eb630355:0x32ff3a56d44a8fce!8m2!3d18.8398263!4d-97.1199529"));
                startActivity(intent);
            }
        });
        //Metodo de boton acerca de
        root.findViewById(R.id.btnAcercaDe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setMessage("Aplicacion creada por TECNM itsz \n" +
                        "©Todos los derechos reservados").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alerta=dialog.create();
                alerta.setTitle("Acerca de: ");
                alerta.show();
            }
        });



        return root;
    }

}