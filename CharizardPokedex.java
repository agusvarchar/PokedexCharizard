package com.charizard;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CharizardPokedex {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Pokedex - Charizard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // Load background image
        URL backgroundURL = CharizardPokedex.class.getResource("/background.png");
        if (backgroundURL == null) {
            System.err.println("Error: Background image not found");
            return;
        }
        ImageIcon backgroundIcon = new ImageIcon(backgroundURL);
        Image backgroundImage = backgroundIcon.getImage();

        // Main panel with background image
        BackgroundPanel mainPanel = new BackgroundPanel(backgroundImage);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Image of Charizard
        URL charizardURL = CharizardPokedex.class.getResource("/charizard.png");
        if (charizardURL == null) {
            System.err.println("Error: Charizard image not found");
            return;
        }
        ImageIcon charizardIcon = new ImageIcon(charizardURL);
        JLabel charizardLabel = new JLabel(charizardIcon);
        charizardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Pokemon name
        JLabel nameLabel = new JLabel("Charizard");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Pokemon description
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText("Charizard is a Fire/Flying-type Pokémon. "
                + "It evolves from Charmeleon starting at level 36. "
                + "It is the final form of Charmander.");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionArea.setForeground(Color.WHITE);

        // Pokemon stats
        String[] columnNames = {"Stat", "Value"};
        Object[][] data = {
                {"HP", "78"},
                {"Attack", "84"},
                {"Defense", "78"},
                {"Special Attack", "109"},
                {"Special Defense", "85"},
                {"Speed", "100"}
        };

        JTable statsTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(statsTable);
        statsTable.setFillsViewportHeight(true);

        // Add components to main panel
        mainPanel.add(charizardLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between image and name
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between name and description
        mainPanel.add(descriptionArea);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between description and table
        mainPanel.add(tableScrollPane);

        // Add main panel to frame
        frame.add(mainPanel);

        // Display frame
        frame.setVisible(true);
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
