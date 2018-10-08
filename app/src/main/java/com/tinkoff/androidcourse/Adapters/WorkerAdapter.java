package com.tinkoff.androidcourse.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinkoff.androidcourse.R;
import com.tinkoff.androidcourse.Worker;

import java.util.ArrayList;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.ViewHolder> {

    private ArrayList<Worker> workerArrayList;

    public WorkerAdapter() {
        workerArrayList = new ArrayList<>();
    }

    public void addItems(ArrayList<Worker> workers) {
        int positionStart = workerArrayList.size();
        int countInserted = workers.size();
        this.workerArrayList.addAll(workers);
        notifyItemRangeInserted(positionStart, countInserted);
    }

    public void setItems(ArrayList<Worker> workers) {
        this.workerArrayList.clear();
        this.workerArrayList.addAll(workers);
        notifyDataSetChanged();
    }

    public ArrayList<Worker> getItems() {
        return workerArrayList;
    }

    public void addItem(Worker worker) {
        workerArrayList.add(worker);
        notifyItemInserted(workerArrayList.indexOf(worker));
    }

    public void removeItem(int position) {
        if (position >= workerArrayList.size()) return;

        workerArrayList.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder viewHolder;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_worker, viewGroup, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Worker worker = workerArrayList.get(i);
        viewHolder.tvPosition.setText(worker.getPosition());
        viewHolder.tvNameAge.setText(worker.getName() + ", " + worker.getAge());
        viewHolder.ivPhoto.setImageResource(worker.getPhoto());
    }

    @Override
    public int getItemCount() {
        return workerArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tvNameAge;
        private TextView tvPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvNameAge = itemView.findViewById(R.id.tv_name_age);
            tvPosition = itemView.findViewById(R.id.tv_position);
        }
    }

}
