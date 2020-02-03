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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import julien.s.mareu.R;

public class MeetingDialog extends AppCompatDialogFragment {

    private Spinner mRoom;
    private TextView mEditHour, mEditDate;
    private EditText mEditSubject;
    private EditText mEditParticipants;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_meeting_dialog,null);

        builder.setView(view)
                .setTitle("Nouvelle réunion")

                .setPositiveButton("Accpeter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String room = mRoom.getSelectedItem().toString();
                        String hour = mEditHour.getText().toString();
                        String date = mEditDate.getText().toString();
                        String subject = mEditSubject.getText().toString();

                    }
                })

                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        mEditHour = view.findViewById(R.id.edit_hour);
        mEditHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.setPickerListener(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mEditHour.setText(hourOfDay + "H" + minute);
                    }
                });
                timePicker.show(getFragmentManager(),"time picker");
            }
        });

        mEditDate = view.findViewById(R.id.edit_date);
        mEditDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.setPickerListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar c = Calendar.getInstance();

                        String currentDateString = DateFormat.getDateInstance(DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD).format(c.getTime());
                        mEditDate.setText(currentDateString);
                    }
                });
                datePicker.show(getFragmentManager(),"date picker");
            }
        });

        return builder.create();
    }

    public interface MeetingDialogListener{
        void applyMeeting();
    }
}
