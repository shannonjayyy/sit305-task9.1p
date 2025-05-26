package com.example.lostandfoundapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LostFoundAdapter extends RecyclerView.Adapter<LostFoundAdapter.ViewHolder> {

    private Context context;
    private List<LostFoundItem> itemList;
    private OnItemDeleteListener deleteListener;

    public interface OnItemDeleteListener {
        void onItemDelete(LostFoundItem item);
    }

    public LostFoundAdapter(Context context, List<LostFoundItem> itemList, OnItemDeleteListener deleteListener) {
        this.context = context;
        this.itemList = itemList;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LostFoundItem item = itemList.get(position);

        holder.textViewName.setText("Name: " + item.getName());
        holder.textViewStatus.setText("Type: " + item.getStatus());
        holder.textViewDescription.setText("Description: " + item.getDescription());
        holder.textViewDate.setText("Date: " + item.getDate());
        holder.textViewLocation.setText("Location: " + item.getLocation());
        holder.textViewContact.setText("Phone: " + item.getContact());

        holder.buttonDelete.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onItemDelete(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewStatus, textViewDescription, textViewDate, textViewLocation, textViewContact;
        Button buttonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewContact = itemView.findViewById(R.id.textViewContact);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
