package com.example.raushan.firegooglein;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.webkit.*;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    Button b2;
    Uri uriProfileImage;
    ProgressBar progressBar;
    StorageReference mstorageRef;
    DatabaseReference mDatabaseRef;
    public static final String FB_STORAGE_PATH = "image/";
    public static final String FB_DATABASE_PATH = "image";
    public static final int REQUEST_CODE = 1234;
    ImageView imageView;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=(Button)findViewById(R.id.button3);
        imageView=(ImageView)findViewById(R.id.imageView);
        mstorageRef=FirebaseStorage.getInstance().getReference();
        mDatabaseRef=FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        final String proptype = getIntent().getStringExtra("proptype2");
        final String cust_name = getIntent().getStringExtra("cust_name2");
        final String prop_name = getIntent().getStringExtra("prop_name2");
        final String cust_num = getIntent().getStringExtra("cust_num2");
        final String altcust_num = getIntent().getStringExtra("alt_num2");
        final String cust_em_site = getIntent().getStringExtra("cust_em_site2");
        final String prop_area = getIntent().getStringExtra("prop_area2");
        final String prop_variant = getIntent().getStringExtra("prop_variant2");
        final String prop_locality = getIntent().getStringExtra("prop_locality2");
        final String prop_size = getIntent().getStringExtra("prop_size2");
        final String prop_fur = getIntent().getStringExtra("prop_fur2");
        final String prop_rent = getIntent().getStringExtra("prop_rent2");
        final String prop_date = getIntent().getStringExtra("prop_date2");
        final String prop_depo = getIntent().getStringExtra("prop_depo2");
        final String prop_brok = getIntent().getStringExtra("prop_brok2");
        final String prop_ten = getIntent().getStringExtra("prop_ten2");
        final String prop_sply = getIntent().getStringExtra("prop_sply2");
        final String prop_av_vac = getIntent().getStringExtra("prop_ava_vac2");
        final String prop_vacn = getIntent().getStringExtra("prop_vacn2");
        final String prop_vac = getIntent().getStringExtra("prop_vac2");
        final String prop_tarrif = getIntent().getStringExtra("prop_tarrif2");
        final String prop_type = getIntent().getStringExtra("prop_type2");
        final String opt = getIntent().getStringExtra("opt");
        final String prop_facilities = getIntent().getStringExtra("prop_facilities2");
        mAuth = FirebaseAuth.getInstance();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageChooser();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uriProfileImage != null)
                {
                    final ProgressDialog dialog = new ProgressDialog(Main2Activity.this);
                    dialog.setTitle("Uploading Image");
                    dialog.show();
                    StorageReference ref =mstorageRef.child(FB_STORAGE_PATH + System.currentTimeMillis() + "." +getImageExt(uriProfileImage));
                    ref.putFile(uriProfileImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            dialog.dismiss();
                            if (opt.equals("1")) {
                                User1 user = new User1(taskSnapshot.getDownloadUrl().toString(), cust_name, cust_num, prop_area, proptype, prop_name, altcust_num, cust_em_site, prop_variant,
                                        prop_locality, prop_size, prop_fur, prop_rent, prop_depo, prop_date, prop_brok, prop_ten, prop_sply);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(user);
                            }
                            else if (opt.equals("2"))
                            {
                                User1 user = new User1(taskSnapshot.getDownloadUrl().toString(), cust_name, cust_num, prop_area, proptype, prop_name, altcust_num, cust_em_site, prop_variant,
                                        prop_locality, prop_size, prop_fur, prop_rent, prop_depo, prop_date, prop_brok, prop_ten, prop_sply,prop_av_vac,prop_vac);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(user);
                            }
                            else if (opt.equals("3"))
                            {
                                User1 user = new User1(taskSnapshot.getDownloadUrl().toString(), cust_name, cust_num, prop_area, proptype, prop_name, altcust_num, cust_em_site, prop_variant,
                                        prop_locality, prop_size,prop_facilities, prop_rent, prop_sply);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(user);
                            }
                            else if (opt.equals("4"))
                            {
                                User1 user = new User1(taskSnapshot.getDownloadUrl().toString(), cust_name, cust_num, prop_area, proptype, prop_name, altcust_num, cust_em_site, prop_variant,
                                        prop_locality, prop_vacn, prop_facilities,prop_vac,prop_rent, prop_depo, prop_date, prop_brok, prop_ten, prop_sply);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(user);
                            }
                            else if (opt.equals("5"))
                            {
                                User1 user = new User1(taskSnapshot.getDownloadUrl().toString(), cust_name, cust_num, prop_area, proptype, prop_name, altcust_num, cust_em_site, prop_variant,
                                        prop_locality, prop_facilities,prop_tarrif,prop_type,prop_sply,opt);
                                String uploadId = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(uploadId).setValue(user);
                            }
                            Toast.makeText(Main2Activity.this,"Data Uploaded",Toast.LENGTH_SHORT).show();

                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    dialog.dismiss();
                                    Toast.makeText(Main2Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress =(100 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                            dialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
                }
                else
                {
                    Toast.makeText(Main2Activity.this,"Something wrong!",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData()!=null)
        {
            uriProfileImage = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uriProfileImage);
                imageView.setImageBitmap(bitmap);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String getImageExt(Uri uri)
    {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    public void showImageChooser(){
        Intent i =new Intent();
        i.setType("image/*");
        i.setAction(i.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Select image"),REQUEST_CODE);
    }
}
