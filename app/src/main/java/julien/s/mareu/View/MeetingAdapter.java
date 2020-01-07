package julien.s.mareu.View;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    public static class MeetingViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public 

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
