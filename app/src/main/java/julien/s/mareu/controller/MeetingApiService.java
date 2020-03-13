package julien.s.mareu.controller;

import java.util.List;

import julien.s.mareu.model.Meeting;

public interface MeetingApiService {

    List<Meeting> getMeetingsList();

    void addMeeting(Meeting meeting);

    void deleteMeeting(Meeting meeting);

    void sortMeetingByDate();
}
