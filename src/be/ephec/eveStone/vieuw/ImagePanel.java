package be.ephec.eveStone.vieuw;

import java.awt.*; 
import java.beans.*; 
import javax.swing.*; 
 
/** 
 * <p>Title: </p> 
 * <p>Description: </p> 
 * <p>Copyright: Copyright (c) 2005</p> 
 * <p>Company: </p> 
 * @author not attributable 
 * @version 1.0 
 */ 
public final class ImagePanel extends JPanel { 
  public static final String IMAGE_PROPERTY = "ImagePanel.image"; 
  private InnerListener innerListener = new InnerListener(); 
 
  public ImagePanel(Image image) { 
    super(); 
    addPropertyChangeListener(IMAGE_PROPERTY, innerListener); 
    setImage(image); 
  } 
 
  public void dispose() { 
    removePropertyChangeListener(IMAGE_PROPERTY, innerListener); 
    innerListener = null; 
    setImage(null); 
  } 
 
  public void setImage(Image image) { 
    putClientProperty(IMAGE_PROPERTY, image); 
  } 
 
  public Image getImage() { 
    return (Image) getClientProperty(IMAGE_PROPERTY); 
  }
 
  /** {@inheritDoc} 
   */ 
  @Override protected void paintComponent(Graphics graphics) { 
    super.paintComponent(graphics); 
    Image image = getImage();
    Graphics2D g2d = (Graphics2D) graphics;
    if (image != null) {
      int x = (this.getWidth() - image.getWidth(null))/2;
      int y = (this.getHeight() - image.getHeight(null)/2);
      g2d.drawImage(image, 0, 0, null); 
    } 
  } 
 
  /** 
   * <p>Title: </p> 
   * <p>Description: </p> 
   * <p>Copyright: Copyright (c) 2005</p> 
   * <p>Company: </p> 
   * @author not attributable 
   * @version 1.0 
   */ 
  private class InnerListener implements PropertyChangeListener { 
    /** {@inheritDoc} 
     */ 
    public void propertyChange(PropertyChangeEvent event) { 
      String property = event.getPropertyName(); 
      if (property.equals(IMAGE_PROPERTY)) { 
        Image image = getImage(); 
        int width = 0; 
        int height = 0; 
        if (image != null) { 
          width = image.getWidth(null); 
          height = image.getHeight(null); 
        } 
        Dimension size = new Dimension(width, height); 
        setPreferredSize(size); 
        setMinimumSize(size); 
        repaint(); 
      } 
    } 
  } 
}
