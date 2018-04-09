package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfo extends BaseSort implements Serializable{
   
	private static final long serialVersionUID = -8939479764036168495L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 用户名
    * 字段名:USER_NAME
    * 类型:VARCHAR
     */
    private String userName;

    /**
    * 昵称
    * 字段名:NICK_NAME
    * 类型:VARCHAR
     */
    private String nickName;

    /**
    * 状态 0 正常 -1 停用 1 锁定（待审核）
    * 字段名:STATE
    * 类型:VARCHAR
     */
    private String state;

    
    private String headAddress;
    
    private List<HeadImage> images;
    
    public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	public List<HeadImage> getImages() {
		return images;
	}

	public void setImages(List<HeadImage> images) {
		this.images = images;
	}

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
     * 用户名
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 昵称
     * @return NICK_NAME
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 状态 0 正常 -1 停用 1 锁定（待审核）
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 -1 停用 1 锁定（待审核）
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{id:'").append(id).append("', userName:'").append(userName).append("', nickName:'")
				.append(nickName).append("', state:'").append(state).append("'}");
		return builder.toString();
	}
    
    
    
    
}