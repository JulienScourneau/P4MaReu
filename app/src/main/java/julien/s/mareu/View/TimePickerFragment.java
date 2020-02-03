package julien.s.mareu.View;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;


import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener pickerListener;

    public void setPickerListener(TimePickerDialog.OnTimeSetListener pickerListener) {
        this.pickerListener = pickerListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
       return new TimePickerDialog(getActivity(),pickerListener,hour,minute,true);
    }
}
