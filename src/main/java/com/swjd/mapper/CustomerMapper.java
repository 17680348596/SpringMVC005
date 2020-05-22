package com.swjd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swjd.pojo.Customer;

import java.util.List;

public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> findAll();

}
