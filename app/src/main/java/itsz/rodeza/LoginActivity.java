package itsz.rodeza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    //Se crean las variables que se enlazaran con la parte grafica de esta actividad se uso Firebase para esta app
    private Button btnSendCode;
    private TextView processText,tvOmitir,tvAdministrador;
    private TextInputLayout TextLayoutPais;
    private TextInputEditText TextInputPais , TextInputNumero;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se enlazan las variables creadas anteriormente con el id de la parte grafica del xml
        btnSendCode = findViewById(R.id.btnEnviarCodigo);
        processText = findViewById(R.id.tvMensaje);
        TextLayoutPais = findViewById(R.id.TextInputLayoutPais);
        TextInputPais = findViewById(R.id.TextInputPais);
        TextInputNumero = findViewById(R.id.TextInputCodigo);
        tvOmitir=findViewById(R.id.tvOmitir);
        tvAdministrador=findViewById(R.id.tvAdministrador);

        auth = FirebaseAuth.getInstance(); //Inicializamos la variable auth con la clase FirebaseAuth
        TextLayoutPais.setVisibility(View.GONE); //Se oculta el cuadro donde se ponia el codigo de pais
        TextInputPais.setText("52");  //Se ingresa el codigo de pais desde este codigo


        btnSendCode.setOnClickListener(new View.OnClickListener() {  // Metodo del boton enviar codigo
            @Override
            public void onClick(View v) {
                String country_code = TextInputPais.getText().toString(); //Recuperacion de datos ingresados por el usuario
                String phone = TextInputNumero.getText().toString(); //Se crea una variable string y se almacena lo que se recupera de lo que se ingreso en el editText numero
                String phoneNumber = "+" + country_code + "" + phone; //Creamos variable string llamada phoneNumber y concatenamos el codigo y numero de telefono
                if (country_code.equals("52") && !phone.isEmpty()){ //condicion que valida si codigo es 52 y numero es diferente de vacio entra al cuerpo del if
                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)  //se crea un objeto de la clase PhoneAuthOptions y generamos una nueva autenticacion
                            .setPhoneNumber(phoneNumber)  //insertamos el numero de telefono y le pasamos la variable que contiene el numero
                            .setTimeout(60L , TimeUnit.SECONDS) //el metodo setTimeout se le dice el tiempo de espera y que sera en segundos
                            .setActivity(LoginActivity.this)
                            .setCallbacks(mCallBacks)
                            .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);
                }else{ //En caso de que la condicion no se cumpla se ejecuta este else
                    processText.setText("Por favor llene todos los campos");
                    processText.setTextColor(Color.RED);
                    processText.setVisibility(View.VISIBLE);
                }
            }
        });
        mCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() { //Usamos el objeto mCallBacks y llamamos al metodo SingIn si la verificacion se completo
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signIn(phoneAuthCredential); //Se llama al metodo sinIng
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) { //metodo si la verificacion fallo
                processText.setText(e.getMessage()); //se pone el error en el textview processText
                processText.setTextColor(Color.RED);  //se colorea el texto a rojo
                processText.setVisibility(View.VISIBLE); //se pone visible
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                processText.setText("Mensaje de texto enviado"); //en el texview se pone si el mensaje se envio o no
                processText.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() { //si se envio automaticamente se inicia la actividad donde se va a ingresar el codigo
                    @Override
                    public void run() {
                        Intent otpIntent = new Intent(LoginActivity.this , OtpActivity.class);
                        otpIntent.putExtra("auth" , s);
                        startActivity(otpIntent);
                    }
                }, 10000);

            }
        };

        //Metodo para omitir inicio de sesion en el textView omitir
        tvOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingresar();
            }
        });
        //Metodo para iniciar sesion como administrador en el textView Iniciar sesion como administrador
        tvAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginAdministrador(); //Se llama al metodo LoginAdministrador
            }
        });
    }//Fin del oncreate

    @Override
    protected void onStart() { //metodo onStar dentro de este metodo se crea un objeto de la clase FirebaseUser
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user !=null){ //Condicion que valida si el usuario es diferente de nulo se llama al metodo Ingresar
            Ingresar();
        }
    }
    //Metodo para inicio de sesion como administrador
    private void LoginAdministrador(){
        Intent intent= new Intent(this,LoginAdministrador.class);
        startActivity(intent);
    }
    //Metodo ingresar que nos lleva a la clase BottomNavigation
    private void Ingresar(){
        Intent mainIntent = new Intent(LoginActivity.this , BottomNavigationActivity.class);
        startActivity(mainIntent);
        finish();
    }
    //Metodo sinIng
    private void signIn(PhoneAuthCredential credential){
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Ingresar();
                }else{
                    processText.setText(task.getException().getMessage());
                    processText.setTextColor(Color.RED);
                    processText.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}