package julien.s.mareu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import julien.s.mareu.R;
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
        participants.add("Participant");

        ArrayList<Meeting> meetingsList = new ArrayList<>();
        meetingsList.add(new Meeting("ExempleRoom","Exemple Hour","Exemple Subject",participants));
        meetingsList.add(new Meeting("ExempleRoom2","Exemple Hour2","Exemple Subject2",participants));
        meetingsList.add(new Meeting("ExempleRoom3","Exemple Hour3","Exemple Subject3",participants));

    }
}
