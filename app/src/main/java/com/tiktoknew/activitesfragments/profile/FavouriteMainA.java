package com.tiktoknew.activitesfragments.profile;

import com.google.android.material.tabs.TabLayoutMediator;
import com.tiktoknew.adapters.ViewPagerAdapter;
import com.tiktoknew.simpleclasses.AppCompatLocaleActivity;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.tiktoknew.activitesfragments.profile.favourite.FavouriteVideosF;
import com.tiktoknew.activitesfragments.search.SearchHashTagsF;
import com.tiktoknew.activitesfragments.soundlists.FavouriteSoundF;
import com.tiktoknew.R;
import com.tiktoknew.simpleclasses.Functions;
import com.tiktoknew.simpleclasses.Variables;

public class FavouriteMainA extends AppCompatLocaleActivity {

    Context context;
    protected TabLayout tabLayout;
    protected ViewPager2 menuPager;
    ViewPagerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Functions.setLocale(Functions.getSharedPreference(this).getString(Variables.APP_LANGUAGE_CODE,Variables.DEFAULT_LANGUAGE_CODE)
                , this, getClass(),false);
        setContentView(R.layout.activity_favourite_main_);

        initControl();
        actionControl();
    }

    private void actionControl() {
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteMainA.super.onBackPressed();
            }
        });
    }

    private void initControl() {
        context = FavouriteMainA.this;

        SetTabs();
    }

    public void SetTabs() {
        adapter = new ViewPagerAdapter(this);
        menuPager = (ViewPager2) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        menuPager.setOffscreenPageLimit(3);
        registerFragmentWithPager();
        menuPager.setAdapter(adapter);
        addTabs();

        menuPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }


    private void addTabs() {
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, menuPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position==0)
                {
                    tab.setText(context.getString(R.string.videos));
                }
                else
                if (position==1)
                {
                    tab.setText(context.getString(R.string.sounds));
                }
                else
                if (position==2)
                {
                    tab.setText(context.getString(R.string.hashtag));
                }
            }
        });
        tabLayoutMediator.attach();
    }


    private void registerFragmentWithPager() {
        adapter.addFrag(FavouriteVideosF.newInstance());
        adapter.addFrag(FavouriteSoundF.newInstance());
        adapter.addFrag(SearchHashTagsF.newInstance("favourite"));
    }


}
