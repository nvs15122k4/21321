package com.example.lab11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public class DetailStoryAdapter extends PagerAdapter {
    private final ArrayList<StoryEntity> listStory;
    private final Context mContext;

    public DetailStoryAdapter(ArrayList<StoryEntity> listStory, Context mContext) {
        this.listStory = listStory;
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_detail_story, container, false);
        StoryEntity item = listStory.get(position);

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvContent = view.findViewById(R.id.tv_content);

        tvName.setText(item.getName());
        tvContent.setText(item.getContent());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return listStory.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
