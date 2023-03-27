import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.*;



public class JTableRowHeader {

    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    private JTable headerTable;
    Component component;
    private String s;

    
    public JTableRowHeader() { 
        
        Object[][] donnees = {
            {"",  "","",""},
            {"",  "","",""},
            {"",  "","",""},
            {"",  "","",""},
            {"",  "","",""},
            {"",  "","",""}     
    };
    String[] entetes = {"8h", "10h", "12h", "14h"};

       table = new JTable(donnees,entetes);
       table.setCellSelectionEnabled(false);
       //table.getColumnModel().getColumn(2).setPreferredWidth(100);
       table.setPreferredSize(new DimensionUIResource(500, 95));
       model = new DefaultTableModel() {
           private static final long serialVersionUID = 1L;

           @Override
            public int getColumnCount() {
                return 1;
            }
  
            @Override
            public int getRowCount() {
                return table.getRowCount();
            }
        };

        headerTable = new JTable(model);
        headerTable.setValueAt("Lundi", 0, 0);
        headerTable.setValueAt("Mardi", 1, 0);
        headerTable.setValueAt("Mercredi", 2, 0);
        headerTable.setValueAt("Jeudi", 3, 0);
        headerTable.setValueAt("Vendredi", 4, 0);
        headerTable.setValueAt("Samedi", 5, 0);
        headerTable.setShowGrid(true);
        headerTable.setPreferredScrollableViewportSize(new Dimension(100, 300));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
  
            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
  
                boolean selected = table.getSelectionModel().isSelectedIndex(row);
                Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.red);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
     
      
        scrollPane = new JScrollPane(table);
        scrollPane.setRowHeaderView(headerTable);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
       
     /*   table.addMouseListener(new java.awt.event.MouseAdapter()
  
        { public void mouseClicked(java.awt.event.MouseEvent e)
    
           {    
    
            int row=table.rowAtPoint(e.getPoint());
    
            int col= table.columnAtPoint(e.getPoint());
    
            JOptionPane.showMessageDialog(null," Value in the cell clicked :"+ " "+table.getValueAt(row,col).toString());
    
           System.out.println(" Value in the cell clicked :"+" " +table.getValueAt(row,col).toString());
    
           }
        }
    );*/
    }
    JTable getHeader(){return headerTable;}
    JScrollPane  getScrollPane() {return scrollPane;}


    JTable getTable(){return table;}

    String getString(){return s;}

}