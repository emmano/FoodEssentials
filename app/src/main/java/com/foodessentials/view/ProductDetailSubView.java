package com.foodessentials.view;



import com.foodessentials.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductDetailSubView extends RelativeLayout {

    public TextView mTextViewAAN;
    public TextView mTexViewQuantity;

    public ProductDetailSubView(Context context) {
        super(context);
        init();
    }

    private void init() {

        ViewGroup root = (ViewGroup) ViewGroup.inflate(getContext(), R.layout.product_details_sub_view_layout,this);
        mTextViewAAN = (TextView)root.findViewById(R.id.product_detail_NAA);
        mTexViewQuantity = (TextView)root.findViewById(R.id.product_detail_quantity);
    }
}
