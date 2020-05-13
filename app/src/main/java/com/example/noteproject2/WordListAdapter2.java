package com.example.noteproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter2 extends RecyclerView.Adapter<WordListAdapter2.WordViewHolder> {

    Context mContext;
    List<Word2> mData;

    public WordListAdapter2(Context mContext) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_word,parent ,false);

        return new WordViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_content.setText(mData.get(position).getContent());
        holder.tv_date.setText(mData.get(position).getDate());
        holder.img_user.setImageResource(mData.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_content, tv_date;
        ImageView img_user;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);
        }
    }
}
