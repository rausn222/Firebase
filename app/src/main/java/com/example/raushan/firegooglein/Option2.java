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

public class Option2 extends AppCompatActivity {
    Spinner size,furnishing,vacancy,p_tenant;
    EditText vacancies,rent,deposit,brokerage,s_notes;
    TextView d;
    Calendar podate;
    int day,month,year;
    String size2,furnishing2,vacancy2,p_tenant2,vacanct2,rent2,deposit2,brokerage2,spplynotes,date2;
    Button smt2;
    int vac,re,dep,brok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option2);
        size = (Spinner)findViewById(R.id.spinner8);
        furnishing = (Spinner)findViewById(R.id.spinner9);
        vacancy = (Spinner)findViewById(R.id.spinner10);
        p_tenant = (Spinner)findViewById(R.id.spinner11);
        vacancies = (EditText)findViewById(R.id.vacancies_id);
        rent = (EditText)findViewById(R.id.rent_id);
        deposit = (EditText)findViewById(R.id.deposit_id);
        brokerage = (EditText)findViewById(R.id.brokerage_id);
        s_notes = (EditText)findViewById(R.id.splynotes2_id);
        d = (TextView)findViewById(R.id.date2_id);
        smt2 = (Button) findViewById(R.id.opt2smt);
        final String proptype = getIntent().getStringExtra("proptype2");
        final String cust_name = getIntent().getStringExtra("cust_name2");
        final String prop_name = getIntent().getStringExtra("prop_name2");
        final String cust_num = getIntent().getStringExtra("cust_num2");
        final String altcust_num = getIntent().getStringExtra("alt_num2");
        final String cust_em_site = getIntent().getStringExtra("cust_em_site2");
        final String prop_area = getIntent().getStringExtra("prop_area2");
        final String prop_variant = getIntent().getStringExtra("prop_variant2");
        final String prop_locality = getIntent().getStringExtra("prop_locality2");
        size.setFocusable(true);
        size.setFocusableInTouchMode(true);
        size.requestFocus();
        podate = Calendar.getInstance();
        day = podate.get(Calendar.DAY_OF_MONTH);
        month = podate.get(Calendar.MONTH);
        year = podate.get(Calendar.YEAR);
        month = month+1;
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Option2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        d.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });
        smt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size2 = size.getSelectedItem().toString();
                furnishing2 = furnishing.getSelectedItem().toString();
                vacancy2 = vacancy.getSelectedItem().toString();
                p_tenant2 = p_tenant.getSelectedItem().toString();
                vacanct2 = vacancies.getText().toString();
                rent2 = rent.getText().toString();
                deposit2 = deposit.getText().toString();
                brokerage2 = brokerage.getText().toString();
                spplynotes = s_notes.getText().toString();
                date2 = d.getText().toString();
                if(size2.equals("Select size of property"))
                {
                    Toast.makeText(Option2.this,"Please select size of property.",Toast.LENGTH_SHORT).show();
                }
                else if (furnishing2.equals("Select furnishing level"))
                {
                    Toast.makeText(Option2.this,"Please select furnishing level of property.",Toast.LENGTH_SHORT).show();
                }
                else if (vacancy2.equals("Select available vacancy"))
                {
                    Toast.makeText(Option2.this,"Please select vacancy of property.",Toast.LENGTH_SHORT).show();
                }
                else if (vacanct2.equals(""))
                {
                    Toast.makeText(Option2.this,"Please enter vacancy of property.",Toast.LENGTH_SHORT).show();
                }
                else if (!vacanct2.equals(""))
                {
                    vac = Integer.parseInt(vacanct2);
                    if (vac<=0)
                    {
                        Toast.makeText(Option2.this,"Please enter valid vacancy of property.",Toast.LENGTH_SHORT).show();
                    }
                    else if (rent2.equals(""))
                    {
                        Toast.makeText(Option2.this,"Please enter rent of property.",Toast.LENGTH_SHORT).show();
                    }
                    else if (!rent2.equals(""))
                    {
                        re = Integer.parseInt(rent2);
                        if (re<=1)
                        {
                            Toast.makeText(Option2.this,"Please enter valid rent of property.",Toast.LENGTH_SHORT).show();
                        }
                        else if (date2.equals("Select date"))
                        {
                            Toast.makeText(Option2.this,"Please enter date.",Toast.LENGTH_SHORT).show();
                        }
                        else if (deposit2.equals(""))
                        {
                            Toast.makeText(Option2.this,"Please enter deposit for property.",Toast.LENGTH_SHORT).show();
                        }
                        else if (!deposit2.equals(""))
                        {
                            dep = Integer.parseInt(deposit2);
                            if (dep<=1)
                            {
                                Toast.makeText(Option2.this,"Please enter valid deposit of property.",Toast.LENGTH_SHORT).show();
                            }
                            else if (!brokerage2.equals(""))
                            {
                                brok = Integer.parseInt(brokerage2);
                                if (brok<=0)
                                {
                                    Toast.makeText(Option2.this,"Please enter valid brokerage of property.",Toast.LENGTH_SHORT).show();
                                }
                                else if (p_tenant2.equals("Select preferred tenant"))
                                {
                                    Toast.makeText(Option2.this,"Please select tenant for property.",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Intent i = new Intent(Option2.this,Main2Activity.class);
                                    i.putExtra("proptype2",proptype);
                                    i.putExtra("cust_name2",cust_name);
                                    i.putExtra("prop_name2",prop_name);
                                    i.putExtra("cust_num2",cust_num);
                                    i.putExtra("alt_num2",altcust_num);
                                    i.putExtra("cust_em_site2",cust_em_site);
                                    i.putExtra("prop_area2",prop_area);
                                    i.putExtra("prop_variant2",prop_variant);
                                    i.putExtra("prop_locality2",prop_locality);
                                    i.putExtra("prop_size2",size2);
                                    i.putExtra("prop_fur2",furnishing2);
                                    i.putExtra("prop_ava_vac2",vacancy2);
                                    i.putExtra("prop_vac2",vacanct2);
                                    i.putExtra("prop_rent2",rent2);
                                    i.putExtra("prop_date2",date2);
                                    i.putExtra("prop_depo2",deposit2);
                                    i.putExtra("prop_brok2",brokerage2);
                                    i.putExtra("prop_ten2",p_tenant2);
                                    i.putExtra("prop_sply2",spplynotes);
                                    i.putExtra("opt","2");
                                    startActivity(i);
                                }
                            }
                            else if (brokerage2.equals(""))
                            {
                                if (p_tenant2.equals("Select preferred tenant"))
                                {
                                    Toast.makeText(Option2.this,"Please select tenant for property.",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Intent i = new Intent(Option2.this,Main2Activity.class);
                                    i.putExtra("proptype2",proptype);
                                    i.putExtra("cust_name2",cust_name);
                                    i.putExtra("prop_name2",prop_name);
                                    i.putExtra("cust_num2",cust_num);
                                    i.putExtra("alt_num2",altcust_num);
                                    i.putExtra("cust_em_site2",cust_em_site);
                                    i.putExtra("prop_area2",prop_area);
                                    i.putExtra("prop_variant2",prop_variant);
                                    i.putExtra("prop_locality2",prop_locality);
                                    i.putExtra("prop_size2",size2);
                                    i.putExtra("prop_fur2",furnishing2);
                                    i.putExtra("prop_ava_vac2",vacancy2);
                                    i.putExtra("prop_vac2",vacanct2);
                                    i.putExtra("prop_rent2",rent2);
                                    i.putExtra("prop_date2",date2);
                                    i.putExtra("prop_depo2",deposit2);
                                    i.putExtra("prop_brok2",brokerage2);
                                    i.putExtra("prop_ten2",p_tenant2);
                                    i.putExtra("prop_sply2",spplynotes);
                                    i.putExtra("opt","2");
                                    startActivity(i);
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
