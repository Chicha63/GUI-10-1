import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOper {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(String filePath) {
        this.file = new File(filePath);
    }

    public String readFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder string = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                string.append(line).append("\n");
            }
            reader.close();
            return string.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
