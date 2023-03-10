package itsz.rodeza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUser extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentUser.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUser newInstance(String param1, String param2) {
        FragmentUser fragment = new FragmentUser();
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

    FirebaseAuth auth;  //creamos los tipos de objetos o variables que se usaran
    private ImageView ivUser;
    private TextView tvBienvenido,tvUser,tvIndicacion,tvNumber;
    private Button btnIniciarSesionUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View root= inflater.inflate(R.layout.fragment_user, container, false); //indicamos que fragment se inflara
            tvUser=root.findViewById(R.id.tvUser); //relacionamos todos los elementos de esta clase al fragment xml por su id
            ivUser=root.findViewById(R.id.ivUser);
            tvBienvenido=root.findViewById(R.id.tvBienvenido);
            tvIndicacion=root.findViewById(R.id.tvIndicacion);
            tvNumber=root.findViewById(R.id.tvNumber);
            btnIniciarSesionUser=root.findViewById(R.id.btnIniciarSesionUser);
            //Se invoca FirebaseGetInstance para saber si el usuario accedio o no, de no haber accedido se muestra el boton iniciar sesion
            auth=FirebaseAuth.getInstance();

            //Metodo que nos lleva al login en este fragment
            btnIniciarSesionUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getContext(),LoginActivity.class);
                    startActivity(intent);
                }
            });
        return root;
    }//Fin del OncreateView
    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() { //metodo onStar se ejecuta junto al onCreate
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user ==null){ //condicion que valida si el usuario es nulo se llama el metodo UserNoExit
            UserNoExit();
        }else{  //Caso contrario se llama al metodo UserExit
            UserExit();
            String numero=user.getPhoneNumber(); //Se crea una variable y se recupera el numero con getPhoneNumber
            tvNumber.setText(numero); //se inserta el numero al textView tvNumber
        }
    }
    @SuppressLint("SetTextI18n")
    private void UserNoExit(){ //Metodo UserNoExit muestra los elementos en caso de que el usuario no haya accedido
        ivUser.setImageResource(R.drawable.ic_nousersvg);
        tvBienvenido.setText("No se a iniciado sesion");
        tvIndicacion.setVisibility(View.INVISIBLE);
        tvUser.setVisibility(View.INVISIBLE);
        tvNumber.setVisibility(View.INVISIBLE);
        btnIniciarSesionUser.setVisibility(View.VISIBLE);
    }
    @SuppressLint("SetTextI18n")
    private void UserExit(){ //Metodo UserExit muestra los elementos en caso de que el usuario si accedio
        ivUser.setImageResource(R.drawable.ic_usersvg);
        tvBienvenido.setText("Bienvenido haz iniciado sesion");
        tvIndicacion.setVisibility(View.VISIBLE);
        tvUser.setVisibility(View.VISIBLE);
        btnIniciarSesionUser.setVisibility(View.INVISIBLE);
    }

}