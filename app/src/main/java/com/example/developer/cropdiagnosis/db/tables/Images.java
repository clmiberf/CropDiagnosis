package com.example.developer.cropdiagnosis.db.tables;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

@Entity(nameInDb = "images")
class Images {
    @Id
    private Long id;

    @NotNull
    private String imageUrl;

    private Long diseaseSampleId;

    @Generated(hash = 461852227)
    public Images(Long id, @NotNull String imageUrl, Long diseaseSampleId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.diseaseSampleId = diseaseSampleId;
    }

    @Generated(hash = 1787213703)
    public Images() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getDiseaseSampleId() {
        return this.diseaseSampleId;
    }

    public void setDiseaseSampleId(Long diseaseSampleId) {
        this.diseaseSampleId = diseaseSampleId;
    }
}
