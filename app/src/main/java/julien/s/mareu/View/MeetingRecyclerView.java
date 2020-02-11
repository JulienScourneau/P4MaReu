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
    private List<Meeting> mMeetingList;

    public class MeetingViewHolder extends RecyclerView.ViewHolder{

        public FloatingActionButton mAddMeetingButton;
        public ImageButton mDeleteMeetingButton;
        public ImageView mMeetingIcone;
        public TextView mMeetingRoom;
        public TextView mMeetingHour;
        public TextView mMeetingDate;
        public TextView mMeetingSubject;
        public TextView mMeetingParticipant;

        public MeetingViewHolder(View itemView) {
            super(itemView);
            mMeetingIcone = itemView.findViewById(R.id.item_icone_meeting);
            mMeetingRoom = itemView.findViewById(R.id.item_room_meeting);
            mMeetingHour = itemView.findViewById(R.id.item_hour_meeting);
            mMeetingDate = itemView.findViewById(R.id.item_date_meeting);
            mMeetingSubject = itemView.findViewById(R.id.item_subject_meeting);
            mMeetingParticipant = itemView.findViewById(R.id.item_participant_meeting);
            mAddMeetingButton = itemView.findViewById(R.id.add_new_meeting_button);
            mDeleteMeetingButton = itemView.findViewById(R.id.item_list_delete_button);
        }
    }

    public MeetingRecyclerView(List<Meeting> meetingList) {
        this.mMeetingList = meetingList;

    }

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meeting, parent, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, final int position) {

        final Meeting mMeetings = mMeetingList.get(position);

        holder.mMeetingRoom.setText(mMeetings.getRoom());
        holder.mMeetingHour.setText(mMeetings.getHour());
        holder.mMeetingDate.setText(mMeetings.getDate());
        holder.mMeetingSubject.setText(mMeetings.getSubject());
        holder.mMeetingParticipant.setText(mMeetings.getParticipant());
        holder.mMeetingIcone.setBackgroundColor(mMeetings.getRandomColor());

        holder.mDeleteMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DI.getMeetingApiService().deleteMeeting((Meeting)mMeetings);
                removeItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }

    private void removeItem (int position){
        notifyDataSetChanged();
    }
}
