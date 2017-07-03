package com.sandeshnimhan.accent;

/**
 * Created by nimha on 3/27/2017.
 */

public class Word {

   private String mDefaultTranslation;
   private String mMiwokTranslation;
    private int mAudioResourceId;
    private int  mImageResourceId = No_IMAGE_PROVIDED;

    /*
    * For debugging purpose if needed, use Log.v("NumbersActivity", "Current word: " + word);
    * */
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    private static final int No_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId(){ return mAudioResourceId; }
    /*
    * Retruns true if image id is set i.e. image is needed
    * */
    public boolean hasImage(){
        return mImageResourceId != No_IMAGE_PROVIDED;
    }
}
