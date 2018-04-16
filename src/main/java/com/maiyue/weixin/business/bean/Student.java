package com.maiyue.weixin.business.bean;

import io.swagger.annotations.ApiModelProperty;

public class Student {
    /**
    * 学生表ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="学生表ID",dataType="String")
    private String id;

    /**
    * 学号
    *  字段名:STUDENT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="studentCode",value="学号",dataType="String")
    private String studentCode;

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
    * 字段名:IDEN_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="idenCode",value="身份证号",dataType="String")
    private String idenCode;

    /**
    * 籍贯代码
    * 字段名:NATIVE_PLACE_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="nativePlaceCode",value="籍贯代码",dataType="String")
    private String nativePlaceCode;

    /**
    * 地区(国家)代码
    * 字段名:AREA_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="areaCode",value="地区(国家)代码",dataType="String")
    private String areaCode;

    /**
    * 政治面貌代码
    * 字段名:POLITICAL_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="politicalCode",value="政治面貌代码",dataType="String")
    private String politicalCode;

    /**
    * 院系代码
    * 字段名:DEPT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptCode",value="院系代码",dataType="String")
    private String deptCode;

    /**
    * 专业代码
    * 字段名:MAJOR_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="majorCode",value="专业代码",dataType="String")
    private String majorCode;

    /**
    * 入学年级
    * 字段名:ENTRANCE_GRADE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="entranceGrade",value="入学年级",dataType="String")
    private String entranceGrade;

    /**
    * 班级名称
    * 字段名:CLASSES_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classesName",value="班级名称",dataType="String")
    private String classesName;

    /**
    * 家庭地址
    * 字段名:ADDRESS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="address",value="家庭地址",dataType="String")
    private String address;

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
    * 字段名:INSTRUCTOR_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="instructorCode",value="辅导员ID",dataType="String")
    private String instructorCode;

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
    * 院系名称
    * 字段名:DEPT_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptName",value="院系名称",dataType="String")
    private String deptName;

    /**
    * 班级代码
    * 字段名:CLASSES_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classesCode",value="班级代码",dataType="String")
    private String classesCode;

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
     * @return STUDENT_CODE
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * 学号
     * @param studentCode
     */
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
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
     * @return IDEN_CODE
     */
    public String getIdenCode() {
        return idenCode;
    }

    /**
     * 身份证号
     * @param idenCode
     */
    public void setIdenCode(String idenCode) {
        this.idenCode = idenCode == null ? null : idenCode.trim();
    }

    /**
     * 籍贯代码
     * @return NATIVE_PLACE_CODE
     */
    public String getNativePlaceCode() {
        return nativePlaceCode;
    }

    /**
     * 籍贯代码
     * @param nativePlaceCode
     */
    public void setNativePlaceCode(String nativePlaceCode) {
        this.nativePlaceCode = nativePlaceCode == null ? null : nativePlaceCode.trim();
    }

    /**
     * 地区(国家)代码
     * @return AREA_CODE
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 地区(国家)代码
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 政治面貌代码
     * @return POLITICAL_CODE
     */
    public String getPoliticalCode() {
        return politicalCode;
    }

    /**
     * 政治面貌代码
     * @param politicalCode
     */
    public void setPoliticalCode(String politicalCode) {
        this.politicalCode = politicalCode == null ? null : politicalCode.trim();
    }

    /**
     * 院系代码
     * @return DEPT_CODE
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 院系代码
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 专业代码
     * @return MAJOR_CODE
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * 专业代码
     * @param majorCode
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
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
     * @return CLASSES_NAME
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * 班级名称
     * @param classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    /**
     * 家庭地址
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * 家庭地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * @return INSTRUCTOR_CODE
     */
    public String getInstructorCode() {
        return instructorCode;
    }

    /**
     * 辅导员ID
     * @param instructorCode
     */
    public void setInstructorCode(String instructorCode) {
        this.instructorCode = instructorCode == null ? null : instructorCode.trim();
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

    /**
     * 院系名称
     * @return DEPT_NAME
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 院系名称
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 班级代码
     * @return CLASSES_CODE
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * 班级代码
     * @param classesCode
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode == null ? null : classesCode.trim();
    }
}