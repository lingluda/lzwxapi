package com.maiyue.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.Payment;
import com.maiyue.business.mapper.PaymentMapper;
import com.maiyue.business.service.PaymentService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PaymentService实现类
 * 2018/04/13
 */
@Service("paymentService")
public class PaymentServiceImpl extends BaseServiceImpl<Payment, String> implements PaymentService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private PaymentMapper paymentMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Payment, String> getMapper() {
        return paymentMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Payment> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}