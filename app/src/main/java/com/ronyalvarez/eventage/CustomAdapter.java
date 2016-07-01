package com.ronyalvarez.eventage; /**
 * Created by Thomas Croteau on 7/1/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ronyalvarez.eventage.MainScreenActivity;
import com.ronyalvarez.eventage.R;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainScreenActivity mainActivity, String[] prgmNameList, int[] prgmImages) {

        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return result.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.menu_layout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.menuText);
        holder.img=(ImageView) rowView.findViewById(R.id.menuImage);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Toast.makeText(context, "Gallery", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context, "Twitter", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent intentSettings = new Intent(context, SettingsActivity.class);
                        context.startActivity(intentSettings);
                        break;
                    case 4:
                        Intent intentLogin = new Intent(context, LoginActivity.class);
                        context.startActivity(intentLogin);

                        break;
                    default:
                        break;
                }

            }
        });
        return rowView;
    }

}