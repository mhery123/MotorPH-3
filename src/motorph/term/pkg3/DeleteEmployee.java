/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph.term.pkg3;

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DeleteEmployee extends JFrame {
    private JList<String> employeeList;
    private DefaultListModel<String> employeeListModel;
    private JTextArea detailsTextArea;
    private JButton updateButton;
    private JButton deleteButton;

    private List<Employee> employees;

    public DeleteEmployee() {
        setTitle("Employee Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        employeeListModel = new DefaultListModel<>();
        employeeList = new JList<>(employeeListModel);
        JScrollPane employeeListScrollPane = new JScrollPane(employeeList);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        JScrollPane detailsScrollPane = new JScrollPane(detailsTextArea);

        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateEmployeeRecord());

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteEmployeeRecord());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(employeeListScrollPane, BorderLayout.WEST);
        add(detailsScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        employees = new ArrayList<>();
        employees.add(new Employee("10001", "Crisostomo", "Jose", "02/14/1988", "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands", "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646", "Regular", "HR Manager", "N/A"));
        employees.add(new Employee("10002", "Mata", "Christian", "10/21/1987", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", "Regular", "Account Team Leader", "Romualdez, Fredrick"));
        employees.add(new Employee("10003", "San Jose", "Brad", "03/15/1996", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi", "797-009-261", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964", "Regular", "HR Team Leader", "Crisostomo, Jose"));

        for (Employee employee : employees) {
            employeeListModel.addElement(employee.getEmployeeNumber());
        }

        employeeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Employee selectedEmployee = employees.get(selectedIndex);
                    String details =
                            "Employee Number: " + selectedEmployee.getEmployeeNumber() + "\n" +
                            "Last Name: " + selectedEmployee.getLastName() + "\n" +
                            "First Name: " + selectedEmployee.getFirstName() + "\n" +
                            "Birthday: " + selectedEmployee.getBirthday() + "\n" +
                            "Address: " + selectedEmployee.getAddress() + "\n" +
                            "SSS Number: " + selectedEmployee.getSssNumber() + "\n" +
                            "Philhealth Number: " + selectedEmployee.getPhilhealthNumber() + "\n" +
                            "TIN Number: " + selectedEmployee.getTinNumber() + "\n" +
                            "Pagibig Number: " + selectedEmployee.getPagibigNumber() + "\n" +
                            "Status: " + selectedEmployee.getStatus() + "\n" +
                            "Position: " + selectedEmployee.getPosition() + "\n" +
                            "Immediate Supervisor: " + selectedEmployee.getImmediateSupervisor() + "\n";
                    detailsTextArea.setText(details);
                }
            }
        });
    }

    private void updateEmployeeRecord() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Employee selectedEmployee = employees.get(selectedIndex);
            // Open a dialog or form to edit the selected employee record
            // You can use JOptionPane for a simple dialog or create a separate form

            // For example, using JOptionPane to update the last name
            String newLastName = JOptionPane.showInputDialog("Enter new last name:");
            if (newLastName != null && !newLastName.isEmpty()) {
                selectedEmployee.setLastName(newLastName);
                employeeListModel.set(selectedIndex, selectedEmployee.getEmployeeNumber());
            }
        }
    }

    private void deleteEmployeeRecord() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                employees.remove(selectedIndex);
                employeeListModel.remove(selectedIndex);
                detailsTextArea.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeleteEmployee deleteEmployee = new DeleteEmployee();
                deleteEmployee.setVisible(true);
            }
        });
    }
}

class Employee {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;

    public Employee(String employeeNumber, String lastName, String firstName, String birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status, String position, String immediateSupervisor) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public void setPagibigNumber(String pagibigNumber) {
        this.pagibigNumber = pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }
}

