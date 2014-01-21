package com.foodessentials.view;



import com.foodessentials.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductDetailGroupView extends LinearLayout {

    public TextView groupTextView;

    public ProductDetailGroupView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ViewGroup root = (ViewGroup) View
                .inflate(getContext(), R.layout.product_detail_group_view, this);
        groupTextView = (TextView) root.findViewById(R.id.product_detail_group_text_view);
    }
}
