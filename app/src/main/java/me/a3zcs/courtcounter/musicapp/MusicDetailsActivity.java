package me.a3zcs.courtcounter.musicapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.a3zcs.courtcounter.musicapp.databinding.ActivityMusicDetailsBinding;

public class MusicDetailsActivity extends AppCompatActivity {

    public static final String POSITION = "position";
    ActivityMusicDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_music_details);

        int position = getIntent().getIntExtra(POSITION,0);
        String [] music = getResources().getStringArray(R.array.music);
        String [] musicArtiest = getResources().getStringArray(R.array.music_artist);
        String [] musicRateing = getResources().getStringArray(R.array.music_rate);

        binding.textViewName.setText(music[position]);
        binding.textViewArtiest.setText(musicArtiest[position]);
        binding.ratingBar.setMax(5);
        binding.ratingBar.setRating(Float.parseFloat(musicRateing[position]));
        binding.buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicDetailsActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicDetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
