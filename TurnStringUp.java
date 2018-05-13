import javax.swing.*;

public class TurnStringUp implements TransformString{

    private JTextArea area;
    private String text;

    public TurnStringUp(JTextArea area){
        this.area = area;
        text = area.getText();
    }

    public void turnString(){
        area.setText(text.toUpperCase());
    }

}
