package com.example.alberto.u3_alvarez_bouzaz_alberto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class SegundaActivity extends Activity {
    EditText texto_texto;
    EditText texto_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        texto_texto=(EditText) findViewById(R.id.etTexto);
        texto_telefono=(EditText) findViewById(R.id.etTelefono);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pecharActivity(View view){
        texto_telefono=(EditText) findViewById(R.id.etTelefono);
        Intent telefono_devolto=new Intent();
        telefono_devolto.putExtra("TELEFONO",texto_telefono.getText().toString());
        setResult(RESULT_OK, telefono_devolto);
        finish();
    }

    public void finish(){
        super.finish();

    }
}
