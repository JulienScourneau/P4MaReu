package julien.s.mareu.model;

import java.util.Arrays;
import java.util.List;

public class TestMeetingList {

    private static List<String> participants = Arrays.asList(
            ("Participants1"),("Participants2"));

    private static List<Meeting> meetingsList = Arrays.asList(
            new Meeting("ExempleRoom","Exemple Hour","Exemple Subject",participants),
            new Meeting("ExempleRoom2","Exemple Hour2","Exemple Subject2",participants),
            new Meeting("ExempleRoom3","Exemple Hour3","Exemple Subject3",participants)
    );

    public static List<Meeting> getMeetingsList() {
        return meetingsList;
    }

}
