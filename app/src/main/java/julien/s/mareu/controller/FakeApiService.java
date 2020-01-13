package julien.s.mareu.controller;

import java.util.ArrayList;

import julien.s.mareu.model.Meeting;

public class FakeApiService implements MeetingApiService {

    private ArrayList<Meeting> meetings = new ArrayList<>();

    @Override
    public ArrayList<Meeting> getMeetingsList() {
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
