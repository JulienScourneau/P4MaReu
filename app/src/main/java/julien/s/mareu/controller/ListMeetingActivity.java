package julien.s.mareu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import julien.s.mareu.R;
import julien.s.mareu.View.MeetingRecyclerview;
import julien.s.mareu.model.Meeting;
import julien.s.mareu.model.TestMeetingList;


public class ListMeetingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Meeting> mMeetingList = TestMeetingList.getMeetingsList();

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
        mAdapter = new MeetingRecyclerview(mMeetingList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
