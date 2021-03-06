package org.aplas.tugas1_rajendra;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.aplas.tugas1_rajendra.login_register.HalamanEmpat;
import org.aplas.tugas1_rajendra.login_register.Register;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Berhasil extends AppCompatActivity {

    private TextView txtUser,txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil);

        //create a date string.
        String date_n = new SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.
        TextView date  = (TextView) findViewById(R.id.dateText);
        //set it as current date.
        date.setText(date_n);


        this.txtUser=this.findViewById(R.id.user);
        this.txtEmail=this.findViewById(R.id.email);

        //Get String
        String[] stringArray=getIntent().getStringArrayExtra(Register.Key_Register);

        //Set Value ke Text
        txtUser.setText("Hello "+stringArray[0]+" \u2665");

        txtEmail.setText(stringArray[1]);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.clkabout){
            startActivity(new Intent(this,About.class));
        }else if(item.getItemId()==R.id.clkout){

            startActivity(new Intent(this, HalamanEmpat.class));
            Toast.makeText(this, "Log-out Success", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void Dashboard(View view){
        Intent i = new Intent(Berhasil.this, HalamanUtama.class);
        startActivity(i);

        Toast.makeText(this, "Halaman Utama", Toast.LENGTH_SHORT).show();
    }




}