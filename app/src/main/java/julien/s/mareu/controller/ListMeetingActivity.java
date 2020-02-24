package julien.s.mareu.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import julien.s.mareu.R;
import julien.s.mareu.View.MeetingDialog;
import julien.s.mareu.View.MeetingRecyclerView;
import julien.s.mareu.model.Meeting;

public class ListMeetingActivity extends AppCompatActivity {

    private MeetingApiService mApiService = DI.getMeetingApiService();
    private RecyclerView mRecyclerView;
    private MeetingRecyclerView mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mAddMeetingButton;
    private List<Meeting> mMeetingList = mApiService.getMeetingsList();
    private List<String> mMeetingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);

        mMeetingRoom = Arrays.asList(getResources().getStringArray(R.array.room_meeting_list));

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_filtre_date:
                sortDate();
                return true;
            case R.id.item_filtre_room:
                sortRoom();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sortRoom(){
        Collections.sort(mMeetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getRoom().compareTo(o2.getRoom());
            }
        });
        mAdapter.notifyDataSetChanged();
    }

    private void sortDate(){
        Collections.sort(mMeetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return  o1.convertToDate(o1.getHour()).compareTo(o2.convertToDate(o2.getHour()));
            }
        });
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
