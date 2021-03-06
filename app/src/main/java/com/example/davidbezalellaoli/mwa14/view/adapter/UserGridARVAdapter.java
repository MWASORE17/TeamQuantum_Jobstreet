package com.example.davidbezalellaoli.mwa14.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidbezalellaoli.mwa14.R;
import com.example.davidbezalellaoli.mwa14.model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Bezalel Laoli on 4/10/2017.
 */

public class UserGridARVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserGridARVAdapter() {
        this.users = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_grid, parent, false);
        return new UserGridARVAdapter.ItemUserViewHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final UserGridARVAdapter.ItemUserViewHolder _holder = (UserGridARVAdapter.ItemUserViewHolder) holder;
        final User _user = this.users.get(position);
        _holder.name.setText(_user.getName());
        _holder.email.setText(_user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name, email;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_user_grid_image);
            name = (TextView) itemView.findViewById(R.id.item_user_grid_name);
            email = (TextView) itemView.findViewById(R.id.item_user_grid_email);
        }
    }
}
