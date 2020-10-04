package com.iphayao.service.employee;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private int age;
    private String position;
    private String organizationId;
    private String departmentId;
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object setId(Object id2) {
		// TODO Auto-generated method stub
		return null;
	}
}
