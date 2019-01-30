package easy;


import java.util.*;

class Q690EmployeeImportance {
    public static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> idToEmloyee = new HashMap<>();
        for (Employee e: employees) {
            idToEmloyee.put(e.id, e);
        }

        int importance = 0;
        LinkedList<Integer> onesSubordinates = new LinkedList<>();
        onesSubordinates.add(id);

//        ListIterator<Integer> listIter = onesSubordinates.listIterator();
        while (!onesSubordinates.isEmpty()) {
            Integer currId = onesSubordinates.removeFirst();
            Employee emp = idToEmloyee.get(currId);
            importance += emp.importance;
            for(Integer empID: emp.subordinates) {
                onesSubordinates.add(empID);
            }
        }


        return importance;
    }

    // Employee info
    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> sub) {
            this.id = id;
            this.importance = importance;
            this.subordinates = sub;
        }
    };

    public static void main(String[] args) {
        Employee emp1 = new Employee(1,5, Arrays.asList(2, 3));
        Employee emp2 = new Employee(2, 3, Arrays.asList());
        Employee emp3 = new Employee(3, 3, Arrays.asList());

        int ans = getImportance(Arrays.asList(emp1, emp2, emp3), 1);
        System.out.println(ans);

    }
}