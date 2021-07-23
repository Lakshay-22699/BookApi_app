package com.example.bookapi_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.HeroViewHolder> {


    private List<Itemsss> ItemsssList;
    private AllBooks allBooks;


    private Context context;

    private static int currentPosition = 0;

    public BookAdapter(List<Itemsss> cl, Context context) {
        this.ItemsssList = cl;
        this.context = context;
    }
//    public BookAdapter(AllBooks allBooks, Context context) {
//        this.allBooks = allBooks;
//        this.context = context;
//    }


    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
        Itemsss itemsss = ItemsssList.get(position);
        holder.textViewtitle.setText(itemsss.getVolumeInfo().getTitle());
        String[] aut=itemsss.getVolumeInfo().getAuthors();
        String authors="";
        for (int j=0;j< aut.length;j++)
            authors+=aut[j]+"\n";
        holder.textViewauthor.setText(authors);
        holder.textViewdes.setText(itemsss.getVolumeInfo().getDesc());
//        holder.imageView.setImageDrawable();

        Glide.with(context).load(itemsss.getVolumeInfo().getImagelinkss().getThumbnail()).override(60, 60).centerCrop().into(holder.imageView);//to load image from url into imageview
        Log.d("abcd123", "onBindViewHolder: "+itemsss.getVolumeInfo().getImagelinkss().getThumbnail());
        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }

        holder.textViewtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ItemsssList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView textViewtitle,textViewauthor, textViewdes;
        ImageView imageView;
        LinearLayout linearLayout;

        HeroViewHolder(View itemView) {
            super(itemView);

            textViewtitle = itemView.findViewById(R.id.textViewtitle);
            textViewauthor = itemView.findViewById(R.id.textViewAuthor);
            textViewdes = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.imageView);

            linearLayout = itemView.findViewById(R.id.hiddenll);
        }
    }
}