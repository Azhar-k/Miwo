package com.example.android.miwok;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by admin on 26-06-2016.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Numbers A","Numbers B","Numbers C", "Colors A","Colors B","Colors C",
            "Family A","Family B","Family C", "Phrases A","Phrases B","Phrases C"};

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        }else if (position == 1) {
            return new Numbers_B_Fragment();
        }else if (position == 2) {
            return new Numbers_C_Fragment();
        }

        else if (position == 3){
            return new ColorsFragment();
        }
        else if (position == 4) {
            return new Colors_B_Fragment();
        }
        else if (position == 5) {
            return new Colors_C_Fragment();
        }

        else if (position == 6) {
            return new FamilyFragment();
        }
        else if (position == 7) {
            return new Family_B_Fragment();
        }
        else if (position == 8) {
            return new Family_C_Fragment();
        }

        else if(position==9) {
            return new PhrasesFragment();
        }
        else if (position == 10) {
            return new phrases_B_Fragment();
        }
        else  {
            return new phrases_C_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
