package julien.s.mareu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestMeetingList {

   public static List<Meeting> meetingsList = Arrays.asList(
           new Meeting("Hypérion","17h00","02/03","Définition des objectifs","Participant1,Participant2"),
           new Meeting("Ganymède","17h45","02/03","Etat des lieux","Participant1,Participant2,Participant3"),
           new Meeting("Thémisto","16h45","26/02","Avancement des projets","Participant1,Participant2,Participant3,Participant4"),
           new Meeting("Sedna","15h20","12/03","Brainstorming","Participant1,Participant2,Participant3"),
           new Meeting("Ophelia","15h20","11/03","Planning stratégique","Participant1,Participant2")
   );

   public static List<Meeting> getFakeMeetingsList() {
       return new ArrayList<>(meetingsList);
   }
}
