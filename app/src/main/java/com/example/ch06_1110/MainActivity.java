package com.example.ch06_1110;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    DatePicker dPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;
    LinearLayout under;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
/*
//      ch06 test 01  예제
        setContentView(R.layout.ch06_test_01);
        
        setTitle("시간 예약");

        // 버튼
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        // 버튼을 클릭하면 날짜,시간을 가져온다.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);


//              맨 아래 텍스트뷰에 타임피커로부터 가져온 시간과 분 표시.
//              tPicker.getHour 자동완성 뜨는 것 보면 이것이 정수형(int)임을 알 수 있으므로
//              정수형을 문자열로 바꿔주는 Integer.toString을 사용하기
                tvHour.setText(Integer.toString(tPicker.getHour()));
                tvMinute.setText(Integer.toString(tPicker.getMinute()));

                //맨 아래 텍스트뷰에 캘린더뷰에서 가져온 년/월/일 표시.
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

            }
        });


        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                selectYear = year;
                //달은 month+1이라고 해줘야됨!!!주의(안드로이드 기본 설정)
                selectMonth = month +1;
                selectDay = dayOfMonth;
            }
        });
*/



       // ch06 test 01_1  예제
        setContentView(R.layout.ch06_test_01_1);

        setTitle("시간 예약");

        // 크로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        dPicker = (DatePicker) findViewById(R.id.datePicker);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        //리니어 레이아웃
        under = findViewById(R.id.under);

        // 처음에는 2개를 안보이게 설정
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        // 타이머 설정
        chrono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        //아래 레이어 클릭
        under.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            @RequiresApi(api = Build.VERSION_CODES.M)
            public boolean onLongClick(View v) {
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);

                chrono.stop();
                chrono.setTextColor(Color.BLUE);

//              맨 아래 텍스트뷰에 타임피커로부터 가져온 시간과 분 표시.
//              tPicker.getHour 자동완성 뜨는 것 보면 이것이 정수형(int)임을 알 수 있으므로
//              정수형을 문자열로 바꿔주는 Integer.toString을 사용하기
                tvHour.setText(Integer.toString(tPicker.getHour()));
                tvMinute.setText(Integer.toString(tPicker.getMinute()));

                //맨 아래 텍스트뷰에 캘린더뷰에서 가져온 년/월/일 표시.
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(dPicker.getMonth()+1));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));

                return false;
            }
        });




















    }
}