package com.example.raushan.firegooglein;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Option5 extends AppCompatActivity {
    Button btn51,btn52;
    EditText ed51,ed52,ed53;
    TextView textView51;
    String[] listItems5;
    boolean[] checkedItems5;
    String st51,st52,st53,st54;
    int re5;
    ArrayList<Integer> mUserItems5 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option5);
        btn51 = (Button)findViewById(R.id.facilities5);
        btn52 = (Button)findViewById(R.id.opt5smt);
        textView51 = (TextView)findViewById(R.id.textView55);
        ed51 = (EditText)findViewById(R.id.rent5);
        ed52 = (EditText)findViewById(R.id.vacancy5);
        ed53 = (EditText)findViewById(R.id.supplynotes5);
        final String proptype = getIntent().getStringExtra("proptype2");
        final String cust_name = getIntent().getStringExtra("cust_name2");
        final String prop_name = getIntent().getStringExtra("prop_name2");
        final String cust_num = getIntent().getStringExtra("cust_num2");
        final String altcust_num = getIntent().getStringExtra("alt_num2");
        final String cust_em_site = getIntent().getStringExtra("cust_em_site2");
        final String prop_area = getIntent().getStringExtra("prop_area2");
        final String prop_variant = getIntent().getStringExtra("prop_variant2");
        final String prop_locality = getIntent().getStringExtra("prop_locality2");
        listItems5 = getResources().getStringArray(R.array.facilities_list);
        btn51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Option5.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems5, checkedItems5, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if(isChecked){
                            if(!mUserItems5.contains(position)){
                                mUserItems5.add(position);
                            }
                            else {
                                mUserItems5.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0;i<mUserItems5.size();i++)
                        {
                            item =item + listItems5[mUserItems5.get(i)];
                            if(i!=mUserItems5.size() -1){
                                item= item+", ";
                            }
                        }
                        textView51.setText(item);
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
                        for(int i = 0;i<checkedItems5.length;i++)
                        {
                            checkedItems5[i]=false;
                            mUserItems5.clear();
                            textView51.setText("");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mBuilder.show();
            }
        });
        btn52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st51 = textView51.getText().toString();
                st52 = ed51.getText().toString();
                st53 = ed52.getText().toString();
                st54 = ed53.getText().toString();
                if (st51.equals("Please select by clicking on button"))
                {
                    Toast.makeText(Option5.this,"Please select facilities for property.",Toast.LENGTH_SHORT).show();
                }
                else if (st52.equals(""))
                {
                    Toast.makeText(Option5.this,"Please enter tariff for property.",Toast.LENGTH_SHORT).show();
                }
                else if (!st52.equals(""))
                {
                    re5 = Integer.parseInt(st52);
                    if (re5<=1)
                    {
                        Toast.makeText(Option5.this,"Please enter valid tariff for property.",Toast.LENGTH_SHORT).show();
                    }
                    else if (st53.equals(""))
                    {
                        Toast.makeText(Option5.this,"Please enter room type for property.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent i = new Intent(Option5.this,Main2Activity.class);
                        i.putExtra("proptype2",proptype);
                        i.putExtra("cust_name2",cust_name);
                        i.putExtra("prop_name2",prop_name);
                        i.putExtra("cust_num2",cust_num);
                        i.putExtra("alt_num2",altcust_num);
                        i.putExtra("cust_em_site2",cust_em_site);
                        i.putExtra("prop_area2",prop_area);
                        i.putExtra("prop_variant2",prop_variant);
                        i.putExtra("prop_locality2",prop_locality);
                        i.putExtra("prop_facilities2",st51);
                        i.putExtra("prop_tarrif2",st52);
                        i.putExtra("prop_type2",st53);
                        i.putExtra("prop_sply2",st54);
                        i.putExtra("opt","5");
                        startActivity(i);
                    }
                }
            }
        });
    }
}
