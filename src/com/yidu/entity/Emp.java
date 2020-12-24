package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2020-11-19 14:05:02
 */
@Component
public class Emp implements Serializable {
    private static final long serialVersionUID = -58199120840188633L;
    
    private Integer empno;
    
    private String empname;
    
    private String job;
    
    private Integer manager;
    
    private String hiredate;
    
    private Double salary;
    
    private Double commision;
    
    private Integer deptno;


    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommision() {
        return commision;
    }

    public void setCommision(Double commision) {
        this.commision = commision;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", empname='" + empname + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hiredate='" + hiredate + '\'' +
                ", salary=" + salary +
                ", commision=" + commision +
                ", deptno=" + deptno +
                '}';
    }
}