package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.udc.aau3.model.DbHelper;
import com.udc.aau3.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Intent agregarActivityIntent, mostrarActivityIntent, mostrarActualizarActivityIntent
            , mostrarEliminarActivityIntent;
    public static List<Persona> contactos;
    public static DbHelper dbHelper;
    public static SQLiteDatabase sqLiteWrite, sqLiteRead;
    public static String dbName, tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarActivityIntent = new Intent(this, AgregarActivity.class);
        mostrarActivityIntent = new Intent(this, MostrarListaActivity.class);
        mostrarActualizarActivityIntent = new Intent(this, MostrarActualizarActivity.class);
        mostrarEliminarActivityIntent = new Intent(this, MostrarEliminarActivity.class);
        contactos = new ArrayList<>();

        dbName = "agenda";
        tableName = "contactos";
        String query = "CREATE TABLE "+ tableName + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombres VARCHAR(255), " +
                "apellidos VARCHAR(255), " +
                "telefono VARCHAR(50), " +
                "email VARCHAR(255), " +
                "domicilio VARCHAR(255))";

        dbHelper = new DbHelper(this, 1, dbName, query);
        sqLiteWrite = dbHelper.getWritableDatabase();
        sqLiteRead = dbHelper.getReadableDatabase();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menuItem1:
                startActivity(agregarActivityIntent);
                break;
            case R.id.menuItem2:
                //Toast.makeText(this, "MenuItem2", Toast.LENGTH_SHORT).show();
                startActivity(mostrarActivityIntent);
                break;
            case R.id.menuItem3:
                startActivity(mostrarActualizarActivityIntent);
                break;
            case R.id.menuItem4:
                startActivity(mostrarEliminarActivityIntent);
                break;
            case R.id.menuItemSalir:
                finishAffinity();
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sqLiteWrite.close();
        sqLiteRead.close();
        dbHelper.close();
    }
}