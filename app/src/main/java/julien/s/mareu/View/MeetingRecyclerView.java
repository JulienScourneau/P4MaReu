package julien.s.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import julien.s.mareu.R;
import julien.s.mareu.controller.DI;
import julien.s.mareu.model.Meeting;

public class MeetingRecyclerView extends RecyclerView.Adapter<MeetingRecyclerView.MeetingViewHolder> {
    private final List<Meeting> mMeetingList;

    public class MeetingViewHolder extends RecyclerView.ViewHolder{

        public FloatingActionButton mAddMeetingButton;
        public ImageButton mDeleteMeetingButton;
        public ImageView mMeetingIcone;
        public TextView mMeetingRoom;
        public TextView mMeetingHour;
        public TextView mMeetingSubject;
        public TextView mMeetingParticipant;


        public MeetingViewHolder(View itemView) {
            super(itemView);
            mMeetingIcone = itemView.findViewById(R.id.item_icone_meeting);
            mMeetingRoom = itemView.findViewById(R.id.item_room_meeting);
            mMeetingHour = itemView.findViewById(R.id.item_hour_meeting);
            mMeetingSubject = itemView.findViewById(R.id.item_subject_meeting);
            mMeetingParticipant = itemView.findViewById(R.id.item_participant_meeting);
            mAddMeetingButton = itemView.findViewById(R.id.add_new_meeting_button);
            mDeleteMeetingButton = itemView.findViewById(R.id.item_list_delete_button);

        }
    }

    public MeetingRecyclerView(List<Meeting> meetingList) {
        mMeetingList = meetingList;

    }

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meeting, parent, false);
        MeetingViewHolder viewHolder = new MeetingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, int position) {

        final Meeting mMeetings = mMeetingList.get(position);

        holder.mMeetingRoom.setText(mMeetings.getRoom());
        holder.mMeetingHour.setText(mMeetings.getHour());
        holder.mMeetingSubject.setText(mMeetings.getSubject());
        holder.mMeetingParticipant.setText("Participants");

        holder.mDeleteMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DI.getMeetingApiService().deleteMeeting(mMeetings);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }

}
