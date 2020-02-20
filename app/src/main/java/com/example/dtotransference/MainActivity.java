package com.example.dtotransference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dto.PersonaDTO;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtLastName;
    DatePicker date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitComponent();

    }

    private void onInitComponent() {

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
    }

    public void saveData(View view) {

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setName(txtName.getText().toString());
        personaDTO.setLastName(txtLastName.getText().toString());

        Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(MainActivity.this,secondActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("personaDto",personaDTO);

        intent.putExtras(bundle);

        startActivity(intent);

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
