package com.jstrait.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Details extends AppCompatActivity {
    protected int[] images = {R.drawable.pubg1,R.drawable.pubg2,R.drawable.pubg3};
    protected ImageView theImage;
    protected int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        theImage = (ImageView)findViewById(R.id.image);
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
                Intent intent = new Intent(this, MainActivity.class);
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
