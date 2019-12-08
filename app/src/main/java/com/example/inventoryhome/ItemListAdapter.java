package com.example.inventoryhome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ItemListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Item> itemList;

    public ItemListAdapter(Context context, int layout, ArrayList<Item> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice, txtDateOfPurchase, txtLocation, txtDescription;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.txtDateOfPurchase = (TextView) row.findViewById(R.id.txtDateOfPurchase);
            holder.txtLocation = (TextView) row.findViewById(R.id.txtLocation);
            holder.txtDescription = (TextView) row.findViewById(R.id.txtDescription);
            holder.imageView = (ImageView) row.findViewById(R.id.imgItem);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Item item = itemList.get(position);

        holder.txtName.setText(item.getName());
        holder.txtPrice.setText(item.getPrice());
        holder.txtDateOfPurchase.setText(item.getDateOfPurchase());
        holder.txtLocation.setText(item.getLocation());
        holder.txtDescription.setText(item.getDescription());

        byte[] itemImage = item.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(itemImage, 0, itemImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
