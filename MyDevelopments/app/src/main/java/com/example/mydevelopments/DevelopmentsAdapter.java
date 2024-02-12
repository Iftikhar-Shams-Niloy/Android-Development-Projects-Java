package com.example.mydevelopments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DevelopmentsAdapter extends RecyclerView.Adapter<DevelopmentsAdapter.DevelopmentsViewHolder> {
    private Development[] developments;
    public DevelopmentsAdapter(Development[] developments){
        this.developments = developments;
    }
    @Override
    public int getItemCount() {
        return developments.length;
    }
    @NonNull
    @Override
    public DevelopmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false); // INFLATE
        return new DevelopmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopmentsViewHolder holder, int position) {
        holder.bind(developments[position]);
    }



    static class DevelopmentsViewHolder extends RecyclerView.ViewHolder{
        private ImageView appImage;
        private TextView appTitle;
        private TextView appDescription;
        public DevelopmentsViewHolder(@NonNull View itemView) {
            super(itemView);
            appImage = itemView.findViewById(R.id.image_view_project_icon);
            appTitle = itemView.findViewById(R.id.text_view_title);
            appDescription = itemView.findViewById(R.id.text_view_description);
        }
        public void bind(Development development){
            appTitle.setText(development.name);
            appDescription.setText(development.description);
            appImage.setImageResource(development.image);
        }

    }

}
