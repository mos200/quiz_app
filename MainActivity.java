package com.example.android.quizz;


import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables
    AnimationDrawable aAnimation;

    private static int score = 0;

    private EditText name;


    private CheckBox a1_1, a1_2, a1_3, a1_4,
                     a2_1, a2_2, a2_3, a2_4,
                     a3_1, a3_2, a3_3, a3_4,
                     a4_1, a4_2, a4_3, a4_4;

    private boolean q_1_a = false;
    private boolean q_2_a = false;
    private boolean q_3_a = false;
    private boolean q_4_a = false;

    private CompoundButton.OnCheckedChangeListener chkCheckedListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //image animate
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.animation);
        aAnimation = (AnimationDrawable) imageView.getBackground();

        // Initialize the CheckBoxes
        a1_1 = (CheckBox) findViewById(R.id.a1_1);
        a1_2 = (CheckBox) findViewById(R.id.a1_2);
        a1_3 = (CheckBox) findViewById(R.id.a1_3);
        a1_4 = (CheckBox) findViewById(R.id.a1_4);

        a2_1 = (CheckBox) findViewById(R.id.a2_1);
        a2_2 = (CheckBox) findViewById(R.id.a2_2);
        a2_3 = (CheckBox) findViewById(R.id.a2_3);
        a2_4 = (CheckBox) findViewById(R.id.a2_4);

        a3_1 = (CheckBox) findViewById(R.id.a3_1);
        a3_2 = (CheckBox) findViewById(R.id.a3_2);
        a3_3 = (CheckBox) findViewById(R.id.a3_3);
        a3_4 = (CheckBox) findViewById(R.id.a3_4);

        a4_1 = (CheckBox) findViewById(R.id.a4_1);
        a4_2 = (CheckBox) findViewById(R.id.a4_2);
        a4_3 = (CheckBox) findViewById(R.id.a4_3);
        a4_4 = (CheckBox) findViewById(R.id.a4_4);

        // Initialize EditText name
        EditText name = (EditText) findViewById(R.id.name);

        setListeners();
    }

    public void setListeners() {

        // CheckBox listeners
        chkCheckedListner = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton selectedCheckBox, boolean isChecked) {
                // Check which checkbox was clicked
                switch (selectedCheckBox.getId()) {
                    case R.id.a1_1:
                        if (isChecked) {
                            q_1_a = true;
                        }
                        break;
                    case R.id.a2_4:
                        if (isChecked) {
                            q_2_a = true;
                        }
                        break;
                    case R.id.a3_2:
                        if (isChecked) {
                            q_3_a = true;
                        }
                        break;
                    case R.id.a4_2:
                        if (isChecked) {
                            q_4_a = true;
                        }
                        break;

                }
            }
        };

        a1_1.setOnCheckedChangeListener(chkCheckedListner);
        a2_4.setOnCheckedChangeListener(chkCheckedListner);
        a3_2.setOnCheckedChangeListener(chkCheckedListner);
        a4_2.setOnCheckedChangeListener(chkCheckedListner);

/*        // RadioGroup Listeners
        radioCheckChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
                switch (radioGroup.getId()) {
                    case R.id.animal:
                        if (R.id.radio_mammal == radioButtonId) {
                            isChoiceMammal = false;
                        }

                        if (R.id.radio_reptile == radioButtonId) {
                            isChoiceMammal = true;
                        }
                        break;
                }
            }
        };

        radioGroupAnimal.setOnCheckedChangeListener(radioCheckChangeListener);*/
    }

    public void display(String message) {

        RelativeLayout allScore = (RelativeLayout) findViewById(R.id.allScore);
        allScore.setVisibility(View.VISIBLE);
        TextView ScoreView = (TextView) findViewById(R.id.socre_view);
        ScoreView.setText(message);
        ScoreView.setHighlightColor(Color.RED);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        aAnimation.start();

    }


    public void result(View view) {

        if (q_1_a) {
            score = +1;
        }
        if (q_2_a) {
            score += 1;
        }
        if (q_3_a) {
            score += 1;
        }
        if (q_4_a) {
            score += 1;
        }
        //editText id
        name = (EditText) findViewById(R.id.name);
        String string = name.getText().toString();


        display("Hello " + string + "! \nYour Score Is: " + score +"/4");



        //scroll up
        final ScrollView mainScrollView = (ScrollView)findViewById(R.id.groupsScrollView);
        mainScrollView.post(new Runnable() {

            @Override
            public void run() {
                mainScrollView.fullScroll(View.FOCUS_UP);
            }
        });

    }

}
