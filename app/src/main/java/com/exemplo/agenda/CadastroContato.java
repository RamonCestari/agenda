package com.exemplo.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exemplo.agenda.model.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastroContato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);

        Button buttonCadastrar = findViewById(R.id.activity_cadastro_button_cadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa contato = new Pessoa();

                EditText nome = findViewById(R.id.activity_cadastro_contato_nome);
                contato.setNome(nome.getText().toString());
                nome.setText("");

                EditText telefone = findViewById(R.id.activity_cadastro_contato_telefone);
                contato.setTelefone(telefone.getText().toString());
                telefone.setText("");

                EditText endereco = findViewById(R.id.activity_cadastro_contato_endereco);
                contato.setEndereco(endereco.getText().toString());
                endereco.setText("");

                EditText aniversario = findViewById(R.id.activity_cadastro_contato_aniversario);
                try {
                    contato.setAniversario(new SimpleDateFormat("dd/MM/yyyy").parse(aniversario.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                aniversario.setText("");

                Toast.makeText(CadastroContato.this,"Contato adicionado!",Toast.LENGTH_LONG).show();

            }
        });

        FloatingActionButton fabVoltar = findViewById(R.id.activity_cadastro_fab_voltar);
        fabVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltar);

            }
        });


    }
}