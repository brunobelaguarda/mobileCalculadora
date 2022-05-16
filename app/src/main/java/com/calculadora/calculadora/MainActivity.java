package com.calculadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nzero,num,ndois,ntres,nquatro,ncinco,nseis,nsete,noito,nnove,ponto,soma,subtracao,
            multiplicacao,divisao,igual,limpar;

    private TextView txtExpressao, txtresultado;

    private ImageView backspace;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        getSupportActionBar().hide();

        nzero.setOnClickListener(this);
        num.setOnClickListener(this);
        ndois.setOnClickListener(this);
        ntres.setOnClickListener(this);
        nquatro.setOnClickListener(this);
        ncinco.setOnClickListener(this);
        nseis.setOnClickListener(this);
        nsete.setOnClickListener(this);
        noito.setOnClickListener(this);
        nnove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtresultado.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0=0;
                    int var1 = string.length()-1;
                    String txtExpressa = string.substring(var0,var1);
                    expressao.setText(txtExpressa);
                }
                txtresultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longresult = (long) resultado;

                    if (resultado == (double) longresult) {
                        txtresultado.setText((CharSequence) String.valueOf(longresult));
                    } else {
                        txtresultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });


    }

    private void iniciarComponentes(){
        nzero = findViewById(R.id.zero);
        num = findViewById(R.id.bt_um);
        ndois = findViewById(R.id.bt_dois);
        ntres = findViewById(R.id.bt_tres);
        nquatro = findViewById(R.id.bt_quatro);
        ncinco = findViewById(R.id.bt_cinco);
        nseis = findViewById(R.id.bt_seis);
        nsete = findViewById(R.id.bt_sete);
        noito = findViewById(R.id.bt_oito);
        nnove = findViewById(R.id.bt_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.bt_adicao);
        subtracao = findViewById(R.id.bt_subtracao);
        divisao = findViewById(R.id.bt_divisao);
        multiplicacao= findViewById(R.id.bt_multip);
        igual = findViewById(R.id.igual);
        limpar = findViewById(R.id.bt_C);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtresultado= findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);

    }
    public void addExpressao(String string, boolean limpardados){
        if(txtresultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if(limpardados){
            txtresultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtresultado.getText());
            txtExpressao.append(string);
            txtresultado.setText(" ");
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.zero:
                addExpressao("0",true);
                break;
            case R.id.bt_um:
                addExpressao("1",true);
                break;
            case R.id.bt_dois:
                addExpressao("2",true);
                break;
            case R.id.bt_tres:
                addExpressao("3",true);
                break;
            case R.id.bt_quatro:
                addExpressao("4",true);
                break;
            case R.id.bt_cinco:
                addExpressao("5",true);
                break;
            case R.id.bt_seis:
                addExpressao("6",true);
                break;
            case R.id.bt_sete:
                addExpressao("7",true);
                break;
            case R.id.bt_oito:
                addExpressao("8",true);
                break;
            case R.id.bt_nove:
                addExpressao("9",true);
                break;
            case R.id.ponto:
                addExpressao(".",true);
                break;
            case R.id.bt_adicao:
                addExpressao("+",true);
                break;
            case R.id.bt_subtracao:
                addExpressao("-",true);
                break;
            case R.id.bt_divisao:
                addExpressao("/",true);
                break;
            case R.id.bt_multip:
                addExpressao("*",true);
                break;




        }
    }
}