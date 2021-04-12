package com.ufms.calcularmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnIniciar;
    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar= findViewById(R.id.btnIniciar);
        edtNome=findViewById(R.id.edtNome);


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity.this,Activity2.class);
                String nome=edtNome.getText().toString();
                if(!nome.isEmpty()){
                    Bundle bundle = new Bundle();
                    bundle.putString("ch_nome",nome);
                    it.putExtras(bundle);
                }
                startActivity(it);
            }
        });
    }
}