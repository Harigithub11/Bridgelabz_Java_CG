package CoreProgramming.Methods.level1;
public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) ||
               (month > 3 && month < 6) ||
               (month == 6 && day <= 20);
    }
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        System.out.println(isSpringSeason(month, day) ? "Its a Spring Season" : "Not a Spring Season");
    }
}