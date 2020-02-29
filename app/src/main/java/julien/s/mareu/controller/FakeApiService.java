package julien.s.mareu.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import julien.s.mareu.model.Meeting;
import julien.s.mareu.model.TestMeetingList;

public class FakeApiService implements MeetingApiService {

    private List<Meeting> meetings = TestMeetingList.getFakeMeetingsList();

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

    @Override
    public void sortMeetingByRoom() {
        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getRoom().compareTo(o2.getRoom());
            }
        });
    }

    @Override
    public void sortMeetingByDate() {
        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return  o1.convertToDate().compareTo(o2.convertToDate());
            }
        });
    }
}
