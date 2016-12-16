package com.example.developer.cropdiagnosis.db.tables;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Developer on 16-12-15.
 */

@Entity(nameInDb = "diseaseSample")
public class DiseaseSample {
    @Id
    private Long id;

    /**
     * 作物
     */
    @NotNull
    private String crop;

    /**
     * 提交日期
     */
    @NotNull
    private Date submitTime;

    /**
     * 病例状态：以诊断，未诊断
     */
    @NotNull
    private int diagnosedState;

    /**
     * 图片路径
     */
    @ToMany(referencedJoinProperty = "diseaseSampleId")
    @OrderBy("id ASC")
    private List<Images> images;

    /**
     * 病例描述
     */
    @NotNull
    private String description;

    /**
     * 病例名字
     */
    @NotNull
    private String diseaseName;

    /**
     * 病例原因
     */
    @NotNull
    private String diseaseReason;

    /**
     * 解决办法
     */
    @NotNull
    private String solution;

    /**
     * 解决时间
     */
    @NotNull
    private Date solveTime;

    /**
     * 诊断专家名字
     */
    @NotNull
    private String acceptExpertName;

    /**
     * 评论类型：非常好，好，一般，不好
     */
    @NotNull
    private int commentType;

    /**
     * 用户的具体评论内容
     */
    @NotNull
    private String commentDetails;

    /**
     * 用户是否评论
     */
    @NotNull
    private boolean hasCommented;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 579926293)
    private transient DiseaseSampleDao myDao;

    @Generated(hash = 770098471)
    public DiseaseSample(Long id, @NotNull String crop, @NotNull Date submitTime,
            int diagnosedState, @NotNull String description,
            @NotNull String diseaseName, @NotNull String diseaseReason,
            @NotNull String solution, @NotNull Date solveTime,
            @NotNull String acceptExpertName, int commentType,
            @NotNull String commentDetails, boolean hasCommented) {
        this.id = id;
        this.crop = crop;
        this.submitTime = submitTime;
        this.diagnosedState = diagnosedState;
        this.description = description;
        this.diseaseName = diseaseName;
        this.diseaseReason = diseaseReason;
        this.solution = solution;
        this.solveTime = solveTime;
        this.acceptExpertName = acceptExpertName;
        this.commentType = commentType;
        this.commentDetails = commentDetails;
        this.hasCommented = hasCommented;
    }

    @Generated(hash = 1562696706)
    public DiseaseSample() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrop() {
        return this.crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Date getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getDiagnosedState() {
        return this.diagnosedState;
    }

    public void setDiagnosedState(int diagnosedState) {
        this.diagnosedState = diagnosedState;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseReason() {
        return this.diseaseReason;
    }

    public void setDiseaseReason(String diseaseReason) {
        this.diseaseReason = diseaseReason;
    }

    public String getSolution() {
        return this.solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getSolveTime() {
        return this.solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    public String getAcceptExpertName() {
        return this.acceptExpertName;
    }

    public void setAcceptExpertName(String acceptExpertName) {
        this.acceptExpertName = acceptExpertName;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public String getCommentDetails() {
        return this.commentDetails;
    }

    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
    }

    public boolean getHasCommented() {
        return this.hasCommented;
    }

    public void setHasCommented(boolean hasCommented) {
        this.hasCommented = hasCommented;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 181550828)
    public List<Images> getImages() {
        if (images == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ImagesDao targetDao = daoSession.getImagesDao();
            List<Images> imagesNew = targetDao._queryDiseaseSample_Images(id);
            synchronized (this) {
                if (images == null) {
                    images = imagesNew;
                }
            }
        }
        return images;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 604059028)
    public synchronized void resetImages() {
        images = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 510305847)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDiseaseSampleDao() : null;
    }
}
