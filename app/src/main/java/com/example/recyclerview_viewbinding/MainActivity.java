package com.example.recyclerview_viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview_viewbinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = activityMainBinding.getRoot();
        setContentView(rootView);

        recyclerAdapter = new RecyclerAdapter();
        activityMainBinding.recyclerView.setAdapter(recyclerAdapter);

        List<String> list = new ArrayList<>();
        list.add("Iron man");
        list.add("Iron man 2");
        list.add("Iron man 3");
        list.add("Captain America: The First Avenger");
        list.add("Captain America: The Winter Soldier");
        list.add("Captain America: Civil War");
        recyclerAdapter.updateList(list);
    }

}
