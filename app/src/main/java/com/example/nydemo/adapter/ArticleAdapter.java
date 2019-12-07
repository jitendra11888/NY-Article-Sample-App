package com.example.nydemo.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.nydemo.R;
import com.example.nydemo.model.Result;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private OnItemClickListener listener;
    private List<Result> items;
    private int itemLayout;

    public interface OnItemClickListener {
        void onItemClick(Result result);
    }

    public ArticleAdapter(List<Result> items, int itemLayout, OnItemClickListener listener) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.listener = listener;
    }
    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }
    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        final Result item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvSubtitle.setText(item.getByline());
        holder.tvName.setText(item.getSource());
        holder.tvDate.setText(item.getPublishedDate());
        holder.itemView.setTag(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(item);
            }
        });
    }
    @Override public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvSubtitle, tvName, tvDate;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvSubtitle = (TextView) itemView.findViewById(R.id.tv_sub_title);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);


        }
    }

}
