package com.example.contextmenudemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView studentsListView;
    String [] names;
    Resources resources;
    ArrayAdapter<String> stringArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initResources();
        //Array adopter is used to bind data from array with list view
        stringArrayAdapter = new ArrayAdapter<String>(this,
                                                    android.R.layout.simple_list_item_1,
                                                    names);
        studentsListView.setAdapter(stringArrayAdapter);
        //to register context menu with list view
        registerForContextMenu(studentsListView);

    }

    private void initViews(){
        studentsListView = findViewById(R.id.studentsListView);
    }

    private void initResources(){
        resources = getResources();
        names = resources.getStringArray(R.array.names);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(this, "onMenuOpened method got called", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Toast.makeText(this, "onCreateContextMenu method got called", Toast.LENGTH_SHORT).show();
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("--Menu--");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "onContextItemSelected method got called", Toast.LENGTH_SHORT).show();

        int itemId = item.getItemId();
        Log.e("tag","itemId" + itemId);

        if (item.getItemId() == R.id.save_as) {
            Toast.makeText(this, "save_as", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.save) {
            Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.copy) {
            Toast.makeText(this, "copy", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.paste) {
            Toast.makeText(this, "paste", Toast.LENGTH_SHORT).show();
        }

//        switch (itemId){
//            case 0:
//                Toast.makeText(this, "save_as", Toast.LENGTH_SHORT).show();
//                break;
//            case 1:
//                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
//                break;
//            case 2:
//                Toast.makeText(this, "copy", Toast.LENGTH_SHORT).show();
//                break;
//            case 3:
//                Toast.makeText(this, "paste", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                Toast.makeText(this, "default called as no case matches", Toast.LENGTH_SHORT).show();
//        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        Toast.makeText(this, "onContextMenuClosed method got called", Toast.LENGTH_SHORT).show();
        super.onContextMenuClosed(menu);
    }
}