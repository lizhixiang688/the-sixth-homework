package com.example.pracycse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitle = new ArrayList<>();
    ViewPagerAdapater viewPagerAdapater=new ViewPagerAdapater(getSupportFragmentManager(),
            ViewPagerAdapater.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.Tab_layout);
        viewPager = findViewById(R.id.viewpager_1);
        fragmentTitle.add("首页");
        fragmentTitle.add("游戏");
        fragmentTitle.add("科技");
        fragmentTitle.add("汽车");
        fragmentTitle.add("美女");
        fragmentTitle.add("动态");
        fragmentList.add(new LeftFragment());
        fragmentList.add(new RightFragment());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment5());
        fragmentList.add(new Fragment6());
        viewPager.setAdapter(viewPagerAdapater);
        tabLayout.setupWithViewPager(viewPager);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.add_tab) {
            fragmentTitle.add("tab"+(fragmentTitle.size()+1));
            fragmentList.add(new NewFragment());
            viewPagerAdapater.notifyDataSetChanged();
        }
        return true;
    }
    class ViewPagerAdapater extends FragmentPagerAdapter {
        ViewPagerAdapater(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}