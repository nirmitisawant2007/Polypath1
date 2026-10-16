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

public class StudyMaterialFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_section_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        if (getActivity() != null && getActivity().getIntent() != null) {
            String branch = getActivity().getIntent().getStringExtra("BRANCH_NAME");
            String semester = getActivity().getIntent().getStringExtra("SEMESTER_NAME");
            String originalSubject = getActivity().getIntent().getStringExtra("SUBJECT_NAME");

            String searchSubject = (originalSubject != null) ? originalSubject : "";

            List<String> titles = new ArrayList<>();
            List<String> ids = new ArrayList<>();

            PdfDataManager.getPdfData(branch, semester, searchSubject, "study material", titles, ids);

            if (ids.isEmpty()) {
                Toast.makeText(getContext(), "Notes not available for " + originalSubject, Toast.LENGTH_LONG).show();
            } else {
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