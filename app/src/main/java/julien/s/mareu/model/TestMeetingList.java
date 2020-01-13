package julien.s.mareu.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMeetingList {

    private List<Meeting> meetingsList = Arrays.asList(
            new Meeting("ExempleRoom","Exemple Hour","Exemple Subject",participants),
            new Meeting("ExempleRoom2","Exemple Hour2","Exemple Subject2",participants),
            new Meeting("ExempleRoom3","Exemple Hour3","Exemple Subject3",participants)
    );

    public List<Meeting> getMeetingsList() {
        return meetingsList;
    }

    private static ArrayList<String> participants = new ArrayList<>();

}
