package julien.s.mareu.model;

import java.util.List;
import java.util.StringJoiner;

public class Meeting {

    private int mIcone;
    private String mRoom;
    private String mHour;
    private String mSubject;
    private List<String> mParticipantList;
    private String mParticipants;

    /**
     * Constructor
     *
     */
    public Meeting(String room, String hour, String subject, List<String> participant) {
        this.mRoom = room;
        this.mHour = hour;
        this.mSubject = subject;
        this.mParticipantList = participant;
    }



    /**
     * Getter
     *
     */
    public int getIcone(){
        return mIcone;
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

    public List<String> getParticipantList(){
        return mParticipantList;
    }

    public String getParticipant(){
        return mParticipants;
    }

    /**
     * Setters
     *
     */
    public void setIcone(int icone){
        mIcone = icone;
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

    public void setParticipantList(List<String> participantList) {
        mParticipantList = participantList;
    }

    public void setParticipant(String participant) {
        mParticipants = join(",",getParticipantList());

    }

    private String join(String separator, List<String> participantList) {
        if (participantList ==null || participantList.size() <= 0)
            return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < participantList.size();i++) {

            sb.append(participantList.get(i));
            if (i != participantList.size() -1){
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
