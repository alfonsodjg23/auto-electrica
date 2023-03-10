package itsz.rodeza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpActivity extends AppCompatActivity {
    //Creamos los objetos o variables a usar
    private TextInputEditText TextInputCodigo;
    private String OTP;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        //Relacionamos los elementos al xml correspondiente a esta clase por su id
        Button mVerifyCodeBtn = findViewById(R.id.btnEnviarCodigo);
        TextInputCodigo = findViewById(R.id.TextInputCodigo);

        firebaseAuth = FirebaseAuth.getInstance();

        OTP = getIntent().getStringExtra("auth"); //recuperamos el codigo que viene de la otra clase
        mVerifyCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verification_code = TextInputCodigo.getText().toString();
                if(!verification_code.isEmpty()){ //Si el codigo es diferente de vacio llamamos al metodo singIn
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP , verification_code);
                    signIn(credential);
                }else{
                    Toast.makeText(OtpActivity.this, "Ingrese el codigo enviado a traves de sms", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void signIn(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){ //Si el proceso sucedio con exito se llama al metodo sendToMain
                    sendToMain();
                }else{
                    Toast.makeText(OtpActivity.this, "Codigo incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() { //Metodo onStar verifica si el usuario es diferente de nulo se llama al metodo sendToMain
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser !=null){
            sendToMain();
        }
    }

    private void sendToMain(){ //Metodo sendToMain nos lleva a LoginActivity
        startActivity(new Intent(OtpActivity.this , LoginActivity.class));
        finish();
    }
}