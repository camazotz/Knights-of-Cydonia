package com.example.pebble;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	MediaPlayer mp;
	SoundHandler handle = new SoundHandler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button tmp = (Button) findViewById(R.id.buttonStart);
        //tmp.setOnClickListener(new View.OnClickListener() {
        	
       // });
    }
    

    public void onClick(View v)
	{
    	
    	mp = MediaPlayer.create(this, R.raw.dragon);
    	handle.setName("dragon", mp);
		//playKnight();
		
		//Wait 2-3 seconds for user input.
		//If incorrect, vibrate to indicate damage
		//3 hits is a kill, and restart, keep count of misses
		
	    
		//playDragon();

	    //playWizard();
	}
    
    public void playDragon()
    {
    	
    	mp = MediaPlayer.create(this, R.raw.dragon);
     	mp.setOnCompletionListener(new OnCompletionListener() {

             @Override
             public void onCompletion(MediaPlayer mp) {
                 // TODO Auto-generated method stub
                 //mp.release();
             }

         });
     	
     	mp.start();
    	/*Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() { 
	        	    
	             mp.start(); 
	         } 
	    }, 4000);*/
    	
    }
    
    public void playKnight()
    {
    	mp = MediaPlayer.create(this, R.raw.knight);
    	
    	
    	mp.start();
    	mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                playDragon();
            }

        }); 
    	/*Handler handler = new Handler();
    	handler.postDelayed(new Runnable() { 
	         public void run() { 
	        	 mp.start();
	         } 
	    }, 4000);  */
       
    }
    
    public void playWizard()
    {
    	mp = MediaPlayer.create(this, R.raw.wizard);
    	  
        mp.start();
        mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer player) {
                // TODO Auto-generated method stub
            	mp.release();
               playKnight();
            }

        }); 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
