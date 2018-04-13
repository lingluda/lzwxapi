package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

public class Provinces {
    /**
    * null
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="null",dataType="String")
    private String id;

    /**
    * null
    * 字段名:PROVINCEID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="provinceid",value="null",dataType="String")
    private String provinceid;

    /**
    * null
    * 字段名:PROVINCE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="province",value="null",dataType="String")
    private String province;

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

    /**
     * @return PROVINCE
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}