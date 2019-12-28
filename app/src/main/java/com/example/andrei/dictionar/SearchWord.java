package com.example.andrei.dictionar;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchWord extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_word_ro__eng);

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            ArrayList<String> arrayList = new ArrayList();

            dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null,null,null,DBManager.ColRo);

            if(cursor.moveToFirst()){
                do{

                    arrayList.add(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

                }
                while(cursor.moveToNext());

                final AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

                complete.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_list__detail,R.id.textView2,arrayList) );

            }

            if(arrayList.isEmpty()){

                //Button cauta = (Button) findViewById(R.id.cauta);
                //cauta.setVisibility(View.INVISIBLE);

                TextView warning = (TextView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);

                AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);
                complete.setFocusable(false);
                complete.setClickable(false);

            }
            else{

                //Button cauta = (Button) findViewById(R.id.cauta);
                //cauta.setVisibility(View.VISIBLE);

                TextView warning = (TextView) findViewById(R.id.warning);
                warning.setVisibility(View.INVISIBLE);

            }

            final AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

            complete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Cursor cursor = dbManager.query(null,"CuvantRO like \"%" + complete.getText() + "%\"",null,DBManager.ColRo);
                    if(cursor.moveToFirst()){
                        do{

                            EditText cuvant = (EditText) findViewById(R.id.editText4);
                            TextView textView = (TextView) findViewById(R.id.textView);

                            cuvant.setVisibility(View.VISIBLE);
                            textView.setVisibility(View.VISIBLE);
                            cuvant.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

                        }
                        while(cursor.moveToNext());
                    }

                }
            });

        }
        else if(bundle.getString("eng") != null){

            AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

            complete.setHint("Search for the desired word in English");

            ArrayList<String> arrayList = new ArrayList();

            dbManager = new DBManager(this);

            Cursor cursor = dbManager.query(null,null,null,DBManager.ColEng);

            if(cursor.moveToFirst()){
                do{

                    arrayList.add(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

                }
                while(cursor.moveToNext());

                complete = (AutoCompleteTextView) findViewById(R.id.complete);
                complete.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_list__detail,R.id.textView2,arrayList) );

            }

            if(arrayList.isEmpty()){

                TextView warning = (TextView) findViewById(R.id.warning);
                warning.setVisibility(View.VISIBLE);

                complete = (AutoCompleteTextView) findViewById(R.id.complete);
                complete.setFocusable(false);
                complete.setClickable(false);

            }
            else{

                TextView warning = (TextView) findViewById(R.id.warning);
                warning.setVisibility(View.INVISIBLE);

            }

            complete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    final AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

                    Cursor cursor = dbManager.query(null,"CuvantENG like \"%" + complete.getText() + "%\"",null,DBManager.ColEng);
                    if(cursor.moveToFirst()){
                        do{

                            EditText cuvant = (EditText) findViewById(R.id.editText4);
                            TextView textView = (TextView) findViewById(R.id.textView);

                            cuvant.setVisibility(View.VISIBLE);
                            textView.setVisibility(View.VISIBLE);
                            cuvant.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

                        }
                        while(cursor.moveToNext());
                    }

                }
            });

        }

    }

    /*public void search(View v){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

            Cursor cursor = dbManager.query(null,"CuvantRO like \"%" + complete.getText() + "%\"",null,DBManager.ColRo);
            if(cursor.moveToFirst()){
                do{

                    EditText cuvant = (EditText) findViewById(R.id.editText4);
                    TextView textView = (TextView) findViewById(R.id.textView);

                    cuvant.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    cuvant.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColEng)));

                }
                while(cursor.moveToNext());
            }

        }
        else if(bundle.getString("eng") != null){

            AutoCompleteTextView complete = (AutoCompleteTextView) findViewById(R.id.complete);

            Cursor cursor = dbManager.query(null,"CuvantENG like \"%" + complete.getText() + "%\"",null,DBManager.ColEng);
            if(cursor.moveToFirst()){
                do{

                    EditText cuvant = (EditText) findViewById(R.id.editText4);
                    TextView textView = (TextView) findViewById(R.id.textView);

                    cuvant.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    cuvant.setText(cursor.getString(cursor.getColumnIndex(DBManager.ColRo)));

                }
                while(cursor.moveToNext());
            }

        }

    }*/

}
