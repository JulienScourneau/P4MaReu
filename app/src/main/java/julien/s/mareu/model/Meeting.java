package julien.s.mareu.model;

import java.util.ArrayList;

public class Meeting {

    private String mRoom;
    private String mHour;
    private String mSubject;
    private ArrayList<String> mParticipant = new ArrayList();

    public Meeting(String room, String hour, String subject, ArrayList<String> participant) {
        this.mRoom = room;
        this.mHour = hour;
        this.mSubject = subject;
        this.mParticipant = participant;
    }

    public String getRoom() {
        return mRoom;
    }

    public String getHour() {
        return mHour;
    }

    public String getSubject() {
        return mSubject;
    }

    public ArrayList<String> getParticipant() {
        return mParticipant;
    }

    public void setRoom(String room) {
        mRoom = room;
    }

    public void setHour(String hour) {
        mHour = hour;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public void setParticipant(ArrayList<String> participant) {
        mParticipant = participant;
    }
}
