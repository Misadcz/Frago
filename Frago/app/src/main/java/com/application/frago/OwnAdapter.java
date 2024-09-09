package com.application.frago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OwnAdapter extends BaseAdapter {

    Context context;
    String itemList[];
    int imageList[];
    LayoutInflater inflater;

    public OwnAdapter(Context ctx, String[] itemList, int[] imageList) {
        this.context = ctx;
        this.itemList = itemList;
        this.imageList = imageList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return itemList.length;
    }

    @Override
    public Object getItem(int i) {
        return itemList[i];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) // pokud neni pohled, priradim pohled k danemu XML
        {
            convertView = inflater.inflate(R.layout.activity_own_adapter, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.name);    // priradit promennou k elementu
        ImageView imageView = convertView.findViewById(R.id.icon);  // priradit promennou k elementu

        textView.setText(itemList[position]);   //nastaveni textu pro elemenet
        imageView.setImageResource(imageList[position]);    //nastaveni pro obrazek
        return convertView;
    }
}
