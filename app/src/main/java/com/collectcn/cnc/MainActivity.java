package com.collectcn.cnc;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.

        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        final TextView tView = (TextView)findViewById(R.id.tView);
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


        final DBHelper dbHelper = new DBHelper(this);
        //dbHelper.insertData();

        //final Cursor cursor = dbHelper.getuser();


        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Context context = getApplicationContext();

                String text = tView.getText().toString();
                if(text.length()==11) {
                    try {
                        dbHelper.insertData(text);
                        tView.setText("");
                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(context, "Database Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(context, "Invalid Number", Toast.LENGTH_SHORT).show();
                }

            }
        });


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
        if (id == R.id.Export){
            export();
            return true;
        }
        if (id == R.id.Clear) {
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.clearTable();
            Context context = getApplicationContext();
            Toast.makeText(context, "All Data Cleared", Toast.LENGTH_SHORT).show();
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
            case R.id.buttonBackspace:
                // your code for button2 here
                if (text != null && text.length() > 0)
                    tView.setText(text.substring(0, text.length()-1));
                break;
            // even more buttons here
        }
    }

    public void export()
    {
        final DBHelper dbHelper = new DBHelper(this);
        final Cursor cursor = dbHelper.getuser();

        File sd = Environment.getExternalStorageDirectory();

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        String csvFile = year+"-"+month+"-"+day+"_"+hour+"-"+minute+"-"+second+".xls";

        File directory = new File(sd.getAbsolutePath());
        //create directory if not exist
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        try {

            //file path
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("userList", 0);
            // column and row
            sheet.addCell(new Label(0, 0, "PhoneNumber"));
            sheet.addCell(new Label(1, 0, "CreatedTime"));

            if (cursor.moveToFirst()) {
                do {
                    String phone_number = cursor.getString(cursor.getColumnIndex("phone_number"));
                    String created_time = cursor.getString(cursor.getColumnIndex("created_time"));

                    int i = cursor.getPosition() + 1;
                    sheet.addCell(new Label(0, i, phone_number));
                    sheet.addCell(new Label(1, i, created_time));
                } while (cursor.moveToNext());
            }

            //closing cursor
            cursor.close();
            workbook.write();
            workbook.close();
            Toast.makeText(getApplication(),
                    "Data Exported in Root Folder", Toast.LENGTH_LONG).show();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    finish();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
