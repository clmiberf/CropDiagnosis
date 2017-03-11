package com.example.developer.cropdiagnosis.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.shared.CropImage;

import java.util.List;

import static com.example.developer.cropdiagnosis.R.id.image_crop_item;

/**
 * Created by clmiberf on 2017/3/9.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageCropView> {

    private List<CropImage> imageViewList;
    public ImageAdapter(List<CropImage> list){
        this.imageViewList = list;
    }

    @Override
    public ImageAdapter.ImageCropView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_content_disease_image_item,parent,false);
        return new ImageCropView(view);
    }

    @Override
    public void onBindViewHolder(ImageCropView holder, int position) {
        holder.imageView.setImageResource(imageViewList.get(position).getCropImg());

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
