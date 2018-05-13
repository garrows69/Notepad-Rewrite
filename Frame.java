import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JTextArea area;
    private JMenu fileMenu;
    private JMenuItem newFile;
    private JMenuItem saveFile;
    private JMenuItem openFile;
    private JMenu editMenu;
    private JMenuItem turnStringUp;
    private JMenuItem turnStringLow;


    public Frame()

    {
        //frame properties
        frame = new JFrame("Notepad");
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //panel Properties
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(400,400));

        //menuBar properties
        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(10,25));
        menuBar.setOpaque(true);
        menuBar.setBackground(new Color(136,200, 136));

        //fileMenu Properties
        fileMenu = new JMenu("File");
        newFile = new JMenuItem("New File");
        newFile.addActionListener(this);
        saveFile = new JMenuItem("Save File");
        saveFile.addActionListener(this);
        openFile = new JMenuItem("Open File");
        openFile.addActionListener(this);

        //editMenu Properties
        editMenu = new JMenu("Edit");
        turnStringUp = new JMenuItem("TURN STRING UP");
        turnStringUp.addActionListener(this);
        turnStringLow = new JMenuItem("turn string low");
        turnStringLow.addActionListener(this);

        //JTextArea Properties
        area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }

    public void showFrame(){
        frame.getContentPane().add(panel);

        //adds contents to panel
        panel.add(menuBar, BorderLayout.NORTH);
        panel.add(area);

        //adds contents to menuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //adds contents to fileMenu
        fileMenu.add(newFile);
        fileMenu.add(saveFile);
        fileMenu.add(openFile);

        //adds contents to editMenu
        editMenu.add(turnStringUp);
        editMenu.add(turnStringLow);

        //sets frame
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newFile){
            NewFile newF = new NewFile(area);
            newF.showFrame();

        }
        else if(e.getSource() == saveFile){
            SaveFile save = new SaveFile(area);
            save.showFrame();
        }
        else if(e.getSource() == openFile){
            OpenFile open = new OpenFile(area);
            open.open();
        }
        else if(e.getSource() == turnStringUp){
            TransformString turn = new TurnStringUp(area);
            turn.turnString();
        }
        else if(e.getSource() == turnStringLow){
            TransformString turn = new TurnStringLow(area);
            turn.turnString();
        }
    }
}
