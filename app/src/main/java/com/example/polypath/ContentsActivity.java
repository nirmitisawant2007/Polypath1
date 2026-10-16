package com.example.polypath;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ContentsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private String selectedSubject;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        // Receive the subject name from SubjectActivity
        selectedSubject = getIntent().getStringExtra("subject_name");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment;
                switch (position) {
                    case 0: fragment = new StudyMaterialFragment(); break;
                    case 1: fragment = new ManualsFragment(); break;
                    case 2: fragment = new SyllabusFragment(); break;
                    default: fragment = new StudyMaterialFragment();
                }

                // Pass the subject name to the Fragment
                Bundle args = new Bundle();
                args.putString("subject", selectedSubject);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Study Material"); break;
                case 1: tab.setText("Manuals"); break;
                case 2: tab.setText("Syllabus"); break;
            }
        }).attach();
    }
}