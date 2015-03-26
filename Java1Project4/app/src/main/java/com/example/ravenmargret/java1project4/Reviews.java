//Created Brenna Pavlinchak 3/22/2015

package com.example.ravenmargret.java1project4;


public class Reviews
{
    String mMovieName;
    String mActorName;
    String mReleaseDate;
    String mDirector;
    String mReview;

    public Reviews(String mMovieName, String mActorName, String mReleaseDate, String mDirector, String mReview)
    {
        this.mMovieName = mMovieName;
        this.mActorName = mActorName;
        this.mReleaseDate = mReleaseDate;
        this.mDirector = mDirector;
        this.mReview = mReview;
    }

    public String getmMovieName()
    {
        return mMovieName;
    }
    public String getmActorName()
    {
        return mActorName;
    }
    public String getmReleaseDate()
    {
        return mReleaseDate;
    }
    public String getmDirector()
    {
        return mDirector;
    }
    public String getmReview()
    {
        return mReview;
    }

    public void setmMovieName(String mMovieName) { this.mMovieName = mMovieName; }
    public void setmActorName(String mActorName)
    {
        this.mActorName = mActorName;
    }
    public void setmReleaseDate(String mReleaseDate)
    {
        this.mReleaseDate = mReleaseDate;
    }
    public void setmDirector(String mDirector)
    {
        this.mDirector = mDirector;
    }
    public void setmReview(String mReview)
    {
        this.mReview = mReview;
    }

    @Override
    public String toString()
    {
        return mMovieName + mActorName + mReleaseDate + mDirector + mReview;

    }
}