package com.example.dtotransference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dto.PersonaDTO;

import java.io.Serializable;

public class secondActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtLastName;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initComponent();

        Bundle bundle = getIntent().getExtras();

        PersonaDTO personaDTO = (PersonaDTO) bundle.getSerializable("personaDto");
        txtName.setText(personaDTO.getName().toString());
        txtLastName.setText(personaDTO.getLastName().toString());
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

    private void initComponent() {
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);

    }
}
