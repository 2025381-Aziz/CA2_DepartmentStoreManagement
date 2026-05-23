/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2.tree;

import CA_2.models.Employee;

public class TreeNode {

    Employee employee;

    TreeNode left;

    TreeNode right;

    public TreeNode(Employee employee) {

        this.employee = employee;

        left = null;

        right = null;
    }
}
