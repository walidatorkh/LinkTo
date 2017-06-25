package com.walidatorkh.linkto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextDownloader.Callbacks{
    EditText enterURL;
    TextView getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterURL = (EditText)findViewById(R.id.enterURL);
        getData = (TextView)findViewById(R.id.getData);
    }
    public void downloadedData(View view){
        String link = enterURL.getText().toString();
        TextDownloader textDownloader = new TextDownloader(this);
        textDownloader.execute(link);
    }

    public void onAboutToBegin() {
        getData.setText("");
    }

    public void onSuccess(String downloadedText) {
        try {
            User user = new User(downloadedText);
            getData.setText(user.toString());
        }
        catch (Exception ex) {
            getData.setText("Error: " + ex.getMessage());
        }

    }

    public void onError(int httpStatusCode, String errorMessage) {
        getData.setText("Error! \n  Status code:" + httpStatusCode + "\n Message: " + errorMessage);
    }
}

