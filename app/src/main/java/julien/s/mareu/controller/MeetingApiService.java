package julien.s.mareu.controller;

import java.util.ArrayList;

import julien.s.mareu.model.Meeting;

public interface MeetingApiService {


    ArrayList<Meeting> getMeetingsList();

    void addMeeting(Meeting meeting);

    void deleteMeeting(Meeting meeting);
}
