package com.liujie.java8.test;

public class Employee implements Comparable {
    private String name;
    private int age;
    private double sal;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (Double.compare(employee.sal, sal) != 0) return false;
        if (!name.equals(employee.name)) return false;
        return status == employee.status;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + age;
        temp = Double.doubleToLongBits(sal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                ", status=" + status +
                '}';
    }

    public Employee(String name, int age, double sal, Status status) {
        this.name = name;
        this.age = age;
        this.sal = sal;
        this.status = status;
    }

    public Employee(String name, int age, double sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }
}
