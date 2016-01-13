import java.io.File;
import java.io.IOException;

/**
 * Created by apoko_000 on 12/8/2015.
 */
public class fileValidatorTC {

    public void fileValidation() throws IOException {
        //Ensures the input file, final.txt exists
        File file = new File("C:\\Users\\andrew.pokorney\\IdeaProjects\\Assignments\\src\\final.txt");  //file IO 1
        if (!file.exists()) {
            System.out.println("The file \"final.txt\" does not exist! Please ensure the file is loaded to the appropriate folder. [closing program]");
            System.exit(0);
        }
    }
}
