package com.tiktoknew.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.tiktoknew.Constants;
import com.tiktoknew.activitesfragments.VideosListF;
import com.tiktoknew.interfaces.FragmentCallBack;
import com.tiktoknew.models.HomeModel;
import com.tiktoknew.R;
import com.tiktoknew.simpleclasses.Variables;
import com.tiktoknew.simpleclasses.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class ViewPagerStatAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private static int PAGE_REFRESH_STATE=PagerAdapter.POSITION_UNCHANGED;
    VerticalViewPager menuPager;

    FragmentCallBack callBack;

    public ViewPagerStatAdapter(@NonNull FragmentManager fm, VerticalViewPager menuPager, boolean isFirstTime, FragmentCallBack callBack) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.menuPager=menuPager;
        this.callBack=callBack;

        if (isFirstTime)
        {
            if (Paper.book(Variables.PromoAds).contains(Variables.PromoAdsModel))
            {
                try {

                    HomeModel initItem=Paper.book(Variables.PromoAds).read(Variables.PromoAdsModel);
                    if (initItem!=null)
                        addFragment(new VideosListF(true,initItem,menuPager,callBack, R.id.mainMenuFragment), "");

                }catch (Exception e)
                {
                    Log.d(Constants.tag,"Exception: "+e);
                }
            }
        }


    }

    public void refreshStateSet(boolean isRefresh) {
       if (isRefresh)
       {
           PAGE_REFRESH_STATE=PagerAdapter.POSITION_NONE;
       }
       else
       {
           PAGE_REFRESH_STATE=PagerAdapter.POSITION_UNCHANGED;
       }
    }


    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public void removeFragment(int position) {
        mFragmentList.remove(position);
        mFragmentTitleList.remove(position);
        notifyDataSetChanged();
    }


    @Override
    public int getItemPosition(Object object) {
        // refresh all fragments when data set changed
        return PAGE_REFRESH_STATE;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}