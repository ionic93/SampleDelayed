package com.example.sampledelayed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            AlertDialog dialog = makeRequestDialog(
                    "Request Remote",
                    "Do you want a data?",
                    "Yes", "No"
            );
            dialog.show();
            textView.setText("displaying Dialog");
        });
    }

    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence yes, CharSequence no) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("be express after 5seconds");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("request completed");
                    }
                },3000);
            }
        });

        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}