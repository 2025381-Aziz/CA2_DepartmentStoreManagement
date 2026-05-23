/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.services;

import java.util.ArrayList;
import CA_2.models.Employee;

public class SearchingService {

    public static Employee binarySearch(
            ArrayList<Employee> employeeList,
            String target,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;

        String middleName =
                employeeList.get(middle).getName();

        int comparison =
                target.compareToIgnoreCase(middleName);

        if (comparison == 0) {

            return employeeList.get(middle);

        } else if (comparison < 0) {

            return binarySearch(
                    employeeList,
                    target,
                    left,
                    middle - 1);

        } else {

            return binarySearch(
                    employeeList,
                    target,
                    middle + 1,
                    right);
        }
    }
}
