package com.maiyue.weixin.business.bean;

import java.io.Serializable;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModelProperty;

public class Student extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1533722906864471531L;

	/**
    * 学生表ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="学生表ID",dataType="String")
    private String id;

    /**
    * 学号
    * 字段名:SNO
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="sno",value="学号",dataType="String")
    private String sno;

    /**
    * 姓名
    * 字段名:NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="name",value="姓名",dataType="String")
    private String name;

    /**
    * 性别0女 1男
    * 字段名:SEX
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="sex",value="性别0女 1男",dataType="String")
    private String sex;

    /**
    * 出生日期
    * 字段名:BIRTHDAY
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="birthday",value="出生日期",dataType="String")
    private String birthday;

    /**
    * 民族代码
    * 字段名:NATION_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="nationCode",value="民族代码",dataType="String")
    private String nationCode;

    /**
    * 身份证号
    * 字段名:IDEN_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="idenId",value="身份证号",dataType="String")
    private String idenId;

    /**
    * 籍贯代码
    * 字段名:NATIVE_PLACE_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="nativePlaceId",value="籍贯代码",dataType="String")
    private String nativePlaceId;

    /**
    * 地区(国家)代码
    * 字段名:AREA_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="areaId",value="地区(国家)代码",dataType="String")
    private String areaId;

    /**
    * 政治面貌代码
    * 字段名:POLITICAL_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="politicalId",value="政治面貌代码",dataType="String")
    private String politicalId;

    /**
    * 院系代码
    * 字段名:COLLEGE_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="collegeId",value="院系代码",dataType="String")
    private String collegeId;

    /**
    * 专业代码
    * 字段名:MAJOR_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="majorId",value="专业代码",dataType="String")
    private String majorId;

    /**
    * 入学年级
    * 字段名:ENTRANCE_GRADE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="entranceGrade",value="入学年级",dataType="String")
    private String entranceGrade;

    /**
    * 班级名称
    * 字段名:CLASSNAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classname",value="班级名称",dataType="String")
    private String classname;

    /**
    * 家庭地址
    * 字段名:ADRESS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="adress",value="家庭地址",dataType="String")
    private String adress;

    /**
    * 电话号码
    * 字段名:PHONE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="phone",value="电话号码",dataType="String")
    private String phone;

    /**
    * 邮箱
    * 字段名:EMAIL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="email",value="邮箱",dataType="String")
    private String email;

    /**
    * 辅导员ID
    * 字段名:INSTRUCTOR_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="instructorId",value="辅导员ID",dataType="String")
    private String instructorId;

    /**
    * 一卡通号
    * 字段名:ONE_CARD
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="oneCard",value="一卡通号",dataType="String")
    private String oneCard;

    /**
    * 银行卡号
    * 字段名:BANK_ACCOUNT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="bankAccount",value="银行卡号",dataType="String")
    private String bankAccount;

    /**
    * 头像图片
    * 字段名:IMAGE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="image",value="头像图片",dataType="String")
    private String image;

    /**
     * 学生表ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 学生表ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 学号
     * @return SNO
     */
    public String getSno() {
        return sno;
    }

    /**
     * 学号
     * @param sno
     */
    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    /**
     * 姓名
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别0女 1男
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别0女 1男
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 出生日期
     * @return BIRTHDAY
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 民族代码
     * @return NATION_CODE
     */
    public String getNationCode() {
        return nationCode;
    }

    /**
     * 民族代码
     * @param nationCode
     */
    public void setNationCode(String nationCode) {
        this.nationCode = nationCode == null ? null : nationCode.trim();
    }

    /**
     * 身份证号
     * @return IDEN_ID
     */
    public String getIdenId() {
        return idenId;
    }

    /**
     * 身份证号
     * @param idenId
     */
    public void setIdenId(String idenId) {
        this.idenId = idenId == null ? null : idenId.trim();
    }

    /**
     * 籍贯代码
     * @return NATIVE_PLACE_ID
     */
    public String getNativePlaceId() {
        return nativePlaceId;
    }

    /**
     * 籍贯代码
     * @param nativePlaceId
     */
    public void setNativePlaceId(String nativePlaceId) {
        this.nativePlaceId = nativePlaceId == null ? null : nativePlaceId.trim();
    }

    /**
     * 地区(国家)代码
     * @return AREA_ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 地区(国家)代码
     * @param areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * 政治面貌代码
     * @return POLITICAL_ID
     */
    public String getPoliticalId() {
        return politicalId;
    }

    /**
     * 政治面貌代码
     * @param politicalId
     */
    public void setPoliticalId(String politicalId) {
        this.politicalId = politicalId == null ? null : politicalId.trim();
    }

    /**
     * 院系代码
     * @return COLLEGE_ID
     */
    public String getCollegeId() {
        return collegeId;
    }

    /**
     * 院系代码
     * @param collegeId
     */
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    /**
     * 专业代码
     * @return MAJOR_ID
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 专业代码
     * @param majorId
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    /**
     * 入学年级
     * @return ENTRANCE_GRADE
     */
    public String getEntranceGrade() {
        return entranceGrade;
    }

    /**
     * 入学年级
     * @param entranceGrade
     */
    public void setEntranceGrade(String entranceGrade) {
        this.entranceGrade = entranceGrade == null ? null : entranceGrade.trim();
    }

    /**
     * 班级名称
     * @return CLASSNAME
     */
    public String getClassname() {
        return classname;
    }

    /**
     * 班级名称
     * @param classname
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * 家庭地址
     * @return ADRESS
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 家庭地址
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    /**
     * 电话号码
     * @return PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话号码
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮箱
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 辅导员ID
     * @return INSTRUCTOR_ID
     */
    public String getInstructorId() {
        return instructorId;
    }

    /**
     * 辅导员ID
     * @param instructorId
     */
    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId == null ? null : instructorId.trim();
    }

    /**
     * 一卡通号
     * @return ONE_CARD
     */
    public String getOneCard() {
        return oneCard;
    }

    /**
     * 一卡通号
     * @param oneCard
     */
    public void setOneCard(String oneCard) {
        this.oneCard = oneCard == null ? null : oneCard.trim();
    }

    /**
     * 银行卡号
     * @return BANK_ACCOUNT
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 银行卡号
     * @param bankAccount
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 头像图片
     * @return IMAGE
     */
    public String getImage() {
        return image;
    }

    /**
     * 头像图片
     * @param image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}