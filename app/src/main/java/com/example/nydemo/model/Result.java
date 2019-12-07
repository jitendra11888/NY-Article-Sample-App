package com.example.nydemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Result implements Parcelable {
    @SerializedName("url")
    private String url;
    @SerializedName("adx_keywords")
    private String adxKeywords;
    @SerializedName("column")
    private String column;
    @SerializedName("section")
    private String section;
    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String abstracts;
    @SerializedName("published_date")
    private String publishedDate;
    @SerializedName("source")
    private String source;
    @SerializedName("id")
    private String id;
    @SerializedName("asset_id")
    private String assetId;
    @SerializedName("views")
    private String views;
//    @SerializedName("des_facet")
//    private ArrayList<Object> desFacet;
//    @SerializedName("org_facet")
//    private ArrayList<Object> orgFacet;
//    @SerializedName("per_facet")
//    private ArrayList<Object> perFacet;
//    @SerializedName("geo_facet")
    private ArrayList<Object> geoFacet;
    @SerializedName("media")
    private ArrayList<Media> media;
    @SerializedName("uri")
    private String uri;


    protected Result(Parcel in) {
        url = in.readString();
        adxKeywords = in.readString();
        column = in.readString();
        section = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        abstracts = in.readString();
        publishedDate = in.readString();
        source = in.readString();
        id = in.readString();
        assetId = in.readString();
        views = in.readString();
        media = in.createTypedArrayList(Media.CREATOR);
        uri = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

//    public ArrayList<Object> getDesFacet() {
//        return desFacet;
//    }
//
//    public void setDesFacet(ArrayList<Object> desFacet) {
//        this.desFacet = desFacet;
//    }
//
//    public ArrayList<Object> getOrgFacet() {
//        return orgFacet;
//    }
//
//    public void setOrgFacet(ArrayList<Object> orgFacet) {
//        this.orgFacet = orgFacet;
//    }
//
//    public ArrayList<Object> getPerFacet() {
//        return perFacet;
//    }
//
//    public void setPerFacet(ArrayList<Object> perFacet) {
//        this.perFacet = perFacet;
//    }

    public ArrayList<Object> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(ArrayList<Object> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(adxKeywords);
        parcel.writeString(column);
        parcel.writeString(section);
        parcel.writeString(byline);
        parcel.writeString(type);
        parcel.writeString(title);
        parcel.writeString(abstracts);
        parcel.writeString(publishedDate);
        parcel.writeString(source);
        parcel.writeString(id);
        parcel.writeString(assetId);
        parcel.writeString(views);
        parcel.writeTypedList(media);
        parcel.writeString(uri);
    }
}
