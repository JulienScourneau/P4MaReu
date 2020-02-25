package julien.s.mareu.model;

import android.graphics.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Meeting {

    private int mIcone;
    private String mRoom;
    private String mHour;
    private String mDate;
    private String mSubject;
    private String mParticipant;

    /**
     * Constructor
     *
     */
    public Meeting(String room, String hour,String date, String subject, String participant) {

        this.mRoom = room;
        this.mHour = hour;
        this.mDate = date;
        this.mSubject = subject;
        this.mParticipant = participant;
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

    public String getDate() {
        return mDate;
    }

    public String getSubject() {
        return mSubject;
    }

    public String getParticipant(){
        return mParticipant;
    }

    /**
     * Setters
     *
     */
    public void setIcone(int icone){
        mIcone = getRandomColor();
    }

    public void setRoom(String room) {
        mRoom = room;
    }

    public void setHour(String hour) {
        mHour = hour;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public void setParticipant(String participant) {
        mParticipant = participant;
    }

    public static String join(String separator, List<String> inputList) {

        if (inputList == null || inputList.size() <= 0)
            return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputList.size(); i++) {

            sb.append(inputList.get(i));

            if (i != inputList.size() -1){
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),rnd.nextInt(256));
    }

    public Date convertToDate(){
        String dateString = getDate() +" "+ getHour();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM hh'h'mm");
        Date convertedDate = new Date();
        try{
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return convertedDate;
    }
}
