package julien.s.mareu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestMeetingList {

   public static List<Meeting> meetingsList = Arrays.asList(
           new Meeting("Salle C","17h00","02/03","Sujet cool","Participant1,Participant2"),
           new Meeting("Salle A","17h45","02/03","Sujet interessant","Participant1,Participant2,Participant3"),
           new Meeting("Salle B","16h45","26/02","Sujet important","Participant1,Participant2,Participant3,Participant4"),
           new Meeting("Salle E","15h20","12/03","Sujet 5","Participant1,Participant2,Participant3"),
           new Meeting("Salle D","12h05","14/03","Sujet 2","Participant1,Participant2")
   );

   public static List<Meeting> getMeetingsList() {
       return new ArrayList<>(meetingsList);
   }
}
