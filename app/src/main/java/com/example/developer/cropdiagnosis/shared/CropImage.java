package com.example.developer.cropdiagnosis.shared;

import android.widget.ImageView;

/**
 * Created by clmiberf on 2017/3/10.
 */

public class CropImage {
    private int cropImg;

    public CropImage(int cropImg) {
        this.cropImg = cropImg;
    }

    public int getCropImg() {
        return cropImg;
    }

    public void setCropImg(int cropImg) {
        this.cropImg = cropImg;
    }
}
