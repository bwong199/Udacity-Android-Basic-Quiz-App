package com.benwong.udacityquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioButtonGroup;
    private RadioButton radioButton;
    private RadioButton radiolatAnswer;
    private RadioButton radiochestAnswer;
    private RadioButton radioBicepAnswer;
    private RadioButton selectedRadioBtn;
    private String q1Answer;
    private String q2Answer;
    private String q3Answer;
    private String q4Answer;

    private String q5Answer;

    private EditText q2Input;
    private EditText q3Input;
    private CheckBox q4CheckboxAbs;
    private CheckBox q4CheckboxHamstring;
    private CheckBox q4CheckboxBicep;
    private CheckBox q4CheckboxTricep;

    private CheckBox q5InputT;
    private CheckBox q5InputF;
    private CheckBox q5InputM;
    private Button submitButton;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radiolatAnswer = (RadioButton) findViewById(R.id.radioLatAnswer);

        radiochestAnswer = (RadioButton) findViewById(R.id.radioChestAnswer);
        radioBicepAnswer = (RadioButton) findViewById(R.id.radioBicepAnswer);

        q2Input = (EditText)findViewById(R.id.q2Answer);
        q3Input = (EditText)findViewById(R.id.q3Answer);
        q4CheckboxAbs = (CheckBox)findViewById(R.id.q4AnswerAbs);
        q4CheckboxHamstring = (CheckBox)findViewById(R.id.q4AnswerHamstring);
        q4CheckboxBicep = (CheckBox)findViewById(R.id.q4AnswerBicep);
        q4CheckboxTricep = (CheckBox)findViewById(R.id.q4AnswerTricep);


        q5InputT = (CheckBox)findViewById(R.id.q5AnswerT);
        q5InputF = (CheckBox)findViewById(R.id.q5AnswerF);
        q5InputM = (CheckBox)findViewById(R.id.q5AnswerM);

        submitButton = (Button) findViewById(R.id.button);

        final int selectedId = radioButtonGroup.getCheckedRadioButtonId();
        selectedRadioBtn = (RadioButton) findViewById(selectedId);

        mScore = 5;

        radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                System.out.println(rb.getText());
                q1Answer = String.valueOf(rb.getText());
            }
        });



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                q2Answer = String.valueOf(q2Input.getText());
                q3Answer = String.valueOf(q3Input.getText());

                if(q4CheckboxBicep.isChecked() && q4CheckboxTricep.isChecked() && !q4CheckboxHamstring.isChecked() && !q4CheckboxAbs.isChecked()) {
                    q4Answer = "true";
                }else{
                    q4Answer="false";
                }


                if(q5InputT.isChecked() && !q5InputF.isChecked()){
                    q5Answer = "yes";

                }else {
                    q5Answer = "no";
                }

                if(q5InputM.isChecked()){
                    q5Answer = "maybe";
                }


                System.out.println(q1Answer);
                System.out.println(q2Answer);
                System.out.println(q3Answer);
                System.out.println(q4Answer);
                System.out.println(q5Answer);
                System.out.println(mScore);

                if(!q1Answer.equals(null)  ||!q2Answer.equals(null)  ||!q3Answer.equals(null)  ||!q4Answer.equals(null)  || !q5Answer.equals(null)){
                    if(!(q1Answer.equals("Chest"))){
                        Toast.makeText(getApplicationContext(), "Bench press works out chest", Toast.LENGTH_SHORT).show();
                        mScore = mScore - 1;
                    }

                    if(!(q2Answer.equalsIgnoreCase("tricep"))){
                        Toast.makeText(getApplicationContext(), "Rope pulldown works out tricep", Toast.LENGTH_SHORT).show();
                        mScore = mScore - 1;
                    }

                    if(!(q3Answer.equalsIgnoreCase("front"))){
                        Toast.makeText(getApplicationContext(), "Shoulder press works out front delt", Toast.LENGTH_SHORT).show();
                        mScore = mScore - 1;
                    }

                    if(!(q4Answer.equalsIgnoreCase("true"))){
                        Toast.makeText(getApplicationContext(), "Biceps and triceps are muscles in the arm.", Toast.LENGTH_SHORT).show();
                        mScore = mScore - 1;
                    }

                    if(!(q5Answer.equalsIgnoreCase("no"))){
                        Toast.makeText(getApplicationContext(), "Don't roid. It's not good for you.", Toast.LENGTH_SHORT).show();
                        mScore = mScore - 1;
                    }

                    if(q5Answer.equalsIgnoreCase("maybe")){
                        Toast.makeText(getApplicationContext(), "Maybe some cycle your roid to get a bit of size :)", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(getApplicationContext(), "Your mScore is " + mScore + " out of 5", Toast.LENGTH_SHORT).show();

                    System.out.println(mScore);
                    mScore = 5;
                }
            }
        });
    }
}
