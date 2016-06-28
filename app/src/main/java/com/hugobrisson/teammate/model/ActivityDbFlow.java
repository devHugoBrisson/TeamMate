package com.hugobrisson.teammate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hugobrisson.teammate.BuildConfig;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
/*
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/*
@Table(databaseName = BuildConfig.database_name,
        tableName = TMConstantKey.DB_ACTIVITY)
@ModelContainer*/
public class ActivityDbFlow  {

   /* public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_START_DATE = "startDate";
    public static final String COLUMN_END_DATE = "endDate";
    public static final String COLUMN_MAX_MATERS = "maxMaters";
    public static final String COLUMN_CURRENT_MATERS = "currentMaters";
    public static final String COLUMN_IS_FREE = "isFree";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_OWNER = "owner";
    public static final String COLUMN_SPORT = "sport";

    @PrimaryKey
    @Column(name = COLUMN_ID)
    public String id;

    @Column(name = COLUMN_NAME)
    private String name;


    @Column(name = COLUMN_DESC)
    private String description;

    @Column(name = COLUMN_ADDRESS)
    private String address;

    @Column(name = COLUMN_LATITUDE)
    private double latitude;

    @Column(name = COLUMN_LONGITUDE)
    private double longitude;

    @Column(name = COLUMN_START_DATE)
    private Date startDate;

    @Column(name = COLUMN_END_DATE)
    private Date endDate;

    @Column(name = COLUMN_MAX_MATERS)
    private int maxMaters;

    @Column(name = COLUMN_CURRENT_MATERS)
    private int currentMaters;

    @Column(name = COLUMN_IS_FREE)
    private boolean isFree;

    @Column(name = COLUMN_PRICE)
    private double price;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_OWNER,
            columnType = String.class, foreignColumnName = User.COLUMN_ID)}, saveForeignKeyModel = true)
    private User owner;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_SPORT,
            columnType = String.class, foreignColumnName = Sport.COLUMN_ID)}, saveForeignKeyModel = true)
    private Sport sport;


    public ActivityDbFlow() {
    }

    public ActivityDbFlow(String sName) {
        name = sName;
    }

    protected ActivityDbFlow(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        address = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        startDate = (Date) in.readSerializable();
        endDate = (Date) in.readSerializable();
        maxMaters = in.readInt();
        currentMaters = in.readInt();
        isFree = in.readByte() != 0;
        price = in.readDouble();
        owner = (User) in.readParcelable(User.class.getClassLoader());
        sport = (Sport) in.readParcelable(Sport.class.getClassLoader());
    }

    public static final Creator<ActivityDbFlow> CREATOR = new Creator<ActivityDbFlow>() {
        @Override
        public ActivityDbFlow createFromParcel(Parcel in) {
            return new ActivityDbFlow(in);
        }

        @Override
        public ActivityDbFlow[] newArray(int size) {
            return new ActivityDbFlow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeSerializable(startDate);
        dest.writeSerializable(endDate);
        dest.writeInt(maxMaters);
        dest.writeInt(currentMaters);
        dest.writeByte((byte) (isFree ? 1 : 0));
        dest.writeDouble(price);
        dest.writeParcelable(owner, flags);
        dest.writeParcelable(sport, flags);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMaxMaters() {
        return maxMaters;
    }

    public void setMaxMaters(int maxMaters) {
        this.maxMaters = maxMaters;
    }

    public int getCurrentMaters() {
        return currentMaters;
    }

    public void setCurrentMaters(int currentMaters) {
        this.currentMaters = currentMaters;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean free) {
        isFree = free;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }*/
}
