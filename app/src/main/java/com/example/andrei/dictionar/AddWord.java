package com.example.andrei.dictionar;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddWord extends AppCompatActivity {

    DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word_ro__eng);

        dbManager = new DBManager(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("ro") != null){

            EditText cuvant = (EditText) findViewById(R.id.editText);
            EditText traducere = (EditText) findViewById(R.id.editText2);

            cuvant.setHint("Word in RO");
            traducere.setHint("Translation in ENG");

            ImageView ro1 = (ImageView) findViewById(R.id.ro1);
            ImageView eng2 = (ImageView) findViewById(R.id.eng2);

            ro1.setVisibility(View.VISIBLE);
            //ro2.setVisibility(View.INVISIBLE);
            eng2.setVisibility(View.VISIBLE);
            //eng1.setVisibility(View.INVISIBLE);

        }
        if(bundle.getString("eng") != null){

            EditText cuvant = (EditText) findViewById(R.id.editText);
            EditText traducere = (EditText) findViewById(R.id.editText2);

            cuvant.setHint("Word in ENG");
            traducere.setHint("Translation in RO");

            ImageView ro1 = (ImageView) findViewById(R.id.ro1);
            ImageView eng2 = (ImageView) findViewById(R.id.eng2);

            ImageView ro2 = (ImageView) findViewById(R.id.ro2);
            ImageView eng1 = (ImageView) findViewById(R.id.eng1);

            //ro1.setVisibility(View.INVISIBLE);
            ro2.setVisibility(View.VISIBLE);
            eng1.setVisibility(View.VISIBLE);
            //eng2.setVisibility(View.INVISIBLE);

        }

    }

    public void add_word(View v){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            EditText cuvant = (EditText) findViewById(R.id.editText);
            EditText traducere = (EditText) findViewById(R.id.editText2);

            if(!cuvant.getText().toString().equals("") && !traducere.getText().toString().equals("")){

                ContentValues contentValues = new ContentValues();
                contentValues.put(DBManager.ColRo, cuvant.getText().toString());
                contentValues.put(DBManager.ColEng, traducere.getText().toString());

                long id = dbManager.InsertCuvinte(contentValues);

                if(id>0){

                    if(!cuvant.getText().toString().equals("") || !traducere.getText().toString().equals("")){

                        Toast.makeText(getApplicationContext(), "Word added!", Toast.LENGTH_LONG).show();
                        cuvant.setText("");
                        traducere.setText("");

                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error to add the word!", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Fill in all fields!", Toast.LENGTH_LONG).show();
            }

        }
        else if(bundle.getString("eng") != null){

            EditText cuvant = (EditText) findViewById(R.id.editText);
            EditText traducere = (EditText) findViewById(R.id.editText2);

            //cuvant.setHint("Word in ENG");
            //traducere.setHint("Translation in RO");

            if(!cuvant.getText().toString().equals("") && !traducere.getText().toString().equals("")){

                ContentValues contentValues = new ContentValues();
                contentValues.put(DBManager.ColEng, cuvant.getText().toString());
                contentValues.put(DBManager.ColRo, traducere.getText().toString());

                long id = dbManager.InsertCuvinte(contentValues);

                if(id>0){

                    if(!cuvant.getText().toString().equals("") || !traducere.getText().toString().equals("")){

                        Toast.makeText(getApplicationContext(), "Word added!", Toast.LENGTH_LONG).show();
                        cuvant.setText("");
                        traducere.setText("");

                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error to add the word!", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Fill in all fields!", Toast.LENGTH_LONG).show();
            }

        }





    }

}
