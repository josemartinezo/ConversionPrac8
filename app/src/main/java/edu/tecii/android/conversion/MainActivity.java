package edu.tecii.android.conversion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.inputFt)
    EditText inputFt;
    @Bind(R.id.inputM)
    EditText inputM;
    @Bind(R.id.btnSumbit)
    Button btnSumbit;
    @Bind(R.id.Resu)
    TextView Resu;
    @Bind(R.id.Resu1)
    TextView Resu1;
    @Bind(R.id.Resu2)
    TextView Resu2;
    @Bind(R.id.Resu3)
    TextView Resu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnSumbit)
    public void handleClickSubmit() {
        hideKeyboard();
        String ft = inputFt.getText().toString().trim();
        double ft01 = Double.parseDouble(ft);
        String m = inputM.getText().toString().trim();
        double m01 = Double.parseDouble(m);

        if (!ft.isEmpty()) {
            //double hip = Math.sqrt(Math.pow(cat01, 2) + Math.pow(cat02, 2));
            double pie = m01*3.2808;
            double met = ft01/3.2808;
            double sumapi = ft01+pie;
            double sumam = m01+met;

            double pulgadas = sumapi*12.000;
            double yd = sumam*1.0936;
            double millas = sumapi*0.00018939;


            String Resul = "Pulgadas: " +pulgadas;
            String Resul1 = "Yardas: "+yd;
            String Resul2 = "Metros: "+sumam;
            String Resul3 = "Millas: "+millas;

            Resu.setVisibility(View.VISIBLE);
            Resu.setText(Resul);
            Resu1.setVisibility(View.VISIBLE);
            Resu1.setText(Resul1);
            Resu2.setVisibility(View.VISIBLE);
            Resu2.setText(Resul2);
            Resu3.setVisibility(View.VISIBLE);
            Resu3.setText(Resul3);
        }
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
