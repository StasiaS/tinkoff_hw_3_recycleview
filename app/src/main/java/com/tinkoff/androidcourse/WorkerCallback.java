package com.tinkoff.androidcourse;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class WorkerCallback extends ItemTouchHelper.Callback {

    private int mDefaultSwipeDirs;
    private int mDefaultDragDirs;

    public WorkerCallback(int dragDirs, int swipeDirs) {
        this.mDefaultSwipeDirs = swipeDirs;
        this.mDefaultDragDirs = dragDirs;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(this.getDragDirs(recyclerView, viewHolder), this.getSwipeDirs(recyclerView, viewHolder));
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return this.mDefaultDragDirs;
    }

    public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return this.mDefaultSwipeDirs;
    }
}
