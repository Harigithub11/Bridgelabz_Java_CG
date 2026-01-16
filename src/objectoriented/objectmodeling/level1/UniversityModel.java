package objectoriented.objectmodeling.level1;

import java.util.ArrayList;

class UniversityModel {
    ArrayList<String> departments = new ArrayList<>();
    ArrayList<String> faculties = new ArrayList<>();

    UniversityModel() {
        departments.add("CSE");
        faculties.add("Dr. Kumar");
    }

    void showDetails() {
        System.out.println("Departments: " + departments);
        System.out.println("Faculties: " + faculties);
    }

    public static void main(String[] args) {
        UniversityModel u = new UniversityModel();
        u.showDetails();
    }
}
