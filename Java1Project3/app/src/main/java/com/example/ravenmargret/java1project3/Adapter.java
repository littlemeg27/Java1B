//Brenna Pavlinchak 3/16/15

package com.example.ravenmargret.java1project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class Adapter extends BaseAdapter
{

    Context mContext;
    ArrayList<Vacations> mObjects;

    public Adapter(Context d, ArrayList<Vacations> objects)
    {
        mContext = d;
        mObjects = objects;
    }

    private static final int ID_CONSTANT = 0x01000000;

    @Override
    public int getCount()
    {
        if(mObjects != null)
        {
            return mObjects.size();
        }

        else
        {
            return 0;
        }
    }


    @Override
    public long getItemId(int position)
    {
        return ID_CONSTANT + position;
    }

    @Override
    public Vacations getItem(int position)
    {
        if(mObjects != null && position < mObjects.size() && position >= 0)
        {
            return  mObjects.get(position);
        }
        else
        {
            return null;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null) //No recycled view create new
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_adapter, parent, false);
        }

        Vacations item = getItem(position);

        ((TextView) convertView.findViewById(R.id.text)).setText(item.getNameOfVacation());

        return convertView;
    }
}
