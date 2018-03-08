package com.jstrait.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected int[] images = {R.drawable.pubg,R.drawable.rainbow,R.drawable.sc2};
    protected ImageView theImage;
    protected int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theImage = (ImageView)findViewById(R.id.image);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Details");
        categories.add("Left");
        categories.add("Right");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(    android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        switch (item) {
            case "Right":
                rightSwipe();

            case "Left":
                leftSwipe();

            case "Home":
                Intent intent = new Intent(this, Details.class);
                startActivity(intent);


        }
    }
    public void onNothingSelected(AdapterView<?> arg0){
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {MenuInflater inflater = getMenuInflater();
           inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.right:
                rightSwipe();
                return true;
            case R.id.left:
                leftSwipe();
                return true;
            case R.id.home:
                Intent intent = new Intent(this, Details.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void leftClicked(View view){
        leftSwipe();

    }

    private void leftSwipe(){
        num--;
        if(num < 0){
            num = images.length-1;
        }
        theImage.setImageResource(images[num]);
    }

    public void rightClicked(View view){
        rightSwipe();

    }
    private void rightSwipe(){
        num++;
        if(num >= images.length){
            num = 0;
        }
        theImage.setImageResource(images[num]);
    }

    public void bye(View view){
        Intent intent = new Intent(this, Details.class);
        startActivity(intent);
    }
}
