package com.example.polypath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder> {
    private List<String> titles;
    private List<String> ids;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    public PdfAdapter(List<String> titles, List<String> ids, OnItemClickListener listener) {
        this.titles = titles;
        this.ids = ids;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String currentTitle = titles.get(position);
        holder.title.setText(currentTitle);

        // Logo Logic: Title ke base par logo change karna
        String lowerTitle = currentTitle.toLowerCase();

        if (lowerTitle.contains("syllabus")) {
            holder.icon.setImageResource(R.drawable.ic_syllabus);
        } else if (lowerTitle.contains("study material") ) {
            holder.icon.setImageResource(R.drawable.ic_study_material);
        } else if (lowerTitle.contains("manual")) {
            holder.icon.setImageResource(R.drawable.ic_manual);
        } else {
            // Default agar kuch match na kare
            holder.icon.setImageResource(R.drawable.ic_study_material);
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(ids.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // In IDs ko item_card.xml se match karna zaroori hai
            title = itemView.findViewById(R.id.txtTitle);
            icon = itemView.findViewById(R.id.imgIcon);
        }
    }
}