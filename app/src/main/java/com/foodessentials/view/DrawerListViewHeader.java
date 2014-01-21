package com.foodessentials.view;


import com.foodessentials.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ortiguelae on 1/19/14.
 */
public class DrawerListViewHeader extends RelativeLayout {

   public TextView mUserName;

    public DrawerListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View root = View.inflate(getContext(), R.layout.drawer_list_view_header, this);
        mUserName = (TextView) root.findViewById(R.id.drawer_list_view_header_username);
    }
}
