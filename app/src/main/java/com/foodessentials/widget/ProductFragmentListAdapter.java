package com.foodessentials.widget;

import com.foodessentials.utils.labelapi.Product;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductFragmentListAdapter extends BaseAdapter {

    Context mContext;

    List<Product> mProductList;

    public ProductFragmentListAdapter(Context ctx, List<Product> productList) {

        mContext = ctx;
        mProductList = productList;
    }


    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProductFragmentRowItemView row;

        if (view == null) {

            row = new ProductFragmentRowItemView(mContext, null);
        } else {
            row = (ProductFragmentRowItemView) view;

        }
        row.mCompanyName.setText(mProductList.get(i).mCompanyName);
        row.mFoodCategory.setText(mProductList.get(i).mFoodCategory);
        row.mProductName.setText(mProductList.get(i).mProductName);
        row.mCompanyName.setText(mProductList.get(i).mCompanyName);
        row.mServingSize.setText(mProductList.get(i).mServingSize);
        return row;
    }
}
