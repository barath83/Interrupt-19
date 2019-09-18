package com.example.ace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView days = (TextView) findViewById(R.id.days);
        final TextView hours = (TextView) findViewById(R.id.hours);
        final TextView mins = (TextView) findViewById(R.id.minutes);
        final TextView seconds = (TextView) findViewById(R.id.seconds);



        Calendar thatday = Calendar.getInstance();
        thatday.setTime(new Date(0));
        thatday.set(Calendar.HOUR_OF_DAY, 9);
        thatday.set(Calendar.DAY_OF_MONTH, 25);
        thatday.set(Calendar.MONTH, 8);
        thatday.set(Calendar.YEAR, 2019);

        Calendar today = Calendar.getInstance();

        long diff = thatday.getTimeInMillis() - today.getTimeInMillis();
        long diffSec = diff / 1000;



    /*    172800000 milliseconds = 5days

    1000(1sec) is time interval to call onTick method

    millisUntilFinished is amount of until finished

    */

        new CountDownTimer(diff, 1000) {

            @Override

            public void onTick(long millisUntilFinished) {
                /*            converting the milliseconds into days, hours, minutes and seconds and displaying it in textviews             */

                days.setText(TimeUnit.HOURS.toDays(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)) + "");

                hours.setText((TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished))) + "");

                mins.setText((TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished))) + "");

                seconds.setText((TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))) + "");

            }

            @Override

            public void onFinish() {
                /*            clearing all fields and displaying countdown finished message             */

                days.setText("Count down completed");
                hours.setText("");
                mins.setText("");
                seconds.setText("");
            }
        }.start();
    }


    }


