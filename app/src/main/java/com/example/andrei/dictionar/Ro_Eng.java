package com.example.andrei.dictionar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Ro_Eng extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro__eng);

        Bundle bundle = getIntent().getExtras();

        ImageView imageView = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView5);

        if(bundle.getString("ro")!= null){

            imageView.setVisibility(View.INVISIBLE);
            imageView1.setVisibility(View.INVISIBLE);

        }
        else if(bundle.getString("eng")!= null){

            imageView.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.VISIBLE);

        }

    }

    public void search(View v){

        Bundle bundle = getIntent().getExtras();

        Intent i = new Intent(this, SearchWord.class);

        if(bundle.getString("ro")!= null){

            i.putExtra("ro", "1");
            startActivity(i);

        }
        else if(bundle.getString("eng")!= null){

            i.putExtra("eng", "2");
            startActivity(i);

        }

    }

    public void addWord(View v){

        Bundle bundle = getIntent().getExtras();

        Intent i = new Intent(this, AddWord.class);

        if(bundle.getString("ro")!= null){

            i.putExtra("ro", "1");
            startActivity(i);

        }
        else if(bundle.getString("eng")!= null){

            i.putExtra("eng", "2");
            startActivity(i);

        }

    }

    public void deleteWord(View v){

        Bundle bundle = getIntent().getExtras();

        Intent i = new Intent(this, DeleteWord.class);

        if(bundle.getString("ro")!= null){

            i.putExtra("ro", "1");
            startActivity(i);

        }
        else if(bundle.getString("eng")!= null){

            i.putExtra("eng", "2");
            startActivity(i);

        }

    }

    public void random(View v){

        Bundle bundle = getIntent().getExtras();

        Intent i = new Intent(this, RandomWord.class);

        if(bundle.getString("ro")!= null){

            i.putExtra("ro", "1");
            startActivity(i);

        }
        else if(bundle.getString("eng")!= null){

            i.putExtra("eng", "2");
            startActivity(i);

        }

    }

    
}
