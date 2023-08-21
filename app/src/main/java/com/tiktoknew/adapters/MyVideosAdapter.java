package com.tiktoknew.adapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.tiktoknew.Constants;
import com.tiktoknew.models.HomeModel;
import com.tiktoknew.R;
import com.tiktoknew.interfaces.AdapterClickListener;
import com.tiktoknew.simpleclasses.Functions;

import java.util.ArrayList;


/**
 * Created by qboxus on 3/20/2018.
 */

public class MyVideosAdapter extends RecyclerView.Adapter<MyVideosAdapter.CustomViewHolder> {


    public Context context;
    private ArrayList<HomeModel> dataList;
    String whereFrom;
    AdapterClickListener adapterClickListener;

    public MyVideosAdapter(Context context, ArrayList<HomeModel> dataList,String whereFrom, AdapterClickListener adapterClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.whereFrom=whereFrom;
        this.adapterClickListener = adapterClickListener;
    }

    @Override
    public MyVideosAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewtype) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_myvideo_layout, viewGroup,false);
        return new CustomViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView thumbImage;
        TextView viewTxt;
        LinearLayout tabPinned;

        public CustomViewHolder(View view) {
            super(view);
            tabPinned=view.findViewById(R.id.tabPinned);
            thumbImage = view.findViewById(R.id.thumb_image);
            viewTxt = view.findViewById(R.id.view_txt);

        }

        public void bind(final int position, final HomeModel item, final AdapterClickListener listener) {
            itemView.setOnClickListener(v -> {
                listener.onItemClick(v, position, item);

            });

        }

    }


    @Override
    public void onBindViewHolder(final MyVideosAdapter.CustomViewHolder holder, final int i) {
        final HomeModel item = dataList.get(i);

        try {

            if (Constants.IS_SHOW_GIF) {

                holder.thumbImage.setController(Functions.frescoImageLoad(item.gif,holder.thumbImage,true));


            } else {
                if (item.thum != null && !item.thum.equals("")) {

                    holder.thumbImage.setController(Functions.frescoImageLoad(item.thum,holder.thumbImage,false));

                }
            }
        } catch (Exception e) {
            Functions.printLog(Constants.tag, e.toString());
        }

        if (whereFrom.equals("myProfile"))
        {
            if (item.pin.equals("1"))
            {
                holder.tabPinned.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.tabPinned.setVisibility(View.GONE);
            }
        }
        else
        {
            holder.tabPinned.setVisibility(View.GONE);
        }


        holder.viewTxt.setText(item.views);
        holder.viewTxt.setText(Functions.getSuffix(item.views));


        holder.bind(i, item, adapterClickListener);

    }



}