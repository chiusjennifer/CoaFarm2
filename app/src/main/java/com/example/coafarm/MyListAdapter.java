package com.example.coafarm;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView {
    public MyListAdapter(@NonNull Context context) {
        super(context);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvId,tvSub1,tvSub2,tvAvg;
        private ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvId = itemView.findViewById(R.id.tv);
        }
    }
}
