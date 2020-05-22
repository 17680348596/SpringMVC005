package com.swjd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swjd.pojo.Customer;

import java.util.List;

public interface CustomerService extends IService<Customer> {

    List<Customer> getList();

}
