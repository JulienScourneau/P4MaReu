package julien.s.mareu.controller;

import java.util.ArrayList;
import java.util.List;

import julien.s.mareu.model.Meeting;
import julien.s.mareu.model.TestMeetingList;

public class FakeApiService implements MeetingApiService {

    private List<Meeting> meetings = TestMeetingList.getMeetingsList();

    @Override
    public List<Meeting> getMeetingsList() {
        return meetings;
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }
}
