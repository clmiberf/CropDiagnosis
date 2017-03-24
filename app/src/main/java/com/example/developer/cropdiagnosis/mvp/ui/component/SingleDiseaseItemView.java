package com.example.developer.cropdiagnosis.mvp.ui.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.db.DbConstants;

import java.util.Date;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class SingleDiseaseItemView extends FrameLayout {

    private TextView tvCrop;
    private TextView tvDate;
    private TextView tvStatus;
    private TextView tvSummary;
    private ImageView imageView;

    public SingleDiseaseItemView(Context context) {
        super(context);
        initView(context);
    }

    public SingleDiseaseItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleDiseaseItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SingleDiseaseItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_disease_item, this, true);

        tvCrop = (TextView) view.findViewById(R.id.tv_crop_disease_item);
        tvDate = (TextView) view.findViewById(R.id.tv_date_disease_item);
        tvStatus = (TextView) view.findViewById(R.id.tv_status_disease_item);
        tvSummary = (TextView) view.findViewById(R.id.tv_summary_disease_item);
        imageView = (ImageView) view.findViewById(R.id.image_view);
    }

    public void setStatusText(int status) {
        tvStatus.setText(status == DbConstants.DiagnosedStatus.DIAGNOSED ? getContext().getResources().getText(R.string.diagnosed) : getContext().getResources().getText(R.string.not_diagnosed));
    }

    public void setDateText(Date date) {
        String dateBuilder = String.valueOf(date.getYear() + 1900) + " " +
                date.getMonth() + " " +
                (date.getDay() + 11);
        tvDate.setText(dateBuilder);
    }

    public void setCropText(String cropText) {
        this.tvCrop.setText(cropText);
    }

    public void setSummaryText(String summary) {
        this.tvSummary.setText(summary);
    }

    public void setImageView(String imageUrl, Context context) {
        Glide.with(context)
                .load(imageUrl)
                .into(imageView);
    }
}
