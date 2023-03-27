import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;

public class AffecterEtudiant {
  
    AffecterEtudiant(){
        JLabel titleLabel = new JLabel("Ajouter un étudiant");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

       // cinEtu	nom	prenom	email	numTel	niveau	numeroSal	;
      
       JLabel namelLabel = new JLabel("Nom et prenom : ");
       namelLabel.setForeground(Color.blue);
       JTextField name=new JTextField("                               ");
       JTextField prename=new JTextField("                               ");
       JPanel p1 = new JPanel();
       p1.add(namelLabel);
       p1.add(name);p1.add(prename);
       
       
       JLabel cinLabel = new JLabel("Numéro CIN : ");
       cinLabel.setForeground(Color.blue);
       JTextField  cin = new JTextField ("                               "); 
       JPanel p2 = new JPanel();
       p2.add(cinLabel);
       p2.add(cin);

       JLabel emailLabel = new JLabel("Email : ");
       emailLabel.setForeground(Color.blue);
       JTextField email = new JTextField ("                               ");
       JPanel p3 = new JPanel();
       p3.add(emailLabel);
       p3.add(email);

       JLabel numtelLabel = new JLabel("Num tel : ");
       numtelLabel.setForeground(Color.blue);
       JTextField numtel= new JTextField("                               ");
       JPanel p4 = new JPanel();
       p4.add(numtelLabel);
       p4.add(numtel);

       JLabel nivLabel = new JLabel("Niveau : ");
       nivLabel.setForeground(Color.blue);
       JTextField niv= new JTextField("                               ");
       JPanel p5 = new JPanel();
       p5.add(nivLabel);
       p5.add(niv);

       JLabel numseanceLabel = new JLabel("Numero Seance : ");
       numseanceLabel .setForeground(Color.blue);
       JTextField numseance= new JTextField("                               ");
       JPanel p6 = new JPanel();
       p6.add(numseanceLabel );
       p6.add(numseance );
     
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
       // Ajouter les  panels au frame
       f.setLayout(new GridLayout(10,2));
   f.add(titleLabel);
   f.add(p1);
   f.add(p2);
   f.add(p3);
   f.add(p4);
   f.add(p5);
   f.add(p6);
   f.add(buttonpanel);
   f.setResizable(false);
   f.setLocationRelativeTo(null);
   f.setVisible(true);
   f.setSize(400,550);   
}

public static void main(String[] args) {
new AffecterEtudiant();
}
}