package com.foodessentials.widget;

import com.foodessentials.labelapi.LabelApi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ortiguelae on 1/19/14.
 */
public class DrawerListAdapter extends BaseAdapter {

    List<DrawerRowItem> mList;

    Context mContext;

    public DrawerListAdapter(Context context, List<DrawerRowItem> rowItemModelList) {
        mList = rowItemModelList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mList.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DrawerRowItemView row;

        if (view == null) {

            row = new DrawerRowItemView(mContext, null);

        }
      else {

            row = (DrawerRowItemView) view;
        }

        row.mTextView.setText(mList.get(i).mTextViewText);
        row.mImageView.setImageResource(mList.get(i).mIconId);

        return row;
    }
}
