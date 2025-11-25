package com.example.lab11;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M002StoryFrg extends Fragment {
    private Context mContext;
    private String topicName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backToM001Screen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);

        RecyclerView rv = v.findViewById(R.id.rv_story);
        ArrayList<StoryEntity> listStory = readStoryFromFile();

        StoryAdapter adapter = new StoryAdapter(listStory, mContext);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private ArrayList<StoryEntity> readStoryFromFile() {
        ArrayList<StoryEntity> listStory = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/truyenngungon.txt"), "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("|")) {
                    String[] parts = line.split("\\|");
                    String storyName = parts[0].trim();
                    String pageName = parts[1].trim();

                    if (storyName.equals(topicName)) {
                        String content = reader.readLine();
                        if (content != null) {
                            content = content.trim();
                            StoryEntity story = new StoryEntity(storyName, pageName, content);
                            listStory.add(story);
                        }
                    }
                }

                if (line.equals("---")) {
                    continue;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listStory;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    private void backToM001Screen() {
        ((MainActivity) getActivity()).backToM001Screen();
    }
}