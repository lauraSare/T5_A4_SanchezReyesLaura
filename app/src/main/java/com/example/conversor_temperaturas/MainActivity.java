package com.example.conversor_temperaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton rbDecimal,rbBinario,rbOctal,rbHexa;
    CheckBox cbBinario,cbOctal,cbHexa;
    TextView cajaIngresar,cajaOctal,cajaBinario,cajaHexa;
    byte checkSelec;

    Operaciones c = new Operaciones();

    int numeroIngresado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbDecimal=findViewById(R.id.btn_Decimal);
        rbBinario=findViewById(R.id.btn_Binario);
        rbOctal=findViewById(R.id.btn_Octal);
        rbHexa=findViewById(R.id.btn_Hexadecimal);

        cbBinario=findViewById(R.id.cbBinario1);
        cbOctal=findViewById(R.id.cbOctal1);
        cbHexa=findViewById(R.id.cbHexa1);

        cajaIngresar=findViewById(R.id.Caja_texto);
        cajaBinario=findViewById(R.id.CajaBinario1);
        cajaOctal=findViewById(R.id.CajaOctal1);
        cajaHexa=findViewById(R.id.CajaHexa1);

        cajaBinario.setEnabled(false);
        cajaOctal.setEnabled(false);
        cajaHexa.setEnabled(false);

    }
    public void checkSelecy(View v){
        if(v.getId()==R.id.cbBinario1){
            if(cbBinario.isChecked())
                checkSelec=1;
        }else if (v.getId()==R.id.cbOctal1){
            if(cbOctal.isChecked())
                checkSelec=1;
            checkSelec=2;
        }else{
            if(cbHexa.isChecked())
                checkSelec=3;

        }
    }

    public  void btnBinario(View v){
        if(cajaIngresar.getText().toString().isEmpty()){
            cajaBinario.setText("0");
        }else{
            if(checkSelec==1){
                cajaBinario.setText(cajaIngresar.getText().toString());
            }else if(checkSelec==2){
                numeroIngresado=c.binarioADecimal(Integer.parseInt(cajaIngresar.getText().toString()));
                cajaOctal.setText(c.decimalAOctal(numeroIngresado));
            }else{
                numeroIngresado=c.binarioADecimal(Integer.parseInt(cajaIngresar.getText().toString()));
                cajaHexa.setText(c.decimalAHexadecimal(numeroIngresado));
            }
        }
    }
    public  void btDecimal(View v){

        if(cajaIngresar.getText().toString().isEmpty()){
            numeroIngresado=0;
            cajaIngresar.setText("0");
            long resultado=c.decimalABinario(numeroIngresado);
            cajaBinario.setText(resultado+"");
        }else{
            numeroIngresado=Integer.parseInt(cajaIngresar.getText().toString());
            if(checkSelec==1){
                long resultado=c.decimalABinario(numeroIngresado);
                cajaBinario.setText(resultado+"");
            }else if(checkSelec==2){
                cajaOctal.setText(c.decimalAOctal(numeroIngresado));
            }else if(checkSelec==3){
                cajaHexa.setText(c.decimalAHexadecimal(numeroIngresado));
            }
        }
    }
    public  void btHexa(View v){

        if(cajaIngresar.getText().toString().isEmpty()){
            cajaIngresar.setText("0");
            numeroIngresado=0;
        }else{
            numeroIngresado=Integer.parseInt(cajaIngresar.getText().toString());
            if(checkSelec==1){
                int convercion= c.hexadecimalADecimal(cajaIngresar.getText().toString());
                cajaBinario.setText(c.decimalABinario(convercion)+"");
            }else if(checkSelec==2){
                int convercion= c.hexadecimalADecimal(cajaIngresar.getText().toString());
                String res=c.decimalAOctal(convercion);
                cajaOctal.setText(res);
            }else{
                cajaHexa.setText(cajaIngresar.getText().toString());
            }
        }
    }

    public  void btOcta(View v){
        if(cajaIngresar.getText().toString().isEmpty()){
            numeroIngresado=0;
            cajaIngresar.setText("0");
        }else{
            numeroIngresado=Integer.parseInt(cajaIngresar.getText().toString());
            if(checkSelec==1){
                int dec=c.octalADecimal(numeroIngresado);
                long res=c.decimalABinario(dec);
                cajaBinario.setText(res+"");
            }else if(checkSelec==2){
                cajaOctal.setText(cajaIngresar.getText().toString());
            }else if(checkSelec==3){
                int dec=c.octalADecimal(numeroIngresado);
                cajaHexa.setText(c.decimalAHexadecimal(dec));
            }
        }
    }


    @Override
    public void onClick(View v) {

    }
}