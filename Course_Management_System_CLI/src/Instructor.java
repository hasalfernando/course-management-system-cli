import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.Scanner;

public class Instructor extends Admin{

    public String name;
    public String module;
    public String moduleCode;

    public Instructor(){
        this.name="James Bond";
        this.module="Concurrent Programming";
        this.moduleCode="6SENG004C.1";
    }
    public void publishCoursework() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Please enter the path of your file to publish:");
        String path = sc2.nextLine();

        File source = new File(path);

        File dest = new File("src/Files/Coursework_Spec/"+ this.module+"-"+this.moduleCode+"_CW_Spec.pdf");
        try {
            if(new File("src/Files/Coursework_Spec/").getParentFile().length()!=0) {
                FileUtils.cleanDirectory(new File("src/Files/Coursework_Spec/"));
            }
            FileUtils.copyFile(source, dest);
            System.out.println("You have successfully published a coursework for students.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void viewSubmissions() {

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Loading submissions...");
        if((new File("src/Files/Submitted/").getParentFile().length()!=0)) {
            System.out.println("These are the submissions that have been received:");
            File folder = new File("src/Files/Submitted");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }
            }
            String proceed = "Yes";
            while(!proceed.equals("No")) {
                System.out.println("Provide the file name if you want to view a submission or else type 'No'");
                proceed = sc3.nextLine();
                if(!proceed.equals("No")){
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File myFile = new File("src/Files/Submitted/"+proceed);
                            Desktop.getDesktop().open(myFile);
                        } catch (IOException ex) {
                            System.err.println("No such file in submissions directory.\n");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("There are no submissions yet!\n");
        }

        System.out.println(" ");
    }

    public void provideFeedback() {

        Scanner sc4 = new Scanner(System.in);
        System.out.println("Loading submissions...");
        if((new File("src/Files/Submitted/").getParentFile().length()!=0)) {
            System.out.println("Please type the name of a chosen submission (without .pdf extension) to which you want to provide feedback to:");
            File folder = new File("src/Files/Submitted");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }

            }

            String filename = sc4.nextLine();
            System.out.println("Please type your feedback message below:");
            String message = sc4.nextLine();

            try {
                FileWriter fw = new FileWriter("src/Files/Feedback/" + filename + ".txt");
                fw.write(message);
                fw.close();
                System.out.println("Successfully wrote the feedback.\n");
            } catch (IOException e) {
                System.out.println("An error occurred.\n");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("There are no submissions for you to provide feedback yet!\n");
        }
    }
}
