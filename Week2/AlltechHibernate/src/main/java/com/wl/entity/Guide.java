package com.wl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private Long guideId;

    @Column(name = "staff_id", nullable = false)
    private String staffId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    public Guide() {
    }

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }


    public Long getGuideDd() {
        return guideId;
    }

    public void setGuideDd(Long guideDd) {
        this.guideId = guideDd;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
