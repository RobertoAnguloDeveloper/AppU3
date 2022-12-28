package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menuItem1:
                Toast.makeText(this, "MenuItem1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem2:
                Toast.makeText(this, "MenuItem2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem3:
                Toast.makeText(this, "MenuItem3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem4:
                Toast.makeText(this, "MenuItem4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItemSalir:
                System.exit(0);
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }
}