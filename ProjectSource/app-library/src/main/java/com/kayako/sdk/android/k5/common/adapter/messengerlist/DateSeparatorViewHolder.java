package com.kayako.sdk.android.k5.common.adapter.messengerlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kayako.sdk.android.k5.R;

public class DateSeparatorViewHolder extends RecyclerView.ViewHolder {
    TextView time;

    public DateSeparatorViewHolder(View itemView) {
        super(itemView);
        time = (TextView) itemView.findViewById(R.id.time);
    }
}