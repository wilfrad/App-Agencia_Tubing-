package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ButtonSimple extends Button{
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }

    @Override
    protected void childProperties() {
        font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        setFont(font);
        setColor(new Color(160,173,69));
        colorOver = new Color(171,186,73);
        colorClick = new Color(144,156,61);
        borderColor = new Color(255, 255, 255,0);
        radius = 15;
        setContentAreaFilled(false);
    }
}
