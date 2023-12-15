import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Gender {

    private JFrame frame;

    public Gender() {
        frame = new JFrame("Gender Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.decode("#FAF9F6"));
        frame.setLayout(new BorderLayout());

        // Create label with custom color
        JLabel label = new JLabel("SELECT GENDER");
        label.setFont(new Font("Tahoma", Font.BOLD, 24));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new EmptyBorder(20, 0, 20, 0));
        label.setForeground(Color.decode("#4B5320")); // Set custom color

        // Create image buttons
        JButton femaleButton = createImageButton("C:\\Users\\QHTF\\Downloads\\female.png", 450, 450); // ari lang iadjust ang size sa button if dako or gamay ra sa inyong screen
        JButton maleButton = createImageButton("C:\\Users\\QHTF\\Downloads\\male.png", 450, 450);

        // Add action listeners to buttons
        femaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Female selected"); //pwede rasad ari na ninyu iredirect para sa categories for female
                //optional ra ha kung naa moy nahibaw an lain way para ma redirect forda go
            }
        });

        maleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Male selected"); //pwede rasad ari na ninyu iredirect para sa categories for male

            }
        });

        // Create panel to hold buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(femaleButton);
        buttonPanel.add(maleButton);

        // Add components to the frame
        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.pack();
        frame.setLocationRelativeTo(null); //center ang content sa frame
        frame.setVisible(true);
    }
      //para invisible ang background sa button, no border || bg color etc....
      //add ug function para maka adjust2 sa button
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gender();
            }
        });
    }
}
