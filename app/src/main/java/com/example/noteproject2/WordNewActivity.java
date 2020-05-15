package com.example.noteproject2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Timestamp;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class WordNewActivity extends AppCompatActivity {
    private EditText mEditWordView;
    private EditText mEditTitleView;
    private EditText mEditDueDateView;
    //private EditText mEditDueTimeView;
    DatePickerDialog datePicker;
    //TimePickerDialog timePicker;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        Bundle b = getIntent().getExtras();

        mEditWordView = findViewById(R.id.edit_word);
        mEditDueDateView = findViewById(R.id.edit_date_due);
        mEditTitleView = findViewById(R.id.edit_Title);
        //mEditDueTimeView = findViewById(R.id.edit_time_due);

//        mEditDueTimeView.setInputType(EditorInfo.TYPE_NULL);
//        mEditDueTimeView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar calendar = Calendar.getInstance();
//                int hour = calendar.get(Calendar.HOUR_OF_DAY);
//                int minutes = calendar.get(Calendar.MINUTE);
//
//                timePicker = new TimePickerDialog(WordNewActivity.this,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker view, int sHourOfDay, int sMinute) {
//                                mEditDueTimeView.setText(String.format("%02d", sHourOfDay) + ":" + String.format("%02d", sMinute));
//                            }
//                        }, hour, minutes, true);
//                timePicker.show();
//            }
//        });
        mEditDueDateView.setInputType(EditorInfo.TYPE_NULL);
        mEditDueDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(WordNewActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int sYear, int sMonth, int sDayOfMonth) {
                                sMonth++;
                                mEditDueDateView.setText(sYear + "-" + sMonth + "-" + sDayOfMonth);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });

        final Button button = findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTitleView.getText()) && TextUtils.isEmpty(mEditDueDateView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    //Log.d("due time", mEditDueTimeView.getText().toString());
                    Log.d("due date", mEditDueDateView.getText().toString());
                    //String due = mEditDueDateView.getText().toString() + ' ' + mEditDueTimeView.getText().toString() + ":00";
                    String due = mEditDueDateView.getText().toString() + ' ' + "00:00" + ":00";
                    Log.d("due",due);
                    Word newWord = new Word(mEditTitleView.getText().toString(), mEditWordView.getText().toString(), Timestamp.valueOf(due),1);
                    replyIntent.putExtra("newWord", newWord);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}