package com.Project.Dairy;

import com.Project.FIle_Encrypt.EncryptionV1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class DairyMainGui extends JFrame implements ActionListener {
    Image image=new ImageIcon("D:\\Progr\\src\\com\\Project\\Dairy\\Khaby.jpg").getImage();

    DairyDao dairyDao;
    Date date=new Date(System.currentTimeMillis());
    JTable table;
    JPanel top,bottom;
    String[] obj={"ID","Title","Created At"};
    String [] sort={"Get all Note","Get Note by Date","Get by Title"};
    JComboBox box;
    JButton add,delete,edit,show;
    JLabel label=new JLabel("Never Give Up ");
    public DairyMainGui(){
        dairyDao=new DairyDao();
        setIconImage(image);

        top=new JPanel(new FlowLayout(FlowLayout.LEFT,3,1));
        add=new JButton("Add Note");
        delete=new JButton("Delete Note");
        edit=new JButton("Edit Note");
        show=new JButton("Show Note");
        box=new JComboBox<>(sort);

        top.add(add);top.add(delete);top.add(edit);top.add(show);top.add(box);
        add.addActionListener(this);
        delete.addActionListener(this);
        edit.addActionListener(this);
        show.addActionListener(this);
        box.addActionListener(this);

        DefaultTableModel model=new DefaultTableModel(obj,0);
        table=new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane pane=new JScrollPane(table);

        bottom=new JPanel(new BorderLayout());
        bottom.add(BorderLayout.CENTER,label);



        add(BorderLayout.NORTH,top);
        add(BorderLayout.CENTER,pane);
        add(BorderLayout.SOUTH,bottom);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200,600);

        setLocation(200,100);
        load(dairyDao.getAllDairy());
    }


    public static void main(String[] args) {
        new DairyMainGui().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String s=JOptionPane.showInputDialog("Enter the title");
            if (s==null){
                return;
            }
            Dairy dairy=new Dairy(0,s,"",new Date(System.currentTimeMillis()));
            if (dairyDao.addANote(dairy)){
                JOptionPane.showMessageDialog(this,"Note added Successfully");
            }else {
                JOptionPane.showMessageDialog(this,"Error try again ");return;
            }
            dispose();
            DairyEditPage.main(new String[]{},dairy);
        } else if (e.getSource() == delete) {
            int row=table.getSelectedRow();
            if (row<0){
                JOptionPane.showMessageDialog(this,"Select the Note to Delete");return;
            }
            int id=(int)table.getValueAt(row,0);
            if (dairyDao.deleteDairy(id)){
                JOptionPane.showMessageDialog(this,"Note is Deleted Successfully");
            }else {
                JOptionPane.showMessageDialog(this,"Error try again ");
            }
        } else if (e.getSource() == edit) {
            int row=table.getSelectedRow();
            if (row<0){
                JOptionPane.showMessageDialog(this,"Select the Note to Edit");return;
            }
            int id=(int)table.getValueAt(row,0);
            Dairy dairy=dairyDao.getDairyById(id);
            if (dairy==null){
                JOptionPane.showMessageDialog(this,"Error pls try again ");return;
            }
//            setVisible(false);
            DairyEditPage.main(new String[]{},dairy);
            dispose();
        }
        else if (e.getSource() == show) {
            int row=table.getSelectedRow();
            if (row<0){
                JOptionPane.showMessageDialog(this,"Select the Note to Show");return;
            }
            int id=(int)table.getValueAt(row,0);
            Dairy dairy=dairyDao.getDairyById(id);
            if (dairy==null){
                JOptionPane.showMessageDialog(this,"Error pls try again ");return;
            }
//            setVisible(false);
            DairyShowPage.main(new String[]{},dairy);
            dispose();
        } else if (e.getSource()==box) {
            int i=box.getSelectedIndex();
            if (i<0){
                JOptionPane.showMessageDialog(this,"Select Valid Option");return;
            }
            String val=box.getSelectedItem().toString();
            if (val.equalsIgnoreCase("Get all Note")){
                List<Dairy>list=dairyDao.getAllDairy();
                load(list);
                return;
            }
            else if (val.equalsIgnoreCase("Get by Title")) {
                String s=JOptionPane.showInputDialog("Enter The Title of Dairy page");
                if (s==null)return;
                List<Dairy>list=dairyDao.getDataByName(s);
                if (list.isEmpty()){
                    JOptionPane.showMessageDialog(this,"NO Dairy page with this title");return;
                }
               load(list);
                return;
            } else {
                String s=JOptionPane.showInputDialog("Enter The Date in this format (YYYY-MM-DD)");
                if (s==null)return;
                try{
                    date=Date.valueOf(s);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,"IN-Valid Date format ");return;
                }
                load(date);
            }
        }
        load(dairyDao.getAllDairy());
    }
    public void load(List<Dairy>list){
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Dairy dairy:list){
            model.addRow(new Object[]{dairy.getId(),dairy.getTittle(),dairy.getDate_of()});
        }
    }

    public void load(Date date){
        List<Dairy>list=dairyDao.getDataByDate(date);
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Dairy dairy:list){
            model.addRow(new Object[]{dairy.getId(),dairy.getTittle(),dairy.getDate_of()});
        }
    }
}
