package com.foodessentials.app;


import com.foodessentials.R;
import com.foodessentials.utils.labelapi.Product;
import com.foodessentials.widget.ProductFragmentListAdapter;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ortiguelae on 1/18/14.
 */
public class UserFoodFragment extends ListFragment implements AdapterView.OnItemClickListener {

    ListView mList;

    List<Product> mProductList;

    public UserFoodFragment(List<Product> productList) {
        mProductList = productList;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList = getListView();
        setListAdapter(new ProductFragmentListAdapter(getActivity(), mProductList));
        mList.setOnItemClickListener(this);



    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try {

            ((ILoadDetailsFragment) getActivity()).onLoadDetailsFragment((Product)getListView().getItemAtPosition(i));
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "FoodEssentials Activity needs to implement ILoadDetailsFragment");
        }
    }


    interface ILoadDetailsFragment {

        public void onLoadDetailsFragment(Product product);


    }

}
