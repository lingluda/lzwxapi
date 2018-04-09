package com.maiyue.weixin.bean;

import java.io.Serializable;

public class BaseConfig extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5355500217140769170L;

	/**
    * Id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 配置名称
    * 字段名:CONFIG_NAME
    * 类型:VARCHAR
     */
    private String configName;

    /**
    * 配置值
    * 字段名:CONFIG_VALUE
    * 类型:VARCHAR
     */
    private String configValue;

    /**
    * 值类型
    * 字段名:CONFIG_TYPE
    * 类型:VARCHAR
     */
    private String configType;

    /**
    * 配置状态
    * 字段名:CONFIG_STATE
    * 类型:VARCHAR
     */
    private String configState;

    /**
     * Id标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Id标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 配置名称
     * @return CONFIG_NAME
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 配置名称
     * @param configName
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    /**
     * 配置值
     * @return CONFIG_VALUE
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 配置值
     * @param configValue
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    /**
     * 值类型
     * @return CONFIG_TYPE
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 值类型
     * @param configType
     */
    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    /**
     * 配置状态
     * @return CONFIG_STATE
     */
    public String getConfigState() {
        return configState;
    }

    /**
     * 配置状态
     * @param configState
     */
    public void setConfigState(String configState) {
        this.configState = configState == null ? null : configState.trim();
    }
}