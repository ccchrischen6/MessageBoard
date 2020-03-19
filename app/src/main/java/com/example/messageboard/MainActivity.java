package com.example.messageboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_2 = (LinearLayout) getView("ll_2");
    }


    public void addMessage(View view) {
        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, Keys.ADD_NEW_MESSAGE);  // you can use any number other than 111
    }

    @Override
    protected void onActivityResult(int requestCoe, int resultCode, Intent intent){
        if (requestCoe == Keys.ADD_NEW_MESSAGE && resultCode == RESULT_OK){
            Message message = (Message) intent.getSerializableExtra(Keys.MESSAGE);

            TextView textView = new TextView(this);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(30, 35, 30, 35);
            textView.setLayoutParams(params);
            textView.setTextSize(24);

            String text = "Topic:\t" + message.getTopic() + "\n" +
                    "Detail:\t"+ message.getDetail() + "\n" +
                    "Name:\t" + message.getName();


            textView.setText(text);
            ll_2.addView(textView);
        }
    }

    //get View by its ID
    private View getView(String sID) {
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }



}
