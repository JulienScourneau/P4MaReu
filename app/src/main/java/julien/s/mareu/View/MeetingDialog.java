package julien.s.mareu.View;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import julien.s.mareu.R;
import julien.s.mareu.controller.DI;
import julien.s.mareu.controller.MeetingApiService;
import julien.s.mareu.model.Meeting;

public class MeetingDialog extends AppCompatDialogFragment {

    private MeetingApiService mApiService = DI.getMeetingApiService();;
    private Spinner mRoom;
    private TextView mEditHour, mEditDate;
    private EditText mEditSubject, mEditParticipant;
    private List<String> mParticipantList = new ArrayList<>();
    private ImageButton mAddParticipant, mDeleteParticipant;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_meeting_dialog,null);

        mRoom = view.findViewById(R.id.spinner_room);
        mEditHour = view.findViewById(R.id.edit_hour);
        mEditDate = view.findViewById(R.id.edit_date);
        mEditSubject = view.findViewById(R.id.edit_subject);
        mEditParticipant = view.findViewById(R.id.edit_participant);
        mAddParticipant = view.findViewById(R.id.add_participant_button);
        mDeleteParticipant = view.findViewById(R.id.delete_participant_button);

        builder.setView(view)
                .setTitle("Nouvelle réunion")

                .setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addNewMeeting();
                    }
                })

                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        mEditHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePicker();
            }
        });

        mEditDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });

        mAddParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewParticipant();
            }
        });

        mDeleteParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteParticipant();
            }
        });
        return builder.create();
    }

    private void addNewParticipant(){

        if (mEditParticipant.getText().toString().matches("")){
            Toast.makeText(getActivity(),"Entrer un nom",Toast.LENGTH_SHORT).show();
        }else{
            mParticipantList.add(mEditParticipant.getText().toString());
            mEditParticipant.setHint(Meeting.join(",",mParticipantList));
            mEditParticipant.setText("");
        }
    }

    private void deleteParticipant(){

        if (mParticipantList.size() == 0) {
            mEditParticipant.setHint("Participants");
            mEditParticipant.setText("");
        }else{
            mParticipantList.remove(mParticipantList.size()-1);
            mEditParticipant.setHint(Meeting.join(",",mParticipantList));
            mEditParticipant.setText("");
        }
    }

    private void addNewMeeting(){

        String room = mRoom.getSelectedItem().toString();
        String hour = mEditHour.getText().toString();
        String date = mEditDate.getText().toString();
        String subject = mEditSubject.getText().toString();
        String participant = Meeting.join(",",mParticipantList);

        mApiService.addMeeting(new Meeting(room,hour,date,subject,participant));
        mApiService.getMeetingsList();
    }

    private void openTimePicker(){

        TimePickerFragment timePicker = new TimePickerFragment();
        timePicker.setPickerListener(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                mEditHour.setText(String.format("%02dh%02d",hourOfDay,minute));
            }
        });
        timePicker.show(getFragmentManager(),"time picker");
    }

    private void openDatePicker(){

        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setPickerListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(year,month,dayOfMonth);

                SimpleDateFormat format = new SimpleDateFormat("dd/MM");
                mEditDate.setText(format.format(c.getTime()));
            }
        });
        datePicker.show(getFragmentManager(),"date picker");
    }
}
