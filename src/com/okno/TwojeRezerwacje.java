package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TwojeRezerwacje extends JComponent {

    JTable tabelaRezerwacje;

    public TwojeRezerwacje(Uzytkownicy uzyt)
    {
        setLayout(null);

        BazaDanych baza = new BazaDanych();
        String[][] data = baza.selectRezerwacjeUzytkownika(uzyt.getIdUzytkownika());

        Font font = new Font("Impact", Font.PLAIN, 40);
        if(data[0][0] != null) {

            tabelaRezerwacje = new JTable(data, new Object[]{"Film", "Data", "Godzina", "Miejsce", ""});
            tabelaRezerwacje.setFont(font);
//            tabelaRezerwacje.setEnabled(false);
            tabelaRezerwacje.setRowHeight(50);

            //SET CUSTOM RENDER TO TEAMS COLUMN
            tabelaRezerwacje.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer() );

            //SET VUSTOM EDITOR TO TEAMS COLUMN
            tabelaRezerwacje.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField("zrezygnuj")));

            tabelaRezerwacje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


            JScrollPane scroll = new JScrollPane(tabelaRezerwacje);
            scroll.setBounds(50, 40, 1350, 500);
            add(scroll);

        }else{
            JLabel tRezerwacjaTeraz = new JLabel("Brak zarezerwowanych biletow. Zarezerwuj juz teraz!", SwingConstants.CENTER);
            tRezerwacjaTeraz.setBounds(50,40,1350,500);
            tRezerwacjaTeraz.setFont(font);
            add(tRezerwacjaTeraz);
        }

    }

}

class ButtonRenderer extends JButton implements TableCellRenderer
{
    public ButtonRenderer()
    {
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setText((value == null) ? "":value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor
{
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor(JTextField textField) {
        super(textField);

        btn = new JButton();
        btn.setOpaque(true);

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

        @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        //SET TEXT TO BUTTON, SET CLICKED TO TRUE, THEN RETURN THE BTN OBJECT

        lbl = (value == null) ? "": value.toString();
        btn.setText(lbl);
        clicked = true;
        //to do
        return btn;
//        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    //IF BUTTON CELL VALUE CHANGES, IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if(clicked)
        {
            //SHOW US SOME MESSAGE
            JOptionPane.showMessageDialog(btn, lbl + " clicked");

        }
        //SET IT TO FALSE NOW THAT ITS CLICKED
//        return super.getCellEditorValue();
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

