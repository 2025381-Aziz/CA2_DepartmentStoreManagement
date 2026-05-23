/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.services;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

import CA_2.models.Employee;
import CA_2.enums.ManagerType;
import CA_2.enums.DepartmentType;

public class FileService {

    public static void readFile(
            String fileName,
            ArrayList<Employee> employeeList) {

        try {

            File file = new File(fileName);

            Scanner fileReader = new Scanner(file);

            if (fileReader.hasNextLine()) {

                fileReader.nextLine();
            }

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                String[] data = line.split(",");
                if (data.length < 8) {

                    continue;
                }

                String firstName = data[0];

                String departmentText = data[5];

                String jobTitle = data[7];

                ManagerType managerType;

                if (jobTitle.toLowerCase().contains("manager")) {

                    managerType = ManagerType.HEAD_MANAGER;

                } else {

                    managerType = ManagerType.TEAM_LEAD;
                }

                DepartmentType department;

                switch (departmentText.toUpperCase()) {

                    case "SALES":
                        department = DepartmentType.SALES;
                        break;

                    case "HR":
                        department = DepartmentType.HR;
                        break;

                    case "IT DEVELOPMENT":
                        department = DepartmentType.IT;
                        break;

                    default:
                        department
                                = DepartmentType.CUSTOMER_SERVICE;
                        break;
                }

                Employee employee
                        = new Employee(
                                firstName,
                                managerType,
                                department);

                employeeList.add(employee);
            }

            fileReader.close();

            System.out.println("File read successfully!");

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");
        }
    }
}
