import javax.swing.*;
import java.io.*;

public class OpenFile {

    private JTextArea area;

    public OpenFile(JTextArea area){
        this.area = area;
    }

    public void open(){
        String line = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        int retrieval = chooser.showOpenDialog(null);
        if(retrieval == chooser.APPROVE_OPTION){
            try{
                FileReader read = new FileReader(chooser.getSelectedFile());
                BufferedReader reader = new BufferedReader(read);
                while((line = reader.readLine()) != null){
                    area.setText(line);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
