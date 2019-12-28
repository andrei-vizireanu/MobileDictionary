package com.example.andrei.dictionar;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteWord extends AppCompatActivity {

    DBManager dbManager;
    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_word_ro__eng);

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            dbManager = new DBManager(this);

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            Cursor cursor = dbManager.query(null,null,null,DBManager.ColRo);


            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColRo)), cursor.getString(cursor.getColumnIndex(DBManager.ColEng))));

                }
                while(cursor.moveToNext());

            }

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

            if(myadapter.getCount() == 0){

                Button cauta = (Button) findViewById(R.id.button9);
                cauta.setVisibility(View.INVISIBLE);

                TextView warning2 = (TextView) findViewById(R.id.warning2);
                warning2.setVisibility(View.VISIBLE);

                EditText cautare = (EditText) findViewById(R.id.cautare);
                cautare.setFocusable(false);
                cautare.setClickable(false);

            }
            else{

                Button cauta = (Button) findViewById(R.id.button9);
                cauta.setVisibility(View.VISIBLE);

                TextView warning2 = (TextView) findViewById(R.id.warning2);
                warning2.setVisibility(View.INVISIBLE);

            }

        }
        else if(bundle.getString("eng") != null){

            dbManager = new DBManager(this);

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            Cursor cursor = dbManager.query(null,null,null,DBManager.ColEng);


            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColEng)), cursor.getString(cursor.getColumnIndex(DBManager.ColRo))));

                }
                while(cursor.moveToNext());

            }

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

            if(myadapter.getCount() == 0){

                Button cauta = (Button) findViewById(R.id.button9);
                cauta.setVisibility(View.INVISIBLE);

                TextView warning2 = (TextView) findViewById(R.id.warning2);
                warning2.setVisibility(View.VISIBLE);

                EditText cautare = (EditText) findViewById(R.id.cautare);
                cautare.setFocusable(false);
                cautare.setClickable(false);

            }
            else{

                Button cauta = (Button) findViewById(R.id.button9);
                cauta.setVisibility(View.VISIBLE);

                TextView warning2 = (TextView) findViewById(R.id.warning2);
                warning2.setVisibility(View.INVISIBLE);

            }

        }

    }

    public void load(View v){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            listnewsData.clear();

            Cursor cursor = dbManager.query(null, null, null, DBManager.ColRo);

            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColRo)), cursor.getString(cursor.getColumnIndex(DBManager.ColEng))));

                }
                while(cursor.moveToNext());

            }

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

            Button load = (Button) findViewById(R.id.load);
            load.setVisibility(View.INVISIBLE);

            EditText cautare = (EditText) findViewById(R.id.cautare);
            cautare.setText("");

        }
        else if(bundle.getString("eng") != null){

            listnewsData.clear();

            Cursor cursor = dbManager.query(null, null, null, DBManager.ColEng);

            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColEng)), cursor.getString(cursor.getColumnIndex(DBManager.ColRo))));

                }
                while(cursor.moveToNext());

            }

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

            Button load = (Button) findViewById(R.id.load);
            load.setVisibility(View.INVISIBLE);

            EditText cautare = (EditText) findViewById(R.id.cautare);
            cautare.setText("");

        }



    }

    public void searchWord(View v){

        LoadElement();

    }

    void LoadElement(){

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("ro") != null){

            EditText cautare = (EditText) findViewById(R.id.cautare);

            if(!cautare.getText().toString().equals("")){

                Button load = (Button) findViewById(R.id.load);
                load.setVisibility(View.VISIBLE);

            }

            String[] SelectionArgs = {cautare.getText().toString() + "%"};

            listnewsData.clear();

            Cursor cursor = dbManager.query(null, "CuvantRO like ?", SelectionArgs, DBManager.ColRo);

            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColRo)), cursor.getString(cursor.getColumnIndex(DBManager.ColEng))));

                }
                while(cursor.moveToNext());

            }

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

        }
        else if(bundle.getString("eng") != null){

            EditText cautare = (EditText) findViewById(R.id.cautare);

            if(!cautare.getText().toString().equals("")){

                Button load = (Button) findViewById(R.id.load);
                load.setVisibility(View.VISIBLE);

            }

            String[] SelectionArgs = {cautare.getText().toString() + "%"};

            listnewsData.clear();

            Cursor cursor = dbManager.query(null, "CuvantENG like ?", SelectionArgs, DBManager.ColEng);

            if(cursor.moveToFirst()){
                do {

                    listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColEng)), cursor.getString(cursor.getColumnIndex(DBManager.ColRo))));

                }
                while(cursor.moveToNext());

            }

            MyCustomAdapter myadapter;

            ListView lsNews=(ListView)findViewById(R.id.LVNews);

            myadapter = new MyCustomAdapter(listnewsData);

            lsNews.setAdapter(myadapter);

        }

    }



    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }

        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView id = (TextView)myView.findViewById(R.id.id);
            id.setText(String.valueOf(s.ID));

            TextView cuvant=( TextView)myView.findViewById(R.id.cuvant);
            cuvant.setText(s.Cuvant);

            TextView traducere=( TextView)myView.findViewById(R.id.traducere);
            traducere.setText(s.Traducere);

            Button delete = (Button)myView.findViewById(R.id.deleteWord);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String[] SelectionArgs = {String.valueOf(s.ID)};
                    int count = dbManager.Delete("ID=?",SelectionArgs);
                    if(count>0){
                        LoadElement();
                    }

                    MyCustomAdapter myadapter;

                    ListView lsNews=(ListView)findViewById(R.id.LVNews);

                    Cursor cursor = dbManager.query(null,null,null,DBManager.ColRo);


                    if(cursor.moveToFirst()){
                        do {

                            listnewsData.add(new AdapterItems(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColRo)), cursor.getString(cursor.getColumnIndex(DBManager.ColEng))));

                        }
                        while(cursor.moveToNext());

                    }

                    myadapter = new MyCustomAdapter(listnewsData);

                    lsNews.setAdapter(myadapter);

                    if(myadapter.getCount() == 0){

                        Button cauta = (Button) findViewById(R.id.button9);
                        cauta.setVisibility(View.INVISIBLE);

                        TextView warning2 = (TextView) findViewById(R.id.warning2);
                        warning2.setVisibility(View.VISIBLE);

                        EditText cautare = (EditText) findViewById(R.id.cautare);
                        cautare.setFocusable(false);
                        cautare.setClickable(false);

                    }
                    else{

                        Button cauta = (Button) findViewById(R.id.button9);
                        cauta.setVisibility(View.VISIBLE);

                        TextView warning2 = (TextView) findViewById(R.id.warning2);
                        warning2.setVisibility(View.INVISIBLE);

                        LoadElement();

                    }

                }
            });

            Button edit = (Button)myView.findViewById(R.id.edit);
            edit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    Bundle bundle = getIntent().getExtras();

                    if(bundle.getString("ro") != null){

                        Intent i = new Intent(DeleteWord.this, Edit_Word.class);

                        String SelectionArgs = s.Cuvant;
                        String SelectionArgs1 = s.Traducere;
                        int SelectionArgs2 = s.ID;

                        i.putExtra("Cuv", SelectionArgs);
                        i.putExtra("Tra", SelectionArgs1);
                        i.putExtra("Id", SelectionArgs2);
                        i.putExtra("ro","1");

                        startActivity(i);

                        finish();

                    }
                    else if(bundle.getString("eng") != null){

                        Intent i = new Intent(DeleteWord.this, Edit_Word.class);

                        String SelectionArgs = s.Cuvant;
                        String SelectionArgs1 = s.Traducere;
                        int SelectionArgs2 = s.ID;

                        i.putExtra("Cuv", SelectionArgs);
                        i.putExtra("Tra", SelectionArgs1);
                        i.putExtra("Id", SelectionArgs2);
                        i.putExtra("eng","2");

                        startActivity(i);

                        finish();

                    }



                }

        });



            return myView;
        }

    }

}
