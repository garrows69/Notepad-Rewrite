import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NewFile{

    private JFrame frame;
    private JTextArea area;

    public NewFile(JTextArea area){
        frame = new JFrame("NewFile");
        frame.setPreferredSize(new Dimension(200,200));
        this.area = area;
    }

    public void showFrame(){
        String line = area.getText();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        int retrival = chooser.showSaveDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            try {
                FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt");
                fw.write(line.toString());
                fw.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        area.setText("");
    }
}
