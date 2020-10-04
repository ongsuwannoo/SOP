package com.iphayao.service.department;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iphayao.service.employee.Employee;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    private String id;
    private String name;
    private String organizationId;
    private List<Employee> employees;
	public void setEmployees(List<Employee> employees2) {
		// TODO Auto-generated method stub
		
	}
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object setId(String id2) {
		// TODO Auto-generated method stub
		return null;
	}
}
