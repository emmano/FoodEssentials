package com.foodessentials.app;


import com.foodessentials.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ortiguelae on 1/18/14.
 */
public class UserFoodFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_food_fragment_layout, container, false);
    }


}
