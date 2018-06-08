package com.example.raushan.firegooglein;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Option1 extends AppCompatActivity {
    Spinner sp1,sp2,sp3;
    EditText ed1,ed2,ed3,ed4;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    int rent,deposit,brokerage;
    Calendar mCalender;
    int day,month,year;
    TextView tv;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        sp1 = (Spinner)findViewById(R.id.spinner4);
        sp2 = (Spinner)findViewById(R.id.spinner5);
        sp3 = (Spinner)findViewById(R.id.spinner7);
        b1 = (Button)findViewById(R.id.cobb);
        ed1 = (EditText)findViewById(R.id.editText7);
        ed2 = (EditText)findViewById(R.id.editText10);
        tv = (TextView)findViewById(R.id.textView4);
        final String proptype = getIntent().getStringExtra("proptype2");
        final String cust_name = getIntent().getStringExtra("cust_name2");
        final String prop_name = getIntent().getStringExtra("prop_name2");
        final String cust_num = getIntent().getStringExtra("cust_num2");
        final String altcust_num = getIntent().getStringExtra("alt_num2");
        final String cust_em_site = getIntent().getStringExtra("cust_em_site2");
        final String prop_area = getIntent().getStringExtra("prop_area2");
        final String prop_variant = getIntent().getStringExtra("prop_variant2");
        final String prop_locality = getIntent().getStringExtra("prop_locality2");
        mCalender = Calendar.getInstance();
        day = mCalender.get(Calendar.DAY_OF_MONTH);
        month = mCalender.get(Calendar.MONTH);
        year = mCalender.get(Calendar.YEAR);
        month = month+1;
        ed3 = (EditText)findViewById(R.id.editText11);
        ed4 = (EditText)findViewById(R.id.editText8);
        sp1.setFocusable(true);
        sp1.setFocusableInTouchMode(true);
        sp1.requestFocus();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = sp1.getSelectedItem().toString();
                s2 = sp2.getSelectedItem().toString();
                s6 = sp3.getSelectedItem().toString();
                s3 = ed1.getText().toString();
                s4 = ed2.getText().toString();
                s5 = ed3.getText().toString();
                s7 = ed4.getText().toString();
                s8 = tv.getText().toString();
                if(s1.equals("Select size of property"))
                {
                    Toast.makeText(Option1.this,"Please select size of property.",Toast.LENGTH_SHORT).show();
                }
                else if (s2.equals("Select furnishing level"))
                {
                    Toast.makeText(Option1.this,"Please select furnishing level of property.",Toast.LENGTH_SHORT).show();
                }
                else if (s3.equals(""))
                {
                    Toast.makeText(Option1.this,"Please enter rent.",Toast.LENGTH_SHORT).show();
                }
                else if (!s3.equals(""))
                {
                    rent = Integer.parseInt(s3);
                    if (rent<=1)
                    {
                        Toast.makeText(Option1.this,"Please enter rent above 1.",Toast.LENGTH_SHORT).show();
                    }
                    else if (s8.equals("Select date"))
                    {
                        Toast.makeText(Option1.this,"Please select date.",Toast.LENGTH_SHORT).show();
                    }
                    else if (s4.equals(""))
                    {
                        Toast.makeText(Option1.this,"Please enter deposit amount.",Toast.LENGTH_SHORT).show();
                    }
                    else if (!s4.equals(""))
                    {
                        deposit = Integer.parseInt(s4);
                        if (deposit<=1)
                        {
                            Toast.makeText(Option1.this,"Please enter deposit above 1.",Toast.LENGTH_SHORT).show();
                        }
                        else if (!s5.equals(""))
                        {
                            brokerage = Integer.parseInt(s5);
                            if (brokerage<=0)
                            {
                                Toast.makeText(Option1.this,"Please enter brokerage above 0.",Toast.LENGTH_SHORT).show();
                            }
                            else if (s6.equals("Select preferred tenant"))
                            {
                                Toast.makeText(Option1.this,"Please select preferred tenant.",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(Option1.this,Main2Activity.class);
                                i.putExtra("proptype2",proptype);
                                i.putExtra("cust_name2",cust_name);
                                i.putExtra("prop_name2",prop_name);
                                i.putExtra("cust_num2",cust_num);
                                i.putExtra("alt_num2",altcust_num);
                                i.putExtra("cust_em_site2",cust_em_site);
                                i.putExtra("prop_area2",prop_area);
                                i.putExtra("prop_variant2",prop_variant);
                                i.putExtra("prop_locality2",prop_locality);
                                i.putExtra("prop_size2",s1);
                                i.putExtra("prop_fur2",s2);
                                i.putExtra("prop_rent2",s3);
                                i.putExtra("prop_date2",s8);
                                i.putExtra("prop_depo2",s4);
                                i.putExtra("prop_brok2",s5);
                                i.putExtra("prop_ten2",s6);
                                i.putExtra("prop_sply2",s7);
                                i.putExtra("opt","1");
                                startActivity(i);
                            }
                        }
                        else if (s5.equals(""))
                        {
                            if (s6.equals("Select preferred tenant"))
                            {
                                Toast.makeText(Option1.this,"Please select preferred tenant.",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(Option1.this,Main2Activity.class);
                                i.putExtra("proptype2",proptype);
                                i.putExtra("cust_name2",cust_name);
                                i.putExtra("prop_name2",prop_name);
                                i.putExtra("cust_num2",cust_num);
                                i.putExtra("alt_num2",altcust_num);
                                i.putExtra("cust_em_site2",cust_em_site);
                                i.putExtra("prop_area2",prop_area);
                                i.putExtra("prop_variant2",prop_variant);
                                i.putExtra("prop_locality2",prop_locality);
                                i.putExtra("prop_size2",s1);
                                i.putExtra("prop_fur2",s2);
                                i.putExtra("prop_rent2",s3);
                                i.putExtra("prop_date2",s8);
                                i.putExtra("prop_depo2",s4);
                                i.putExtra("prop_brok2",s5);
                                i.putExtra("prop_ten2",s6);
                                i.putExtra("prop_sply2",s7);
                                i.putExtra("opt","1");
                                startActivity(i);
                            }
                        }
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Option1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        tv.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });
    }
}
