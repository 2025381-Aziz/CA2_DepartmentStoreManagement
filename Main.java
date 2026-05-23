package CA_2;

import java.util.Scanner;
import java.util.ArrayList;
import CA_2.models.Employee;
import CA_2.services.SortingService;
import CA_2.services.SearchingService;
import CA_2.tree.BinaryTree;
import CA_2.enums.ManagerType;
import CA_2.enums.DepartmentType;
import CA_2.services.ValidationService;
import CA_2.services.FileService;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        BinaryTree tree = new BinaryTree();
        FileService.readFile(
                "Applicants_Form.txt",
                employeeList);
        employeeList.add(new Employee(
                "Ali",
                ManagerType.TEAM_LEAD,
                DepartmentType.SALES));
        employeeList.add(new Employee(
                "Vali",
                ManagerType.HEAD_MANAGER,
                DepartmentType.HR));
        employeeList.add(new Employee(
                "John",
                ManagerType.ASSISTANT_MANAGER,
                DepartmentType.IT));

        int choice;

        do {

            System.out.println("\n===== DEPARTMENT STORE MANAGEMENT SYSTEM =====");

            System.out.println("1. SORT EMPLOYEES");
            System.out.println("2. SEARCH EMPLOYEE");
            System.out.println("3. ADD EMPLOYEE");
            System.out.println("4. CREATE BINARY TREE");
            System.out.println("5. DISPLAY TREE");
            System.out.println("6. EXIT");

            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            if (!ValidationService.isValidMenuChoice(choice)) {

                System.out.println("Invalid menu option!");

                continue;
            }

            switch (choice) {

                case 1:
                    SortingService.mergeSort(employeeList);

                    System.out.println("\n===== SORTED EMPLOYEES =====");

                    for (Employee employee : employeeList) {

                        System.out.println(employee);
                    }
                    break;

                case 2:
                    input.nextLine();

                    SortingService.mergeSort(employeeList);

                    System.out.print("Enter employee name to search: ");

                    String searchName = input.nextLine();

                    Employee foundEmployee
                            = SearchingService.binarySearch(
                                    employeeList,
                                    searchName,
                                    0,
                                    employeeList.size() - 1);

                    if (foundEmployee != null) {

                        System.out.println("\n===== EMPLOYEE FOUND =====");

                        System.out.println(foundEmployee);

                    } else {

                        System.out.println("Employee not found!");
                    }
                    break;

                case 3:
                    input.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = input.nextLine();
                    if (!ValidationService.isValidName(name)) {

                        System.out.println("Invalid name!");

                        break;
                    }

                    System.out.println("Select Manager Type:");
                    System.out.println("1. HEAD_MANAGER");
                    System.out.println("2. ASSISTANT_MANAGER");
                    System.out.println("3. TEAM_LEAD");

                    int managerChoice = input.nextInt();
                    if (!ValidationService.isValidManagerChoice(managerChoice)) {

                        System.out.println("Invalid manager option!");

                        break;
                    }

                    ManagerType managerType = null;

                    switch (managerChoice) {

                        case 1:
                            managerType = ManagerType.HEAD_MANAGER;
                            break;

                        case 2:
                            managerType = ManagerType.ASSISTANT_MANAGER;
                            break;

                        case 3:
                            managerType = ManagerType.TEAM_LEAD;
                            break;

                        default:
                            System.out.println("Invalid manager choice!");
                            break;
                    }

                    System.out.println("Select Department:");
                    System.out.println("1. SALES");
                    System.out.println("2. HR");
                    System.out.println("3. IT");
                    System.out.println("4. CUSTOMER_SERVICE");

                    int departmentChoice = input.nextInt();
                    if (!ValidationService.isValidDepartmentChoice(departmentChoice)) {

                        System.out.println("Invalid department option!");

                        break;
                    }

                    DepartmentType department = null;

                    switch (departmentChoice) {

                        case 1:
                            department = DepartmentType.SALES;
                            break;

                        case 2:
                            department = DepartmentType.HR;
                            break;

                        case 3:
                            department = DepartmentType.IT;
                            break;

                        case 4:
                            department = DepartmentType.CUSTOMER_SERVICE;
                            break;

                        default:
                            System.out.println("Invalid department choice!");
                            break;
                    }

                    Employee newEmployee = new Employee(name, managerType, department);

                    employeeList.add(newEmployee);

                    System.out.println("Employee added successfully!");
                    break;

                case 4:
                    for (Employee employee : employeeList) {

                        tree.insert(employee);
                    }

                    System.out.println("Binary Tree Created Successfully!");
                    break;

                case 5:
                    System.out.println("\n===== EMPLOYEE HIERARCHY TREE =====");

                    tree.displayLevelOrder();

                    System.out.println("\nTotal Nodes: "
                            + tree.countNodes(tree.getRoot()));

                    System.out.println("Tree Height: "
                            + tree.treeHeight(tree.getRoot()));
                    break;

                case 6:
                    System.out.println("System closing...");
                    break;

                default:
                    System.out.println("Invalid menu option! Please try again");

            }

        } while (choice != 6);

    }
}
