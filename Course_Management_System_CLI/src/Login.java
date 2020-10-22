import java.io.IOException;
import java.util.Scanner;

public class Login {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Please Enter Username:");
        String username = sc.nextLine();
        System.out.println("Please Enter Password:");
        String password = sc.nextLine();

        if(username.equals("student") && password.equals("stu1234")){
            Student student = new Student();
            playStudent(student);
        }
        else if(username.equals("instructor") && password.equals("ins1234")){
            Instructor instructor = new Instructor();
            playInstructor(instructor);
        }
        else if(username.equals("admin") && password.equals("adm1234")){
            Admin admin = new Admin();
            playAdmin(admin);
        }
        else{
            System.err.println("OOPS! Your username and password details doesn't match.\nPlease try again!");
        }

    }

    private static void playAdmin(Admin admin) throws IOException {
        System.out.println("Please select the option you want to proceed with.");

        int n = 0;
        while(n!=4) {
            System.out.print("1 - Clear Coursework_Spec\n2 - Clear Feedback\n3 - Clear Submissions\n4 - Logout\n");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    admin.clearCourseworkSpec();
                    break;
                case 2:
                    admin.clearFeedback();
                    break;
                case 3:
                    admin.clearSubmissions();
                    break;
            }
        }

        System.out.println("Logging out...");
        System.out.println("You are logged out of the system.");
    }

    private static void playInstructor(Instructor instructor) throws IOException {
        System.out.println("Please select the option you want to proceed with.");

        int n = 0;
        while(n!=7) {
            System.out.print("1 - Publish Coursework\n2 - View Submissions\n3 - Provide Feedback\n" +
                    "4 - Clear Coursework_Spec\n5 - Clear Feedback\n6 - Clear Submissions\n7 - Logout\n");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    instructor.publishCoursework();
                    break;
                case 2:
                    instructor.viewSubmissions();
                    break;
                case 3:
                    instructor.provideFeedback();
                    break;
                case 4:
                    instructor.clearCourseworkSpec();
                    break;
                case 5:
                    instructor.clearFeedback();
                    break;
                case 6:
                    instructor.clearSubmissions();
                    break;
            }
        }

        System.out.println("Logging out...");
        System.out.println("You are logged out of the system.");
    }

    public static void playStudent(Student student) throws IOException {
        System.out.println("Please select the option you want to proceed with.");

        int n = 0;
        while(n!=4) {
            System.out.print("1 - View Coursework\n2 - Submit Coursework\n3 - View Feedback\n4 - Logout\n");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    student.viewCoursework();
                    break;
                case 2:
                    student.submitCoursework();
                    break;
                case 3:
                    student.viewFeedback();
                    break;
            }
        }

        System.out.println("Logging out...");
        System.out.println("You are logged out of the system.");
    }
}
