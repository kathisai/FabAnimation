package io.com.uitask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import io.com.uitask.R;
import io.com.uitask.models.Reminder;

/**
 * Created by skathi on 3/8/2018.
 */

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Reminder> mList;
    private Context mContext;

    public ShopAdapter(List<Reminder> list, Context mContext) {
        this.mList = list;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new ShopViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Reminder shop = mList.get(position);

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class ShopViewHolder extends RecyclerView.ViewHolder {


        public ShopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
