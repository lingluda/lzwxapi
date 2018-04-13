package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

public class Cities {
    /**
    * null
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="null",dataType="String")
    private String id;

    /**
    * null
    * 字段名:CITYID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="cityid",value="null",dataType="String")
    private String cityid;

    /**
    * null
    * 字段名:CITY
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="city",value="null",dataType="String")
    private String city;

    /**
    * null
    * 字段名:PROVINCEID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="provinceid",value="null",dataType="String")
    private String provinceid;

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

    /**
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return PROVINCEID
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * @param provinceid
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }
}