package com.example.developer.cropdiagnosis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.ui.component.SingleDiseaseItemView;

import java.util.List;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseListAdapter extends RecyclerView.Adapter<DiseaseListAdapter.DiseaseHolder> {
    private Context context;
    private List<DiseaseModelBean> datas;




    private DiseaseListAdapter.OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public DiseaseListAdapter(Context context, List<DiseaseModelBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public DiseaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SingleDiseaseItemView view = new SingleDiseaseItemView(context);
        return new DiseaseHolder(view);
    }

    @Override
    public void onBindViewHolder(DiseaseHolder holder, int position) {
        holder.singleItemView.setCropText(datas.get(position).getCrop());
        holder.singleItemView.setDateText(datas.get(position).getSubmitTime());
        holder.singleItemView.setStatusText(datas.get(position).getDiseaseStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null)
                {
                    int pos = holder.getLayoutPosition();
                    clickListener.onItemClick(holder.itemView,pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (clickListener != null)
                {
                    int pos = holder.getLayoutPosition();
                    clickListener.onItemLongClick(holder.itemView,pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class DiseaseHolder extends RecyclerView.ViewHolder  {
        public SingleDiseaseItemView singleItemView;

        public DiseaseHolder(SingleDiseaseItemView itemView) {
            super(itemView);
            singleItemView = itemView;
        }
    }
}
