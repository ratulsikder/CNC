package com.collectcn.cnc;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        TextView tView = (TextView)findViewById(R.id.tView);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);
        Button btn0 = (Button)findViewById(R.id.button0);
        Button btnOK = (Button)findViewById(R.id.buttonOK);
        Button btnB = (Button)findViewById(R.id.buttonBackspace);

        tView.setPadding(0,(int)(height/3.5),0,0);
        tView.setTextSize(width/25);
        btn1.setWidth(width/30);
        btn2.setWidth(width/30);
        btn3.setWidth(width/3);
        btn4.setWidth(width/3);
        btn5.setWidth(width/3);
        btn6.setWidth(width/3);
        btn7.setWidth(width/3);
        btn8.setWidth(width/3);
        btn9.setWidth(width/3);
        btn0.setWidth(width/3);
        btnOK.setWidth(width/3);
        btnB.setWidth(width/3);

        btn1.setHeight(height/9);
        btn2.setHeight(height/9);
        btn3.setHeight(height/9);
        btn4.setHeight(height/9);
        btn5.setHeight(height/9);
        btn6.setHeight(height/9);
        btn7.setHeight(height/9);
        btn8.setHeight(height/9);
        btn9.setHeight(height/9);
        btn0.setHeight(height/9);
        btnOK.setHeight(height/9);
        btnB.setHeight(height/9);

        btn1.setTextSize(width/30);
        btn2.setTextSize(width/30);
        btn3.setTextSize(width/30);
        btn4.setTextSize(width/30);
        btn5.setTextSize(width/30);
        btn6.setTextSize(width/30);
        btn7.setTextSize(width/30);
        btn8.setTextSize(width/30);
        btn9.setTextSize(width/30);
        btn0.setTextSize(width/30);
        btnOK.setTextSize(width/30);
        btnB.setTextSize(width/30);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        final int id = v.getId();
        TextView tView = (TextView)findViewById(R.id.tView);
        String text = tView.getText().toString();
        Context context = getApplicationContext();

        //CharSequence text = "Hello toast!";
        //int duration = Toast.LENGTH_SHORT;

        switch (id) {
            case R.id.button1:
                // your code for button1 here
                tView.setText(text+"1");
                break;
            case R.id.button2:
                // your code for button2 here
                tView.setText(text+"2");
                break;
            case R.id.button3:
                // your code for button2 here
                tView.setText(text+"3");
                break;
            case R.id.button4:
                // your code for button2 here
                tView.setText(text+"4");
                break;
            case R.id.button5:
                // your code for button2 here
                tView.setText(text+"5");
                break;
            case R.id.button6:
                // your code for button2 here
                tView.setText(text+"6");
                break;
            case R.id.button7:
                // your code for button2 here
                tView.setText(text+"7");
                break;
            case R.id.button8:
                // your code for button2 here
                tView.setText(text+"8");
                break;
            case R.id.button9:
                // your code for button2 here
                tView.setText(text+"9");
                break;
            case R.id.button0:
                // your code for button2 here
                tView.setText(text+"0");
                break;
            case R.id.buttonOK:
                // your code for button2 here
                tView.setText(text+"0");
                break;
            case R.id.buttonBackspace:
                // your code for button2 here
                if (text != null && text.length() > 0)
                    tView.setText(text.substring(0, text.length()-1));
                break;
            // even more buttons here
        }
    }
}
