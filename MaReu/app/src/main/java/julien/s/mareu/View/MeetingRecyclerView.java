package julien.s.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import julien.s.mareu.R;
import julien.s.mareu.controller.DI;
import julien.s.mareu.controller.MeetingApiService;
import julien.s.mareu.model.Meeting;

public class MeetingRecyclerView extends RecyclerView.Adapter<MeetingRecyclerView.MeetingViewHolder> implements Filterable {
    private MeetingApiService mApiService = DI.getMeetingApiService();
    private List<Meeting> mMeetingList;
    private List<Meeting> mFullMeetingList;

    public class MeetingViewHolder extends RecyclerView.ViewHolder {

        private ImageButton mDeleteMeetingButton;
        private ImageView mMeetingIcon;
        private TextView mMeetingRoom;
        private TextView mMeetingDate;
        private TextView mMeetingSubject;
        private TextView mMeetingParticipant;

        public MeetingViewHolder(View itemView) {
            super(itemView);
            mMeetingIcon = itemView.findViewById(R.id.item_icone_meeting);
            mMeetingRoom = itemView.findViewById(R.id.item_room_meeting);
            mMeetingDate = itemView.findViewById(R.id.item_date_meeting);
            mMeetingSubject = itemView.findViewById(R.id.item_subject_meeting);
            mMeetingParticipant = itemView.findViewById(R.id.item_participant_meeting);
            mDeleteMeetingButton = itemView.findViewById(R.id.item_list_delete_meeting_button);
        }
    }

    public MeetingRecyclerView(List<Meeting> meetingList) {
        this.mMeetingList = meetingList;
        this.mFullMeetingList = new ArrayList<>(mMeetingList);

    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder,final int position) {

        final Meeting mMeetings = mMeetingList.get(position);

        holder.mMeetingRoom.setText(mMeetings.getRoom());
        holder.mMeetingDate.setText(mMeetings.getHour() + " - " + mMeetings.getDate());
        holder.mMeetingSubject.setText(mMeetings.getSubject());
        holder.mMeetingParticipant.setText(mMeetings.getParticipant());
        holder.mMeetingIcon.setBackgroundColor(mMeetings.getIcone());

        holder.mDeleteMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DI.getMeetingApiService().deleteMeeting(mMeetings);
                removeItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }

    private void removeItem (int position){
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getItemCount());
    }

    @Override
    public Filter getFilter() {
        return meetingFilter;
    }

    private Filter meetingFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Meeting> filteredList = new ArrayList<>();
            FilterResults results = new FilterResults();
            mMeetingList = mApiService.getMeetingsList();
            mFullMeetingList = mMeetingList;

            if (constraint == null || constraint.length()==0){
                filteredList.addAll(mFullMeetingList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Meeting meeting : mApiService.getMeetingsList()) {
                    if (meeting.getRoom().toLowerCase().contains(filterPattern)){
                        filteredList.add(meeting);
                    }
                }
            }
            results.count = filteredList.size();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mMeetingList = (List) results.values;
            notifyDataSetChanged();
        }
    };
}