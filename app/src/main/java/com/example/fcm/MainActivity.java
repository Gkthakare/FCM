package com.example.fcm;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private EditText mTitle,mMessage;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.mTitle);
        mMessage = findViewById(R.id.mMessage);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.mSend).setOnContextClickListener(new View.OnContextClickListener() {
                @Override
                public boolean onContextClick(View view) {
                    String title = mTitle.getText().toString().trim();
                    String message = mMessage.getText().toString().trim();
                    if(!title.equals("") && !message.equals("")) {
                        FCMSend.pushNotification(
                                MainActivity.this,
                               "d_8odZtHQs6fzOpCc0bqzN:APA91bHAliYCY4NR5cI_i0zQ27YksS71oUlA0bUaYDQ6u3E4ldSn5CJAbhC8uArMmoA1vdIxrJ7mrASJyuhAaanAuyQpZqEARxLCU58XRmUQ9qyYW8axvXHbbYq4oJFZS6DJCli1sPvR",
                                title,
                                message
                        );
                    }
                    return onContextClick(view);
                }
            });
//        }

//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            return;
//                        }
//                        String token = task.getResult();
//                        System.out.println("Token: " + token);
//                    }
//                });
    }
}