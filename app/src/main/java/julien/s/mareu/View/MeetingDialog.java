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

import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import julien.s.mareu.R;
import julien.s.mareu.controller.DI;
import julien.s.mareu.model.Meeting;

public class MeetingDialog extends AppCompatDialogFragment {

    private Spinner mRoom;
    private TextView mEditHour, mEditDate;
    private EditText mEditSubject;
    private EditText mEditParticipant;
    private List<String> mParticipantList = new ArrayList<>();
    private ImageButton mAddParticipant;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_meeting_dialog,null);

        builder.setView(view)
                .setTitle("Nouvelle réunion")

                .setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String room = mRoom.getSelectedItem().toString();
                        String hour = mEditHour.getText().toString();
                        String date = mEditDate.getText().toString();
                        String subject = mEditSubject.getText().toString();
                        String participant = Meeting.join(",",mParticipantList);

                        DI.getNewInstanceApiservice().addMeeting(new Meeting(room,hour,date,subject,participant));

                    }
                })

                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        mRoom = view.findViewById(R.id.spinner_room);
        mEditHour = view.findViewById(R.id.edit_hour);
        mEditDate = view.findViewById(R.id.edit_date);
        mEditSubject = view.findViewById(R.id.edit_subject);
        mEditParticipant = view.findViewById(R.id.edit_participant);
        mAddParticipant = view.findViewById(R.id.add_participant_button);

        mEditHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.setPickerListener(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mEditHour.setText(String.format("%02d:%02d",hourOfDay,minute));
                    }
                });
                timePicker.show(getFragmentManager(),"time picker");
            }
        });

        mEditDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        mAddParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mParticipantList.add(mEditParticipant.getText().toString());
                mEditParticipant.setHint(Meeting.join(",",mParticipantList));

            }
        });

        return builder.create();
    }
}
