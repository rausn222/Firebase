package com.example.raushan.firegooglein;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.app.*;
import android.app.*;
import android.widget.Toast;

import java.util.ArrayList;

public class Option3 extends AppCompatActivity {
    Button btn1,btn2;
    TextView tvw1;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer>mUserItems = new ArrayList<>();
    String size3,rate33,facilities3,sply3;
    Spinner size_id;
    EditText ed1,ed2;
    int ra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        btn1 = (Button)findViewById(R.id.facilities3);
        btn2 = (Button)findViewById(R.id.opt3smt);
        tvw1 = (TextView)findViewById(R.id.textView5);
        size_id = (Spinner)findViewById(R.id.size3);
        ed1 = (EditText)findViewById(R.id.rate3);
        ed2 = (EditText)findViewById(R.id.supplynotes3);
        final String proptype = getIntent().getStringExtra("proptype2");
        final String cust_name = getIntent().getStringExtra("cust_name2");
        final String prop_name = getIntent().getStringExtra("prop_name2");
        final String cust_num = getIntent().getStringExtra("cust_num2");
        final String altcust_num = getIntent().getStringExtra("alt_num2");
        final String cust_em_site = getIntent().getStringExtra("cust_em_site2");
        final String prop_area = getIntent().getStringExtra("prop_area2");
        final String prop_variant = getIntent().getStringExtra("prop_variant2");
        final String prop_locality = getIntent().getStringExtra("prop_locality2");
        listItems = getResources().getStringArray(R.array.facilities_list);
        checkedItems = new boolean[listItems.length];
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Option3.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if(isChecked){
                            if(!mUserItems.contains(position)){
                                mUserItems.add(position);
                            }
                            else {
                                mUserItems.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0;i<mUserItems.size();i++)
                        {
                            item =item + listItems[mUserItems.get(i)];
                            if(i!=mUserItems.size() -1){
                                item= item+", ";
                            }
                        }
                        tvw1.setText(item);
                    }
                });
                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                mBuilder.setNeutralButton(R.string.clear_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i = 0;i<checkedItems.length;i++)
                        {
                            checkedItems[i]=false;
                            mUserItems.clear();
                            tvw1.setText("");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mBuilder.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size3 = size_id.getSelectedItem().toString();
                facilities3 = tvw1.getText().toString();
                rate33 = ed1.getText().toString();
                sply3 = ed2.getText().toString();
                if (size3.equals("Select size of property"))
                {
                    Toast.makeText(Option3.this,"Please select size of property.",Toast.LENGTH_SHORT).show();
                }
                else if (facilities3.equals("Please select by clicking on button"))
                {
                    Toast.makeText(Option3.this,"Please select facilities of property.",Toast.LENGTH_SHORT).show();
                }
                else if (rate33.equals(""))
                {
                    Toast.makeText(Option3.this,"Please enter rate of property.",Toast.LENGTH_SHORT).show();
                }
                else if (!rate33.equals(""))
                {
                    ra = Integer.parseInt(rate33);
                    if (ra<=1)
                    {
                        Toast.makeText(Option3.this,"Please enter valid rate of property.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent i = new Intent(Option3.this,Main2Activity.class);
                        i.putExtra("proptype2",proptype);
                        i.putExtra("cust_name2",cust_name);
                        i.putExtra("prop_name2",prop_name);
                        i.putExtra("cust_num2",cust_num);
                        i.putExtra("alt_num2",altcust_num);
                        i.putExtra("cust_em_site2",cust_em_site);
                        i.putExtra("prop_area2",prop_area);
                        i.putExtra("prop_variant2",prop_variant);
                        i.putExtra("prop_locality2",prop_locality);
                        i.putExtra("prop_size2",size3);
                        i.putExtra("prop_facilities2",facilities3);
                        i.putExtra("prop_rent2",rate33);
                        i.putExtra("prop_sply2",sply3);
                        i.putExtra("opt","3");
                        startActivity(i);
                    }
                }
            }
        });
    }
}
