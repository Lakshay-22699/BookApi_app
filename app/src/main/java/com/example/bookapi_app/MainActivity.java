package com.example.bookapi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    TextView t1,t2,t3;
    Button b1;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        b1=findViewById(R.id.button);
        i1=findViewById(R.id.imageView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                Api api = retrofit.create(Api.class);
                Call<AllBooks> call = api.getbooks();
//        ProgressDialog dialog = new ProgressDialog(MainActivity.this);dialog.setMessage("please wait...");
//        dialog.show();
                call.enqueue(new Callback<AllBooks>() {
                    @Override
                    public void onResponse(Call<AllBooks> call, Response<AllBooks> response) {
//                dialog.dismiss();
                        AllBooks allBooks = response.body();
//                        Log.d("abc123", "onResponse: "+allBooks);
//
//                        String tmp=AllBooks.getItems().getVolumeInfo().title;
                        List<Itemsss> itemsss;
                        itemsss=allBooks.getItems();
                        String tmp ="";
//                        List<List<String>> lists = null;
                        for(int i=0;i<itemsss.size();i++)
                        {
                            tmp+=itemsss.get(i).getVolumeInfo().getTitle()+"\n";
//                            lists.add(itemsss.get(i).getVolumeInfo().getAuthor());
                        }

                        t1.setText(itemsss.get(0).getVolumeInfo().getTitle());
//                        t1.setText(tmp);
                        String[] aut=itemsss.get(0).getVolumeInfo().getAuthors();
                        String authors="";
                        for (int j=0;j< aut.length;j++)
                            authors+=aut[j]+"\n";
                        t2.setText(authors);
                        t3.setText(itemsss.get(0).getVolumeInfo().getDesc());
                        String url=itemsss.get(0).getVolumeInfo().getImagelinkss().getThumbnail();
                        Glide.with(MainActivity.this)
                                .load(url) // image url
                                .override(200, 200) // resizing
                                .centerCrop()
                                .into(i1);
//                        t2.setText(lists.get(0).get(0));

//                String[] s=AllBooks.getItems().getVolumeInfo().author;
//                String s1="";
//                for(int i=0;i<s.length;i++)
//                    s1+=s[i]+"\n";
//
//                t2.setText(s1);
                    }

                    @Override
                    public void onFailure(Call<AllBooks> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        t3.setText(t.getMessage());
                    }
                });
            }
        });
        b1.performClick();
    }

//    public void setsuburl(View view) {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//        Api api = retrofit.create(Api.class);
//        Call<AllBooks> call = api.getbooks();
////        ProgressDialog dialog = new ProgressDialog(MainActivity.this);dialog.setMessage("please wait...");
////        dialog.show();
//        call.enqueue(new Callback<AllBooks>() {
//            @Override
//            public void onResponse(Call<AllBooks> call, Response<AllBooks> response) {
////                dialog.dismiss();
//                AllBooks allBooks = response.body();
//                Log.d("abc123", "onResponse: "+allBooks);
////
////                t1.setText(AllBooks.getItems().getVolumeInfo().title);
////                String[] s=AllBooks.getItems().getVolumeInfo().author;
////                String s1="";
////                for(int i=0;i<s.length;i++)
////                    s1+=s[i]+"\n";
////
////                t2.setText(s1);
//            }
//
//            @Override
//            public void onFailure(Call<AllBooks> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                t3.setText(t.getMessage());
//            }
//        });
//
//    }
}