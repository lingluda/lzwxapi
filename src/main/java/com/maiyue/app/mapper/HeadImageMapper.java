package com.maiyue.app.mapper;

import com.maiyue.app.bean.HeadImage;

/**
 * HeadImageMapper
 * 2018/03/29
 */
public interface HeadImageMapper extends BaseMapper<HeadImage, String> {
	
	HeadImage getCurrentHead(String userId);
	
}