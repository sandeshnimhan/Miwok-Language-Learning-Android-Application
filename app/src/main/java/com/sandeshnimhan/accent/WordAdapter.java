package com.sandeshnimhan.accent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nimha on 3/27/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /*For background color of each activity*/
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*return super.getView(position, convertView, parent);*/

        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);
        }
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        /*
        * Checks if image view needs to be set.
        * */
        /*
        * Note: Even without this check (hasImage() method in Word.java) App (PhrsesActivity) was working fine, find out why?
        * */
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            /*Making Visible again as views are reused, just  to make sure previously invisible view is visible while reusing*/
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            /*Hides the ImageView - Invisible but does not takes blank space in the app*/
            imageView.setVisibility(View.GONE);
        }

        /*Set the theme color for the list item*/
        View textContainer = listItemView.findViewById(R.id.text_container);
        /*Find the color that resource id maps to*/
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        /*Set the background color of text container view*/
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
