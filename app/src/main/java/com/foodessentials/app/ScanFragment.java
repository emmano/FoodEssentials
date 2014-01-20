package com.foodessentials.app;

import com.foodessentials.R;
import com.foodessentials.labelapi.api.LabelApiCallback;
import com.foodessentials.utils.IntentIntegrator;
import com.foodessentials.utils.IntentResult;
import com.foodessentials.utils.labelapi.Product;
import com.foodessentials.utils.labelapi.ProductParser;

import org.json.JSONObject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by ortiguelae on 1/18/14.
 */
public class ScanFragment extends Fragment implements LabelApiCallback, View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setHasOptionsMenu(true);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator
                .parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {

            Toast.makeText(getActivity(), "" + intentResult.getContents(), Toast.LENGTH_LONG)
                    .show();
            Log.d("UPC", "" + intentResult.getContents());
            FoodEssentialsActivity.LABEL_API.getLabelReference()
                    .labelArray(intentResult.getContents(), this);
        } else {

            Toast.makeText(getActivity(), "FAIL", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.scan_fragment_layout, container, false);
        ImageButton btn = (ImageButton) rootView.findViewById(R.id.scan_me_button);
        AlphaAnimation animation = new AlphaAnimation(0.5f,1.0f);
        animation.setDuration(1000);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        btn.startAnimation(animation);
        btn.setOnClickListener(this);
        return rootView;
    }

  /*  @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.scan_fragment_menu,menu);

    }*/


    @Override
    public void onResult(JSONObject object, String error) {
        if (error == null) {
            Toast.makeText(getActivity(), object.toString(), Toast.LENGTH_LONG).show();
            Product product= ProductParser.parseProduct(object);
            Toast.makeText(getActivity(),product.mNutrients.get(0).nutrientName,Toast.LENGTH_LONG).show();
            Log.e("RESULT", object.toString());
        } else {
            Log.e("ERROR", error);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.scan_me_button:
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.initiateScan();

                break;
            default:
                break;


        }
    }
}
