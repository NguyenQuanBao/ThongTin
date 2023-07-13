package com.example.thongtin;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;


     class Student {
        private String id;
        private String name;
        private String clazz;
        private String gender;
        private String address;
        private double score;

        public Student(String id, String name, String clazz, String gender, String address, double score) {
            this.id = id;
            this.name = name;
            this.clazz = clazz;
            this.gender = gender;
            this.address = address;
            this.score = score;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getClazz() {
            return clazz;
        }

        public String getGender() {
            return gender;
        }

        public String getAddress() {
            return address;
        }

        public double getScore() {
            return score;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public class HelloController {

    @FXML
    TableView<Student> studentTable;

    @FXML
    TableColumn<Student, String> idColumn;

    @FXML
    TableColumn<Student, String> nameColumn;

    @FXML
    TableColumn<Student, String> classColumn;

    @FXML
    TableColumn<Student, String> genderColumn;

    @FXML
    TableColumn<Student, String> addressColumn;

    @FXML
    TableColumn<Student, Double> scoreColumn;

    @FXML
    TextField idField;

    @FXML
    TextField nameField;

    @FXML
    TextField classField;

    @FXML
    TextField genderField;

    @FXML
    TextField addressField;

    @FXML
    TextField scoreField;

//    @FXML
//    private Button addStudentButton;
//
//    @FXML
//    private Button updateStudentButton;
//
//    @FXML
//    private Button deleteStudentButton;

    private List<Student> students = new ArrayList<>();

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("clazz"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        studentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                idField.setText(newSelection.getId());
                nameField.setText(newSelection.getName());
                classField.setText(newSelection.getClazz());
                genderField.setText(newSelection.getGender());
                addressField.setText(newSelection.getAddress());
                scoreField.setText(String.valueOf(newSelection.getScore()));
            }
        });
    }

    @FXML
    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String clazz = classField.getText();
        String gender = genderField.getText();
        String address = addressField.getText();
        double score = Double.parseDouble(scoreField.getText());

        Student student = new Student(id, name, clazz, gender, address, score);
        students.add(student);
        studentTable.getItems().add(student);

        clearFields();
    }
@FXML
    private void updateStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            selectedStudent.setId(idField.getText());
            selectedStudent.setName(nameField.getText());
            selectedStudent.setClazz(classField.getText());
            selectedStudent.setGender(genderField.getText());
            selectedStudent.setAddress(addressField.getText());
            selectedStudent.setScore(Double.parseDouble(scoreField.getText()));

            studentTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            students.remove(selectedStudent);
            studentTable.getItems().remove(selectedStudent);

            clearFields();
        }
    }
    private void clearFields() {
        idField.clear();
        nameField.clear();
        classField.clear();
        genderField.clear();
        addressField.clear();
        scoreField.clear();
    }
}
