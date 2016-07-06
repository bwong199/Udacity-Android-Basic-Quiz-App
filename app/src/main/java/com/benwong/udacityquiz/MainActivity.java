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
    private CheckBox q4InputT;
    private CheckBox q4InputF;
    private CheckBox q5InputT;
    private CheckBox q5InputF;
    private Button submitButton;

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
        q4InputT = (CheckBox)findViewById(R.id.q4AnswerT);
        q4InputF = (CheckBox)findViewById(R.id.q4AnswerF);
        q5InputT = (CheckBox)findViewById(R.id.q5AnswerT);
        q5InputF = (CheckBox)findViewById(R.id.q5AnswerF);

        submitButton = (Button) findViewById(R.id.button);

        final int selectedId = radioButtonGroup.getCheckedRadioButtonId();
        selectedRadioBtn = (RadioButton) findViewById(selectedId);

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
                if(q4InputT.isChecked()){
                    q4Answer = "true";
                    q4InputF.setChecked(false);
                }


                if(q4InputF.isChecked()){
                    q4Answer = "false";
                    q4InputT.setChecked(false);
                }


                if(q5InputT.isChecked()){
                    q5Answer = "yes";
                    q5InputF.setChecked(false);
                }

                if(q5InputF.isChecked()){
                    q5Answer = "no";
                    q5InputT.setChecked(false);
                }

                System.out.println(q1Answer);
                System.out.println(q2Answer);
                System.out.println(q3Answer);
                System.out.println(q4Answer);
                System.out.println(q5Answer);

                if(!q1Answer.equals(null)  ||!q2Answer.equals(null)  ||!q3Answer.equals(null)  ||!q4Answer.equals(null)  || !q5Answer.equals(null)){
                    if(!(q1Answer.equals("Chest"))){
                        Toast.makeText(getApplicationContext(), "Bench press works out chest", Toast.LENGTH_SHORT).show();
                    }

                    if(!(q2Answer.equals("tricep"))){
                        Toast.makeText(getApplicationContext(), "Rope pulldown works out tricep", Toast.LENGTH_SHORT).show();
                    }

                    if(!(q3Answer.equals("front"))){
                        Toast.makeText(getApplicationContext(), "Shoulder press works out front delt", Toast.LENGTH_SHORT).show();
                    }

                    if(!(q4Answer.equals("true"))){
                        Toast.makeText(getApplicationContext(), "Shoulder press works out front delt", Toast.LENGTH_SHORT).show();
                    }

                    if(!(q5Answer.equals("no"))){
                        Toast.makeText(getApplicationContext(), "Don't roid. It's not good for you.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
