package Exercise1;

import static org.junit.Assert.*;

public class EmployeeTest {

    @org.junit.Test
    public void getInfo() {
        Employee emp = new Employee();
        emp.getInfo("John Smith",5,10);
        assertEquals(emp.getName(),"John Smith");
    }

    @org.junit.Test
    public void computeBaseSalary() {
        Employee emp = new Employee();
        emp.getInfo("John Smith",5,10);
        int salary = emp.computeBaseSalary(20);
        assertEquals(salary,210);
    }
}