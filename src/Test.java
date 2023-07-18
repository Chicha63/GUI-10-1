import java.io.BufferedReader;
import java.io.FileReader;

public class Test extends FileOper{
    @Override
    public final String readFile(){
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
