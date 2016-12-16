package com.example.developer.cropdiagnosis.db.tables;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Developer on 16-12-15.
 */

@Entity(nameInDb = "user")
class User {

    @Id
    private Long id;

    @NotNull
    private String phoneNumber;

    /**
     * 用户账号密码
     */
    @NotNull
    private String password;

    /**
     * 用户所在省
     */
    @NotNull
    private String province;

    /**
     * 用户所在市
     */
    @NotNull
    private String city;

    /**
     * 用户所在县
     */
    @NotNull
    private String county;

    /**
     * 用户所在村
     */
    @NotNull
    private String village;

    /**
     * 用户关注的作物
     */
    @ToMany(referencedJoinProperty = "userId")
    private List<Crop> crops;

    private Long cropId;

    /**
     * 用户的邮箱
     */
    private String email;

    /**
     * 用户类型 “公司”还是“个人”
     */
    @NotNull
    private int userType;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 186222595)
    public User(Long id, @NotNull String phoneNumber, @NotNull String password,
            @NotNull String province, @NotNull String city, @NotNull String county,
            @NotNull String village, Long cropId, String email, int userType) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.province = province;
        this.city = city;
        this.county = county;
        this.village = village;
        this.cropId = cropId;
        this.email = email;
        this.userType = userType;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getVillage() {
        return this.village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Long getCropId() {
        return this.cropId;
    }

    public void setCropId(Long cropId) {
        this.cropId = cropId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 723428058)
    public List<Crop> getCrops() {
        if (crops == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CropDao targetDao = daoSession.getCropDao();
            List<Crop> cropsNew = targetDao._queryUser_Crops(id);
            synchronized (this) {
                if (crops == null) {
                    crops = cropsNew;
                }
            }
        }
        return crops;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1573027743)
    public synchronized void resetCrops() {
        crops = null;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
