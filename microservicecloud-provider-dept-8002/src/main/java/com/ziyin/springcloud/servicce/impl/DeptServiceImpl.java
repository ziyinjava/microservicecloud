package com.ziyin.springcloud.servicce.impl;

import com.ziyin.springcloud.bo.Dept;
import com.ziyin.springcloud.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ziyin.springcloud.servicce.DeptService;

import java.util.List;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-18:34
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}
}
