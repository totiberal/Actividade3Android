package com.example.alberto.u3_alvarez_bouzaz_alberto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class U3_Alvarez_Bouzas_Alberto extends Activity {
    private Button boton1;
    private Button boton2;

    //Usado para sacar o dialogo
    private static final int DIALOGO_LISTA = 3;

    //Codigo para validar que o segundo activity devolveme o que me ten que devolver
    private static final int Cod_Pet = 13;

    //Creo unha venta de dialogo para elexir entre o telefono e o buscador
    AlertDialog.Builder venta_dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3__alvarez__bouzas__alberto);
        boton1 = (Button) findViewById(R.id.btnLargo);
        boton2 = (Button) findViewById(R.id.btnDat);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivityForResult(intent, Cod_Pet);
            }
        });


       boton1.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
                showDialog(13);
               return false;
           }
       });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u3__alvarez__bouzas__alberto, menu);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Cod_Pet) {

            if (resultCode == RESULT_OK) {
                if (data.hasExtra("TELEFONO"))
                    Toast.makeText(this, data.getExtras().getString("TELEFONO"), Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(this, "A cagaches", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id){
        venta_dialogo = new AlertDialog.Builder(this);
        venta_dialogo.setTitle("Escolle unha opcion");
        venta_dialogo.setItems(R.array.spinner_opcions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })

    }
}
