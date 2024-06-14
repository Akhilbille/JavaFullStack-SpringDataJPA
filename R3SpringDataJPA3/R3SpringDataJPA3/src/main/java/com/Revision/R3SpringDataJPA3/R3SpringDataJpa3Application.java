//All CrudRepository Methods


package com.Revision.R3SpringDataJPA3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Revision.R3SpringDataJPA3.dao.Student;
import com.Revision.R3SpringDataJPA3.service.IStudentService;

@SpringBootApplication
public class R3SpringDataJpa3Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext container = SpringApplication.run(R3SpringDataJpa3Application.class, args);
		 
		 
		 //Getting Bean of Student Service to access all methods
		  IStudentService service = container.getBean(IStudentService.class);
		  
		  //CRUD Operations
		  
		  //Create
		  // **save() - Creating Student Object**
//		  Student s= new Student("Akhil","a@gmail.com");
//		  String result = service.registerStudents(s);
//		  System.out.println(result);
		  
		  //  **saveAll() - To store group of objects**
//		  List<Student> students = new ArrayList<>();
//		  students.add(new Student("Dinesh","dinesh@gmail.com"));
//		  students.add(new Student("Deepu","deepu@gmail.com"));
//		  students.add(new Student("Vinay","vinay@gmail.com"));
//
//		  service.registerMultipleStudents(students).forEach(s1 ->  System.out.println(s1));
		  
		  
		  //Read
		  // **count() - To get number of records**
//		  Long recordsCount = service.getNumberofRecords();
//		  System.out.println(recordsCount);
		  
		  // **existsByID() - To check whether record is present or not**
//		  Integer id = 1;
//		  Boolean status = service.isRecordExist(id);
//		  System.out.println(status);
		  
		  // ** findAll() - to return all records **
//		   service.getAllRecords().forEach(data-> System.out.println(data));
		  
		   
		   // **findAllById() - To get all records by their Ids
//		   List<Integer> ids = new ArrayList<>();
//		   ids.add(1);
//		   ids.add(10);
//		   service.getRecordsByIds(ids).forEach(r-> System.out.println(r));
		   
		   // **findById() - Returns Optional Object**
//		   Optional<Student> record = service.getRecordbyId(3);
//		   if(record.isPresent())
//			   System.out.println(record.get());
//		   else
//			   record.orElseThrow(() -> new IllegalArgumentException("Record not found"));
		   
		   //** deleteByID() - return void but to confirm it is deleted we are using String 
//		   String message = service.deleteRecordById(4);
//		   System.out.println(message);
		  
		  //** delete(S entity) - To delete by object
//		  Student st = new Student("Vinay","vinay@gmail.com");
//		   st.setId(54);
//		  String mess = service.deleteByRecord(st);
//		  System.out.println(mess);
		  
		  //** deleteAllById(Iterable<Integers> ids)
//		  List<Integer> ids= new ArrayList<>();
//		  ids.add(52);
//		  ids.add(53);
//		  String mes = service.deleteAllRecordsById(ids);
//		  System.out.println(mes);
		  
		  
		  //** deleteAll() - To delete all records
		  String message = service.deleteAllRecords();
		  System.out.println(message);
		  
		  
		  
		  
		  
		  
		   
		 
	}

}
