package com.example.anmol.reactance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resu;
    EditText resi;
    EditText ind;
    EditText capa;
    EditText freq;
    Button ok;
    double resis,capac,induc,fre,impd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resu= (TextView)findViewById(R.id.result);
        resi= (EditText)findViewById(R.id.resi);
        ind= (EditText)findViewById(R.id.indu);
        capa= (EditText)findViewById(R.id.capa);
        freq= (EditText)findViewById(R.id.freq);
        ok=(Button) findViewById(R.id.calc);
        resi.addTextChangedListener(watch);
        ind.addTextChangedListener(watch1);
        capa.addTextChangedListener(watch2);
        freq.addTextChangedListener(watch3);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capac=1/(2*3.14*capac*fre);
                induc=2*3.14*fre*induc;
                impd=Math.sqrt(Math.pow(resis,2)+Math.pow((capac-induc),2));
                resu.setText("Resultant impedence = " + String.format("%.2f",impd));

            }
        });




    }
    TextWatcher watch =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //TODO Auto-generated method stub
            if(s!=null)
            resis=Double.parseDouble(s.toString());

        }

        @Override
        public void afterTextChanged(Editable s) {
            //TODO Auto-generated method stub

        }
    };
    TextWatcher watch1= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //TODO Auto-generated method stub
            if(s!=null)
                induc=Double.parseDouble(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            //TODO Auto-generated method stub
        }
    };
    TextWatcher watch2 =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //TODO Auto-generated method stub
            if(s!=null)
                capac=Double.parseDouble(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            //TODO Auto-generated method stub
        }
    };
    TextWatcher watch3= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //TODO Auto-generated method stub
            if(s!=null)
                fre=Double.parseDouble(s.toString());

        }

        @Override
        public void afterTextChanged(Editable s) {
            //TODO Auto-generated method stub
        }
    };
}
