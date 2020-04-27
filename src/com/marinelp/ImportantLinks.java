package com.marinelp;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportantLinks {

    private final JTextField addressInput;
    private final JTextField addressDetailsInput;
    private final JButton button;

    private String link;
    private String linkDetail;

    public static void main(String[] args) {

        new ImportantLinks();
        //TextIO textIO = new TextIO();

    }

    public ImportantLinks() {

/*
        Example of code if you want to modify this program

        TextIO.putln("Good Afternoon! This program will create");
        TextIO.putln("your profile file, if you will just answer");
        TextIO.putln("a few simple questions.");
        TextIO.putln();

        // Gather responses from the user.
        TextIO.put("What is your name? ");
        name = TextIO.getln();
        TextIO.put("What is your email address? ");
        email = TextIO.getln();
        TextIO.put("What is your yearly income? ");
        salary = TextIO.getlnDouble();
        TextIO.put("What is your favorite color? ");
        favColor = TextIO.getln();

        // Write the user’s information to the file named profile.txt.
        TextIO.writeFile("profile.txt"); // subsequent output goes to file
        TextIO.writeUserSelectedFile();
        TextIO.putln("Name: " + name);
        TextIO.putln("Email: " + email);
        TextIO.putln("Favorite Color: " + favColor);
        TextIO.putf( "Yearly Income: %,1.2f%n", salary);

        // Print a final message to standard output.
        TextIO.writeStandardOutput();
        TextIO.putln("Thank you. Your profile has been written to profile.txt.");
*/

        JFrame mainWindow = new JFrame("IMPORTANT LINKS");
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        mainWindow.setSize(800, 250);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane().setBackground(Color.WHITE);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = mainWindow.getContentPane();

        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(100, 15, 600, 35);
        labelPanel.setBackground(Color.GREEN);
        container.add(labelPanel);
        labelPanel.repaint();

        JLabel label = new JLabel();
        label.setText("PERSONAL LINKS BUNKER");
        Font titleFont = new Font("Time New Roman", Font.BOLD, 13);
        label.setFont(titleFont);
        label.setForeground(Color.DARK_GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        labelPanel.add(label);


        JPanel addressPanel = new JPanel();
        addressPanel.setBounds(100, 55, 600, 30);
        addressPanel.setBackground(Color.GREEN);
        addressPanel.setLayout(new GridLayout(1, 2));
        container.add(addressPanel);
        addressPanel.repaint();

        JLabel addressLabel = new JLabel();
        addressLabel.setText("ENTER THE LINK");
        addressLabel.setFont(titleFont);
        addressLabel.setForeground(Color.DARK_GRAY);
        addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addressLabel.setVerticalAlignment(SwingConstants.CENTER);
        addressPanel.add(addressLabel);

        JLabel addressDetailes = new JLabel();
        addressDetailes.setText("LINK DETAIL'S");
        addressDetailes.setFont(titleFont);
        addressDetailes.setForeground(Color.DARK_GRAY);
        addressDetailes.setHorizontalAlignment(SwingConstants.CENTER);
        addressDetailes.setVerticalAlignment(SwingConstants.CENTER);
        addressPanel.add(addressDetailes);

        JPanel addressAndDetailesInputPanel = new JPanel();
        addressAndDetailesInputPanel.setBounds(100, 90, 600, 30);
        addressAndDetailesInputPanel.setBackground(Color.WHITE);
        addressAndDetailesInputPanel.setLayout(new GridLayout(1, 2));
        container.add(addressAndDetailesInputPanel);
        addressAndDetailesInputPanel.repaint();


        addressInput = new JTextField();
        addressInput.setPreferredSize(new Dimension(230, 22));
        addressInput.setBackground(Color.BLACK);
        addressInput.setForeground(Color.WHITE);
        addressInput.setCaretColor(Color.WHITE);
        addressInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GREEN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));
        addressAndDetailesInputPanel.add(addressInput);
        addressInput.repaint();
        addressInput.revalidate();

        addressDetailsInput = new JTextField();
        addressDetailsInput.setPreferredSize(new Dimension(230, 22));
        addressDetailsInput.setBackground(Color.BLACK);
        addressDetailsInput.setForeground(Color.WHITE);
        addressDetailsInput.setCaretColor(Color.WHITE);
        addressDetailsInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GREEN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));
        // for upper case
        DocumentFilter filter = new UppercaseDocumentFilter();
        ((AbstractDocument) addressDetailsInput.getDocument()).setDocumentFilter(filter); // upper case
        addressAndDetailesInputPanel.add(addressDetailsInput);
        addressDetailsInput.repaint();
        addressDetailsInput.revalidate();


        link = addressInput.getText();
        linkDetail = addressDetailsInput.getText();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(100, 150, 600, 40);
        buttonPanel.setBackground(Color.GREEN);
        container.add(buttonPanel);
        buttonPanel.revalidate();
        buttonPanel.repaint();


        button = new JButton();
        button.setBounds(500, 150, 600, 25);
        button.setText("ADD LINK");
        button.setBackground(Color.BLACK);
        button.setFont(titleFont);
        button.setForeground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);

        // BORDER AND PADDING ON THE BUTTON
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));

        // CHANGE BUTTON BACKGROUND ON HOVER
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
            }
        });
        button.addActionListener(new ButtonHandler());
        buttonPanel.add(button);
        button.repaint();
        button.revalidate();


    }

    // *** Method for user input to type directly upper case ***
    private static class UppercaseDocumentFilter extends DocumentFilter {
        public void insertString(FilterBypass fb, int offset, String text,
                                 AttributeSet attr) throws BadLocationException {

            fb.insertString(offset, text.toUpperCase(), attr);
        }

        public void replace(FilterBypass fb, int offset, int length, String text,
                            AttributeSet attrs) throws BadLocationException {

            fb.replace(offset, length, text.toUpperCase(), attrs);
        }
    }


    // *** Method to handler the add link button. ***
    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            link = addressInput.getText();
            linkDetail = addressDetailsInput.getText();

            TextIO.writeUserSelectedFile(); // subsequent output goes to file
            TextIO.putln("LINK DETAILS: " + linkDetail + "<br>");
            TextIO.putln("\n" + "<br>");
            TextIO.putln("OPEN THE LINK: " + "<a href=" +link + ">" + link + "</a>" + "<br>");
            System.exit(0);
        }
    }
}
