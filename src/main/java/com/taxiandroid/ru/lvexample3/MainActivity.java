package com.taxiandroid.ru.lvexample3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> arrayOfUsers;
    ListView listView;
    CustomUsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateUsersList();

        listView.setOnItemClickListener(itemClickListener);
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        }


        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            User itemLV = (User) parent.getItemAtPosition(position);
            String itemName = itemLV.name;
            Toast.makeText(getApplicationContext(),
                    "Вы выбрали " + itemName, Toast.LENGTH_SHORT).show();
        }


        public void onNothingSelected(AdapterView<?> parent) {

        }


    };


        private void populateUsersList() {
            // Construct the data source
           // ArrayList<User> arrayOfUsers = User.getUsers();
            arrayOfUsers = User.getUsers();
            // Create the adapter to convert the array to views
            adapter = new CustomUsersAdapter(this, arrayOfUsers);
            // Attach the adapter to a ListView
            listView = (ListView) findViewById(R.id.lvUsers);
            listView.setAdapter(adapter);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            arrayOfUsers = User.delUsers();
            adapter = new CustomUsersAdapter(this, arrayOfUsers);
            listView.setAdapter(adapter);

            Toast toast = Toast.makeText(getApplicationContext(), "List View очищен!", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        if (id == R.id.action_insert) {
            arrayOfUsers = User.insUsers("Андрей","Тихорецк");
            arrayOfUsers = User.insUsers("Света", "Тихорецк");
            adapter = new CustomUsersAdapter(this, arrayOfUsers);
            listView.setAdapter(adapter);

            Toast toast = Toast.makeText(getApplicationContext(), "Добавлены данные!", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        if (id==R.id.action_populating) {
            User newUser = new User("Nathan", "San Diego");
            adapter.add(newUser);
            listView.setAdapter(adapter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
