import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Admin {
    
    public String name;
    public String id;
    
    public Admin(){
        this.name = "Chanderpaul";
        this.id = "Adm001";
    }
    
    public void clearCourseworkSpec() throws IOException {
        FileUtils.cleanDirectory(new File("src/Files/Coursework_Spec/"));
    }

    public void clearFeedback() throws IOException {
        FileUtils.cleanDirectory(new File("src/Files/Feedback/"));
    }

    public void clearSubmissions() throws IOException {
        FileUtils.cleanDirectory(new File("src/Files/Submitted/"));
    }
}
