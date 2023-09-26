package sk.tmconsulting.evidenciavydavkov.view;

import com.toedter.calendar.JDayChooser;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class GUI {
    public static void main(String[] args) {

        JFrame hlavneOkno = new JFrame("Evidencia výdavkov"); // vytvorime okno


        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Načítanie obrázka (nahradiť cestu k súboru obrázka)
                ImageIcon backgroundImage = new ImageIcon("podklad.jpg");

                // Vykreslenie obrázka ako pozadia
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        hlavneOkno.setMinimumSize(new Dimension(800, 600));
        hlavneOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ked kliknem na X na okne (cize vo frame) tak sa zatvori standardne
        hlavneOkno.setLocationRelativeTo(null); // vycentrovanie okna
        hlavneOkno.setMaximumSize(new Dimension(800,600)); //maximalne okno




        // JFrame by mal obsahovat panel, teda container JPanel
        //JPanel panel = new JPanel();
        backgroundPanel.setLayout(null); // layout pre panel bude null, cize prazdny






        hlavneOkno.setContentPane(backgroundPanel); // Dany   panel pridame do hlavneOkno


        // Názov vydavku label
        JLabel labelNazovVydavku = new JLabel("Názov výdavku");
        labelNazovVydavku.setBounds(85, 65, 100, 20); // x, y, sirka, vyska
       // labelNazovVydavku.setHorizontalAlignment(JTextField.RIGHT); //nastavuje kruzor v okne doprava
        labelNazovVydavku.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo
        labelNazovVydavku.setFont(new Font("Montserrat", Font.BOLD, 12));
        backgroundPanel.add(labelNazovVydavku);

        // Názov vydavku text
        JTextField textNazovVydavku = new JTextField();
        textNazovVydavku.setBounds(190, 60, 200, 30); // x, y, sirka, vyska
        textNazovVydavku.setFont(new Font("Montserrat", Font.PLAIN, 12));
        //textNazovVydavku.setHorizontalAlignment(JTextField.RIGHT); //nastavuje kruzor v okne doprava
        backgroundPanel.add(textNazovVydavku);


        // Cena vydavku label
        JLabel labelCenaVydavku = new JLabel("Cena výdavku");
        labelCenaVydavku.setBounds(85, 95, 100, 20); // x, y, sirka, vyska
        //labelCenaVydavku.setHorizontalAlignment(JTextField.RIGHT);
        labelCenaVydavku.setFont(new Font("Montserrat", Font.BOLD, 12));
        labelCenaVydavku.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo

        backgroundPanel.add(labelCenaVydavku);

        // Cena vydavku text
        JTextField textCenaVydavku = new JTextField();
        textCenaVydavku.setBounds(190, 90, 200, 30); // x, y, sirka, vyska
        textCenaVydavku.setFont(new Font("Montserrat", Font.PLAIN, 12));
       // textCenaVydavku.setHorizontalAlignment(JTextField.RIGHT);
        backgroundPanel.add(textCenaVydavku);




        //Kategoria vydavku
        JLabel labelKategorie = new JLabel("Kategória"); // popisok
        labelKategorie.setBounds(85,125,100,20); // x, y, sirka, vyska
       // textCenaVydavku.setHorizontalAlignment(JTextField.RIGHT);
        labelKategorie.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo
        labelKategorie.setFont(new Font("Montserrat", Font.BOLD, 12));
        backgroundPanel.add(labelKategorie);

        String[] kategorie = { "Potraviny", "BENZÍN", "INÉ", "OBLEČENIE", "KONÍČKY" };

        //Create the combo box, select item at index 4. - dropbox s možnostami
        //Indices start at 0, so 4 specifies the KONÍČKY.  - indikuje zacina 0 konci 4
        JComboBox cmbKategorie = new JComboBox(kategorie);
        cmbKategorie.setFont(new Font("Montserrat", Font.PLAIN, 12));
        cmbKategorie.setSelectedIndex(4);
        cmbKategorie.setBounds(190,120,200,30); // x, y, sirka, vyska
        backgroundPanel.add(cmbKategorie);

        // Date picker- Datum

        //Kategoria vydavku
        JLabel labelDatum = new JLabel("Dátum"); // popisok
        labelDatum.setBounds(85,155,100,20); // x, y, sirka, vyska
        labelDatum.setFont(new Font("Montserrat", Font.BOLD, 12));
        labelDatum.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo
        backgroundPanel.add(labelDatum);

        // date picker  -vyberač dátumu OLD
       /* UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBounds(190,150,200,30); // x, y, sirka, vyska
        JFormattedTextField textField = datePicker.getJFormattedTextField();
        textField.setFont(new Font("sans-serif", Font.BOLD, 13));
        panel.add(datePicker);*/
        //date picker  -vyberač dátumu OLD END

       /* JCalendar calendar = new JCalendar(); // Vytvorte inštanciu JCalendar
        panel.add(calendar);
        calendar.setBounds(290,150,200,30); // x, y, sirka, vyska

        hlavneOkno.setVisible(true);*/
        // jCalendar picker NEW
        JDateChooser dateChooser = new JDateChooser(); // Vytvorte inštanciu JDateChooser



        dateChooser.setBounds(190,150,200,30); // x, y, sirka, vyska
        //dateChooser.getJCalendar().setPreferredSize(new Dimension(450, 300));


         dateChooser.getJCalendar().setLocale(new Locale("sk"));
        //dateChooser.setDateFormatString("dd. MMMM yyyy");

         dateChooser.getJCalendar().setPreferredSize(new Dimension(480, 300));
         dateChooser.setFont(new Font("Montserrat", Font.PLAIN, 12));
         //dateChooser.setDateFormatString("dd.MM.yyyy HH:mm");

         URL iconURL = dateChooser.getClass().getResource(
         "/com/toedter/calendar/images/JDayChooserColor32.gif");
         ImageIcon icon = new ImageIcon(iconURL);
         dateChooser.setIcon(icon);


        hlavneOkno.add(dateChooser);






       /* JButton btnOk = new JButton("Vypiš!"); // tlacidlo
        btnOk.setBounds(100, 100, 80, 20); // x, y, sirka, vyska


        btnOk.addActionListener(new ActionListener() { // sluzi na "odchytenie" cize spracovanie zatlacenia tlacidla
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
                labelText.setText( textField.getText() );
            }
        });
        panel.add(btnOk);*/




        /*JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 100, 80, 20);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hlavneOkno.dispatchEvent(new WindowEvent(hlavneOkno, WindowEvent.WINDOW_CLOSING));
            }
        });
        panel.add(btnCancel);*/


        // display it
        hlavneOkno.pack();
        hlavneOkno.setVisible(true);


    }
}


