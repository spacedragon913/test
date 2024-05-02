import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.net.URL;
import java.io.IOException;
import java.awt.FlowLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            URL imageUrl = new URL("https://cdn.britannica.com/53/117053-050-6B05C512/Rock.jpg");
            BufferedImage originalImage = ImageIO.read(imageUrl);

            // Scale the image to a specific width and height
            Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            ImageIcon icon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(icon);

            // Set layout manager and add label to the content pane
            frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
            frame.getContentPane().add(label);

            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
