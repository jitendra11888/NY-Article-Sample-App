package com.example.nydemo.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Media implements Parcelable{
    @SerializedName("type")
    private String type;
    @SerializedName("subtype")
    private String subtype;
    @SerializedName("caption")
    private String caption;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("approved_for_syndication")
    private String approvedForSyndication;
    @SerializedName("media-metadata")
    private ArrayList<MediaMetaData> mediaMetadata;


    protected Media(Parcel in) {
        type = in.readString();
        subtype = in.readString();
        caption = in.readString();
        copyright = in.readString();
        approvedForSyndication = in.readString();
        mediaMetadata = in.createTypedArrayList(MediaMetaData.CREATOR);
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(String approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public ArrayList<MediaMetaData> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(ArrayList<MediaMetaData> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(subtype);
        parcel.writeString(caption);
        parcel.writeString(copyright);
        parcel.writeString(approvedForSyndication);
        parcel.writeTypedList(mediaMetadata);
    }
}
