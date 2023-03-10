package itsz.rodeza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_administrador);

        //Metodo que nos lleva a la ventana registrar producto dentro se llama al metodo RegistrarProducto
        findViewById(R.id.btnRegistrarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarProducto();
            }
        });
        //Metodo que nos lleva a la ventana editar producto dentro se llama al metodo EditarProducto
        findViewById(R.id.btnEditarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarProducto();
            }
        });
        //Metodo que nos lleva a la ventana buscar producto dentro se llama al metodo BuscarProducto
        findViewById(R.id.btnBuscarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarProducto();
            }
        });
        //Metodo que nos lleva a la ventana borrar producto, dentro se llama al metodo BorrarProducto
        findViewById(R.id.borrarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BorrarProducto();
            }
        });
    }
    private void RegistrarProducto(){
        Intent intent = new Intent(this,RegistrarProducto.class);
        startActivity(intent);
    }
    private void EditarProducto(){
        Intent intent= new Intent(this,EditarProducto.class);
        startActivity(intent);
    }
    private void BuscarProducto(){
        Intent intent= new Intent(this,BuscarProducto.class);
        startActivity(intent);
    }
    private void BorrarProducto(){
        Intent intent= new Intent(this,BorrarProducto.class);
        startActivity(intent);
    }
}