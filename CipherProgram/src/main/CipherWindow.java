package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.ciphers.VectorBlockCipher;
import main.tools.CP;
import main.tools.JTextFieldLimit;

@SuppressWarnings("serial")
public class CipherWindow extends JFrame {
	
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel subPanel;
	private JPanel plainTextAreaPanel;
	private JPanel encriptedTextAreaPanel;
	private JPanel keyPanel;
	private JScrollPane plainTextScrollPane;
	private JScrollPane encriptedScrollPane;
	
	private JTextArea plainTextArea;
	private JTextArea encriptedTextArea;
	private JTextField keyInput;
	
	private JButton encriptButton;
	private JButton decriptButton;
	
	private JLabel titleLabel;
	private JLabel plainTextLabel;
	private JLabel encriptedTextLabel;
	private JLabel keyLabel;
	
	private GridBagConstraints grid;
	private Color lightBlue;
	private Color lightGreen;
	private Color buttonColor;
	private Font font;
	private String key;
	
	public CipherWindow() {
		super("Vector Cipher");
		grid = new GridBagConstraints();
		buttonColor = new Color(240,240,240);
		lightBlue = new Color(200, 200, 240);
		lightGreen = new Color(200, 240, 200);
		
		initPanels();
		initLabels();
		initScrollPanes();
		initTextAreas();
		initButtons();
		
		key = keyInput.getText();
		
		add(mainPanel);
	}
	
	private void initScrollPanes() {
		plainTextScrollPane = new JScrollPane();
		plainTextScrollPane.setPreferredSize(new Dimension(420, 420));
		plainTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		plainTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelGridAdd(plainTextAreaPanel, plainTextScrollPane, 0, 1);
		
		encriptedScrollPane = new JScrollPane();
		encriptedScrollPane.setPreferredSize(new Dimension(420, 420));
		encriptedScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		encriptedScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelGridAdd(encriptedTextAreaPanel, encriptedScrollPane, 0, 1);
	}

	private void initTextAreas() {
		plainTextArea = new JTextArea();
		plainTextArea.setSize(400, 400);
		plainTextArea.setLineWrap(true);
		plainTextArea.setEditable(true);
		plainTextScrollPane.add(plainTextArea);
		
		encriptedTextArea = new JTextArea();
		encriptedTextArea.setSize(400, 400);
		encriptedTextArea.setLineWrap(true);
		encriptedTextArea.setEditable(true);
		encriptedScrollPane.add(encriptedTextArea);
		
		keyInput = new JTextField();
		keyInput.setColumns(32);
		keyInput.setDocument(new JTextFieldLimit(32));
		keyInput.setText("A generic 32 byte key goes here!");
		panelGridAdd(keyPanel, keyInput, 1, 0);
	}
	
	private void updateKey() {
		try {
			key = keyInput.getText();
		} catch(NumberFormatException e) {
			CP.println("The user is dumb and didn't put a number.");
		}
	}

	private void initButtons() {
		encriptButton = new JButton();
		standardButtonInits(encriptButton, "Encript",
				"Will encript the text in the plain text area.", 14f, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CP.println("\tEncript button clicked");
				updateKey();
				encriptedTextArea.setText(VectorBlockCipher.encrypt(plainTextArea.getText(), key));
			}
		});
		panelGridAdd(plainTextAreaPanel, encriptButton, 0, 2);
		
		decriptButton = new JButton();
		standardButtonInits(decriptButton, "Decript",
				"Will decript the text in the encripted text area.", 14f, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CP.println("\tDecript button clicked");
				updateKey();
				plainTextArea.setText(VectorBlockCipher.decrypt(encriptedTextArea.getText(), key));
			}
		});
		panelGridAdd(encriptedTextAreaPanel, decriptButton, 0, 2);
	}

	private void initLabels() {
		titleLabel = new JLabel("Vector Cipher");
		font = titleLabel.getFont();
		titleLabel.setFont(font.deriveFont(20f));
		titleLabel.setForeground(Color.LIGHT_GRAY);
		panelGridAdd(mainPanel, titleLabel, 0, 0);
		
		plainTextLabel = new JLabel("Plain Text");
		plainTextLabel.setForeground(Color.DARK_GRAY);
		plainTextLabel.setFont(font.deriveFont(14f));
		panelGridAdd(plainTextAreaPanel, plainTextLabel, 0, 0);
		
		encriptedTextLabel = new JLabel("Encripted Text");
		encriptedTextLabel.setForeground(Color.DARK_GRAY);
		encriptedTextLabel.setFont(font.deriveFont(14f));
		panelGridAdd(encriptedTextAreaPanel, encriptedTextLabel, 0, 0);
		
		keyLabel = new JLabel("32 byte Key");
		keyLabel.setForeground(Color.DARK_GRAY);
		keyLabel.setFont(font.deriveFont(14f));
		panelGridAdd(keyPanel, keyLabel, 0, 0);
	}
	
	private void initPanels() {
		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setVisible(true);
		
		subPanel = new JPanel(new GridBagLayout());
		subPanel.setBackground(Color.DARK_GRAY);
		subPanel.setVisible(true);
		
		contentPanel = new JPanel(new GridBagLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setVisible(true);
		
		plainTextAreaPanel = new JPanel(new GridBagLayout());
		plainTextAreaPanel.setBackground(lightBlue);
		plainTextAreaPanel.setVisible(true);
		
		encriptedTextAreaPanel = new JPanel(new GridBagLayout());
		encriptedTextAreaPanel.setBackground(lightGreen);
		encriptedTextAreaPanel.setVisible(true);
		
		keyPanel = new JPanel(new GridBagLayout());
		keyPanel.setBackground(Color.LIGHT_GRAY);
		keyPanel.setVisible(true);
		
		panelGridAdd(mainPanel, contentPanel, 0, 1);
		panelGridAdd(mainPanel, subPanel, 0, 2);
		panelGridAdd(contentPanel, plainTextAreaPanel, 0, 0);
		panelGridAdd(contentPanel, encriptedTextAreaPanel, 1, 0);
		panelGridAdd(subPanel, keyPanel, 1, 0);
	}
	
	private void panelGridAdd(JPanel panel, Component comp, int gx, int gy) {
		grid.gridx = gx;
		grid.gridy = gy;
		panel.add(comp, grid);
	}
	
	public void refreshPanel(JPanel panel) {
		panel.removeAll();
		panel.setVisible(false);
		panel.setVisible(true);
	}
	
	private void standardButtonInits(JButton button, String buttonText, String toolTip, float fontSize, ActionListener action) {
		button.setText(buttonText);
		button.setToolTipText(toolTip);
		button.setFont(font.deriveFont(fontSize));
		button.setFocusPainted(false);
		button.setBackground(buttonColor);
		button.addActionListener(action);
	}
}
