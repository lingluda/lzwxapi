package com.maiyue.weixin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.constant.Business;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.BaseService;
import com.maiyue.weixin.utils.RedisUtil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {
	
	@Autowired
	private RedisUtil redisUtil;
	
    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     * @return GenericDao实现类
     */
    public abstract BaseMapper<Model, PK>  getMapper();

    /**
     * 插入对象
     *
     * @param model 对象
     */
    public int insert(Model model) {
        return getMapper().insertSelective(model);
    }

    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int update(Model model) {
        return getMapper().updateByPrimaryKeySelective(model);
    }

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    public int delete(PK id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return
     */
    public Model selectById(PK id) {
    	Model model = null;
    	if(redisUtil.get((String)id) == null){
    		model = getMapper().selectByPrimaryKey(id);
    		if(model == null)
    			redisUtil.set((String)id, false, Constant.exTime());
    		else
    			redisUtil.set((String)id, true, Constant.exTime());
    	}else{
    		boolean flag = (boolean) redisUtil.get((String)id);
    		if(flag)
    		model = getMapper().selectByPrimaryKey(id);
    	}
        return model;
    }

    
    /***
     * 查询全部
     */
    public List<Model> findAll (Map<String,Object> params) {
        return getMapper().findByPage(params);
    }


    /***
     * 分页查询
     * @param params
     * @param page
     * @param pageSize
     * @param orderBy
     * @return
     */
    public PageInfo<Model> findByPage(Map<String,Object> params,int page,int pageSize,String orderBy){
        PageHelper.startPage(page,pageSize,orderBy);
        List<Model> list = getMapper().findByPage(params);
        return new PageInfo<Model>(list);
    }
    
    
    /***
     * 分页查询
     * @param params
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<Model> findByPage(Map<String,Object> params){
        PageHelper.startPage((Integer)params.get(Business.PAGENUM), (Integer)params.get(Business.PAGESIZE));
        List<Model> list = getMapper().findByPage(params);
        return new PageInfo<Model>(list);
    }
    
    
}
