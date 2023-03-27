import java.awt.*;
import java.awt.event.ActionListener;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.*;

public class AddInterface {
String s;
    AddInterface() {
        JLabel titleLabel = new JLabel("Ajouter une séance ");
titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
titleLabel.setForeground(Color.RED);
titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel salelLabel = new JLabel("Choisir la salle : ");
        salelLabel.setForeground(Color.blue);
        String[] datas = { "Salle 1", "Salle 2" };
        JComboBox salles = new JComboBox<>(datas);

        JPanel p1 = new JPanel();
        p1.add(salelLabel);
        p1.add(salles);
        
        
        JLabel datelLabel = new JLabel("Choisir le jour : ");
        datelLabel.setForeground(Color.blue);
        String[] datad = { "Lundi", "Mardi" , "Mercredi"};
        JComboBox date = new JComboBox<>(datad);
        JPanel p2 = new JPanel();
        p2.add(datelLabel);
        p2.add(date);

        JLabel timeLabel = new JLabel("Choisir l'heure' : ");
        timeLabel.setForeground(Color.blue);
        String[] datat = { "8", "10" , "14", "16"};
        JComboBox time = new JComboBox<>(datat);
        JPanel p3 = new JPanel();
        p3.add(timeLabel);
        p3.add(time);

        JLabel matierLabel = new JLabel("Choisir quelle matiere : ");
        matierLabel.setForeground(Color.blue);
        String[] datam = { "8", "10" , "14", "16"};
        JComboBox matier = new JComboBox<>(datam);
        JPanel p4 = new JPanel();
        p4.add(matierLabel);
        p4.add(matier);

        JLabel formateurLabel = new JLabel("Choisir quelle formateur : ");
        formateurLabel.setForeground(Color.blue);
        String[] dataf = { "8", "10" , "14", "16"};
        JComboBox formateur = new JComboBox<>(dataf);
        JPanel p5 = new JPanel();
        p5.add(formateurLabel);
        p5.add(formateur);
      
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
        // Ajouter les onglets au frame
        f.setLayout(new GridLayout(7,2));
    f.add(titleLabel);
    f.add(p1);
    f.add(p2);
    f.add(p3);
    f.add(p4);
    f.add(p5);
    f.add(buttonpanel);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setSize(400,500);
}
public static void main(String[] args) 
{
  new AddInterface();
}

String getS(){return s;}
}
