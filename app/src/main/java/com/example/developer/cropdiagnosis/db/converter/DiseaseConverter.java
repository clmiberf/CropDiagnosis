package com.example.developer.cropdiagnosis.db.converter;

import com.example.developer.cropdiagnosis.db.DbConstants;
import com.example.developer.cropdiagnosis.db.tables.DiseaseSample;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;

import java.util.List;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseConverter {
    public List<DiseaseModelBean> toModels(List<DiseaseSample> entities) {
        return null;
    }

    public List<DiseaseSample> toEntities(List<DiseaseModelBean> models) {
        return null;
    }

    public DiseaseSample toEntity(DiseaseModelBean model) {
        DiseaseSample sample = new DiseaseSample();
        sample.setCrop(model.getCrop());
        sample.setSubmitTime(model.getSubmitTime());
        sample.setDiagnosedState(model.getDiseaseStatus() == DbConstants.DiagnosedStatus.DIAGNOSED ? DbConstants.DiagnosedStatus.DIAGNOSED : DbConstants.DiagnosedStatus.NOT_DIAGNOSED);
        sample.setDescription(model.getDescription());
        sample.setDiseaseName(model.getDiseaseName());
        sample.setSolution(model.getSolution());
        sample.setSolveTime(model.getSolveTime());
        sample.setAcceptExpertName(model.getAcceptExpertName());
        switch (model.getCommentType()) {
            case DbConstants.CommentType.NORMAL:
                sample.setCommentType(DbConstants.CommentType.NORMAL);
                break;
            case DbConstants.CommentType.VERY_GOOD:
                sample.setCommentType(DbConstants.CommentType.VERY_GOOD);
                break;
            case DbConstants.CommentType.GOOD:
                sample.setCommentType(DbConstants.CommentType.GOOD);
                break;
            case DbConstants.CommentType.BAD:
                sample.setCommentType(DbConstants.CommentType.BAD);
                break;
        }
        sample.setCommentDetails(model.getCommentDetails());
        sample.setHasCommented(model.isHasCommented());
        return sample;
    }

    public DiseaseModelBean toModel(DiseaseSample entity) {
        return null;
    }
}
