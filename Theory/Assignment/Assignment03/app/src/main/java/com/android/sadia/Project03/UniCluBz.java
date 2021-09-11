package com.android.sadia.Project03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class UniCluBz extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    private FragmentUniversityAffiliation fragmentA;
    private UniCluBzListViewModel uniCluBzListViewModel;
    private Fragment ftab1,ftab2,ftab3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uniclubz);

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        UniCluBzAdapter adapter = new UniCluBzAdapter();
        recyclerView.setAdapter(adapter);

        uniCluBzListViewModel = ViewModelProviders.of(ftab2).get(UniCluBzListViewModel.class);
        uniCluBzListViewModel.getAllUniCluBzLists().observe(ftab2, new Observer<List<UniCluBzList>>() {
            @Override
            public void onChanged(List<UniCluBzList> uniCluBzLists) {

                adapter.setUniCluBzLists(uniCluBzLists);
            }
        });


        tabLayout = (TabLayout) findViewById(R.id.tablayout1);
        tabItem1 = (TabItem) findViewById(R.id.tab1);
        tabItem2 = (TabItem) findViewById(R.id.tab2);
        tabItem3 = (TabItem) findViewById(R.id.tab3);
        viewPager = (ViewPager) findViewById(R.id.vpager);
        fragmentA = new FragmentUniversityAffiliation();




        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


}