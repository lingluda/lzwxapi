package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

public class Area {
    /**
    * null
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="null",dataType="String")
    private String id;

    /**
    * null
    * 字段名:AREAID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="areaid",value="null",dataType="String")
    private String areaid;

    /**
    * null
    * 字段名:AREA
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="area",value="null",dataType="String")
    private String area;

    /**
    * null
    * 字段名:CITYID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="cityid",value="null",dataType="String")
    private String cityid;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return AREAID
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * @param areaid
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    /**
     * @return AREA
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * @return CITYID
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * @param cityid
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }
}