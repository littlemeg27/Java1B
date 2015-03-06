//Brenna Pavlinchak 3/4

package com.example.ravenmargret.java1project1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity
{
    Button addWordButton;
    EditText addWordText;
    Button getIndexButton;
    EditText getIndexText;
    TextView wordCountText;
    TextView averageTextBox;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;


        final ArrayList arrayList = new ArrayList<String>();
        addWordButton = (Button)findViewById(R.id.addWordButton);
        addWordText = (EditText)findViewById(R.id.addWordText);
        getIndexButton = (Button)findViewById(R.id.getIndexButton);
        getIndexText = (EditText)findViewById(R.id.getIndexText);
        wordCountText = (TextView)findViewById(R.id.wordCountText);
        averageTextBox = (TextView)findViewById(R.id.averageTextBox);

        addWordButton.setOnClickListener(new View.OnClickListener()
        {
            int letterCount;
            int wordLength;
            int count;
            int letterCountAverage;

            @Override
            public void onClick(View v)
            {

                String addItem = addWordText.getText().toString();
                if (!arrayList.contains(addItem))
                {
                    arrayList.add(addItem);
                    addWordText.setText("");

                    letterCount = addItem.length();
                    count = count + letterCount;
                }
                else
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                    dialog.setTitle("Word Entered");
                    dialog.setMessage("You entered a word that was already in the Array!");
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                        }

                    });
                    dialog.show();
                    addWordText.setText("");
                }

                wordLength = arrayList.size();
                wordCountText.setText(String.valueOf("Number Of Words: " + wordLength));
                wordCountText.setGravity(Gravity.CENTER);

                letterCountAverage = count / wordLength;
                averageTextBox.setText(String.valueOf("Average Letter's: " + letterCountAverage));
                averageTextBox.setGravity(Gravity.CENTER);
            }

        });


        getIndexButton.setOnClickListener(new View.OnClickListener()
        {
            int arrayIndex;

            @Override
            public void onClick(View v)
            {
                arrayIndex = Integer.parseInt(String.valueOf(getIndexText.getText()));

                if (arrayIndex < arrayList.size())
                {
                    getIndexText.setText("");
                    String addItem = getIndexText.getText().toString();


                    if (!arrayList.contains(addItem))
                    {
                        String arrayWord = "";

                        arrayWord = (String) arrayList.get(arrayIndex);

                        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                        dialog.setTitle("Index Picked");
                        dialog.setMessage("You picked index: " + arrayIndex + "\n" + "Which chose the word: " + arrayWord);
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }

                        });
                        dialog.show();
                    }
                    else
                    {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                        dialog.setTitle("Index Picked");
                        dialog.setMessage("Invalid Index!");
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }

                        });
                        dialog.show();
                        getIndexText.setText("");
                    }

                }

            }

        });

    }
}
