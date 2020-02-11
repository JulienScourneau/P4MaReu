package julien.s.mareu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestMeetingList {

   public static List<Meeting> meetingsList = Arrays.asList(
           new Meeting("ExempleRoom","00h00","00/00","Exemple Subject","Participants1,Participants2"),
           new Meeting("ExempleRoom2","00h00","00/00","Exemple Subject2","Participants1,Participants2"),
           new Meeting("ExempleRoom3","00h00","00/00","Exemple Subject3","Participants1,Participants2")
   );

   public static List<Meeting> getMeetingsList() {
       return new ArrayList<>(meetingsList);
   }
}
