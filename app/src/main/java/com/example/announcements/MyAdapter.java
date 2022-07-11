package com.example.announcements;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder > {
    Context context;
    ArrayList<info> list;
    public MyAdapter(Context context, ArrayList<info> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.information,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        info infor= list.get(position);
         holder.headline.setText(infor.getHdl());
         holder.link.setText(infor.getLnk());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView headline, link;

        public MyViewHolder(View itemView) {
            super(itemView);
            headline = itemView.findViewById(R.id.hdl);
            link = itemView.findViewById(R.id.lnnk);
        }
    }

}
