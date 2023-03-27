import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ReservationSalle extends JFrame implements ActionListener {
    private JComboBox<String> salleComboBox;
    private JComboBox<String> heureComboBox;
    private JTextArea resultatTextArea;
    private HashMap<String, ArrayList<String>> sallesDisponibles;

    public ReservationSalle() {
        super("Réservation de salles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation des salles disponibles
        sallesDisponibles = new HashMap<String, ArrayList<String>>();
        sallesDisponibles.put("Salle A", new ArrayList<String>(Arrays.asList("8h-9h", "10h-11h", "14h-15h")));
        sallesDisponibles.put("Salle B", new ArrayList<String>(Arrays.asList("9h-10h", "11h-12h", "15h-16h")));
        sallesDisponibles.put("Salle C", new ArrayList<String>(Arrays.asList("8h-9h", "11h-12h", "14h-15h", "16h-17h")));

        // Initialisation des composants graphiques
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel salleLabel = new JLabel("Salle : ");
        salleComboBox = new JComboBox<String>(sallesDisponibles.keySet().toArray(new String[0]));
        JLabel heureLabel = new JLabel("Heure : ");
        heureComboBox = new JComboBox<String>();
        updateHeureComboBox();
        JButton reserverButton = new JButton("Réserver");
        reserverButton.addActionListener(this);
        topPanel.add(salleLabel);
        topPanel.add(salleComboBox);
        topPanel.add(heureLabel);
        topPanel.add(heureComboBox);
        topPanel.add(reserverButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        resultatTextArea = new JTextArea(10, 40);
        resultatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultatTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String salle = (String) salleComboBox.getSelectedItem();
        String heure = (String) heureComboBox.getSelectedItem();
        if (sallesDisponibles.get(salle).contains(heure)) {
            sallesDisponibles.get(salle).remove(heure);
            updateHeureComboBox();
            resultatTextArea.append("Réservation de la salle " + salle + " pour " + heure + " effectuée.\n");
        } else {
            resultatTextArea.append("La salle " + salle + " n'est pas disponible pour " + heure + ".\n");
        }
    }

    private void updateHeureComboBox() {
        String salle = (String) salleComboBox.getSelectedItem();
        heureComboBox.removeAllItems
    }
