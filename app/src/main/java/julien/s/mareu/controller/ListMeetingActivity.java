package julien.s.mareu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import julien.s.mareu.R;
import julien.s.mareu.View.MeetingAdapter;
import julien.s.mareu.model.Meeting;

public class ListMeetingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);

        ArrayList<String> participants = new ArrayList<>();
        participants.add("Participants1");

        ArrayList<Meeting> mMeetingsList = new ArrayList<>();
        mMeetingsList.add(new Meeting("ExempleRoom","Exemple Hour","Exemple Subject",participants));
        mMeetingsList.add(new Meeting("ExempleRoom","Exemple Hour","Exemple Subject",participants));
        mMeetingsList.add(new Meeting("ExempleRoom3","Exemple Hour3","Exemple Subject3",participants));

        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MeetingAdapter(mMeetingsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
