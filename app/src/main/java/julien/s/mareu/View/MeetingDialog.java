package julien.s.mareu.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import julien.s.mareu.R;
import julien.s.mareu.controller.TimePickerFragment;

public class MeetingDialog extends AppCompatDialogFragment {

    private TimePickerDialog picker;
    private TextView mEditHour;
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

                        mEditHour.setText(hourOfDay + " " + minute);
                    }
                });
                timePicker.show(getFragmentManager(),"time picker");
            }
        });

        return builder.create();
    }
}
