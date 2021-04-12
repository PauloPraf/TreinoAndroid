package com.ufms.calcularmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView txtnome;
    EditText edtFaltas,edtP1,edtP2,edtTrabalho;
    TextView txtMedia,txtResultado;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtnome= findViewById(R.id.txtnome2);
        edtFaltas=findViewById(R.id.edtQtdFaltas);
        edtP1=findViewById(R.id.edtP1);
        edtP2=findViewById(R.id.edtP2);
        edtTrabalho=findViewById(R.id.edtTrabalho);
        txtMedia=findViewById(R.id.txtMedia);
        txtResultado=findViewById(R.id.txtResultado);
        btcalcular=findViewById(R.id.btnCalcular);



        Intent it2=getIntent();
        Bundle bundle=it2.getExtras();
        if(bundle !=null){
            String nome=bundle.getString("ch_nome");
            txtnome.setText(nome);
        }
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int faltas=Integer.parseInt(edtFaltas.getText().toString());
                double p1=Double.parseDouble(edtP1.getText().toString());
                double p2=Double.parseDouble(edtP2.getText().toString());
                double trab=Double.parseDouble(edtTrabalho.getText().toString());
                double media=(p1+p2+trab)/3;
                txtMedia.setText(Double.toString(media));
                double porcentagemPresenca=1-(faltas/68);
                if (porcentagemPresenca<0.75){
                    txtResultado.setText("Reprovado por falta");
                }else{
                    if(media>=6){
                        txtResultado.setText("Aprovado");
                    }
                    else{
                        txtResultado.setText("Reprovado pq é Burrão");
                    }
                }

            }
        });
    }
}