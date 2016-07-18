package com.example.admin.httpurlconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ((TextView) findViewById(R.id.text_view));
        tv.setText(RestUtil.requestWebService("http://http://jsonplaceholder.typicode.com/users"));
    }
}
