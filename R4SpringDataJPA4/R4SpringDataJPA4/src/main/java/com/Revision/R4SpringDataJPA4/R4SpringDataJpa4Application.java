package com.Revision.R4SpringDataJPA4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Revision.R4SpringDataJPA4.service.IStudentService;

@SpringBootApplication
public class R4SpringDataJpa4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(R4SpringDataJpa4Application.class, args);
		IStudentService service = container.getBean(IStudentService.class);
		
		// ** findAll(Sort sort) - returns all details by sorting them based on parameters passed
		//true - Ascending order, false - descending order
//		
//		service.fetchDetailsSorting(true, "name","email")
//		.forEach(s-> System.out.println(
//				s.getName()+ " "+ s.getEmail()
//				));
		
		// **findAll(pageable) - Page<Student> but we are collecting content so it is in List<Student>
		//(pagenumber,pagesize,true/false,parameters(fields))
//		service.fetchDetailPaging(1, 4, true, "name").forEach(s->System.out.println(s.getName()+ "   "+ s.getEmail()));
		
		
		//**Dynamic Paging**
		service.dynamicPaging(2);
		
		
	}

}
