package com.bridgelabz.JavaIO;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.JavaIO.EmployeePayrollService.IOService;


public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries()
    {
        EmployeePayrollData[] arrayOfEmployees = {
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);

        employeePayrollService.printData(IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(IOService.FILE_IO);
        Assert.assertEquals(3, entries);

    }

    @Test
    public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.readDataFromFile(IOService.FILE_IO);
        Assert.assertEquals(3, entries);
    }
}
