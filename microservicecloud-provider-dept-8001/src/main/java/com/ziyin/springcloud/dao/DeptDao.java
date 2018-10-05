package com.ziyin.springcloud.dao;

import com.ziyin.springcloud.bo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-18:27
 */
@Mapper
public interface DeptDao
{
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
