import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;


class CustomLabel extends JLabel {

    public CustomLabel(String text) {
        super(text);
        setFont(new Font("Newsreader", Font.PLAIN, 30));
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(new EmptyBorder(100, 0, 0, 0)); 
        setForeground(Color.BLACK);
        setOpaque(true);
        
    }
}

public class Gender {

    private JFrame frame;

    public Gender() {
        frame = new JFrame("Gender Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.decode("#FAF9F6"));
        frame.setLayout(new BorderLayout());
        
        // Create custom label
        CustomLabel label = new CustomLabel("SELECT GENDER");
        
        // Create image buttons
        JButton femaleButton = createImageButton("C:\\Users\\QHTF\\Downloads\\female.png", 490, 490); //size na sa button adjust lang pud mo accordnig sa inyung pc
        JButton maleButton = createImageButton("C:\\Users\\QHTF\\Downloads\\male.png", 490, 490);

        // Add action listeners to buttons
        femaleButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Female selected"));
        maleButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Male selected"));

        // Create panel to hold buttons with reduced distance
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(femaleButton);
        buttonPanel.add(maleButton);

        // Set smaller horizontal gap between buttons
        ((GridLayout) buttonPanel.getLayout()).setHgap(0); // 0 ang gap kay dako kaayo ang border sa image button bisag naka invisible pana
        // maong lisud kaayo i apply ang naa sa figma nga gamay rag space between duha ka button dako sad kaayo ang size sa button if pagamyan kiwaw kaau huuhuhuhu
        // i try ug run nya i click between sa duha ka button mo gana ang actionlistener message

        // Add components to the frame
        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // center the content in the frame
        frame.setVisible(true);
    }

    private JButton createImageButton(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);

        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(width, height));

        return button;
    }
    
     private void centerFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gender());
    }
}
