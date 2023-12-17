import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class HomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1920, 1080); // size sa frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        // Set the background color of the panel to #FAF9F6
        panel.setBackground(new Color(0xFAF9F6));

        ImageIcon modelLogo = new ImageIcon("PICKME.png"); // Picture nis mga model
        ImageIcon pickMeLogo = new ImageIcon("logo.png"); // Picture sa atong logo
        ImageIcon nmgText = new ImageIcon("NOMOREGUESSING.png"); // Katu ning NOMOREGUESSING nga text
        ImageIcon quote = new ImageIcon("TEXT.png"); // Katu ning qoute sa atung homepage

        Image img1 = modelLogo.getImage();
        Image scaledImg1 = img1.getScaledInstance(689, 630, Image.SCALE_SMOOTH); // size sa image sa mga model
        modelLogo = new ImageIcon(scaledImg1);

        Image img2 = pickMeLogo.getImage(); 
        Image scaledImg2 = img2.getScaledInstance(685, 271, Image.SCALE_SMOOTH); // size sa image sa logo
        pickMeLogo = new ImageIcon(scaledImg2);

        Image img3 = nmgText.getImage();
        Image scaledImg3 = img3.getScaledInstance(481, 33, Image.SCALE_SMOOTH); // size sa image sa NOMOREGUESSING
        nmgText = new ImageIcon(scaledImg3);

        Image img4 = quote.getImage();
        Image scaledImg4 = img4.getScaledInstance(410, 83, Image.SCALE_SMOOTH); // size sa image sa qoute
        quote = new ImageIcon(scaledImg4);

        JLabel label1 = new JLabel(modelLogo);
        JLabel label2 = new JLabel(pickMeLogo);
        JLabel label3 = new JLabel(nmgText);
        JLabel label4 = new JLabel(quote);

        // LOGIN button
        JButton loginButton = createRoundedButton("LOG IN", new Color(0x4B5320));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LOGIN button clicked!");
            }
        });

        // SIGN UP button
        JButton signUpButton = createRoundedButton("SIGN UP", new Color(0x4B5320));
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SIGN UP button clicked!");
            }
        });

        // location sa mga images
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0); // model
        panel.setLayout(new GridBagLayout());
        panel.add(label1, c);

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(-310, -75, 0, 0); // logo nato
        panel.add(label2, c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(-663, -30, 0, 0); // NOMOREGUESSING
        panel.add(label3, c);

        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(-500, -100, 0, 0); // qoute
        panel.add(label4, c);

        // location nani sa button para LOG IN ug SIGN UP
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(-150, -235, 0, 0); // LOG IN
        panel.add(loginButton, c);

        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(-150, 15, 0, 0);
        panel.add(Box.createRigidArea(new Dimension(200, 0)), c);

        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(-150, 215, 0, 0); // SIGN UP
        panel.add(signUpButton, c);

        frame.setVisible(true);
    }

    // Mao ni mga characteristics sa button
    private static JButton createRoundedButton(String text, Color fontColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(172, 57)); // size
        button.setBackground(new Color(0xE4E4D7));
        button.setFont(new Font("Newsreader", Font.PLAIN, 25)); // font size
        button.setForeground(fontColor); // font color
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                new RoundedBorder(20) // kani kay border para rounded corner
        ));
        return button;
    }

    // para rounded corner ni sya pero ka click ra makita ang rounded corner
    private static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(c.getBackground());
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
}
