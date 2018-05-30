/*
* This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 
* International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ 
* or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package whiskey.io.blessini;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter
{
    Point location;
    MouseEvent pressed;
 
    @Override
    public void mousePressed(MouseEvent me)
    {
        pressed = me;
    }
 
    @Override
    public void mouseDragged(MouseEvent me)
    {
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
     }
}
