package com.example.noteproject2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Message_Fragment extends Fragment {

//    RecyclerView WordRecyclerview;
//    WordListAdapter2 wordAdapter;
//    List<Word2> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //View view = inflater.inflate(R.layout.fragment_message, container,false);
        View view = inflater.inflate(R.layout.fragment_note, container,false);

        //WordRecyclerview = view.findViewById(R.id.word_rv);
        //mData = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.word_rv);
        List<Word2> mData = new ArrayList<>();

        mData.add(new Word2("test","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test2","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test2","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test2","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test3","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test3","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test3","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test4","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test5","test,","6 july 1995",R.drawable.userphoto));
        mData.add(new Word2("test6","test,","6 july 1995",R.drawable.userphoto));


        WordListAdapter2 adapter = new WordListAdapter2(getActivity());
        recyclerView.setAdapter(adapter);

        //Attach a Layout Manager to it
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));


        return view;
    }
}
