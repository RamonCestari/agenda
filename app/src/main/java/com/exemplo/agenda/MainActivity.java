package com.exemplo.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> contatos = new ArrayList<>();
        contatos.add("Ramon");
        contatos.add("Beatriz");
        contatos.add("Marcio");
        contatos.add("Celso");
        contatos.add("Igor");
        contatos.add("Vitoria");
        contatos.add("Jonathan");

        FloatingActionButton button = findViewById(R.id.main_activity_button_add_contato);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroContato.class));

            }
        });

        ListView listaContatos = findViewById(R.id.main_activity_lista_contatos);
        listaContatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos));
    }
}