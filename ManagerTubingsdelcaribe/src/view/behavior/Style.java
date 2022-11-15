package view.behavior;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Style {
    public static class Colors {
        public static Color[] buttonMenuActive = {new Color(200,213,119), new Color(102,102,102), Color.white};
        public static Color[] buttonMenuDisable = {new Color(200,213,119), new Color(102,102,102), Color.white};
        public static Color[] buttonMenuEntered = {new Color(220,233,139), Color.white};
        public static Color[] buttonMenuExited = {new Color(160,173,69), new Color(91, 91, 91)};
        public static Color buttonCloseEntered = new Color(102,102,102);
        public static Color buttonCloseExited = new Color(204,204,204);
        public static Color buttonPrincipalEntered = new Color(255,255,255,30);
        public static Color buttonPrincipalExited = new Color(255,255,255,0);
        public static Color button;
        public static Color buttonClick;
        public static Color buttonOver;
        public static Color transparent = new Color(255,255,255,0);
    }
    public static class Button {
        public static void selected(Color[] colors, JPanel btn, JLabel text, JPanel decorate) {
            btn.setBackground(colors[0]);
            text.setForeground(colors[1]);
            if (decorate != null)
                decorate.setBackground(colors[2]);
        }
        
        public static void feel (Color color, JLabel text) {
            text.setForeground(color);
        }
        
        public static void feel (Color color, JPanel btn) {
            btn.setBackground(color);
        }
        
        public static void feel (Color[] colors, JPanel btn, JLabel text) {
            btn.setBackground(colors[0]);
            text.setForeground(colors[1]);
        }
    }
}
