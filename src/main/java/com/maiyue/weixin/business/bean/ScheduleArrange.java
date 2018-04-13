package com.maiyue.weixin.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ScheduleArrange {
    /**
    * id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="id标识",dataType="String")
    private String id;

    /**
    * 班级ID
    * 字段名:CLASS_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classId",value="班级ID",dataType="String")
    private String classId;

    /**
    * 教师ID
    * 字段名:TEACHER_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="teacherId",value="教师ID",dataType="String")
    private String teacherId;

    /**
    * 学生ID
    * 字段名:STUDENT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="studentId",value="学生ID",dataType="String")
    private String studentId;

    /**
    * 学年
    * 字段名:TERM_YEAR
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termYear",value="学年",dataType="String")
    private String termYear;

    /**
    * 学期ID
    * 字段名:TERM_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termId",value="学期ID",dataType="String")
    private String termId;

    /**
    * 课程日期
    * 字段名:COURSE_DATE
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="courseDate",value="课程日期",dataType="Date")
    private Date courseDate;

    /**
    * 第几节
    * 字段名:SECTION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="section",value="第几节",dataType="String")
    private String section;

    /**
    * 第几周数
    * 字段名:FEW_WEEKS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="fewWeeks",value="第几周数",dataType="String")
    private String fewWeeks;

    /**
    * 星期几
    * 字段名:WHAT_DAY
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="whatDay",value="星期几",dataType="String")
    private String whatDay;

    /**
    * 课程名称
    * 字段名:COURSE_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="courseName",value="课程名称",dataType="String")
    private String courseName;

    /**
    * 上课时间
    * 字段名:START_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="startTime",value="上课时间",dataType="String")
    private String startTime;

    /**
    * 下课时间
    * 字段名:END_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="endTime",value="下课时间",dataType="String")
    private String endTime;

    /**
    * 地点
    * 字段名:ADDRESS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="address",value="地点",dataType="String")
    private String address;

    /**
    * 授课教师
    * 字段名:TEACHER
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="teacher",value="授课教师",dataType="String")
    private String teacher;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态 0 正常 1 锁定 -1 删除
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 1 锁定 -1 删除",dataType="String")
    private String state;

    /**
     * id标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * id标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 班级ID
     * @return CLASS_ID
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 班级ID
     * @param classId
     */
    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    /**
     * 教师ID
     * @return TEACHER_ID
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 教师ID
     * @param teacherId
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    /**
     * 学生ID
     * @return STUDENT_ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 学生ID
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * 学年
     * @return TERM_YEAR
     */
    public String getTermYear() {
        return termYear;
    }

    /**
     * 学年
     * @param termYear
     */
    public void setTermYear(String termYear) {
        this.termYear = termYear == null ? null : termYear.trim();
    }

    /**
     * 学期ID
     * @return TERM_ID
     */
    public String getTermId() {
        return termId;
    }

    /**
     * 学期ID
     * @param termId
     */
    public void setTermId(String termId) {
        this.termId = termId == null ? null : termId.trim();
    }

    /**
     * 课程日期
     * @return COURSE_DATE
     */
    public Date getCourseDate() {
        return courseDate;
    }

    /**
     * 课程日期
     * @param courseDate
     */
    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    /**
     * 第几节
     * @return SECTION
     */
    public String getSection() {
        return section;
    }

    /**
     * 第几节
     * @param section
     */
    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    /**
     * 第几周数
     * @return FEW_WEEKS
     */
    public String getFewWeeks() {
        return fewWeeks;
    }

    /**
     * 第几周数
     * @param fewWeeks
     */
    public void setFewWeeks(String fewWeeks) {
        this.fewWeeks = fewWeeks == null ? null : fewWeeks.trim();
    }

    /**
     * 星期几
     * @return WHAT_DAY
     */
    public String getWhatDay() {
        return whatDay;
    }

    /**
     * 星期几
     * @param whatDay
     */
    public void setWhatDay(String whatDay) {
        this.whatDay = whatDay == null ? null : whatDay.trim();
    }

    /**
     * 课程名称
     * @return COURSE_NAME
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 课程名称
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * 上课时间
     * @return START_TIME
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 上课时间
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 下课时间
     * @return END_TIME
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 下课时间
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 地点
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地点
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 授课教师
     * @return TEACHER
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 授课教师
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
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
     * 状态 0 正常 1 锁定 -1 删除
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 1 锁定 -1 删除
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}