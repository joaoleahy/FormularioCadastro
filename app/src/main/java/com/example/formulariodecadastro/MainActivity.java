package com.example.formulariodecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText idade;
    private RadioButton masculino;
    private RadioButton feminino;
    private TextView resultadoNome;
    private TextView resultadoIdade;
    private TextView resultadoSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        masculino = findViewById(R.id.radioButtonMasculino);
        feminino = findViewById(R.id.radioButtonFeminino);
        resultadoNome = findViewById(R.id.resultadoNome);
        resultadoIdade = findViewById(R.id.resultadoIdade);
        resultadoSexo = findViewById(R.id.resultadoSexo);
        Button botaoCadastrar = findViewById(R.id.bt_Cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editNome = nome.getText().toString();
                String editIdade = idade.getText().toString();

                if (editNome.isEmpty() || editIdade.isEmpty()) {
                    Snackbar.make(view,"Preencha o nome e a idade",Snackbar.LENGTH_SHORT).show();
                } else {
                    RadioButtonSelecionado(view);
                }
            }
        });
    }

    private void RadioButtonSelecionado(View view) {

        String editNome = nome.getText().toString();
        String editIdade = idade.getText().toString();

        if(feminino.isChecked()){
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("Sexo: Feminino");
        } else if(masculino.isChecked()) {
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("Sexo: Masculino");
        } else {
            Snackbar.make(view,"Selecione o sexo",Snackbar.LENGTH_SHORT).show();
        }

    }
}