package com.shantanu.retrofitapp2.Module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetroPhoto {

    @SerializedName("cat_id")//albumId
    private Integer cat_id; //albumId;
    @SerializedName("cat_name")//title
    private String cat_name;//title
    @SerializedName("url")
    private String url;

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public List<RetroPhoto> getDatas() {
        return datas;
    }

    public void setDatas(List<RetroPhoto> datas) {
        this.datas = datas;
    }

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    List<RetroPhoto> datas;



   /* public RetroPhoto(Integer cat_id, String cat_name, String url, String thumbnailUrl)//Integer albumId, Integer id, String title, String url, String thumbnailUrl

    {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        //this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }*/


}

