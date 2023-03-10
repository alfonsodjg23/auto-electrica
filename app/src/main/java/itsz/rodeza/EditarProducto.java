package itsz.rodeza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class EditarProducto extends AppCompatActivity {

    //Se crear las variables u objetos
    CardView card1,card2,cvPCompra,cvPMayoreo,cvPPublico,cvExistencia,cvPPCaja,cvUXMayoreo1,cvUXMayoreo2,cvUXMayoreo3,cvUltimaCompra,cvDepartamento;
    CardView cvEstado,cvUtilidad,cvTipoProducto;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        //Se enlazan todos los elementos al xml correspondiente a esta clase por medio de su id
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

        //Cambia el color de cada carta recuperando el diseño del cardview personalizado dentro de drawable
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