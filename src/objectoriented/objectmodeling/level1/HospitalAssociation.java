package objectoriented.objectmodeling.level1;

class HospitalAssociation {
    String doctor = "Dr. Rao";
    String patient = "Hari";

    void consult() {
        System.out.println(doctor + " consulting " + patient);
    }

    public static void main(String[] args) {
        HospitalAssociation h = new HospitalAssociation();
        h.consult();
    }
}
