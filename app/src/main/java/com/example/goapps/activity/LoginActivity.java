package com.example.goapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goapps.R;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    ImageButton login;
    EditText username,password;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.login_relative);

        login = (ImageButton) findViewById(R.id.btnLogin);
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (password.getText().toString().toUpperCase().equals("TEST1"))
                {
                    login_sukses();
                } else
                {
                    Toast.makeText(getApplicationContext(), "Salah Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //handle pengubahan bahasa
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings) {
            Intent nIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(nIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void login_sukses() {
        String user_login = username.getText().toString();
        Intent i = new Intent(this,MainActivity.class);
        //kirimkan username ke tampilan utama
        i.putExtra("USERNAME", user_login);
        startActivity(i);

    }
}
