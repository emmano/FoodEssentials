package com.foodessentials.app;

import com.foodessentials.R;
import com.foodessentials.labelapi.LabelApi;
import com.foodessentials.labelapi.session.LabelSessionCallback;
import com.foodessentials.labelapi.session.Session;
import com.foodessentials.widget.DrawerListAdapter;
import com.foodessentials.widget.DrawerListViewHeader;
import com.foodessentials.widget.DrawerRowItem;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodEssentialsActivity extends Activity implements LabelSessionCallback {

    private DrawerLayout mDrawerLayout;

    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mTitle;

    private CharSequence mDrawerTitle;

    static public LabelApi LABEL_API;

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_essentials);
        LABEL_API = new LabelApi();
        LABEL_API.createSession("Emmanuel_o", this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        List<DrawerRowItem> modelList = new ArrayList<DrawerRowItem>(3);
        final DrawerRowItem rowItem1 = new DrawerRowItem("My Ingredients", R.drawable.ic_drawer);
        final DrawerRowItem rowItem2 = new DrawerRowItem("My Something", R.drawable.ic_drawer);
        final DrawerRowItem rowItem3 = new DrawerRowItem("My Ingredients", R.drawable.ic_drawer);
        modelList.add(rowItem1);
        modelList.add(rowItem2);
        modelList.add(rowItem3);


        mDrawerList.setAdapter(new DrawerListAdapter(this, modelList));

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mTitle = mDrawerTitle = getTitle();
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ScanFragment(), "Fragment")
                    .commit();
        }


    }

    @Override
    public void response(Session session, String error) {
        if (session.mSessionID != null) {
            DrawerListViewHeader header = new DrawerListViewHeader(this, null);
            header.mUserName.setText(session.mUserID);
            mDrawerList.addHeaderView(header);

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food_essentials, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class DrawerItemClickListener
            implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        }


    }
}
