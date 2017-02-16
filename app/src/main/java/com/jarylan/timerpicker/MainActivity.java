package com.jarylan.timerpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jarylan.timerpicker.view.TimerPickerView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimerPickerView timerPickerView;
    private Button btGetTime;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FrameLayout timeLayout = (FrameLayout) findViewById(R.id.time_layout);
        timeLayout.addView(getTimePickerView());
        btGetTime = (Button) findViewById(R.id.bt_get_time);
        tvTime = (TextView) findViewById(R.id.tv_time);
        btGetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTime.setText(timerPickerView.getTime("-","-"," ",":",":",""));
            }
        });
    }

    private View getTimePickerView() {
        View timepickerview = View.inflate(this, R.layout.timepicker, null);
        timerPickerView = new TimerPickerView(timepickerview);
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        timerPickerView.setSTART_YEAR(1995);// 设置最小年份
        timerPickerView.setEND_YEAR(year);// 设置最大年份
        timerPickerView.initDateTimePicker(year, month, day, hour, min,second);//传入-1则不显示该列
        return timepickerview;
    }
}
