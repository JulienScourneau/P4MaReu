package julien.s.mareu.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);

        initView();
        setUpListener();
        setSupportActionBar(mToolbar);
        setUpRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_filtre_date:
                mApiService.sortMeetingByDate();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.item_filtre_room:
                mApiService.sortMeetingByRoom();
                mAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initView(){
        mToolbar = findViewById(R.id.toolbar);
        mAddMeetingButton = findViewById(R.id.add_new_meeting_button);
    }

    private void setUpListener(){
        mAddMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeetingDialog meetingDialog = new MeetingDialog();
                meetingDialog.show(getSupportFragmentManager(),"meeting dialog");
            }
        });
    }

    private void setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MeetingRecyclerView(mMeetingList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
