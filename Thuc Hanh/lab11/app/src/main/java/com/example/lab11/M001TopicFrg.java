package com.example.lab11;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class M001TopicFrg extends Fragment implements View.OnClickListener {
    private Context mContext;

    private final int[] storyImages = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        LinearLayout lnMain = v.findViewById(R.id.ln_topic);
        lnMain.removeAllViews();

        for (int i = 0; i < StoryData.STORY_NAMES.length; i++) {
            String storyName = StoryData.STORY_NAMES[i];

            View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);
            ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
            TextView tvTopic = vTopic.findViewById(R.id.tv_topic);

            if (i < storyImages.length) {
                ivTopic.setImageResource(storyImages[i]);
            }

            tvTopic.setText(storyName);
            lnMain.addView(vTopic);

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
            params.bottomMargin = 5;
            vTopic.setLayoutParams(params);
            vTopic.setTag(storyName);
            vTopic.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String storyName = (String) v.getTag();
        ((MainActivity) getActivity()).gotoM002Screen(storyName);
    }
}