import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
public class AddMatiere {
  AddMatiere(){
        JLabel titleLabel = new JLabel("Ajouter une matiere");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                JLabel namelLabel = new JLabel("Nom matière : ");
                namelLabel.setForeground(Color.blue);
                JTextField name=new JTextField("                               "); 
                JPanel p1 = new JPanel();
                p1.add(namelLabel);
                p1.add(name);
               
                JLabel codeLabel = new JLabel("Code matière : ");
                codeLabel.setForeground(Color.blue);
                JTextField  code = new JTextField ("                               "); 
                JPanel p2 = new JPanel();
                p2.add(codeLabel);
                p2.add(code);
      
              
                JButton ajouter = new JButton("Ajouter");
                JButton annuler = new JButton("Annuler");
                JPanel buttonpanel = new JPanel();
                buttonpanel.add(ajouter);
                buttonpanel.add(annuler);
        
                ajouter.addActionListener(new java.awt.event.ActionListener() {
                  @Override
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                
        
                  }
              });
              annuler.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                  System.exit(0);
                }
            });
        



            

                JFrame f = new JFrame();

                Image img = Toolkit.getDefaultToolkit().getImage("E:/img.jpg");
        
               f.setContentPane(new JPanel() {
                  @Override
                  public void paintComponent(Graphics g) {
                     super.paintComponent(g);
                     g.drawImage(img, 0, 0, null);
                  }
               });
               f.pack();
               
              


                // Ajouter les  panels au frame
                f.setLayout(new GridLayout(6,2));
            f.add(titleLabel);
            f.add(p1);
            f.add(p2); 
            f.add(buttonpanel);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setSize(400,500);   
    }
    
    public static void main(String[] args) {
      new AddMatiere();
    }
}
