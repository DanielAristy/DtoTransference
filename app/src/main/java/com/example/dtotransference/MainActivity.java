package com.example.dtotransference;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dto.PersonaDTO;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtLastName;
    TextView date;
    String birthDate;

    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener dateSetListener;
    private static final String TAG = "MainActivity";
    public static final int MAYOR_DE_EDAD = 18;
    public Boolean verificateDate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitComponent();
        createDate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Boolean validarFecha(int year,int month,int day){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ahora = LocalDate.now();
        LocalDate local = LocalDate.of(year,month,day);
        Period periodo = Period.between(local, ahora);

        if (periodo.getYears() < MAYOR_DE_EDAD){
            verificateDate = true;
        }

        return verificateDate;
    }

    private void createDate() {

        date.setOnClickListener(new View.OnClickListener(){

            int day, month, year;
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                birthDate = month + "/" + day + "/" + year;

                if (validarFecha(year,month,day) == true) {
                    Toast.makeText(getApplicationContext(),"Menor de Edad",Toast.LENGTH_SHORT).show();
                    date.setText("");
                    verificateDate = false;
                }
                else{
                    date.setText(birthDate);
                    verificateDate = true;
                }

            }
        };
    }

    public void saveData(View view) {

        Boolean verificarCampos = false;
        if (txtName.getText().toString().equals("")
           || txtLastName.getText().toString().equals("")
            || date.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
        }else{
            verificarCampos = true;
        }

        if (verificateDate.equals(true) && verificarCampos.equals(true)){

            Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,secondActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("personaDto",
                    new PersonaDTO(
                            txtName.getText().toString()
                            ,txtLastName.getText().toString())
                        );

            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void onInitComponent() {

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        date = findViewById(R.id.datePicker);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onResume()");
        txtName.setText("");
        txtLastName.setText("");
        date.setText("");
    }

    @Override
    public void onPause() {

        super.onPause();
        Toast.makeText(this, "onPause ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onStop()");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onRestart()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy ".concat(MainActivity.class.getName()), Toast.LENGTH_LONG).show();
        Log.d("->","onDestroy()");
    }
}
