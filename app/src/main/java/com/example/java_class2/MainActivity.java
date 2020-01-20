package com.example.java_class2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView resultText;
    private EditText editText;
    private Button moveButton;

    private  static final int REQUEST_CODE = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListeners();

    }

    private void init(){

        resultText = findViewById(R.id.resultText);
        editText = findViewById(R.id.editText);
        moveButton = findViewById(R.id.moveButton);

    }

    private void setListeners(){
        moveButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("value", editText.getText().toString());
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String value2 = data.getStringExtra("value2");
            resultText.setVisibility(View.VISIBLE);
            resultText.setText(value2);
        }
    }
}
