/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.services;

import java.util.ArrayList;
import CA_2.models.Employee;

public class SortingService {

    public static void mergeSort(ArrayList<Employee> employeeList) {

        if (employeeList.size() <= 1) {
            return;
        }

        int middle = employeeList.size() / 2;

        ArrayList<Employee> left = new ArrayList<>();
        ArrayList<Employee> right = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            left.add(employeeList.get(i));
        }

        for (int i = middle; i < employeeList.size(); i++) {
            right.add(employeeList.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(employeeList, left, right);
    }

    private static void merge(ArrayList<Employee> employeeList,
                              ArrayList<Employee> left,
                              ArrayList<Employee> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getName()
                    .compareToIgnoreCase(right.get(j).getName()) < 0) {

                employeeList.set(k, left.get(i));
                i++;

            } else {

                employeeList.set(k, right.get(j));
                j++;
            }

            k++;
        }

        while (i < left.size()) {

            employeeList.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {

            employeeList.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
