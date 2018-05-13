import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SaveFile {

    private JFrame frame;
    private JTextArea area;
    private File selectedFile;

    public SaveFile(JTextArea area){
        frame = new JFrame("Open File");
        frame.setPreferredSize(new Dimension(300,300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.area = area;
    }

    public void showFrame(){

        JFileChooser choose = new JFileChooser();
        choose.setCurrentDirectory(new File("."));
        int returnValue = choose.showSaveDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION){
        selectedFile = choose.getSelectedFile();
    }

        try {
        BufferedWriter out = new BufferedWriter(new FileWriter(selectedFile));
            out.write(area.getText());
            out.close();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }

        frame.setVisible(false);
        frame.dispose();
    }

}
