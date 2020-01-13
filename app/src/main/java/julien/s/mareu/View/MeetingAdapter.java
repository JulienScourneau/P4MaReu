package julien.s.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import julien.s.mareu.R;
import julien.s.mareu.model.Meeting;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {
    private ArrayList<Meeting> mMeetingList;

    public static class MeetingViewHolder extends RecyclerView.ViewHolder{

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

    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }
}
