package com.example.andrei.dictionar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AlegereaDictionarului extends AppCompatActivity {
    int i =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alegerea_dictionarului);

        final ImageView image1 = (ImageView)findViewById(R.id.arrow1);
        final ImageView image2 = (ImageView)findViewById(R.id.arrow2);
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        Animation.AnimationListener animListener = new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (animation == animationFadeIn) {

                    // Start fade-out animation
                    image1.startAnimation(animationFadeOut);
                    image2.startAnimation(animationFadeOut);

                } else if (animation == animationFadeOut) {

                    image1.setImageResource(R.drawable.bun);
                    image2.setImageResource(R.drawable.arrow);

                    image1.startAnimation(animationFadeIn);
                    image2.startAnimation(animationFadeIn);

                }
            }
        };

        animationFadeIn.setAnimationListener(animListener);
        animationFadeOut.setAnimationListener(animListener);

        image1.setImageResource(R.drawable.bun);
        image2.setImageResource(R.drawable.arrow);

        image1.startAnimation(animationFadeIn);
        image2.startAnimation(animationFadeIn);


    }

    public void ro_eng(View v){

        Intent i = new Intent(this, Ro_Eng.class);
        i.putExtra("ro", "1");
        startActivity(i);

    }

    public void eng_ro(View v){

        Intent i = new Intent(this, Ro_Eng.class);
        i.putExtra("eng", "2");
        startActivity(i);

    }
}
