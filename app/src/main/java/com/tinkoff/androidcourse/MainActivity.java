package com.tinkoff.androidcourse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tinkoff.androidcourse.Adapters.WorkerAdapter;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private WorkerAdapter workerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.rv_workers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        workerAdapter = new WorkerAdapter();
        recyclerView.setAdapter(workerAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workerAdapter.addItem(WorkerGenerator.generateWorker());
                recyclerView.scrollToPosition(workerAdapter.getItemCount() - 1);
            }
        });


    }
}
