package com.crinsoft.sanalturrehberi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class FeedSayfasi extends AppCompatActivity {
    BottomNavigationView mMainNav;
    FrameLayout frameLayout;
    HomeTab homeTab;
    SehirAramaTab sehirAramaTab;
    FavorilerTab favorilerTab;
    HesabimTab hesabimTab;
    TextView deneme;
    String UserNickName;
    private ArrayList<FavBilgileri> favBilgileris;


    RecyclerView recyclerView;
    FavRecyclerView adapter;
    RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_sayfasi);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer((GravityCompat.START));
            }
        });
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        mMainNav = (BottomNavigationView) findViewById(R.id.bottomNavigationView );
        deneme = findViewById(R.id.deneme);
        Intent inten = new Intent(FeedSayfasi.this,MainActivity.class);

        UserNickName = getIntent().getStringExtra("KullaniciAdi");
        System.out.println(UserNickName);
        deneme.setText("Gelen bilgi"+ UserNickName);


        recyclerView=findViewById(R.id.recyclerviewFav);

        //recyclerView.setHasFixedSize(true);






        homeTab = new HomeTab();
        sehirAramaTab = new SehirAramaTab();
        favorilerTab = new FavorilerTab();
        hesabimTab = new HesabimTab();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.HomeTab :
                        setFragment(homeTab);
                        return true;

                    case R.id.sehirAramaTab :
                        setFragment(sehirAramaTab);
                        return true;

                    case R.id.favorilerTab :
                        setFragment(favorilerTab);
                        return true;

                    case R.id.persontab :
                        setFragment(hesabimTab);

                        return true;

                    default:
                       return false;

                }


            }
        });



    }



    private void setFragment(Fragment fragment){
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.frameLayout,fragment);
    fragmentTransaction.commit();

    }
    public void HhesapBilgileri(View view){

        Intent intent = new Intent(this,HesapBilgileri.class);
        intent.putExtra("KullaniciAdi", UserNickName);
        startActivity(intent);


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    public void gotoGoogleMaps(View view){
        Intent intent = new Intent(FeedSayfasi.this,GoogleMapActivity.class);
        startActivity(intent);


    }

    public void SeyehatPlanlari(View view){
        Intent intent = new Intent(FeedSayfasi.this,SeyehatPlanlari.class);
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);


    }

    public void setAdapter(){
        adapter = new FavRecyclerView(favBilgileris);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }




    }














