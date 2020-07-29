package com.swapnil.whatsapp_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    FloatingActionButton fab;
    viewPagerAdapter viewPagerAdapter;
    private int[] tabIcons = {
            R.drawable.ic_camera_alt_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        toolbar=findViewById(R.id.toolbar);
        fab=findViewById(R.id.fab_action);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Whatsapp");
        viewPagerAdapter=new viewPagerAdapter(getSupportFragmentManager());


        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        setupTabIcons();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeFabIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        Log.e("Main","fucked up");
        if(item.getItemId() == R.id.menu_search){
            Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.menu_three){
            Toast.makeText(this, "THree", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
    }
    private void changeFabIcon(final int index){
        fab.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0:fab.setImageDrawable(getDrawable(R.drawable.ic_camera_alt_black_24dp));
                           break;
                    case 1:fab.setImageDrawable(getDrawable(R.drawable.ic_message_black_24dp));
                           break;
                    case 2:fab.setImageDrawable(getDrawable(R.drawable.ic_camera_alt_black_24dp));
                           break;
                    case 3:fab.setImageDrawable(getDrawable(R.drawable.ic_call_black_24dp));
                           break;
                }
                fab.show();
            }
        },400);
    }
}
