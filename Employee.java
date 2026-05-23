/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.models;

import CA_2.enums.ManagerType;
import CA_2.enums.DepartmentType;

public class Employee {

    private String name;
    private ManagerType managerType;
    private DepartmentType department;

    public Employee(String name,
            ManagerType managerType,
            DepartmentType department) {

        this.name = name;

        this.managerType = managerType;

        this.department = department;
    }

    public String getName() {
        return name;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    @Override
    public String toString() {

        return "\nEmployee Information"
                + "\n----------------------"
                + "\nName: " + name
                + "\nManager Type: " + managerType
                + "\nDepartment: " + department
                + "\n";
    }
}
