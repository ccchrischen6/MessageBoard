package com.example.messageboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    private boolean isAnonymous;
    private String name;
    private String topic;
    private String detail;
    EditText e_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        CheckBox c_1 = (CheckBox) getView("C_1");
        e_1 = (EditText) getView("E_1");
        c_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                e_1.setText("");
                e_1.setEnabled(!isChecked);
            }
        });
    }

    //get View by its ID
    private View getView(String sID) {
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }

    public void submit(View view) {
        isAnonymous = ((CheckBox) getView("C_1")).isChecked();
        name = ((EditText) getView("E_1")).getText().toString();
        topic = ((EditText) getView("E_2")).getText().toString();
        detail = ((EditText) getView("E_3")).getText().toString();

        Message message = new Message(isAnonymous, name, topic, detail);

        Intent intent = new Intent();
        intent.putExtra(Keys.MESSAGE, message);
        setResult(RESULT_OK, intent);
        finish();
    }

}
