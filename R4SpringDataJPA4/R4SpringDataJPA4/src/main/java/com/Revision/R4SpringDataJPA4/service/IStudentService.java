package com.Revision.R4SpringDataJPA4.service;

import java.util.List;

import com.Revision.R4SpringDataJPA4.dao.Student;

public interface IStudentService {
	
	public Iterable<Student> fetchDetailsSorting(Boolean status, String...  props);
	public List<Student> fetchDetailPaging(int pgNo,int pgSize, boolean status, String... props);
	public void dynamicPaging(int pageSize);

}
