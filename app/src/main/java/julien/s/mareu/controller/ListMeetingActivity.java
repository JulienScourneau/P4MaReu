package julien.s.mareu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import julien.s.mareu.R;
import julien.s.mareu.View.MeetingDialog;
import julien.s.mareu.View.MeetingRecyclerView;
import julien.s.mareu.model.Meeting;
import julien.s.mareu.model.TestMeetingList;


public class ListMeetingActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton mAddMeetingButton;
    List<Meeting> mMeetingList = DI.getMeetingApiService().getMeetingsList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);

        mAddMeetingButton = findViewById(R.id.add_new_meeting_button);
        mAddMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeetingDialog meetingDialog = new MeetingDialog();
                meetingDialog.show(getSupportFragmentManager(),"meeting dialog");
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MeetingRecyclerView(mMeetingList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
