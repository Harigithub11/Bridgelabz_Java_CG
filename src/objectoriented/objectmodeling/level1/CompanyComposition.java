package objectoriented.objectmodeling.level1;

import java.util.ArrayList;

class CompanyComposition {
    ArrayList<String> departments = new ArrayList<>();

    CompanyComposition() {
        departments.add("IT");
        departments.add("HR");
    }

    void showDepartments() {
        for (String d : departments) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        CompanyComposition company = new CompanyComposition();
        company.showDepartments();
    }
}
