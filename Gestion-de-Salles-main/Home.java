
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


class Home extends JFrame{

  private JFrame frame = new JFrame("JTable RowHeader");
  private JScrollPane scrollPaneS1,scrollPaneS2;
  private JTable table1,table2, header;
  private JTable headerTable;
  Statement st;
  ResultSet rs;
  Connect c=new Connect();
  String seanceinfo="" ;
  Connection  cnx=c.gConnection();
  Home() {
    
   
    //Créer le tableau de salle 1
    JTableRowHeader tab1=new JTableRowHeader();
    table1=tab1.getTable();
    header= tab1.getHeader();
    scrollPaneS1=tab1.getScrollPane();
    //Créer le panneau de salle 1
    JPanel p1 = new JPanel();
    p1.add(scrollPaneS1); p1.repaint();
     //Créer le tableau de salle 2
    JTableRowHeader tab2=new JTableRowHeader();
    scrollPaneS2=tab2.getScrollPane();
    scrollPaneS2.setBounds(10, 20, 500, 500);
    //Créer le panneau de salle 2
    JPanel p2 = new JPanel();
    p2.add(scrollPaneS2); p2.repaint();



    for (int j=0;j<=5;j ++){
      for (int h=0;h<=3;h++){
        String heure= (String) table1.getColumnName(h).toString();
        String jour= header.getValueAt(j,0).toString();
       
        try {
          st = (Statement) cnx.createStatement();
          rs = st.executeQuery("SELECT * FROM seance WHERE jour LIKE '"+jour+"' AND date_deb LIKE '"+heure+"%'");
       
        while (rs.next()){  System.out.println("Les  : "+rs.getString(1));

           if (!rs.getString("codeM").isEmpty()){
              seanceinfo="Matiére: "+getMatierName(rs.getString("codeM"))+"\n"+
                   "Nom fromateur : "+getEnsName(rs.getString("cinEns"));
          System.out.println("Les info de la seance  sont : "+heure+" "+jour+ " "+seanceinfo);
          table1.setValueAt(seanceinfo, j,h);}
        
       }}  catch (SQLException e1) {
          e1.printStackTrace();
          }
    }}

    table1.addMouseListener(new java.awt.event.MouseAdapter()
  
    { public void mouseClicked(java.awt.event.MouseEvent e)

       {    

        int row=table1.rowAtPoint(e.getPoint());

        int col= table1.columnAtPoint(e.getPoint());
       if (table1.getValueAt(row,col).toString().isEmpty())  {  AddInterface ad= new AddInterface(); table1.setValueAt(ad.getS(), row, col);
         p1.repaint(); p2.repaint();}
        else{
        JOptionPane.showMessageDialog(null,"Informations de la seance :\n "+ table1.getValueAt(row,col).toString());}
          }
         } 
    ); 

    
    
    




    //Créer le conteneur des onglets
    JTabbedPane onglets = new JTabbedPane();
    //Définir la position de conteneur d'onglets
    onglets.setBounds(20,20,600,150);
    //Associer chaque panneau à l'onglet correspondant
    onglets.add("Salle 1 ", p1);
    onglets.add("Salle 2 ", p2);
    JPanel p3=new JPanel();
    JButton b1= new JButton("Affecter étudiant");
    JButton b2= new JButton("Ajouter enseignat");
    JButton b3= new JButton("Ajouter Matiere");
    p3.add(b1); p3.add(b2); p3.add(b3);

    b1.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       new AffecterEtudiant();
     }
  });
  b2.addActionListener(new java.awt.event.ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
     new AddEns();
   }
});
b3.addActionListener(new java.awt.event.ActionListener() {
  @Override
  public void actionPerformed(java.awt.event.ActionEvent evt) {
   new AddMatiere();
 }
});


    frame.setLayout(new GridLayout(2,2));
    //Ajouter les onglets au frame
    frame.add(p3);
    frame.add(onglets);

   
    frame.add(p3);
    frame.setSize(800,700);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

   
  }

  
  String getEnsName(String id){
    String m="";
    try {
    Statement  st = (Statement) cnx.createStatement();
    ResultSet rs = st.executeQuery("SELECT nom, prenom FROM enseignant WHERE cinEns = '"+id+"'");
    rs.first();
    //rs.next();
     m= rs.getString("nom")+" "+rs.getString("prenom");
    } catch (SQLException e) { 
      e.printStackTrace();
    }
    return m;
  }
  
  String getMatierName(String id){
    String m="";
    try {
      Statement st = (Statement) cnx.createStatement();
    
      ResultSet  rs = st.executeQuery("SELECT nom FROM matiere WHERE codeM = '"+id+"'");
    rs.first();
     m= rs.getString("nom");
    } catch (SQLException e) { 
      e.printStackTrace();
    }
    return m;
  }


  public static void main(String[] args) 
  {
    new Home();
  }

}