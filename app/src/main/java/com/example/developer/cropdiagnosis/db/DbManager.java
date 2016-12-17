package com.example.developer.cropdiagnosis.db;

import android.content.Context;

import com.example.developer.cropdiagnosis.db.converter.DiseaseConverter;
import com.example.developer.cropdiagnosis.db.tables.DaoMaster;
import com.example.developer.cropdiagnosis.db.tables.DaoSession;
import com.example.developer.cropdiagnosis.db.tables.DiseaseSample;
import com.example.developer.cropdiagnosis.db.tables.DiseaseSampleDao;
import com.example.developer.cropdiagnosis.model.beans.DiseaseModelBean;

import java.util.List;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class DbManager {

    private DaoMaster.DevOpenHelper devOpenHelper = null;

    public DbManager(Context context) {
        devOpenHelper = new DaoMaster.DevOpenHelper(context, DbConstants.DB_NAME);
    }

    public boolean saveDiseaseHistory(List<DiseaseModelBean> entities) {
        DiseaseConverter converter = new DiseaseConverter();
        DaoSession daoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
        DiseaseSampleDao diseaseSampleDao = daoSession.getDiseaseSampleDao();
        diseaseSampleDao.saveInTx(converter.toEntities(entities));
        return true;
    }

    public List<DiseaseModelBean> queryDiseaseHistory() {
        DiseaseConverter converter = new DiseaseConverter();
        DaoSession daoSession = new DaoMaster(devOpenHelper.getReadableDatabase()).newSession();
        DiseaseSampleDao diseaseSampleDao = daoSession.getDiseaseSampleDao();
        List<DiseaseSample> list = diseaseSampleDao.queryBuilder().build().forCurrentThread().list();
        return converter.toModels(list);
    }
}
