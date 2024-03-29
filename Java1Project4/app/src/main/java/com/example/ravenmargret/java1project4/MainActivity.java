//Created Brenna Pavlinchak 3/22/2015

package com.example.ravenmargret.java1project4;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//API key f7bnana2ezdqq3e5h23whmuz
public class MainActivity extends ActionBarActivity
{
    final String TAG = "API TEST";

    ArrayList<Reviews> movieReviews = new ArrayList<Reviews>();

    ListView reviewList;
    TextView searchReviews;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        reviewList = (ListView) findViewById(R.id.listView);
        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchReviews = (EditText) findViewById(R.id.searchReviews);
        
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String movie = searchReviews.getText().toString();
                try
                {
                    ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//Check network class

                    NetworkInfo info = manager.getActiveNetworkInfo();
                    if(info !=null && info.isConnected())
                    {
                        movieReviews.clear();
                        MyTask myTask = new MyTask();
                        String searchReviewsText = searchReviews.getText().toString();
                        myTask.execute("http://api.usatoday.com/open/reviews/movies/Movies/"+ searchReviewsText + "?api_key=f7bnana2ezdqq3e5h23whmuz");
                    }
                }
                catch(Exception e)
                {
                    Log.e(TAG, "Invalid query for review: ");
                }
            }
        });

    }



    private class MyTask extends AsyncTask<String, Void, String>
    {
        final String TAG = "API DEMO AsyncTask";

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading...");
            dialog.setTitle("Network Call");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params)
        {
            String result = "";

            try
            {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                result = IOUtils.toString(is);
                is.close();

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find the anything try again", Toast.LENGTH_SHORT);
                toast.show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find anything try again", Toast.LENGTH_SHORT);
                toast.show();
            }

            return result;
        }



        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            Log.e("JSON DATA", s);


            try
            {
                JSONObject reviewObject = new JSONObject(s);
                JSONArray reviewArray = reviewObject.getJSONArray("MovieReviews");

                for (int i = 0; i < reviewArray.length(); i++)
                {
                    JSONObject insideObject = reviewArray.getJSONObject(i);
                    String movieName;
                    String actorName;
                    String releaseDate;
                    String director;
                    String review;

                    movieName = insideObject.getString("MovieName");
                    actorName = insideObject.getString("ActorName");
                    releaseDate = insideObject.getString("ReleaseDate");
                    director = insideObject.getString("Director");
                    review = insideObject.getString("Review");

                    movieReviews.add(new Reviews(movieName, actorName, releaseDate, director, review));
                }

            }
            catch (JSONException e)
            {
                //Toast toast = Toast.makeText(MainActivity.this, "Something Happened", Toast.LENGTH_SHORT);
                //toast.show();
            }

            CustomAdapter adaptor = new CustomAdapter(mContext, movieReviews);
            reviewList.setAdapter(adaptor);
            dialog.cancel();

        }

    }

}
