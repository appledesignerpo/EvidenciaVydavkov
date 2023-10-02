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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class GUI {
    private static int indexVydavku;
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
        cmbKategorie.setBounds(190,120,203,30); // x, y, sirka, vyska
        backgroundPanel.add(cmbKategorie);

        // Date picker- Datum

        //Kategoria vydavku
        JLabel labelDatum = new JLabel("Dátum"); // popisok
        labelDatum.setBounds(85,155,100,20); // x, y, sirka, vyska
        labelDatum.setFont(new Font("Montserrat", Font.BOLD, 12));
        labelDatum.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo
        backgroundPanel.add(labelDatum);

        // date picker  -vyberač dátumu OLD ONE
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBounds(190,150,200,30); // x, y, sirka, vyska
        JFormattedTextField textField = datePicker.getJFormattedTextField();
        textField.setFont(new Font("sans-serif", Font.BOLD, 13));
        hlavneOkno.add(datePicker);
        //date picker  -vyberač dátumu OLD END

       /* JCalendar calendar = new JCalendar(); // Vytvorte inštanciu JCalendar
        panel.add(calendar);
        calendar.setBounds(290,150,200,30); // x, y, sirka, vyska

        hlavneOkno.setVisible(true);*/
        // jCalendar picker NEW
        /*JDateChooser dateChooser = new JDateChooser(); // Vytvorte inštanciu JDateChooser



        dateChooser.setBounds(195,150,193,30); // x, y, sirka, vyska
        //dateChooser.getJCalendar().setPreferredSize(new Dimension(450, 300));


         dateChooser.getJCalendar().setLocale(new Locale("sk"));
        //dateChooser.setDateFormatString("dd. MMMM yyyy");

         dateChooser.getJCalendar().setPreferredSize(new Dimension(480, 300));
         dateChooser.setFont(new Font("Montserrat", Font.PLAIN, 12));
         //dateChooser.setDateFormatString("dd.MM.yyyy HH:mm");

         URL iconURL = dateChooser.getClass().getResource(
         "/com/toedter/calendar/images/JDayChooserColor16.gif");
         ImageIcon icon = new ImageIcon(iconURL);
         dateChooser.setIcon(icon);*/


        hlavneOkno.add(datePicker);




        // Zoznam vydavkov label
        JLabel labelZoznamVydavkov = new JLabel("Zoznam výdavkov");
        labelZoznamVydavkov.setBounds(385, 35, 150, 20); // x, y, sirka, vyska
        //labelCenaVydavku.setHorizontalAlignment(JTextField.RIGHT);
        labelZoznamVydavkov.setFont(new Font("Montserrat", Font.BOLD, 12));
        labelZoznamVydavkov.setHorizontalAlignment(SwingConstants.RIGHT); // text centrovanie vpravo
        hlavneOkno.add(labelZoznamVydavkov);

        // Zoznam vydavkov list
        //JList listZoznamVydavkov = new JList();
       // listZoznamVydavkov.setBounds(420, 65,330, 300);
        //hlavneOkno.add(listZoznamVydavkov);
        DefaultListModel modelZoznamu = new DefaultListModel<>();
        JList listZoznamVydavkov = new JList<>(modelZoznamu);
        //Priadenie udajov na testovanie
        modelZoznamu.addElement("Chlieb 2.3 POTRAVINY 27.9.2023");
        modelZoznamu.addElement("Rožky 1.3 POTRAVINY 23.9.2023");
        listZoznamVydavkov.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                try{

                String vybranyVydavok = listZoznamVydavkov.getSelectedValue().toString();
                //String jednotliveUdajeVydavku [] = vybranyVydavok.split(" ");

                    //String jednotliveUdajeVydavku [] = vybranyVydavok.split(" ");
                    String regex = " ";
                    String jednotliveUdajeVydavku [] = vybranyVydavok.split(regex);

                    textNazovVydavku.setText(jednotliveUdajeVydavku[0]);
                    textCenaVydavku.setText(jednotliveUdajeVydavku[1]);
                    cmbKategorie.setSelectedItem(jednotliveUdajeVydavku[2]);

                    datePicker.getJFormattedTextField().setText(jednotliveUdajeVydavku[3]);

                    indexVydavku = listZoznamVydavkov.getSelectedIndex();
                    System.out.println(Arrays.toString(jednotliveUdajeVydavku));
                    System.out.println(vybranyVydavok);

                    System.out.println(Arrays.toString(jednotliveUdajeVydavku)); // vypise jednotlive prvky pola
                System.out.println(vybranyVydavok);
                } catch (NullPointerException e1){
                    //TODO spracovat
                }
                }
                }

        });


        // Zoznam vydavkov scrollbar
        JScrollPane scbZoznamVydavkov = new JScrollPane(listZoznamVydavkov);
        scbZoznamVydavkov.setBounds(420,65,330,300);
        hlavneOkno.add(scbZoznamVydavkov);

        //Tlacidlo na pridanie zaznamu
        JButton btnPridajZaznam = new JButton("Pridaj záznam");
        btnPridajZaznam.setBounds(85, 405,150, 30);
        btnPridajZaznam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO po kliknuti na tlacidlo musime doporgramovat
               /* SimpleDateFormat dcn = new SimpleDateFormat("dd.MM.yyyy");
                String date = dcn.format(dateChooser.getDate());*/
                //Potom by sa to mohlo takto vlozit do modelu:
                // date.toString();

                /*modelZoznamu.addElement("Názov: " + textNazovVydavku.getText() + "Cena: " +  " " +  textCenaVydavku.getText() + " " + cmbKategorie.getSelectedItem() + " " + date);*/
                modelZoznamu.addElement(textNazovVydavku.getText() + " " +  textCenaVydavku.getText() + " " + cmbKategorie.getSelectedItem() +  datePicker.getJFormattedTextField().getText().replace(" ", ""));
            }
        });
        hlavneOkno.add(btnPridajZaznam);


//Tlacidlo na upravu zaznamu
        JButton btnUpravZaznam = new JButton("Upraviť záznam");
        btnUpravZaznam.setBounds(225, 405,150, 30);
        btnUpravZaznam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO po kliknuti na tlacidlo musime doporgramovat
                modelZoznamu.setElementAt(textNazovVydavku.getText() + " " +  textCenaVydavku.getText() + " " + cmbKategorie.getSelectedItem() +  datePicker.getJFormattedTextField().getText().replace(" ", ""), indexVydavku);
            }
        });
        hlavneOkno.add(btnUpravZaznam);


        //Tlacidlo na odstranit zaznamu
        JButton btnOdstranZaznam = new JButton("Odstrániť záznam");
        btnOdstranZaznam.setBounds(365, 405,150, 30);
        btnOdstranZaznam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO po kliknuti na tlacidlo musime doporgramovat

                modelZoznamu.remove(indexVydavku);

            }
        });
        hlavneOkno.add(btnOdstranZaznam);


        //Tlacidlo na ukoncenie
        JButton btnUkonciAplikaciu = new JButton("Ukončiť");
        btnUkonciAplikaciu.setBounds(505, 405,150, 30);
        btnUkonciAplikaciu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO po kliknuti na tlacidlo musime doporgramovat
                System.exit(0);
            }
        });
        hlavneOkno.add(btnUkonciAplikaciu);


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


