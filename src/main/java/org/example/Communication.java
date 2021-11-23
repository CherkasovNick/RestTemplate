package org.example;


import org.example.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/employee";

    public List<Employee> getAll() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>(){});
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getOne(Long id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void save(Employee employee) {
        if(employee.getId()==null) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee has added");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID = " + employee.getId() + " has updated");
        }
    }

    public void delete(Long id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID = " + id + " has deleted");
    }
}
