package com.ziyin.springcloud.servicce;

import com.ziyin.springcloud.bo.Dept;

import java.util.List;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-18:33
 */

public interface DeptService
{
	public boolean add(Dept dept);
	public Dept    get(Long id);
	public List<Dept> list();
}