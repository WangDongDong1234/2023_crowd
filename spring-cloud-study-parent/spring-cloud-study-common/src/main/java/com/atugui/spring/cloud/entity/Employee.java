package com.atugui.spring.cloud.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
