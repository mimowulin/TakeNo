package com.lin.mimo.takeno;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    LogFragment logFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toobar);
        final Toolbar toolview = (Toolbar) findViewById(R.id.toview);
        toolbar.setTitle("主ToolBar");
        toolview.setTitle("副ToolBar");
        setSupportActionBar(toolbar);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_settings:
                        Intent it = new Intent();
                        it.setClass(MainActivity.this, LogActivity.class);
                        startActivity(it);
                        break;
                    case R.id.action_log:
                        toolview.setTitle("登入");
                        logFragment = new LogFragment();
                        fragmentManager = getFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction()
                                .setCustomAnimations(R.animator.rotate_alpha_in,R.animator.rotate_alpha_out,
                                        R.animator.rotate_alpha_in, R.animator.rotate_alpha_out);

                        fragmentTransaction.replace(R.id.framelayout,logFragment,"logfragment")
                        .addToBackStack(null);
                        fragmentTransaction.commit();

                }
                return true;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // 實作 drawer toggle 並放入 toolbar
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();

        mDrawerLayout.setDrawerListener(mDrawerToggle);



    }

    public void backToMainFragment(){
        fragmentManager.popBackStack();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:

                break;
        }
        return true;

    }


}
