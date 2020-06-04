package com.example.calculermonimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mTaille;
    private EditText mPoids;
    private Button mButton;
    private TextView mTextView;
    private ImageView image;
    private float poids;
    private float taille;
    private float imc;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        mTaille = findViewById ( R.id.editTextTaille );
        mPoids = findViewById ( R.id.editTextPoids );
        mButton = findViewById ( R.id.button );
        mTextView = findViewById ( R.id.textViewResultat );
        image = findViewById ( R.id.imageView );

    }
        public void CalculerMonIMC ( View v ) {

            try {
                poids = Float.parseFloat(mPoids.getText().toString());
                taille = Float.parseFloat(mTaille.getText().toString());

                imc = poids / (taille * taille);
                imc = imc * 10000;
                String message = String.format("Mon indice de masse corporelle est de\n"+"%.01f", imc) + "kg/m².\n";

                if (imc < 18.5) {

                    mTextView.setText( message + "C'est une denutrition");
                    image.setImageResource(R.drawable.denutrition);
                }
                if (imc >= 18.5 && imc <= 25.9) {

                    mTextView.setText( message + "C'est une corpulence qui est dans la norme");
                    image.setImageResource(R.drawable.normale);
                }
                if (imc >= 25 && imc <= 29.9) {

                    mTextView.setText( message + "C'est un surpoids");
                    image.setImageResource(R.drawable.surpoids);
                }
                if (imc >= 30 && imc <= 39.9) {

                    mTextView.setText( message + "C'est une obésité de classe 1 dite modérée");
                    image.setImageResource(R.drawable.obesite_moderee);
                }
                if (imc >= 40 && imc <= 49.9) {

                    mTextView.setText( message + "C'est une obésité de classe 2 dite sévère");
                    image.setImageResource(R.drawable.obesite_severe);
                }
                if (imc > 50) {

                    mTextView.setText( message + "C'est une obésité de classe 3 dite morbide");
                    image.setImageResource(R.drawable.obesite_morbide);
                }

                mTaille.setText ( "" );
                mPoids.setText ( "" );

            }
            catch (Exception e){
                Log.e ( "Calculer IMC", "Un des champ de saisi est vide\n" + e );
                mTextView.setText("Les champs Poids et Taille ne doivent pas etre vide");
            }
        }
}
