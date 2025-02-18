package com.example.shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int count2 =0 ;
    int num2;
    Button count ,reset , exit ;
    EditText random ;

    String name,num ;
    TextView counter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.count);
        reset = findViewById(R.id.reset);
        exit = findViewById(R.id.exit);
        random = findViewById(R.id.random);
        counter = findViewById(R.id.counter);


        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        name  = settings.getString("thename", "");
        random.setText(name);
        count2 = settings.getInt("thecount",0);
        counter.setText(String.valueOf(count2));


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem menu)
    {
        String num1 = menu.getTitle().toString();
        if(num1.equals("home"))
        {
            if(num2 ==1 )
            {

            }
            else
                finish();
        }
        else
        {
            Intent si = new Intent(this, Page2.class);
            startActivity(si);
        }

        return super.onOptionsItemSelected(menu);

    }

    public void tocount(View view)
    {
        count2 ++  ;
        counter.setText(String.valueOf(count2));
    }
    public void reset(View view)
    {
        count2 = 0 ;
        counter.setText(String.valueOf(count2));

    }
    public void exit222(View view)
    {
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        num = random.getText().toString();
        editor.putInt("thecount", count2);
        editor.putString("thename",num);
        editor.commit();
        finish();
    }
}