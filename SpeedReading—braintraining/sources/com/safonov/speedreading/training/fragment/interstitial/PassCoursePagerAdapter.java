package com.safonov.speedreading.training.fragment.interstitial;

import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class PassCoursePagerAdapter extends PagerAdapter {
    List<View> pages = null;

    public PassCoursePagerAdapter(List<View> pages2) {
        this.pages = pages2;
    }

    public Object instantiateItem(ViewGroup collection, int position) {
        View v = this.pages.get(position);
        ((ViewPager) collection).addView(v, 0);
        return v;
    }

    public int getCount() {
        return this.pages.size();
    }

    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    public void destroyItem(ViewGroup collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    public void finishUpdate(View arg0) {
    }

    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(View arg0) {
    }
}
