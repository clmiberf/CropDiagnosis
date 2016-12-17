package com.example.developer.cropdiagnosis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.developer.cropdiagnosis.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.view.SingleDiseaseItemView;

import java.util.List;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseListAdapter extends RecyclerView.Adapter<DiseaseListAdapter.DiseaseHolder> {
    private Context context;
    private List<DiseaseModelBean> datas;

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
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class DiseaseHolder extends RecyclerView.ViewHolder {
        public SingleDiseaseItemView singleItemView;

        public DiseaseHolder(SingleDiseaseItemView itemView) {
            super(itemView);
            singleItemView = itemView;
        }
    }
}
