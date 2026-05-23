/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.services;

public class ValidationService {

    public static boolean isValidManagerChoice(int choice) {

        return choice >= 1 && choice <= 3;
    }

    public static boolean isValidDepartmentChoice(int choice) {

        return choice >= 1 && choice <= 4;
    }

    public static boolean isValidMenuChoice(int choice) {

        return choice >= 1 && choice <= 6;
    }

    public static boolean isValidName(String name) {

        return name != null
                && !name.trim().isEmpty();
    }
}
