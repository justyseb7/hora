package com.example.justinsebastian.hora;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JOYCE on 15-02-2018.
 */

public class DetailsAdapter extends ArrayAdapter {

    Activity activity;
    List<Details>list;

    public DetailsAdapter(Activity activity, List<Details> list) {
        super( activity,R.layout.custom_layout, list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView = layoutInflater.inflate( R.layout.custom_layout,null,true );

        TextView NAME =(TextView) convertView.findViewById( R.id.name_here );
        TextView SOURCE =(TextView) convertView.findViewById( R.id.source_here );
        TextView TIMEE =(TextView) convertView.findViewById( R.id.time_here );
        TextView DESTINATION =(TextView) convertView.findViewById( R.id.destination_here );
        TextView TYPE =(TextView) convertView.findViewById( R.id.type_here );

        Details details= list.get(position);


        NAME.setText( details.getName() );
        SOURCE.setText( details.getSource() );
        TIMEE.setText( details.getTime() );
        DESTINATION.setText( details.getDestination() );
        TYPE.setText( details.getType() );

        return convertView ;
    }
}
