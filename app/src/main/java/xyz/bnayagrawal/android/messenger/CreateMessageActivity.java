package xyz.bnayagrawal.android.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //this method will send the message to other activityf
    public void onSendMessage(View view) {
        EditText edit_text = (EditText) findViewById(R.id.message);

        //Explicit intent
        //Intent intent = new Intent(this,ReceiveMessageActivity.class);
        //intent.putExtra("message",edit_text.getText().toString());

        //Implicit intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,edit_text.getText().toString());

        //custom activity chooser
        String chooserTitle = getString(R.string.chooser);
        startActivity(Intent.createChooser(intent, chooserTitle));
    }
}
