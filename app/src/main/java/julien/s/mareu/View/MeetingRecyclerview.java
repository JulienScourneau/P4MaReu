package julien.s.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import julien.s.mareu.R;
import julien.s.mareu.controller.MeetingApiService;
import julien.s.mareu.model.Meeting;

public class MeetingRecyclerview extends RecyclerView.Adapter<MeetingRecyclerview.MeetingViewHolder> {
    private List<Meeting> mMeetingList;

    public static class MeetingViewHolder extends RecyclerView.ViewHolder{


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

    public MeetingRecyclerview(List<Meeting> meetingList) {
        mMeetingList = meetingList;

    }

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_meeting,parent, false);
        MeetingViewHolder viewHolder = new MeetingViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MeetingViewHolder holder, int position) {

        final Meeting mMeeting = mMeetingList.get(position);

       // Glide.with(holder.mMeetingIcone.getContext())
       //         .load(mMeeting.getIcone())
       //         .apply(RequestOptions.circleCropTransform())
       //         .into(holder.mMeetingIcone);

        holder.mMeetingRoom.setText(mMeeting.getRoom());
        holder.mMeetingHour.setText(mMeeting.getHour());
        holder.mMeetingSubject.setText(mMeeting.getSubject());
        holder.mMeetingParticipant.setText(mMeeting.getParticipant());

        holder.mAddMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

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
