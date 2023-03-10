package itsz.rodeza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BottomNavigationActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    HomeFragment fragmentHome = new HomeFragment(); //creamos tres objetos, cada uno corresponde a cada uno de los fragments que creamos
    FragmentUser fragmentUser = new FragmentUser();
    FragmentMenu fragmentMenu=new FragmentMenu();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation); //Creamos una variable de BottomNavigationView y la enlazamos con el id del xml correspondiente a esta clase
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(fragmentHome);
        mAuth = FirebaseAuth.getInstance();


    }//Fin del onCreate

    //Metodo que cambia la vista del fragment donde nos encontramos
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.itemHome: //enlazamos el id de cada boton con el xml y llamamos al metodo loadFragment para decirle que fragment se mostrara
                    loadFragment(fragmentHome);
                    return true;
                case R.id.itemUser:
                    loadFragment(fragmentUser);
                    return true;
                case R.id.itemMenuOpciones:
                    loadFragment(fragmentMenu);
                    return true;
            }

            return false;
        }
    };

    //Metodo loadFragment nos infla los fragmentos
    public void loadFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }
}