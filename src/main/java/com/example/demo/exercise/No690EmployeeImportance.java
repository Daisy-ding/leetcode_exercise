package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/4 11:22 下午
 */
public class No690EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportanceByMap(Map<Integer, Employee> employeeMap, int id) {
        int sum = employeeMap.get(id).importance;
        for (Integer subordinateId : employeeMap.get(id).subordinates) {
            sum += getImportanceByMap(employeeMap, subordinateId);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new LinkedHashMap<>();
        Employee target = null;
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
            if (employee.id == id) {
                target = employee;
            }
        }
        if (target == null) {
            return 0;
        }
        int sum = target.importance;
        for (Integer subordinateId : target.subordinates) {
            sum += getImportanceByMap(employeeMap, subordinateId);
        }
        return sum;
    }
}
