package com.wl.entity2;

import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @OneToOne(mappedBy = "departmentToMap")
    private Worker worker;

    public Department() {

    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

}
