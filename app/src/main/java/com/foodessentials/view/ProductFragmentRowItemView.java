package com.foodessentials.view;

import com.foodessentials.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductFragmentRowItemView extends RelativeLayout {


    public TextView mCompanyName;

    public TextView mServingSize;

    public TextView mProductName;

    public TextView mFoodCategory;

    public ImageView mAddToProfileButton;

    private Context mContext;

    public ImageView mGlutenImageView;

    public ProductFragmentRowItemView(Context context) {
        super(context);
        mContext = context;
        init();

    }

    private void init() {

        ViewGroup root = (ViewGroup) View.inflate(mContext, R.layout.product_list_row_item, this);
        root.requestFocus();
        mCompanyName = (TextView) root.findViewById(R.id.user_food_fragment_company_name);
        mServingSize = (TextView) root.findViewById(R.id.user_food_fragment_serving_size);
        mProductName = (TextView) root.findViewById(R.id.user_food_fragment_product_name);
        mFoodCategory = (TextView) root.findViewById(R.id.user_food_fragment_product_category);
        mAddToProfileButton = (ImageView) root.findViewById(R.id.user_food_fragment_image_button);
        mGlutenImageView = (ImageView) root.findViewById(R.id.user_food_fragment_gluten_free);
    }
}
