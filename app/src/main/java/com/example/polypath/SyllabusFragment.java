package com.example.polypath;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SyllabusFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Layout inflate karo
        View view = inflater.inflate(R.layout.fragment_section_layout, container, false);

        // 2. RecyclerView set up karo (GridLayoutManager ke saath 2 column mein)
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // 3. Activity se Intent data lo
        if (getActivity() != null && getActivity().getIntent() != null) {
            String branch = getActivity().getIntent().getStringExtra("BRANCH_NAME");
            String semester = getActivity().getIntent().getStringExtra("SEMESTER_NAME");
            String originalSubject = getActivity().getIntent().getStringExtra("SUBJECT_NAME");

            String searchSubject = (originalSubject != null) ? originalSubject : "";

            List<String> titles = new ArrayList<>();
            List<String> ids = new ArrayList<>();

            // 4. Data fetch karo (Yahan "study material" ki jagah "syllabus" pass kiya hai)
            PdfDataManager.getPdfData(branch, semester, searchSubject, "syllabus", titles, ids);

            // 5. Check karo data mila ya nahi
            if (ids.isEmpty()) {
                Toast.makeText(getContext(), "Syllabus not available for " + originalSubject, Toast.LENGTH_LONG).show();
            } else {
                // 6. Adapter set karo jo clicks handle karega
                PdfAdapter adapter = new PdfAdapter(titles, ids, id -> {
                    Intent intent = new Intent(getContext(), PdfViewerActivity.class);
                    intent.putExtra("PDF_ID", id);
                    intent.putExtra("SUBJECT_NAME", originalSubject);
                    startActivity(intent);
                });
                recyclerView.setAdapter(adapter);
            }
        }
        return view;
    }
}