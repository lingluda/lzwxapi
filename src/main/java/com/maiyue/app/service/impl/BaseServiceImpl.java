package com.maiyue.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.BaseService;

import java.util.List;
import java.util.Map;


/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {
	

	//private final static Integer DEFAULT_PAGE = 1; //默认页数
	//private final static Integer DEFAULT_PAGE_SIZE = 10;//默认分页数量

	
    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     * @return GenericDao实现类
     */
    public abstract BaseMapper<Model, PK> getMapper();

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
        return getMapper().selectByPrimaryKey(id);
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
    public PageInfo<Model> findByPage(Map<String,Object> params,int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<Model> list = getMapper().findByPage(params);
        return new PageInfo<Model>(list);
    }
    
    
}
