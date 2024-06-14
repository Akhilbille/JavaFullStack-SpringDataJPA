package com.Revision.R4SpringDataJPA4.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Revision.R4SpringDataJPA4.dao.IStudentRepo;
import com.Revision.R4SpringDataJPA4.dao.Student;
@Service
public class StudentImpl implements IStudentService {
	
	@Autowired
	private IStudentRepo repo;

	@Override
	public Iterable<Student> fetchDetailsSorting(Boolean status, String... props) {
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, props);
		return repo.findAll(sort);
	}

	@Override
	public List<Student> fetchDetailPaging(int pgNo, int pgSize, boolean status, String... props) {
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, props);
		PageRequest pageable = PageRequest.of(pgNo, pgSize,sort);
		Page<Student> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void dynamicPaging(int pageSize) {
		Long records = 9L;
		Long pageCount = records/pageSize;
		pageCount = (records%pageSize==0 ? pageCount  : ++pageCount);
		for(int i=0;i<pageCount;i++) {
			PageRequest pageable = PageRequest.of(i, pageSize);
			Page<Student> page = repo.findAll(pageable);
			page.getContent().forEach(s->System.out.println(s.getName()));
			System.out.println("-------------------------");
		}
		
	}

}
