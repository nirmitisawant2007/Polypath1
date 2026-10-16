package com.example.polypath;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SubjectHubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_hub);

        // 1. Intent se Subject Name lena aur Toolbar pe set karna
        String subjectName = getIntent().getStringExtra("SUBJECT_NAME");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(subjectName); // Isse upar naam dikhega
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Back button ke liye
        }

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // 2. Adapter set karna
        viewPager.setAdapter(new MyPagerAdapter(this));

        // 3. Tabs ko ViewPager se connect karna aur naam dena
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText("SYLLABUS");
            else if (position == 1) tab.setText("STUDY MATERIAL");
            else tab.setText("MANUALS");
        }).attach();
    }

    // Back button press karne par pichli screen pe jane ke liye
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // --- Pager Adapter Class ---
    private class MyPagerAdapter extends FragmentStateAdapter {
        public MyPagerAdapter(@NonNull AppCompatActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public androidx.fragment.app.Fragment createFragment(int position) {
            switch (position) {
                case 0: return new SyllabusFragment();
                case 1: return new StudyMaterialFragment();
                case 2: return new ManualsFragment();
                default: return new SyllabusFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}