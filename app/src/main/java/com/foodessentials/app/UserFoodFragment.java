package com.foodessentials.app;




import com.foodessentials.R;
import com.foodessentials.utils.labelapi.Product;
import com.foodessentials.widget.ProductFragmentListAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by ortiguelae on 1/18/14.
 */
public class UserFoodFragment extends Fragment {

ListView mExpandableList;
List<Product> mProductList;

    public UserFoodFragment(List<Product> productList){
            mProductList = productList;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.user_food_fragment_layout, container, false);
        mExpandableList = (ListView)root.findViewById(R.id.product_fragment_list_view);
        mExpandableList.setAdapter(new ProductFragmentListAdapter(getActivity(),mProductList));
        return root;
    }


}
