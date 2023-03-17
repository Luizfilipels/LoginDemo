package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaração de algumas variáveis
    private EditText Nome;
    private EditText Senha;
    private TextView txtInfo;
    private Button btnLogin;
    private int contador = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definindo as variáveis aos respectivos IDs definidos no XML
        Nome = (EditText) findViewById(R.id.etNome);
        Senha = (EditText) findViewById(R.id.etSenha);
        txtInfo = (TextView) findViewById(R.id.tvInfo);
        btnLogin = (Button) findViewById(R.id.bttnEntrar);

        txtInfo.setText("Número de tentativas restantes: " + contador);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validar(Nome.getText().toString(), Senha.getText().toString());
            }
        });


    }

    //Metodo verificar usuario e senha
    private void Validar(String usuario, String senha) {
        if((usuario.equals("admin")) && (senha.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, SegundaTela.class);
            startActivity(intent);

        } else {
            contador--;

            txtInfo.setText("Número de tentativas restantes: " + contador);

            if(contador == 0) {
                btnLogin.setEnabled(false);
            }
        }
    }
}