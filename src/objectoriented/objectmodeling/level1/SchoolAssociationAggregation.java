package objectoriented.objectmodeling.level1;

import java.util.ArrayList;

class SchoolAssociationAggregation {
    ArrayList<String> courses = new ArrayList<>();

    void enrollCourse(String course) {
        courses.add(course);
    }

    void showCourses() {
        for (String c : courses) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        SchoolAssociationAggregation student = new SchoolAssociationAggregation();
        student.enrollCourse("Java");
        student.enrollCourse("Python");
        student.showCourses();
    }
}
