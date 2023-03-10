package itsz.rodeza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrarProducto extends AppCompatActivity {

    //Creamos todas las variables del tipo de dato para darles diseño
    CardView card1,card2,cvPCompra,cvPMayoreo,cvPPublico,cvExistencia,cvPPCaja,cvUXMayoreo1,cvUXMayoreo2,cvUXMayoreo3,cvUltimaCompra,cvDepartamento;
    CardView cvEstado,cvUtilidad,cvTipoProducto;
    EditText edtSku, edtDescripcion, edtPCompra, edtPMayoreo, edtPPublico,edtExistencia, edtPZAXCaja,edtUXMayoreo1,edtUXMayoreo2,edtUXMayoreo3,edtUltimaCompra,edtDepartamento,edtEstado,edtUtilidad,edtTipoProducto;
    Button btnAgregar;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        //Enlazamos todas las variables con el tipo de objeto al xml correspondiente a esta clase
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        cvPCompra=findViewById(R.id.cvPCompra);
        cvPMayoreo=findViewById(R.id.cvPMayoreo);
        cvPPublico=findViewById(R.id.cvPPublico);
        cvExistencia=findViewById(R.id.cvExistencia);
        cvPPCaja =findViewById(R.id.cvPPCaja);
        cvUXMayoreo1=findViewById(R.id.cvUXMayoreo1);
        cvUXMayoreo2=findViewById(R.id.cvUXMayoreo2);
        cvUXMayoreo3=findViewById(R.id.cvUXMayoreo3);
        cvUltimaCompra=findViewById(R.id.cvUltimaCompra);
        cvDepartamento=findViewById(R.id.cvDepartamento);
        cvEstado=findViewById(R.id.cvEstado);
        cvUtilidad=findViewById(R.id.cvUtilidad);
        cvTipoProducto=findViewById(R.id.cvTipoProducto);

        edtSku = findViewById(R.id.edtSku);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtPCompra = findViewById(R.id.edtPCompra);
        edtPMayoreo = findViewById(R.id.edtPMayoreo);
        edtPPublico = findViewById(R.id.edtPPublico);
        edtExistencia = findViewById(R.id.edtExistencia);
        edtPZAXCaja = findViewById(R.id.edtPXCaja);
        edtUXMayoreo1 = findViewById(R.id.edtUXMayore1);
        edtUXMayoreo2 = findViewById(R.id.edtUXMayore2);
        edtUXMayoreo3 = findViewById(R.id.edtUXMayore3);
        edtUltimaCompra = findViewById(R.id.edtUltimaCompra);
        edtDepartamento = findViewById(R.id.edtDepartamento);
        edtEstado = findViewById(R.id.edtEstado);
        edtUtilidad = findViewById(R.id.edtUtilidad);
        edtTipoProducto = findViewById(R.id.edtTipoProducto);
        btnAgregar = findViewById(R.id.btnAgregar);

        //Cambiamos el color de cada carta recuperando el diseño que hicimos en la carpeta drawable
        card1.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        card2.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvPCompra.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvPMayoreo.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvPPublico.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvExistencia.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvPPCaja.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvUXMayoreo1.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvUXMayoreo2.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvUXMayoreo3.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvUltimaCompra.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvDepartamento.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvEstado.setBackgroundDrawable(getDrawable(R.drawable.card_custom));
        cvUtilidad.setBackgroundDrawable(getDrawable(R.drawable.card_custom2));
        cvTipoProducto.setBackgroundDrawable(getDrawable(R.drawable.card_custom));

        /*En esta parte se deben crear los metodos para los botones y agregar
        * a la bd se puede usar librerias como Volley o Retrofit
        * */
    }
}