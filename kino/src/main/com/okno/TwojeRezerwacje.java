package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
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

            tabelaRezerwacje = new JTable(data, new Object[]{"Film", "Data", "Godzina", "Miejsce", "", "ID_rezerwacje"}){
                private static final long serialVersionUID = 1L;

                public boolean isCellEditable(int row, int column) {
                    if(column == 4){
                        return true;
                    }else{
                        //all other columns to false
                        return false;
                    }
                };
            };

            tabelaRezerwacje.removeColumn(tabelaRezerwacje.getColumnModel().getColumn(5));

            tabelaRezerwacje.setFont(font);
            tabelaRezerwacje.setRowHeight(50);

            //SET CUSTOM RENDER TO TEAMS COLUMN
            tabelaRezerwacje.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer() );

            //SET VUSTOM EDITOR TO TEAMS COLUMN
            tabelaRezerwacje.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField("Zrezygnowano"), tabelaRezerwacje.getRowCount()));

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
    private Boolean[] enabel;

    public ButtonEditor(JTextField textField, int rowNumber) {
        super(textField);
        btn = new JButton();
        btn.setOpaque(true);

        enabel = new Boolean[rowNumber];
        for(int i = 0; i < rowNumber; i++)
            enabel[i] = true;

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
        if(enabel[row]) {
            btn.setText("ZREZYNOWANO");
            enabel[row] = false;
            btn.setEnabled(false);

            String index = (String) table.getModel().getValueAt(row, 5);

            BazaDanych baza = new BazaDanych();

            baza.deleteRezerwacjeUzytkownika( Integer.parseInt(index));

            baza.closeConnection();
        }
        return btn;
//        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }


    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}