package com.example.java_class2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    private TextView resultText1;
    private EditText editText1;
    private Button finishButton;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        setListeners();
    }
    private  void init(){
        resultText1 = findViewById(R.id.resultText);
        editText1 = findViewById(R.id.editText1);
        finishButton = findViewById(R.id.finishButton);
        value = getIntent().getStringExtra("value");
        resultText1.setText(value);
    }

    private void setListeners() {
        finishButton.setOnClickListener(v ->{
            Intent intent = new Intent();
            intent.putExtra("value2", editText1.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
