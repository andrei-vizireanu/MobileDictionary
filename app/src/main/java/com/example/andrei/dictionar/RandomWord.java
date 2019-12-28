package com.example.andrei.dictionar;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RandomWord extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_word);

        Bundle bundle = getIntent().getExtras();

        if (bundle.getString("ro") != null) {

            ArrayList<String> arrayList = new ArrayList();

            dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null, null, null, DBManager.ColRo);

            if (cursor.moveToFirst()) {
                do {

                    arrayList.add(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

                }

                while (cursor.moveToNext());
            }

            if (arrayList.isEmpty()) {

                    Button cauta = (Button) findViewById(R.id.button8);
                    cauta.setVisibility(View.INVISIBLE);

                    TextView warning = (TextView) findViewById(R.id.warning);
                    warning.setVisibility(View.VISIBLE);

            }
            else {

                    Button cauta = (Button) findViewById(R.id.button8);
                    cauta.setVisibility(View.VISIBLE);

                    TextView warning = (TextView) findViewById(R.id.warning);
                    warning.setVisibility(View.INVISIBLE);

                EditText cuv = (EditText) findViewById(R.id.cuv);
                EditText tra = (EditText) findViewById(R.id.tra);

                DBManager dbManager = new DBManager(this);

                cursor = dbManager.query(null, null, null, "RANDOM()");

                cursor.moveToFirst();

                while (cuv.getText().toString().equals(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)))) {

                    cursor = dbManager.query(null, null, null, "RANDOM()");
                    cursor.moveToFirst();

                }

                cuv.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));
                tra.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

                }



        }
        else if (bundle.getString("eng") != null) {

            TextView textView = (TextView) findViewById(R.id.textView3);
            TextView textView1 = (TextView) findViewById(R.id.textView4);

            textView.setText("ENG");
            textView1.setText("RO");

            ArrayList<String> arrayList = new ArrayList();

            dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null, null, null, DBManager.ColEng);

            if (cursor.moveToFirst()) {
                do {

                    arrayList.add(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

                }
                while (cursor.moveToNext());
            }

                if (arrayList.isEmpty()) {

                    Button cauta = (Button) findViewById(R.id.button8);
                    cauta.setVisibility(View.INVISIBLE);

                    TextView warning = (TextView) findViewById(R.id.warning);
                    warning.setVisibility(View.VISIBLE);

                }
                else {

                    Button cauta = (Button) findViewById(R.id.button8);
                    cauta.setVisibility(View.VISIBLE);

                    TextView warning = (TextView) findViewById(R.id.warning);
                    warning.setVisibility(View.INVISIBLE);

                    EditText cuv = (EditText) findViewById(R.id.cuv);
                    EditText tra = (EditText) findViewById(R.id.tra);

                    DBManager dbManager = new DBManager(this);

                    cursor = dbManager.query(null, null, null, "RANDOM()");

                    cursor.moveToFirst();

                    while (cuv.getText().toString().equals(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)))) {

                        cursor = dbManager.query(null, null, null, "RANDOM()");
                        cursor.moveToFirst();

                    }

                    cuv.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));
                    tra.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

                }

        }

    }

    public void random(View v){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            EditText cuv = (EditText) findViewById(R.id.cuv);
            EditText tra = (EditText) findViewById(R.id.tra);

            DBManager dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null,null,null, "RANDOM()");

            cursor.moveToFirst();

            while(cuv.getText().toString().equals(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)))){

                cursor = dbManager.query(null,null,null, "RANDOM()");cursor.moveToFirst();

            }

            cuv.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));
            tra.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

        }
        else if(bundle.getString("eng") != null){

            EditText cuv = (EditText) findViewById(R.id.cuv);
            EditText tra = (EditText) findViewById(R.id.tra);

            DBManager dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null,null,null, "RANDOM()");

            cursor.moveToFirst();

            while(cuv.getText().toString().equals(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)))){

                cursor = dbManager.query(null,null,null, "RANDOM()");cursor.moveToFirst();

            }

            cuv.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));
            tra.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

        }

    }


}
