package com.edu.sicnu.cs.zzy.fragmenttest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.edu.sicnu.cs.zzy.fragmenttest.Fragment.Fragment_1;
import com.edu.sicnu.cs.zzy.fragmenttest.Fragment.Fragment_2;
import com.edu.sicnu.cs.zzy.fragmenttest.Fragment.Fragment_3;
import com.edu.sicnu.cs.zzy.fragmenttest.Fragment.Fragment_4;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private Fragment currentFragment=null;
    FragmentManager fragmentManager;

    //设置bottomNavigationView的点击方法
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(fragment1);
                    break;
                case R.id.navigation_dashboard:
                    switchFragment(fragment2);
                    break;
                case R.id.navigation_notifications:
                    switchFragment(fragment3);
                    break;
                case R.id.navigation_help:
                    switchFragment(fragment4);
                    break;
            }
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //实例化fragment
        fragment1 = new Fragment_1();
        fragment2 = new Fragment_2();
        fragment3 = new Fragment_3();
        fragment4 = new Fragment_4();

        switchFragment(fragment1);  //将第一个fragment放在前面


    }

    public void switchFragment(Fragment fragment){
        if (currentFragment != fragment){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if(currentFragment!=null){
                transaction.hide(currentFragment);    //将原先的fragment隐藏
            }
            currentFragment = fragment; //替换当前fragment
            if(!fragment.isAdded()){
                transaction.add(R.id.frame,fragment);   //如未加入则加入
            }
            transaction.show(fragment);
            transaction.commit();
        }
    }


}
