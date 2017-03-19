package com.example.developer.cropdiagnosis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.shared.CropImage;

import java.util.List;

import static com.example.developer.cropdiagnosis.R.id.image_crop_item;

/**
 * Created by clmiberf on 2017/3/9.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageCropView> {

    private Context mContext;
    private List<String> imageViewList;
    public ImageAdapter(Context context,List<String> list){
        this.mContext = context;
        this.imageViewList = list;
    }

    @Override
    public ImageCropView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_content_disease_image_item,parent,false);
        return new ImageCropView(view);
    }

    @Override
    public void onBindViewHolder(ImageCropView holder, int position) {
        String url = imageViewList.get(position);
        Glide.with(mContext)
                .load(url).diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.imageView);
        //设置图片的点击事件
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageViewList.size();
    }

    public static class ImageCropView extends  RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageCropView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.image_crop_item);
        }

    }
}
