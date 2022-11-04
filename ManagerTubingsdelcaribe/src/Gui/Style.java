package Gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Style {
    public static class BtnMenu {
        public static void active(JPanel btn, JLabel text,JPanel decorate) {
            btn.setBackground(new Color(200,213,119));
            text.setForeground(new Color(102,102,102));
            decorate.setBackground(Color.white);
        }
        
        public static void disable(JPanel btn, JLabel text,JPanel decorate) {
            btn.setBackground(new Color(160,173,69));
            text.setForeground(new Color(91, 91, 91));
            decorate.setBackground(new Color(102,102,102));
        }

        public static void Entered (JPanel btn, JLabel text) {
            btn.setBackground(new Color(220,233,139));
            text.setForeground(Color.white);
        }

        public static void Exited (JPanel btn, JLabel text) {
            btn.setBackground(new Color(160,173,69));
            text.setForeground(new Color(91, 91, 91));
        }
    }
    
    public static class BtnPrincipal {
        public static void entered (JPanel btn) {
            btn.setBackground(new Color(45,190,160));
        }
        
        public static void exited (JPanel btn) {
            btn.setBackground(new Color(55,200,171));
        }
    }
    
    public static class BtnClose {
        public static void entered (JLabel text) {
            text.setForeground(new Color(204,204,204));
        }

        public static void exited (JLabel text) {
            text.setForeground(new Color(102,102,102));
        }
    }
}
