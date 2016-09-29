package com.fajar.hitungluas;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double luas = 0;    //inisialisasi luas = 0
                String panjang, lebar;

                if(checkNilai()){
                    panjang = edtPanjang.getText().toString().trim();
                    lebar = edtLebar.getText().toString().trim();
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);

                    luas = p * l;
                }
                else{
                    Snackbar snackbar1 = Snackbar.make(view, view.getResources().getString(R.string.hayoo), Snackbar.LENGTH_LONG);
                    snackbar1.show();//Snackbar error kosong
                }

                txtLuas.setText("Luas : "+luas);
            }
        });
    }

    private boolean checkNilai(){
        if(edtLebar.getText().toString().equalsIgnoreCase("") || edtLebar.getText().toString().equalsIgnoreCase(".") || edtPanjang.getText().toString().equalsIgnoreCase("") || edtPanjang.getText().toString().equalsIgnoreCase("."))
            return false;
        else return true;
    }
}