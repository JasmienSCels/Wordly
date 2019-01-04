package com.example.jasmiensofiecels.wordly.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jasmiensofiecels.wordly.R;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/*
 * The purpose of this class is to represent the underlying activity that all other activities will inherit from.
 * Functionalities handled:
 *
 *
 * Create by Jasmien Cels on 12/03/18
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.drawer_layout)
    @Nullable
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    @Nullable
    NavigationView navView;

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_burger_menu);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked(true);

                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void turnOnLoading() {

    }

    @Override
    public void turnOffLoading() {

    }

    @Override
    public void onError(@NonNull String err) {

    }
}
