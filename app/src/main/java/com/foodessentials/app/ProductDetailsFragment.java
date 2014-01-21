package com.foodessentials.app;


import com.foodessentials.R;
import com.foodessentials.utils.labelapi.Product;
import com.foodessentials.widget.ProductDetailsExpandableListAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * Created by ortiguelae on 1/20/14.<br>
 */
public class ProductDetailsFragment extends Fragment {

    private Product mProduct;

    public ProductDetailsFragment(Product product) {

        mProduct = product;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.product_detail_fragment_layout, container,false);
        ExpandableListView expandableListView = (ExpandableListView)root.findViewById(
                R.id.product_fragment_details_expandable_list_view);
        expandableListView.setAdapter(new ProductDetailsExpandableListAdapter(getActivity(),mProduct));
        return root;
    }
}
