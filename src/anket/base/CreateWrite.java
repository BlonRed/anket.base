package anket.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;


class CreateWrite {
    static String firstName, lastName, country, year, age, number;
    static String[] buffer = {firstName, lastName, country, year, age, number};
    private FileWriter card;
    JFrame windowCW;
    JLabel heading;
    JLabel[] article = new JLabel[buffer.length];
    JTextField[] valueArticle = new JTextField[buffer.length];
    JButton okButton;


    CreateWrite() {
        windowCW = new JFrame("Новая карточка");
        windowCW.setSize(300, 500);
        windowCW.setLayout(new GridBagLayout());
        windowCW.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        heading = new JLabel("Введите данные (на латинице).");

        article[0] = new JLabel("Введите имя:");
        article[1] = new JLabel("Введите фамилию:");
        article[2] = new JLabel("Введите страну:");
        article[3] = new JLabel("Введите дату рождения:");
        article[4] = new JLabel("Введите возраст:");
        article[5] = new JLabel("Введите номер телефона:");

        for (int i = 0; i < valueArticle.length; i++) {
            valueArticle[i] = new JTextField("");
        }

        okButton = new JButton("Создать");
        okButton.addActionListener(this::listenCW);

        windowCW.add(heading, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        for (int i = 0; i < article.length; i++) {
            int index = i + 1;
            windowCW.add(article[i], new GridBagConstraints(0, index, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
            windowCW.add(valueArticle[i], new GridBagConstraints(1, index, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 100, 0));
        }

        windowCW.add(okButton, new GridBagConstraints(0, (buffer.length + 1), 2, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        windowCW.setVisible(true);
    }

    public void listenCW(ActionEvent e) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = valueArticle[i].getText();
        }
        if (buffer[0] != null && buffer[1] != null) {
            createCart(buffer[0], buffer[1]);
        }
        for (int i = 0; i < buffer.length; i++) {
            writeData(i, buffer[i]);
        }
        windowCW.dispatchEvent(new WindowEvent(windowCW, WindowEvent.WINDOW_CLOSING));
    }

    public void createCart(String firstName, String lastName) {
        String fileName = "C:\\Users\\Илья\\IdeaProjects\\java-basic\\src\\anket\\base\\data\\" + firstName + lastName + ".txt";
        writeInData((firstName + " " + lastName + "\n"));
        try {
            card = new FileWriter(fileName);
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

    public void writeData(int type, String data) {
        try {
            switch (type) {
                case 0:
                    card.write("First name: " + data + "\n");
                    break;
                case 1:
                    card.write("Last name: " + data + "\n");
                    break;
                case 2:
                    card.write("Country: " + data + "\n");
                    break;
                case 3:
                    card.write("Year of birth: " + data + "\n");
                    break;
                case 4:
                    card.write("Age: " + data + "\n");
                    break;
                case 5:
                    card.write("Number: " + data);
                    card.close();
                    break;

            }
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

    void writeInData(String name) {

        try (FileWriter writ = new FileWriter("C:\\Users\\Илья\\IdeaProjects\\java-basic\\src\\anket\\base\\data\\data.txt", true)) {
            writ.write(name);
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}
