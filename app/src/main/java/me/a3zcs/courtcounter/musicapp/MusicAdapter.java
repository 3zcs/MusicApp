package me.a3zcs.courtcounter.musicapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static me.a3zcs.courtcounter.musicapp.MusicDetailsActivity.POSITION;

/**
 * Created by root on 18/07/17.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    Context context;
    String music [];

    public MusicAdapter(Context context, String[] music) {
        this.context = context;
        this.music = music;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.musicName.setText(music[position]);
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return music.length;
    }

    class MusicViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        TextView musicName;
        int position;
        public MusicViewHolder(View itemView) {
            super(itemView);
            musicName = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,MusicDetailsActivity.class);
            intent.putExtra(POSITION, position);
            context.startActivity(intent);
        }
    }
}
