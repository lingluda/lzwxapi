package com.maiyue.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Score {
    /**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="ID标识",dataType="String")
    private String id;

    /**
    * 学期ID
    * 字段名:TERM_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termId",value="学期ID",dataType="String")
    private String termId;

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
    * 课程ID
    * 字段名:COURSE_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="courseId",value="课程ID",dataType="String")
    private String courseId;

    /**
    * 得分
    * 字段名:SCORE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="score",value="得分",dataType="String")
    private String score;

    /**
    * 学分
    * 字段名:CREDIT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="credit",value="学分",dataType="String")
    private String credit;

    /**
    * 创建时间
    * 字段名:CREATION_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="creationTime",value="创建时间",dataType="Date")
    private Date creationTime;

    /**
    * 状态 0 正常 -1 删除 1锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 -1 删除 1锁定",dataType="String")
    private String state;

    /**
     * ID标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
     * 课程ID
     * @return COURSE_ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 课程ID
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    /**
     * 得分
     * @return SCORE
     */
    public String getScore() {
        return score;
    }

    /**
     * 得分
     * @param score
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * 学分
     * @return CREDIT
     */
    public String getCredit() {
        return credit;
    }

    /**
     * 学分
     * @param credit
     */
    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    /**
     * 创建时间
     * @return CREATION_TIME
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 创建时间
     * @param creationTime
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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
}