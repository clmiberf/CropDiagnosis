package com.example.developer.cropdiagnosis.model.beans;

import java.util.Date;
import java.util.List;

/**
 * Created by Developer on 16-12-14.
 */


public class DiseaseModelBean {

    private long id;

    /**
     * 作物
     */
    private String crop;

    /**
     * 提交日期
     */
    private Date submitTime;

    /**
     * 病例状态：以诊断，未诊断
     */
    private int diseaseStatus;

    /**
     * 图片路径
     */
    private List<String> imageUrl;

    /**
     * 病例描述
     */
    private String description;

    /**
     * 病例名字
     */
    private String diseaseName;

    /**
     * 病例原因
     */
    private String diseaseReason;

    /**
     * 解决办法
     */
    private String solution;

    /**
     * 解决时间
     */
    private Date solveTime;

    /**
     * 诊断专家名字
     */
    private String acceptExpertName;

    /**
     * 评论类型：非常好，好，一般，不好
     */
    private int commentType;

    /**
     * 用户的具体评论内容
     */
    private String commentDetails;

    /**
     * 用户是否评论
     */
    private boolean hasCommented;

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getDiseaseStatus() {
        return diseaseStatus;
    }

    public void setDiseaseStatus(int diseaseStatus) {
        this.diseaseStatus = diseaseStatus;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseReason() {
        return diseaseReason;
    }

    public void setDiseaseReason(String diseaseReason) {
        this.diseaseReason = diseaseReason;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    public String getAcceptExpertName() {
        return acceptExpertName;
    }

    public void setAcceptExpertName(String acceptExpertName) {
        this.acceptExpertName = acceptExpertName;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public String getCommentDetails() {
        return commentDetails;
    }

    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
    }

    public boolean isHasCommented() {
        return hasCommented;
    }

    public void setHasCommented(boolean hasCommented) {
        this.hasCommented = hasCommented;
    }
}
