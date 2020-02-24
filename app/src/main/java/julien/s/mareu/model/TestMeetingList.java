package julien.s.mareu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestMeetingList {

   public static List<Meeting> meetingsList = Arrays.asList(
           new Meeting("Salle C","00h00","00/00","Sujet cool","Participant1,Participant2"),
           new Meeting("Salle A","00h00","00/00","Sujet interessant","Participant1,Participant2,Participant3"),
           new Meeting("Salle B","00h00","00/00","Sujet important","Participant1,Participant2,Participant3,Participant4")
   );

   public static List<Meeting> getMeetingsList() {
       return new ArrayList<>(meetingsList);
   }
}
