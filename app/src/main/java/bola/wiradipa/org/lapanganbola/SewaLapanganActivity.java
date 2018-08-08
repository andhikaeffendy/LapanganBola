package bola.wiradipa.org.lapanganbola;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SewaLapanganActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance(Locale.US);
    TextView tanggal_sewa;
    DatePickerDialog.OnDateSetListener mDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_lapangan);

        Button sewa = (Button) findViewById(R.id.cari_lapang);
        tanggal_sewa = (TextView) findViewById(R.id.tanggal_sewa);
        final EditText waktu_sewa = (EditText) findViewById(R.id.jam_sewa);
        final TextView durasi = (TextView) findViewById(R.id.lama_sewa);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_lapangan);
        List<String> list = new ArrayList<String>();
        list.add("Lapangan Futsal");
        list.add("Lapangan Bola");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout,list);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);

        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SewaLapanganActivity.this, CariLapanganActivity.class);
                startActivity(intent);
            }
        });

        tanggal_sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SewaLapanganActivity.this,
                        R.style.Theme_AppCompat_DayNight_Dialog_MinWidth,
                        mDatePicker,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        durasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPicker numberPicker = new NumberPicker(SewaLapanganActivity.this);
                numberPicker.setMaxValue(10);
                numberPicker.setMinValue(0);
                NumberPicker.OnValueChangeListener myValueNumberPick = new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        durasi.setText(newVal+" jam");
                    }
                };
                numberPicker.setOnValueChangedListener(myValueNumberPick);
                AlertDialog.Builder builder = new AlertDialog.Builder(SewaLapanganActivity.this).setView(numberPicker);
                builder.setTitle("Durasi");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        mDatePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                tanggal_sewa.setText(date);
            }
        };


        waktu_sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int menit = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(SewaLapanganActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        waktu_sewa.setText(hourOfDay + ":" + minute);
                    }
                },hour,menit,true);
                timePickerDialog.setTitle("Pilih Waktu");
                timePickerDialog.show();
            }
        });
    }

}
