package com.paul.tp2_3;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText nom, prenom, birth, phone, mail, postal, address;
    RadioButton male, female;
    Button valider;
    private ImageView profil;
    Integer count = 1;
   //Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profil = (ImageView) findViewById(R.id.profilId);
        profil.setImageResource(R.mipmap.imbase);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int id = getApplicationContext().getResources().getIdentifier(nom_icone,"mipmap","nom.du.package");
                switch(id) {
                    case 1:
                        profil.setImageResource(R.mipmap.im1);
                        break;
                    case 2:
                        profil.setImageResource(R.mipmap.im2);
                        break;
                    case 3:
                        profil.setImageResource(R.mipmap.im3);
                        break;
                    default:
                        profil.setImageResource(R.mipmap.imbase);
                }*/

                if (count == 1) {
                    profil.setImageResource(R.mipmap.im1);
                    count = 2;
                } else if (count == 2) {
                    profil.setImageResource(R.mipmap.im2);
                    count = 3;
                } else if (count == 3) {
                    profil.setImageResource(R.mipmap.im3);
                    count = 4;
                } else if (count == 4) {
                    profil.setImageResource(R.mipmap.im4);
                    count = 1;
                }
            }
        });


        male = (RadioButton) findViewById(R.id.radioButtonM);
        female = (RadioButton) findViewById(R.id.radioButtonF);

        nom = (EditText) findViewById(R.id.nomText);
        prenom = (EditText) findViewById(R.id.prenomText);

        birth = (EditText) findViewById(R.id.birthText);
        /*final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };



        birth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        */

        phone = (EditText) findViewById(R.id.phoneText);
        mail = (EditText) findViewById(R.id.mailText);
        postal = (EditText) findViewById(R.id.postalText);
        address = (EditText) findViewById(R.id.addressText);

        valider = (Button) findViewById(R.id.buttonValider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Informations");

                Intent synthese = new Intent(getApplicationContext(),synthese.class);
                String afficher;
                String radioButton = "";
                if( male.isChecked()) {
                    radioButton = male.getText().toString();
                }
                else if( female.isChecked()) {
                    radioButton = female.getText().toString();
                }

                if(radioButton.isEmpty() || nom.getText().toString().isEmpty() || prenom.getText().toString().isEmpty() || birth.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || mail.getText().toString().isEmpty() || postal.getText().toString().isEmpty() || address.getText().toString().isEmpty()){
                    afficher = "Veuillez remplir tous les champs du formulaire";
                }
                else{
                    afficher = radioButton + " nom : " + nom.getText() + " " + prenom.getText() + " " + birth.getText() + " " + phone.getText() + " " + mail.getFreezesText() + " " + postal.getText() + " " + address.getText();
                    synthese.putExtra("nom", "NOM : " + nom.getText().toString());
                    synthese.putExtra("prenom", "PRENOM : " + prenom.getText().toString());
                    startActivity(synthese);
                }
                Toast.makeText(getApplicationContext(), afficher, Toast.LENGTH_LONG).show();

                builder.setMessage(afficher);
                builder.create();
                builder.show();



            }
        });
    }
    /*
    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        birth.setText(sdf.format(myCalendar.getTime()));
    }
    */
}
