
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class CompanyRecord extends javax.swing.JFrame {
Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;
    public CompanyRecord() {
        initComponents();
        setLocationRelativeTo(null);
        Get_Data();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comapny Record");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }
private void Get_Data(){
     con=Connect.ConnectDB();
        String sql="select CompanyID as 'Company ID',CompanyName as 'Company Name',Address, ContactNo as 'Contact No.',Website from Company order by CompanyName";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {
     
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
    this.hide();
    Company frm = new Company();
    frm.setVisible(true);
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            this.hide();
            Company frm= new Company();
            frm.setVisible(true);
            int row= jTable1.getSelectedRow();
             String add= jTable1.getModel().getValueAt(row,0).toString();
             frm.txtCompanyID.setText(add);
             String add1= jTable1.getModel().getValueAt(row,1).toString();
             frm.txtCompanyName.setText(add1);
             String add2= jTable1.getModel().getValueAt(row,2).toString();
             frm.txtAddress.setText(add2);
             String add3= jTable1.getModel().getValueAt(row,3).toString();
             frm.txtContactNo.setText(add3);
             String add4= jTable1.getModel().getValueAt(row,4).toString();
             frm.txtWebsite.setText(add4);
             frm.btnUpdate.setEnabled(true);
             frm.btnDelete.setEnabled(true);
             frm.btnSave.setEnabled(false);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyRecord().setVisible(true);
            }
        });
    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}