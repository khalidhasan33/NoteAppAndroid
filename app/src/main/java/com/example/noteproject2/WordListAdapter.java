package com.example.noteproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    Context mContext;
    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordTitleView;
        private final TextView wordDueView;
        RelativeLayout container;

        private WordViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            wordItemView = itemView.findViewById(R.id.tv_description);
            wordTitleView = itemView.findViewById(R.id.tv_title);
            wordDueView = itemView.findViewById(R.id.tv_date);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_word, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            //holder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition));
            holder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale));
            //holder.wordItemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition));
            holder.wordItemView.setText(current.getDesc());
            holder.wordTitleView.setText(current.getTitle());
            holder.wordDueView.setText(new SimpleDateFormat("MM/dd/yy").format(current.getDueTimestamp()));
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
}