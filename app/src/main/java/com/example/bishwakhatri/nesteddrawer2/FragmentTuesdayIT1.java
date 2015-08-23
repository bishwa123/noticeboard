package com.example.bishwakhatri.nesteddrawer2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bishwa khatri on 6/13/2015.
 */
public class FragmentTuesdayIT1 extends Fragment {

    ListView listViewTuesdaytIT1;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_sundayit1, container, false);
        View V = inflater.inflate(R.layout.fragment_tuesday_it1, container, false);
        ImageView imageView = (ImageView)V.findViewById(R.id.imageView12);
        //   RoutineCustomlist routineCustomlist=new RoutineCustomlist();

        listViewTuesdaytIT1= (ListView) V.findViewById(R.id.listViewTuesdayIT1);
        ArrayList<RoutineCustomlist> routineCustomlists=new ArrayList<>();
        //  routineCustomlists.add(new RoutineCustomlist());
        routineCustomlists.add(new RoutineCustomlist("10:00-11:30","PHY","C206","JP","L","PHY","C206","JP","L"));
        routineCustomlists.add(new RoutineCustomlist("11:30-13:00","CTECH","C206","MBG","L","CTECH","A404","MBG","L"));
        routineCustomlists.add(new RoutineCustomlist("13:45-15:15","PRGC","A304","DM","P","PHY","C206","JP","P"));
        routineCustomlists.add(new RoutineCustomlist("15:15-16:45","BEE","C106","SS","L","BEE","C106","SS","L"));
        //  routineList.add(new RoutineCustomlist("","CNET","A404","MBG","L"));

        RoutineAdaptor adaptor=new RoutineAdaptor(getActivity(),routineCustomlists);
        listViewTuesdaytIT1.setAdapter(adaptor);


        return V;


    }

    private class RoutineAdaptor extends BaseAdapter {

        public ArrayList<RoutineCustomlist> data;
        LayoutInflater inflater;
        Context c;
        public RoutineAdaptor(Context context, ArrayList<RoutineCustomlist> routineList) {

            this.c=context;
            this.data=routineList;
            inflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view=convertView;
            if(view==null) {

                view = inflater.inflate(R.layout.single_row_routine, null);

                TextView txt2= (TextView) view.findViewById(R.id.teacherA);
                TextView txt1= (TextView)view. findViewById(R.id.subjectA);
                TextView txt3= (TextView) view.findViewById(R.id.roomA);
                TextView txt4= (TextView)view. findViewById(R.id.modeA);
                TextView txt5= (TextView)view. findViewById(R.id.time);

                TextView txt7= (TextView) view.findViewById(R.id.teacherB);
                TextView txt6= (TextView)view. findViewById(R.id.subjectB);
                TextView txt8= (TextView) view.findViewById(R.id.roomB);
                TextView txt9= (TextView)view. findViewById(R.id.modeB);


                String subjectA=data.get(position).getLectnameA();
                String teacherA=data.get(position).getTeachnameA();
                String roomA=data.get(position).getRoomnoA();
                String modeA=data.get(position).getModeA();
                String time=data.get(position).getTime();

                String subjectB=data.get(position).getLectnameB();
                String teacherB=data.get(position).getTeachnameB();
                String roomB=data.get(position).getRoomnoB();
                String modeB=data.get(position).getModeB();

                txt1.setText(subjectA);
                txt2.setText(teacherA);
                txt3.setText(roomA);
                txt4.setText(modeA);
                txt5.setText(time);

                txt6.setText(subjectB);
                txt7.setText(teacherB);
                txt8.setText(roomB);
                txt9.setText(modeB);


            }
            return view;
        }
    }

}
