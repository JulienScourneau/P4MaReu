package julien.s.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import julien.s.mareu.R;
import julien.s.mareu.model.Meeting;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {
    private ArrayList<Meeting> mMeetingList;

    public static class MeetingViewHolder extends RecyclerView.ViewHolder{


        public FloatingActionButton mAddMeetingButton;
        public ImageButton mDeleteMeetingButton;

        public TextView mRoom;
        public TextView mHour;
        public TextView mSubject;
        public TextView mParticipant;


        public MeetingViewHolder(View itemView) {
            super(itemView);
            mRoom = itemView.findViewById(R.id.item_room_meeting);
            mHour = itemView.findViewById(R.id.item_hour_meeting);
            mSubject = itemView.findViewById(R.id.item_subject_meeting);
            mParticipant = itemView.findViewById(R.id.item_participant_meeting);
            mAddMeetingButton = itemView.findViewById(R.id.add_new_meeting_button);
            mDeleteMeetingButton = itemView.findViewById(R.id.item_list_delete_button);
        }
    }

    public MeetingAdapter(ArrayList<Meeting> meetingList) {
        mMeetingList = meetingList;

    }

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_meeting,parent, false);
        MeetingViewHolder viewHolder = new MeetingViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, int position) {

        Meeting mMeeting = mMeetingList.get(position);

        holder.mRoom.setText(mMeeting.getRoom());
        holder.mHour.setText(mMeeting.getHour());
        holder.mSubject.setText(mMeeting.getSubject());
        //holder.mParticipant.setText((CharSequence) mMeeting.getParticipant());

        holder.mDeleteMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }
}
