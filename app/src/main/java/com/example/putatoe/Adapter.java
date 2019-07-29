package com.example.putatoe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Item> items;
    ImageLoader imageLoader=AppController.getmInstance().getmImageLoader();
    public  Adapter(Activity activity,List<Item> items){
        this.activity=activity;
        this.items=items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){

            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if(convertView==null){

            convertView = inflater.inflate(R.layout.custom_layout,null);
        }
        if(imageLoader==null){
            imageLoader=AppController.getmInstance().getmImageLoader();
            NetworkImageView imageView=convertView.findViewById(R.id.image_view);
            TextView name=convertView.findViewById(R.id.cus_name);
            TextView id=convertView.findViewById(R.id.cus_id);
            TextView discount=convertView.findViewById(R.id.tot_discount);
            TextView supportMultipleProductPurchase=convertView.findViewById(R.id.multi_pro);


            Item item=items.get(position);

            imageView.setImageUrl(item.getImage(),imageLoader);
            name.setText(item.getName());
            id.setText(String.valueOf(item.getId()));
            String s1=String.valueOf(item.isSupportMultipleProductPurchase());
            supportMultipleProductPurchase.setText(s1);
            discount.setText(String.valueOf(item.getDiscount()));



        }

        return convertView;
    }
}
