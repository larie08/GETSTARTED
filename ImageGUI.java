import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//round button
class RoundBorder extends AbstractBorder {
    private Color color;
    private int thickness = 5;
    private int radius = 15;

    public RoundBorder(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

public class ImageGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        // Set the background color of the panel to #FAF9F6
        panel.setBackground(new Color(0xFAF9F6));

        ImageIcon icon1 = new ImageIcon("PICKME.png");
        ImageIcon icon2 = new ImageIcon("logo.png");
        ImageIcon icon3 = new ImageIcon("NOMOREGUESSING.png");
        ImageIcon icon4 = new ImageIcon("TEXT.png");

        Image img1 = icon1.getImage();
        Image scaledImg1 = img1.getScaledInstance(689, 630, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(scaledImg1);

        Image img2 = icon2.getImage();
        Image scaledImg2 = img2.getScaledInstance(685, 271, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(scaledImg2);

        Image img3 = icon3.getImage();
        Image scaledImg3 = img3.getScaledInstance(481, 33, Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(scaledImg3);

        Image img4 = icon4.getImage();
        Image scaledImg4 = img4.getScaledInstance(410, 83, Image.SCALE_SMOOTH);
        icon4 = new ImageIcon(scaledImg4);

        JLabel label1 = new JLabel(icon1);
        JLabel label2 = new JLabel(icon2);
        JLabel label3 = new JLabel(icon3);
        JLabel label4 = new JLabel(icon4);

        JButton button = new JButton("GET STARTED");
        button.setPreferredSize(new Dimension(334, 67));
        button.setForeground(Color.decode("#4B5320"));

        // Set the background color of the button to #E4E4D7
        button.setBackground(new Color(0xE4E4D7));

        // Set the font of the button to "Newsreader"
        button.setFont(new Font("Newsreader", Font.PLAIN, 30));

        // Create a rounded border by setting the corner radius of the button
        button.setBorder(new RoundBorder(button.getBackground()));

        // Ensure that the button's border is painted and focus is not painted
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
                // Add any action you want to perform when the button is clicked here
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0); // adjusted insets
        panel.setLayout(new GridBagLayout());
        panel.add(label1, c);

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(-310, -75, 0, 0); // adjusted insets
        panel.add(label2, c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(-663, -30, 0, 0); // adjusted insets
        panel.add(label3, c);

        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(-500, -100, 0, 0); // adjusted insets
        panel.add(label4, c);

        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(-150, -75, 0, 0); // adjusted insets
        panel.add(button, c);

        frame.setVisible(true);
    }
}
