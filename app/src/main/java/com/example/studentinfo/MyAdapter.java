package com.example.studentinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends FirebaseRecyclerAdapter<MainModel, MyAdapter.MyViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.age.setText(model.getAge());

        Glide.with(holder.circleImageView.getContext())
                .load(model.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.circleImageView);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_item, parent, false);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        TextView name, email, age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = (CircleImageView) itemView.findViewById(R.id.student_image);
            name = (TextView) itemView.findViewById(R.id.std_name);
            email = (TextView) itemView.findViewById(R.id.std_email);
            age = (TextView) itemView.findViewById(R.id.std_age);
        }
    }
}
