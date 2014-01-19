package com.foodessentials.widget;


import com.foodessentials.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ortiguelae on 1/19/14.
 */
public class DrawerRowItemView extends LinearLayout {

    public ImageView mImageView;
    public TextView mTextView;
    public DrawerRowItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View root = View.inflate(getContext(), R.layout.drawer_list_row_item, this);
        mImageView = (ImageView)root.findViewById(R.id.drawer_row_item_imageView);
        mTextView = (TextView)root.findViewById(R.id.drawer_row_item_textView);
    }
}
