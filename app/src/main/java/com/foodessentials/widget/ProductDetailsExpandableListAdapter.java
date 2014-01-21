package com.foodessentials.widget;

import com.foodessentials.utils.labelapi.Additives;
import com.foodessentials.utils.labelapi.Allergen;
import com.foodessentials.utils.labelapi.Nutrient;
import com.foodessentials.utils.labelapi.Product;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductDetailsExpandableListAdapter extends BaseExpandableListAdapter {

    private Product mProduct;

    private Object[] productContents;


    private Context mContext;

    public ProductDetailsExpandableListAdapter(Context ctx, Product product) {
        mContext = ctx;
        mProduct = product;
        productContents = new Object[]{mProduct.getNutrients(), mProduct.getAdditives(),
                mProduct.getAllergens()};

    }

    @Override
    public int getGroupCount() {
        return productContents.length;
    }

    @Override
    public int getChildrenCount(int i) {

        switch (i) {
            case 0:
                return ((List<Nutrient>) productContents[i]).size();
            case 1:
                return ((List<Nutrient>) productContents[i]).size();
            case 2:
                return ((List<Nutrient>) productContents[i]).size();
            default:
                return -1;
        }

    }

    @Override
    public Object getGroup(int i) {
        return productContents[i];
    }

    @Override
    public Object getChild(int i, int i2) {

        switch (i) {

            case 0:
                return ((List<Nutrient>) productContents[i]).get(i2);
            case 1:
                return ((List<Additives>) productContents[i]).get(i2);
            case 2:
                return ((List<Allergen>) productContents[i]).get(i2);
            default:
                return null;
        }


    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ProductDetailGroupView row;

        if (view == null) {

            row = new ProductDetailGroupView(mContext, null);

        } else {

            row = (ProductDetailGroupView) (view);

        }

        switch (i){

            case 0:
                row.groupTextView.setText("Nutrients");
                break;
            case 1:
                row.groupTextView.setText("Additives");
                break;
            case 2:
                row.groupTextView.setText("Allergen");
                break;
        }
        return row;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {

        ProductDetailSubView row;

        if (view == null) {

            row = new ProductDetailSubView(mContext, null);

        } else {

            row = (ProductDetailSubView) (view);

        }


        switch (i) {

            case 0:
                row.mTextViewAAN
                        .setText(((List<Nutrient>) productContents[i]).get(i2).nutrientName);
                row.mTexViewQuantity
                        .setText(((List<Nutrient>) productContents[i]).get(i2).nutrientValue+" "+((List<Nutrient>) productContents[i]).get(i2).nutrientUom);
                break;
            case 1:
                row.mTextViewAAN
                        .setText(((List<Additives>) productContents[i]).get(i2).additiveName);
                row.mTexViewQuantity
                        .setText(((List<Additives>) productContents[i]).get(i2).additiveValue);
                break;
            case 2:
                row.mTextViewAAN
                        .setText(((List<Allergen>) productContents[i]).get(i2).allergenName);
                row.mTexViewQuantity
                        .setText(((List<Allergen>) productContents[i]).get(i2).allergenValue);
                break;
            default:
                break;
        }

        return row;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
