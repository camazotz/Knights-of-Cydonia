package com.example.pebble;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class SoundHandler{
	
	Activity act = new Activity();
	MediaPlayer player;
	String filename;
	
	public SoundHandler(String newfile)
	{
		filename = newfile;
	}
	
	public SoundHandler()
	{
		
	}
	
	public void setName(String newfile, MediaPlayer newPlayer)
	{
		filename = newfile;
		playSound(newPlayer);
	}
	
	public void playSound(MediaPlayer player)
	{
		player.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

		});
		
		player.start();
		
	}
}
