package mario.position;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mario.DrawComponent.Drawable;
import mario.PlayingFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Yassine
 */
public class Positions {
    
    int INDEX_IMAGE = 0;
    int CURRENT_INDEX_IMAGE;
    public static int INDEX_ROAD = 0;
    public static int LENGTH_IMAGES = 1;
    
    // Mario's positions
    int MARIO_POSITION_X;
    int MARIO_POSITION_Y;
    
    // Star's positions
    int STAR_POSITION_X;
    int STAR_POSITION_Y;
    
    // Goods's positions
    int GOODS_POSITION_X;
    int GOODS_POSITION_Y;
    
    // Setters
    public void setMarioPosition(int x, int y)
    {
        this.MARIO_POSITION_X = x;
        this.MARIO_POSITION_Y = y;
    }
    
    public void setStarPosition(int x, int y)
    {
        this.STAR_POSITION_X = x;
        this.STAR_POSITION_Y = y;
    }
    
    public void setGoodsPosition(int x, int y)
    {
        this.GOODS_POSITION_X = x;
        this.GOODS_POSITION_Y = y;
    }
    
    // Getters
    public int getMarioPosition_X()
    {
        return this.MARIO_POSITION_X;
    }
    
    public int getMarioPosition_Y()
    {
        return this.MARIO_POSITION_Y;
    }
    
    public int getStarPosition_X()
    {
        return this.STAR_POSITION_X;
    }
    
    public int getStarPosition_Y()
    {
        return this.STAR_POSITION_Y;
    }
    
    public int getGoodsPosition_X()
    {
        return this.GOODS_POSITION_X;
    }
    
    public int getGoodsPosition_Y()
    {
        return this.GOODS_POSITION_Y;
    }
    
    // Methods
    
    public void changeMarioPositionsValue(char operation, int direction)
    {
        switch(operation)
        {
            case '+': 
                if(direction == 39)
                    this.MARIO_POSITION_X = this.MARIO_POSITION_X + 35; // Right
                else
                    this.MARIO_POSITION_Y = this.MARIO_POSITION_Y + 35; // Down
                    break;
            case '-': 
                if(direction == 37)    
                    this.MARIO_POSITION_X = this.MARIO_POSITION_X - 35; // Left
                else
                    this.MARIO_POSITION_Y = this.MARIO_POSITION_Y - 35; // UP
                    break;
        }
    }
    
    public void changeGoodsPositionsValue(char operation, int direction)
    {
        switch(operation)
        {
            case '+': 
                if(direction == 39)
                    this.GOODS_POSITION_X = this.GOODS_POSITION_X + 35; // Right
                else
                    this.GOODS_POSITION_Y = this.GOODS_POSITION_Y + 35; // Down
                    break;
            case '-': 
                if(direction == 37)    
                    this.GOODS_POSITION_X = this.GOODS_POSITION_X - 35; // Left
                else
                    this.GOODS_POSITION_Y = this.GOODS_POSITION_Y - 35; // UP
                    break;
        }
    }
    
    public int[][] getEmptyWallPositions() {
        try {
            File ReadFile = new File("Way Positions.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(ReadFile);
            document.getDocumentElement().normalize();
            
            LENGTH_IMAGES = document.getElementsByTagName("Road").item(INDEX_ROAD).getChildNodes().getLength() / 2;
            NodeList Image = document.getElementsByTagName("Image");
            int[][] point = new int[2][LENGTH_IMAGES];
            
            for(int j = 0; j < LENGTH_IMAGES; j++)
            {
                int i = 0;
                Element element = (Element) Image.item(INDEX_IMAGE);
                point[i][j] = Integer.parseInt(element.getAttribute("X_Position"));
                point[++i][j] = Integer.parseInt(element.getAttribute("Y_Position"));
                ++INDEX_IMAGE;
            }
            
            ++INDEX_ROAD;
            
            return point;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(PlayingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getLengthEmpties()
    {
        try {
            File ReadFile = new File("Way Positions.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(ReadFile);
            document.getDocumentElement().normalize();
            
            LENGTH_IMAGES = document.getElementsByTagName("Road").item(INDEX_ROAD).getChildNodes().getLength() / 2;
            
            return LENGTH_IMAGES;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    

}
