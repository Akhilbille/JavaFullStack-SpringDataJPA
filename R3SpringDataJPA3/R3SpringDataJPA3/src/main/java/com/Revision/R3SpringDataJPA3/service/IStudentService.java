package com.Revision.R3SpringDataJPA3.service;



import java.util.List;
import java.util.Optional;

import com.Revision.R3SpringDataJPA3.dao.Student;

public interface IStudentService {
	
	public String registerStudents(Student student);
	public Iterable<Student> registerMultipleStudents(Iterable<Student> students);
	public Long getNumberofRecords();
	public Boolean isRecordExist(Integer id);
	public Iterable<Student> getAllRecords();
	public Iterable<Student> getRecordsByIds(Iterable<Integer> ids);
	public Optional<Student> getRecordbyId(Integer id);
	public String deleteRecordById(Integer id);
	public String deleteByRecord(Student st);
	public String deleteAllRecordsById(List<Integer> ids);
	public String deleteAllRecords();
}
