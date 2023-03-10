package itsz.rodeza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginAdministrador extends AppCompatActivity {
    private TextInputEditText TextInputCodigo; //Se crea la variable o objeto de tipo TextInputEditText
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_administrador);
        TextInputCodigo = findViewById(R.id.TvCodigo); //Se relaciona el objeto creado anteriormente con el id del xml de esta clase

        //Metodo del btnCodigo y dentro se llama al metodo Login
        findViewById(R.id.btnCodigo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }
    //Metodo login
    private void Login(){
        String code=TextInputCodigo.getText().toString().trim(); //Se crea una variable de tipo String y se recupera el codigo que se ingreso
        if(!code.isEmpty()){
            if(code.equals("123456")){ //Comparamos si el codigo es igual a 123456 se ejecuta lo que esta dentro del cuerpo del if
                Intent intent=new Intent(this,HomeAdministrador.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Codigo incorrecto", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Ingresa el codigo del administrador", Toast.LENGTH_SHORT).show();
        }
    }
}





