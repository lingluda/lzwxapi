package com.maiyue.weixin.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Teacher {
    /**
    * 教师表ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="教师表ID",dataType="String")
    private String id;

    /**
    * 职工号
    * 字段名:TEACHER_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="teacherCode",value="职工号",dataType="String")
    private String teacherCode;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态 0 正常 -1 删除 1锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 -1 删除 1锁定",dataType="String")
    private String state;

    /**
    * 教师姓名
    * 字段名:NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="name",value="教师姓名",dataType="String")
    private String name;

    /**
    * 性别
    * 字段名:SEX
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="sex",value="性别",dataType="String")
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
    * 政治面目代码
    * 字段名:POLITICAL_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="politicalCode",value="政治面目代码",dataType="String")
    private String politicalCode;

    /**
    * 院系代码
    * 字段名:DEPT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptCode",value="院系代码",dataType="String")
    private String deptCode;

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
    * 银行卡号
    * 字段名:BANK_ACCOUNT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="bankAccount",value="银行卡号",dataType="String")
    private String bankAccount;

    /**
    * 家庭地址
    * 字段名:ADDRESS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="address",value="家庭地址",dataType="String")
    private String address;

    /**
    * QQ号
    * 字段名:QQ
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="qq",value="QQ号",dataType="String")
    private String qq;

    /**
    * 头像图片
    * 字段名:IMAGE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="image",value="头像图片",dataType="String")
    private String image;

    /**
    * 学历
    * 字段名:EDUCATION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="education",value="学历",dataType="String")
    private String education;

    /**
    * 校内职务
    * 字段名:POSITION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="position",value="校内职务",dataType="String")
    private String position;

    /**
    * 学院名称
    * 字段名:DEPT_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptName",value="学院名称",dataType="String")
    private String deptName;

    /**
    * 是否是辅导员 0否1是
    * 字段名:IS_INSTRUCTOR
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="isInstructor",value="是否是辅导员 0否1是",dataType="String")
    private String isInstructor;

    /**
    * 班级代码
    * 字段名:CLASSES_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classesCode",value="班级代码",dataType="String")
    private String classesCode;

    /**
    * 班级名称
    * 字段名:CLASSES_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classesName",value="班级名称",dataType="String")
    private String classesName;

    /**
     * 教师表ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 教师表ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 职工号
     * @return TEACHER_CODE
     */
    public String getTeacherCode() {
        return teacherCode;
    }

    /**
     * 职工号
     * @param teacherCode
     */
    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode == null ? null : teacherCode.trim();
    }

    /**
     * 创建时间
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 状态 0 正常 -1 删除 1锁定
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 -1 删除 1锁定
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 教师姓名
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 教师姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
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
     * 政治面目代码
     * @return POLITICAL_CODE
     */
    public String getPoliticalCode() {
        return politicalCode;
    }

    /**
     * 政治面目代码
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
     * QQ号
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * QQ号
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
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
     * 学历
     * @return EDUCATION
     */
    public String getEducation() {
        return education;
    }

    /**
     * 学历
     * @param education
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 校内职务
     * @return POSITION
     */
    public String getPosition() {
        return position;
    }

    /**
     * 校内职务
     * @param position
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 学院名称
     * @return DEPT_NAME
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 学院名称
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 是否是辅导员 0否1是
     * @return IS_INSTRUCTOR
     */
    public String getIsInstructor() {
        return isInstructor;
    }

    /**
     * 是否是辅导员 0否1是
     * @param isInstructor
     */
    public void setIsInstructor(String isInstructor) {
        this.isInstructor = isInstructor == null ? null : isInstructor.trim();
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
}