package julien.s.mareu;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import julien.s.mareu.controller.DI;
import julien.s.mareu.controller.MeetingApiService;
import julien.s.mareu.model.Meeting;
import julien.s.mareu.model.TestMeetingList;

import static org.junit.Assert.*;

/**
 * Unit test Meeting ApiService
 */
public class MeetingServiceTest {

    private MeetingApiService service;
    private MeetingApiService mApiService;

    @Before
    public void setup(){
        mApiService = DI.getMeetingApiService();
        service = DI.getNewApiService();
    }

    @Test
    public void getMeetingListWithSuccess(){
        List<Meeting> meetingsList = service.getMeetingsList();
        List<Meeting> meetingsListDummy = TestMeetingList.getFakeMeetingsList();
        assertEquals(meetingsList,meetingsListDummy);
    }

    @Test
    public void addMeetingWithSuccess(){
        Meeting meetingToAdd = service.getMeetingsList().get(0);
        service.getMeetingsList().clear();
        service.addMeeting(meetingToAdd);
        assertEquals(1,service.getMeetingsList().size());
    }

    @Test
    public void deleteMeetingWithSuccess(){
        Meeting meetingToDelete = service.getMeetingsList().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetingsList().contains(meetingToDelete));
    }

    @Test
    public void SortMeetingByDateWithSuccess(){
        List<Meeting> meetingExpectedList = service.getMeetingsList();
        mApiService.sortMeetingByDate();
        assertEquals(meetingExpectedList.get(2),mApiService.getMeetingsList().get(0));
        assertEquals(meetingExpectedList.get(4),mApiService.getMeetingsList().get(3));

    }
}