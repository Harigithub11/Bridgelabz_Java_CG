package objectoriented.objectmodeling.level1;

class UniversityManagement {
    String student = "Hari";
    String professor = "Dr. Kumar";
    String course = "Java";

    void enrollCourse() {
        System.out.println(student + " enrolled in " + course);
    }

    void assignProfessor() {
        System.out.println(professor + " assigned to " + course);
    }

    public static void main(String[] args) {
        UniversityManagement u = new UniversityManagement();
        u.enrollCourse();
        u.assignProfessor();
    }
}
