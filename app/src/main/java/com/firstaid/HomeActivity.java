package com.firstaid;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    /**
     * Init.
     */
    private void init() {
        mDrawerLayout = findViewById(R.id.mDrawerLayout);

        //Click listener for login button
        findViewById(R.id.ivNav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    /**
     * Close drawer.
     */
    private void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
            return;
        }
        super.onBackPressed();
    }
}
