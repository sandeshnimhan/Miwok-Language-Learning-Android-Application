package com.sandeshnimhan.accent;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    /*
    * Creating global OnCompletionListener so that we don't have to create it for every word click
    * This will be more efficient
    * */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four","Oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        /*int i=0;
        for(String s :words) {
            Log.v("NumbersActivity", "Number " + i + ":" + s);
            i++;
        }*/

        //this code is not memory efficient
        /*LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        for(int i=0;i<words.size();i++) {
            TextView textView = new TextView(this);
            textView.setText(words.get(i));
            rootView.addView(textView);
        }*/

        //Using ListView and ArrayAdapter to make app memory efficient
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        /*ListView*/
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        /*GridView*/
        /*GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(itemsAdapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                /*For debugging and print Word object state - uses toString() in Word.java*/
                /*Log.v("NumbersActivity", "Current word: " + word);*/
                /*releasing Media Player resource as user might click different word before it
                finishes playing audio for the first one - multiple audio will not play
                simultaneously and OnCompletionListener will also get triggered properly, which might
                not happen sometimes when media player does not stop playing sounds repeatedly*/
                releaseMediaPlayer();
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();

                //Setting up an OnCompletionListener to notify when media player has finished playing audio
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
