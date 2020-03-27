package julien.s.mareu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestMeetingList {

   public static List<Meeting> meetingsList = Arrays.asList(
           new Meeting("Hypérion","17h00","02/03","Définition des objectifs","maxime@lamzone.com, alex@lamzone.com"),
           new Meeting("Ganymède","17h45","02/03","Etat des lieux","paul@lamzone.com, viviane@lamzone.com, dominique@lamzone.com"),
           new Meeting("Thémisto","16h45","26/02","Avancement des projets","alex@lamzone.com, luc@lamzone.com,alex@lamzone.com, anne@lamzone.com"),
           new Meeting("Sedna","15h20","12/03","Brainstorming","luc@lamzone.com, amandine@lamzone.com, julien@lamzone.com"),
           new Meeting("Ophelia","15h20","11/03","Planning stratégique","viviane@lamzone.com, luc@lamzone.com")
   );

   public static List<Meeting> getFakeMeetingsList() {
       return new ArrayList<>(meetingsList);
   }
}
