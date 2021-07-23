package com.example.bookapi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    RecyclerView recyclerView;
    BookAdapter adapter;
    List<Itemsss> itemsList;
//    TextView t1,t2,t3;
    Button b1;
//    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        t1=findViewById(R.id.textView);
//        t2=findViewById(R.id.textView2);
//        t3=findViewById(R.id.textView3);
        b1=findViewById(R.id.button);
//        i1=findViewById(R.id.imageView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/books/v1/").addConverterFactory(GsonConverterFactory.create()).build();
                Api api = retrofit.create(Api.class);
                Call<AllBooks> call =api.getbooks(e1.getText().toString());
//        ProgressDialog dialog = new ProgressDialog(MainActivity.this);dialog.setMessage("please wait...");
//        dialog.show();
                call.enqueue(new Callback<AllBooks>() {
                    @Override
                    public void onResponse(Call<AllBooks> call, Response<AllBooks> response) {
//                      dialog.dismiss();
                        AllBooks allBooks = response.body();
                        List<Itemsss> itemsss;
                        itemsss=allBooks.getItems();
                        adapter = new BookAdapter(itemsss, getApplicationContext());
                        recyclerView.setAdapter(adapter);

//                        List<Itemsss> itemsss;
//                        itemsss=allBooks.getItems();
//                        String tmp ="";
//                        for(int i=0;i<itemsss.size();i++)
//                        {
//                            tmp+=itemsss.get(i).getVolumeInfo().getTitle()+"\n";
////                            lists.add(itemsss.get(i).getVolumeInfo().getAuthor());
//                        }
//
//                        t1.setText(itemsss.get(0).getVolumeInfo().getTitle());
////                        t1.setText(tmp);
//                        String[] aut=itemsss.get(0).getVolumeInfo().getAuthors();
//                        String authors="";
//                        for (int j=0;j< aut.length;j++)
//                            authors+=aut[j]+"\n";
//                        t2.setText(authors);
//                        t3.setText(itemsss.get(0).getVolumeInfo().getDesc());
//                        String url=itemsss.get(0).getVolumeInfo().getImagelinkss().getThumbnail();
//                        Glide.with(MainActivity.this).load(url).override(200, 200).centerCrop().into(i1);
                    }

                    @Override
                    public void onFailure(Call<AllBooks> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                        t.setText(t.getMessage());
                    }
                });
            }
        });
//        b1.performClick();
    }



}