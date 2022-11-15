package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import view.behavior.Style;
import view.behavior.IButtonSelected;

public class ButtonMenu extends Button implements IButtonSelected{
    private boolean isSelected = true;
    
    public boolean getSelected () {
        return isSelected;
    }
    
    public void selected() {
        if (isSelected) {
            setForeground(Color.WHITE);
            isSelected = false;
        } else {
            setForeground(new Color(204,204,204));
            isSelected = true;
        }
    }
    
    @Override
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        selected();
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D graphics2d = (Graphics2D) grphcs;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        graphics2d.setColor(borderColor);
        graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        graphics2d.setColor(getBackground());
        //  Border set 2 Pix
        graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintComponent(grphcs);
    }

    @Override
    protected void childProperties() {
        font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        setFont(font);
        setColor(new Color(13,90,177));
        colorOver = new Color(33,120,207);
        colorClick = new Color(23,80,167);
        borderColor = Style.Colors.transparent;
        setContentAreaFilled(false);
    }
}
