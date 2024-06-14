//This Application created with basic methods of CrudRepository with out using any layered approach.
//Methods: save(S entity) - S, count() - long, findAllById(Iterable<Integer> ids) - Iterable<student> ,findAll()- Iterable<Student>,existsById(Integer id) - boolean


package com.Revision.R2SpringDataJPA1;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Revision.R2SpringDataJPA1.dao.IStudentRepo;
import com.Revision.R2SpringDataJPA1.dao.Student;

@SpringBootApplication
public class R2SpringDataJpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(R2SpringDataJpa1Application.class, args);
		IStudentRepo repo = container.getBean(IStudentRepo.class);
		
		
		//Create
		//save() - Inserting data into table 
		Student obj = new Student(2,"Akhil","a@gmail.com"); 
		Student st = repo.save(obj);
		
		
		
		//Read
		//count() - To get number of records
		long records = repo.count();
		System.out.println(records);
		
		
		//To find data
		//findAllById() - to find specific ID return Optional Object
		Optional<Student> data = repo.findById(2);
		if(data.isPresent()) {
			//System.out.println(data.get().getEmail()); // To get individual data
			//System.out.println(data.get()); //To get Student Object
			System.out.println(data); //returns optional object
			
		}
		else {
			System.out.println("Id not present");
		}
		
		
		//findAll() - To get all records
		System.out.println("--------------To get all records-----------------");
		Iterable<Student> allRecords = repo.findAll();
		Iterator<Student> iterator = allRecords.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		//Instead of using Iterator we can use forEach from Stream API
		System.out.println("------------------For Each---------------------");
		repo.findAll().forEach(s->System.out.println(s));
		
		
		//existsById() - To check its existence
		boolean status = repo.existsById(20);
		System.out.println(status);
		
		
		
	}
}
