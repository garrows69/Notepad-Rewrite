import javax.swing.*;

public class TurnStringLow implements TransformString {

    private JTextArea area;
    private String text;

    public TurnStringLow(JTextArea area){
        this.area = area;
        text = area.getText();
    }

    public void turnString(){
        area.setText(text.toLowerCase());
    }

}
