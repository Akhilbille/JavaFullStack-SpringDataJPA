package com.Revision.R3SpringDataJPA3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Revision.R3SpringDataJPA3.dao.Student;
import com.Revision.R3SpringDataJPA3.dao.IstudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IstudentRepo repo;
	

	@Override
	public String registerStudents(Student student) {
		repo.save(student);
		return null;
	}

	
	@Override
	public Iterable<Student> registerMultipleStudents(Iterable<Student> students) {
		Iterable<Student> result = repo.saveAll(students);
		return result;
	}

	@Override
	public Long getNumberofRecords() {
		return repo.count();
	}

	
	@Override
	public Boolean isRecordExist(Integer id) {
		boolean status = repo.existsById(id);
		return status;
	}
	

	@Override
	public Iterable<Student> getAllRecords() {
		return repo.findAll();
	}
	

	@Override
	public Iterable<Student> getRecordsByIds(Iterable<Integer> ids) {
		Iterable<Student> result = repo.findAllById(ids);
		return result;
	}

	
	@Override
	public Optional<Student> getRecordbyId(Integer id) {
		Optional<Student> record = repo.findById(id);
		
		return record;
	}


	@Override
	public String deleteRecordById(Integer id) {
		
//		Optional<Student> status = repo.findById(id);
//		if(status.isPresent())
//		{
//			repo.deleteById(id);
//			return "Deleted";
//		}
//		return "Record not exist to delete";
		
		//Even we can existsById() to check its presence
		boolean isExist = repo.existsById(id);
		if(isExist)
		{
			repo.deleteById(id);
			
			return "Deleted";
			
			
		}
		return "Record not exist to delete";

	}
	
	// **delete() -  Delete by Entity **
	@Override
	public String deleteByRecord(Student st) {
		Integer id = st.getId();
		Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(st);
			return "Record deleted Id: "+ id;
			
		}
		return "Record is not present";
	}


	
	// ** deleteAllById(ids) - To delete all provided Ids if all ids exists if not exists cancel deleting 
	@Override
	public String deleteAllRecordsById(List<Integer> ids) {
		 int count = ids.size();
		 List<Student> records = (List<Student>) repo.findAllById(ids);
		 int count2 = records.size();
		 if(count == count2) {
			 repo.deleteAllById(ids);
			 return "All Records Deleted Succesfully";
		 }
		 
		 return "Records are not deleted Succesfully";
		 
	}


	// ** deleteAll() - To delete all records
	@Override
	public String deleteAllRecords() {
		Long records = repo.count();
		if(records>0) {
			repo.deleteAll();
			return "All records Deleted";
		}
		return "Table is already empty nothing exist to delete";
	}

}
