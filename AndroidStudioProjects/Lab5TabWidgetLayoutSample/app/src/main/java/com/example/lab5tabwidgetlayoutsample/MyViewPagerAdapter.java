package com.example.lab5tabwidgetlayoutsample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fragments.ClassesFragment;
import fragments.StudentsFragment;
import fragments.TeachersFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new StudentsFragment();
            case 1:
                return new TeachersFragment();
            case 2:
                return new ClassesFragment();
            default:
                return new StudentsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
