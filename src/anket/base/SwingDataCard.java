package anket.base;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class SwingDataCard {

    GetInfo gIObj = new GetInfo();
    JFrame window;
    JList<String> roster;
    String[] data = gIObj.showName();
    JScrollPane scroll;
    JLabel heading, searchLabel;
    JList<String> display;
    JButton addButton, searchButton;
    JTextField search;

    SwingDataCard() {
        window = new JFrame("База анкет");
        window.setSize(250, 500);
        window.setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading = new JLabel("Выберите карточку из списка:");

        searchLabel = new JLabel("Поиск:");
        search = new JTextField("");
        search.setPreferredSize(new Dimension(100, 20));
        searchButton = new JButton(" ");
        searchButton.setPreferredSize(new Dimension(20, 20));

        roster = new JList<>(data);
        roster.setSize(new Dimension(200, 100));
        roster.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(roster);
        scroll.setPreferredSize(new Dimension(200, 100));
        roster.addListSelectionListener(this::rosterChanged);

        addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(20, 20));
        addButton.addActionListener(this::createCard);

        display = new JList<>();
        display.setPreferredSize(new Dimension(150, 200));

        window.add(heading, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 20, 2, 2), 0, 0));
        window.add(searchLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 0), 0, 0));
        window.add(search, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2), 0, 0));
        window.add(searchButton, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2), 0, 0));
        window.add(scroll, new GridBagConstraints(0, 2, 3, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(2, 2, 2, 2), 0, 0));
        window.add(addButton, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        window.add(display, new GridBagConstraints(0, 4, 3, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        window.setVisible(true);
    }

    public void createCard(ActionEvent obj) {
        new CreateWrite();

    }

    public void rosterChanged(ListSelectionEvent obj) {
        int index = roster.getSelectedIndex();

        if (index != -1) {
            display.setListData(gIObj.getInfo(data[index]));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingDataCard::new);
    }
}
