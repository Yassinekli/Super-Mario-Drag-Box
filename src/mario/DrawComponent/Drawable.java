/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.DrawComponent;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mario.position.Positions;

/**
 *
 * @author Yassine
 */
public class Drawable {
    
    JLabel LABEL_OF_MARIO = new JLabel();
    JLabel LABEL_OF_STAR = new JLabel();
    JLabel LABEL_OF_GOODS = new JLabel();
    JLabel LABEL_OF_WALL;
    JLabel LABEL_OF_Road;
    Positions p = new Positions();
    
    public int[][] empty_point;
    
    public void drawLevel(JFrame frame, Positions LevelPositions)
    {
        drawMario(frame, LevelPositions.getMarioPosition_X(), LevelPositions.getMarioPosition_Y());
        drawStar(frame, LevelPositions.getStarPosition_X(), LevelPositions.getStarPosition_Y());
        drawGoods(frame, LevelPositions.getGoodsPosition_X(), LevelPositions.getGoodsPosition_Y());
        drawWalls(frame);
    }
    
    public void drawMario(JFrame frame, int x, int y)
    {
        try {
            ImageIcon icon = new ImageIcon(scaledImage(ImageIO.read(new File("Elements\\Mario Right.png")), 35, 35));
            LABEL_OF_MARIO.setSize(35, 35);
            LABEL_OF_MARIO.setLocation(x, y);
            LABEL_OF_MARIO.setIcon(icon);
            LABEL_OF_MARIO.setVisible(true);
            frame.add(LABEL_OF_MARIO, 0);
        
        } catch (IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawStar(JFrame frame, int x, int y)
    {
        try{
            ImageIcon icon = new ImageIcon(scaledImage(ImageIO.read(new File("Elements\\Star.png")), 35, 35));
            LABEL_OF_STAR.setSize(35, 35);
            LABEL_OF_STAR.setLocation(x, y);
            LABEL_OF_STAR.setIcon(icon);
            LABEL_OF_STAR.setVisible(true);
            frame.add(LABEL_OF_STAR, 0);
        
        } catch (IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawGoods(JFrame frame, int x, int y)
    {
        try{
            
            ImageIcon icon = new ImageIcon(scaledImage(ImageIO.read(new File("Elements\\Goods.png")), 35, 35));
            LABEL_OF_GOODS.setSize(35, 35);
            LABEL_OF_GOODS.setLocation(x, y);
            LABEL_OF_GOODS.setIcon(icon);
            LABEL_OF_GOODS.setVisible(true);
            frame.add(LABEL_OF_GOODS, 0);
        
        } catch (IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawWalls(JFrame frame)
    {
        try{
            ImageIcon icon = new ImageIcon(scaledImage(ImageIO.read(new File("Elements\\wall.png")), 35, 35));
            int length_empties = p.getLengthEmpties();
            empty_point = p.getEmptyWallPositions();
            
            int index = 0;
            int x = 35;
            int y = 0;
            
            for(int i=1; i < 12; i++)
            {
                for(int j=0; j < 14; j++)
                {
                    if(index < length_empties)
                    {
                        if((empty_point[0][index] == x*j) && (empty_point[1][index] == y))
                        {    
                            ++index;
                        }
                        else
                        {
                            LABEL_OF_WALL = new JLabel();
                            LABEL_OF_WALL.setSize(35, 35);
                            LABEL_OF_WALL.setLocation(x*j, y);
                            LABEL_OF_WALL.setIcon(icon);
                            LABEL_OF_WALL.setVisible(true);
                            frame.add(LABEL_OF_WALL);
                        }
                    }
                    else
                    {
                        LABEL_OF_WALL = new JLabel();
                        LABEL_OF_WALL.setSize(35, 35);
                        LABEL_OF_WALL.setLocation(x*j, y);
                        LABEL_OF_WALL.setIcon(icon);
                        LABEL_OF_WALL.setVisible(true);
                        frame.add(LABEL_OF_WALL);
                    }
                }
                x = 35;
                y = 35*i;
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Image scaledImage(Image img, int width, int height)
    {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = resizedImage.createGraphics();
        graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphic.drawImage(img, 0, 0, width, height, null);
        graphic.dispose();
        
        return resizedImage;
    }
    
}
