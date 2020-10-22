import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.*;


public class Student {

    public String name;
    public String id;
    public int age;
    public int year;
    public boolean submitted;
    public String cwPath;

    public Student(){
        this.name = "Steve Jobs";
        this.id = "w001";
        this.age = 22;
        this.year = 4;
    }

    public void viewCoursework() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("src/Files/Coursework_Spec/Concurrent Programming-6SENG004C.1_CW_Spec.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.err.println("No registered PDF viewer in your system");
            }
        }
    }

    public void submitCoursework() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please enter the path of your file to submit:");
        String path = sc1.nextLine();

        File source = new File(path);
        File dest = new File("src/Files/Submitted/"+ this.name+"-"+this.id+".pdf");
        try {
            FileUtils.copyFile(source, dest);
            System.out.println("Congratulations! You have successfully submitted your coursework.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void viewFeedback() throws IOException {

        System.out.println("This is the feedback you have received:");
        String fileName = "src/Files/Feedback/"+this.name+"-"+this.id+".txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        System.out.println(" ");
    }
}
