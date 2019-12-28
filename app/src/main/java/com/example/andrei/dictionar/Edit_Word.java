package com.example.andrei.dictionar;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class Edit_Word extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__word);

        Intent intent = getIntent();

        String cuv = intent.getStringExtra("Cuv");
        String tra = intent.getStringExtra("Tra");

        EditText editText = (EditText) findViewById(R.id.editText3);
        EditText editText1 = (EditText) findViewById(R.id.editText5);

        editText.setText(cuv);
        editText1.setText(tra);



    }

    public void save(View v){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            Intent intent = getIntent();

            EditText editText = (EditText) findViewById(R.id.editText3);
            EditText editText1 = (EditText) findViewById(R.id.editText5);

            String cuv = editText.getText().toString();
            String tra = editText1.getText().toString();

            int id = intent.getIntExtra("Id", 0);

            dbManager = new DBManager(this);
            ContentValues values = new ContentValues();
            values.put(DBManager.ColRo, cuv.toString());
            values.put(DBManager.ColEng, tra.toString());
            values.put(DBManager.ColID, id);

            String[] SelectionArgs = {String.valueOf(id)};
            dbManager.Update(values, "ID=?", SelectionArgs);

            Intent i = new Intent(this, DeleteWord.class);
            i.putExtra("ro", "1");
            startActivity(i);
            finish();

        }

        else if(bundle.getString("eng") != null){

            Intent intent = getIntent();

            EditText editText = (EditText) findViewById(R.id.editText3);
            EditText editText1 = (EditText) findViewById(R.id.editText5);

            String cuv = editText.getText().toString();
            String tra = editText1.getText().toString();

            int id = intent.getIntExtra("Id", 0);

            dbManager = new DBManager(this);
            ContentValues values = new ContentValues();
            values.put(DBManager.ColEng, cuv.toString());
            values.put(DBManager.ColRo, tra.toString());
            values.put(DBManager.ColID, id);

            String[] SelectionArgs = {String.valueOf(id)};
            dbManager.Update(values, "ID=?", SelectionArgs);

            Intent i = new Intent(this, DeleteWord.class);
            i.putExtra("eng", "2");
            startActivity(i);
            finish();

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Bundle bundle = getIntent().getExtras();

            if(bundle.getString("ro") != null){

                Intent i = new Intent(this, DeleteWord.class);
                i.putExtra("ro", "1");
                startActivity(i);
                finish();

            }
            else if(bundle.getString("eng") != null){

                Intent i = new Intent(this, DeleteWord.class);
                i.putExtra("eng", "2");
                startActivity(i);
                finish();

            }



            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


}
