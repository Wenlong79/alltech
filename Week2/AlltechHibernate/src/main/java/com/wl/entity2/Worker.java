package com.wl.entity2;

import jakarta.persistence.*;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id", nullable = false)
    private Long workerId;

    @Column(name = "worker_name", nullable = false)
    private String workerName;

    @Column(name = "worker_salary", nullable = false)
    private Float workerSalary;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "department_id", unique = true)
    private Department departmentToMap;

    public Worker() {

    }

    public Worker(String workerName, Float workerSalary, Department department) {
        this.workerName = workerName;
        this.workerSalary = workerSalary;
        this.departmentToMap = department;
    }

}
