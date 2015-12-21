package com.example.petr.simplelist;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SimpleList extends AppCompatActivity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ListView lvMain = (ListView) findViewById(R.id.lvMain);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, names);

        User[] users = new User[10];
        users[0] = new User("Vasy", 12);
        users[1] = new User("Dima", 13);


        lvMain.setAdapter(new MyListAdapter(this, users));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_list, menu);
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

    public static class User {

        String name;
        int age;
        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

    }

    public static class MyListAdapter extends ArrayAdapter<User>{

        User[] dataset;

        public MyListAdapter(Context context, User[] objects) {
            super(context, R.layout.simple_listview_item, objects);
            this.dataset = objects;
        }


        @Override
        public User getItem(int position) {
            return dataset[position];
        }

        @Override
        public int getCount() {
            return dataset.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.simple_listview_item, null);
            Random rand = new Random();
            v.setBackgroundColor(Color.argb(40,
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255)));
            TextView tvname = (TextView) v.findViewById(R.id.name);
            tvname.setText(dataset[position].name);
            TextView tvage = (TextView) v.findViewById(R.id.age);
            tvage.setText(dataset[position].age + "");
            return v;
        }
    }
}
