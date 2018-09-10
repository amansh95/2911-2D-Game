import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;

import java.io.*;
import javax.sound.sampled.*;

public class Window {
	private JFrame frame;
	private JPanel menu;
	private JPanel theme;
	private JPanel about;
	private JPanel player;
	private JPanel level;
	private MapManager map;
	public Clip menuMusic;
	private Player p;
	private int themeSel;
	private String mode;
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	
	
	
	public Window() {
		this.themeSel = 1;
		this.mode = "normal";
		this.map = new MapManager();
		makeFrame();
        setupMenu();
        setupTheme();
        setupAbout();
        setupPlayer();
        setupLevel();
		frame.getContentPane().add(menu);
        frame.setVisible(true);
        
        try {
        	menuMusic = AudioSystem.getClip();
         	
        	menuMusic.open(AudioSystem.getAudioInputStream(new File("files/mainmenu.wav")));
        	menuMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception exc) {
        	exc.printStackTrace(System.out);
        }
	}
	
	
	
	
	public void makeFrame() {
		frame = new JFrame();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dungeon Master");
		frame.setSize(850, 734);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);//set menuMusicow location at center of screen
	}
		
	
	
	
	public void setupMenu() {
		menu = new JPanel();
		
		JLabel background = new JLabel();
		GridBagLayout gbl = new GridBagLayout();
		background.setLayout(gbl);
		background.setIcon(new ImageIcon("files/background1.png"));
		menu.add(background);
		
		JLabel title = new JLabel();
		title.setIcon(new ImageIcon("files/title.png"));
		
		JButton btnGameStart = new JButton("GAME START");
		btnGameStart.setPreferredSize(new Dimension(120,25));
		this.frame.getRootPane().setDefaultButton(btnGameStart);
		btnGameStart.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGameStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(menu);
				frame.getContentPane().add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnAbout = new JButton("ABOUT");
		btnAbout.setPreferredSize(new Dimension(120,25));
		btnAbout.setVisible(true);
		btnAbout.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAbout.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(menu);
				frame.getContentPane().add(about);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnTheme = new JButton("THEME");
		btnTheme.setPreferredSize(new Dimension(120,25));
		btnTheme.setVisible(true);
		btnTheme.setFont(new Font("Dialog", Font.BOLD, 12));
		btnTheme.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(menu);
				frame.getContentPane().add(theme);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setPreferredSize(new Dimension(120,25));
		btnQuit.setVisible(true);
		btnQuit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		

		
		//Below is the layout:
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.insets = new Insets(0, 0, 150, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		background.add(title, gbc_title);
		GridBagConstraints gbc_btnGameStart = new GridBagConstraints();
		gbc_btnGameStart.insets = new Insets(0, 0, 8, 5);
		gbc_btnGameStart.gridx = 0;
		gbc_btnGameStart.gridy = 2;
		background.add(btnGameStart, gbc_btnGameStart);
		GridBagConstraints gbc_btnTheme = new GridBagConstraints();
		gbc_btnTheme.insets = new Insets(0, 0, 8, 5);
		gbc_btnTheme.gridx = 0;
		gbc_btnTheme.gridy = 3;
		background.add(btnTheme, gbc_btnTheme);
		GridBagConstraints gbc_btnAbout = new GridBagConstraints();
		gbc_btnAbout.insets = new Insets(0, 0, 8, 5);
		gbc_btnAbout.gridx = 0;
		gbc_btnAbout.gridy = 4;
		background.add(btnAbout, gbc_btnAbout);
		GridBagConstraints gbc_btnQuit = new GridBagConstraints();
		gbc_btnQuit.insets = new Insets(0, 0, 8, 5);
		gbc_btnQuit.gridx = 0;
		gbc_btnQuit.gridy = 5;
		background.add(btnQuit, gbc_btnQuit);
		
	}
	
	
	
	
	public void setupTheme() {
		theme = new JPanel();
		
		JLabel background = new JLabel();
		GridBagLayout gbl = new GridBagLayout();
		background.setLayout(gbl);
		background.setIcon(new ImageIcon("files/background1.png"));
		theme.add(background);
		
		JLabel lblTheme = new JLabel("Select Game Theme:");
		lblTheme.setFont(new Font("Serif", Font.PLAIN, 20));
		lblTheme.setForeground (Color.WHITE);
		lblTheme.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JButton btnTheme1 = new JButton("Dungeon (default)");
		btnTheme1.setPreferredSize(new Dimension(140,25));
		btnTheme1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTheme1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themeSel = 1;
				frame.remove(theme);
				frame.add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnTheme2 = new JButton("Pokemon");
		btnTheme2.setPreferredSize(new Dimension(140,25));
		btnTheme2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTheme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themeSel = 2;
				frame.remove(theme);
				frame.add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnTheme3 = new JButton("Car Park");
		btnTheme3.setPreferredSize(new Dimension(140,25));
		btnTheme3.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTheme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themeSel = 3;
				frame.remove(theme);
				frame.add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnTheme4 = new JButton("Beach");
		btnTheme4.setPreferredSize(new Dimension(140,25));
		btnTheme4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTheme4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themeSel = 4;
				frame.remove(theme);
				frame.add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(80,25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(theme);
				frame.getContentPane().add(menu);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		
		GridBagConstraints gbc_lblTheme = new GridBagConstraints();
		gbc_lblTheme.insets = new Insets(0, 0, 8, 5);
		gbc_lblTheme.gridx = 0;
		gbc_lblTheme.gridy = 0;
		background.add(lblTheme, gbc_lblTheme);
		GridBagConstraints gbc_btnTheme1 = new GridBagConstraints();
		gbc_btnTheme1.insets = new Insets(0, 0, 8, 5);
		gbc_btnTheme1.gridx = 0;
		gbc_btnTheme1.gridy = 1;
		background.add(btnTheme1, gbc_btnTheme1);
		GridBagConstraints gbc_btnTheme2 = new GridBagConstraints();
		gbc_btnTheme2.insets = new Insets(0, 0, 8, 5);
		gbc_btnTheme2.gridx = 0;
		gbc_btnTheme2.gridy = 2;
		background.add(btnTheme2, gbc_btnTheme2);
		GridBagConstraints gbc_btnTheme3 = new GridBagConstraints();
		gbc_btnTheme3.insets = new Insets(0, 0, 8, 5);
		gbc_btnTheme3.gridx = 0;
		gbc_btnTheme3.gridy = 3;
		background.add(btnTheme3, gbc_btnTheme3);
		GridBagConstraints gbc_btnTheme4 = new GridBagConstraints();
		gbc_btnTheme4.insets = new Insets(0, 0, 8, 5);
		gbc_btnTheme4.gridx = 0;
		gbc_btnTheme4.gridy = 4;
		background.add(btnTheme4, gbc_btnTheme4);
		
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(30, 0, 8, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 5;
		background.add(btnBack, gbc_btnBack);
		
	}
	
	
	public void setupAbout() {
		about = new JPanel();
		
		JLabel background = new JLabel();
		GridBagLayout gbl = new GridBagLayout();
		background.setLayout(gbl);
		background.setIcon(new ImageIcon("files/background1.png"));
		about.add(background);
		
		JTextArea text = new JTextArea("ABOUT THIS GAME"
				+ "\n"
				+ "\nThis game was originally created by a group of 5 students from UNSW Australia for COMP2911."
				+ "\nThis game took many man hours to code and refine and it is with great pleasure that we present it to you."
				+ "\nSokoban is a classic and we hope that our modern take on it provides fun-filled and enjoyable times."
				+ "\n"
				+ "\nCredits (Alphabetical)"
				+ "\n"
				+ "\n-Aman Shekhar    (Game System, Main system design)"
				+ "\n-Garfield Qiu    (GUI, Game system, Main system design, Map generation design)"
				+ "\n-Jessey Kang    (Map Generation, Tutorial, Game system, Main system)"
				+ "\n-Jonathan Yang    (GUI, Map Generation, Game system, Main system, Sound effect) "
				+ "\n-Yida Hao    (UML deisgn, Level design, Main system)"
				+ "\n"
				+ "\nUNSW AUSTRALIA"
				+ "\n26 May 2017");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Serif", Font.PLAIN, 14));
		text.setOpaque(false);
		text.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(80,25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(about);
				frame.getContentPane().add(menu);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		//Layout:
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_text.insets = new Insets(0, 0, 8, 5);
		gbc_text.gridx = 0;
		gbc_text.gridy = 0;
		background.add(text, gbc_text);
		
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(30, 0, 8, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		background.add(btnBack, gbc_btnBack);
	}
	
	
	public void setupPlayer() {
		player = new JPanel();
		
		JLabel background = new JLabel();
		GridBagLayout gbl = new GridBagLayout();
		background.setLayout(gbl);
		background.setIcon(new ImageIcon("files/background1.png"));
		player.add(background);
		
		JLabel lblplayerName = new JLabel("Player Name:");
		lblplayerName.setFont(new Font("Serif", Font.PLAIN, 20));
		lblplayerName.setForeground (Color.WHITE);
		lblplayerName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JTextField textField = new JTextField();
		textField.setColumns(12);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				p = new Player(text);
				frame.remove(player);
				frame.add(level);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		
		JButton btnCon = new JButton("Next");
		btnCon.setPreferredSize(new Dimension(80,25));
		btnCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				p = new Player(text);
				frame.remove(player);
				frame.add(level);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(80,25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(player);
				frame.getContentPane().add(menu);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		


		//below is the layout:
		GridBagConstraints gbc_lblplayerName = new GridBagConstraints();
		gbc_lblplayerName.insets = new Insets(0, 0, 8, 5);
		gbc_lblplayerName.gridx = 0;
		gbc_lblplayerName.gridy = 0;
		background.add(lblplayerName, gbc_lblplayerName);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 8, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		background.add(textField, gbc_textField);
		GridBagConstraints gbc_btnCon = new GridBagConstraints();
		gbc_btnCon.insets = new Insets(0, 0, 8, 5);
		gbc_btnCon.gridx = 0;
		gbc_btnCon.gridy = 2;
		background.add(btnCon, gbc_btnCon);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(30, 0, 8, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 3;
		background.add(btnBack, gbc_btnBack);
	
	}
	
	
	
	
	public void setupLevel() {
		level = new JPanel();
		
		JLabel background = new JLabel();
		GridBagLayout gbl = new GridBagLayout();
		background.setLayout(gbl);
		background.setIcon(new ImageIcon("files/background1.png"));
		level.add(background);
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(80, 25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(level);
				frame.getContentPane().add(player);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		
		
		JLabel lblMode = new JLabel("Select Mode:");
		lblMode.setFont(new Font("Serif", Font.PLAIN, 20));
		lblMode.setForeground(Color.WHITE);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setPreferredSize(new Dimension(110, 25));
		JButton btnFog = new JButton("Fog");
		btnFog.setPreferredSize(new Dimension(110, 25));
		JButton btnTorch = new JButton("Torch");
		btnTorch.setPreferredSize(new Dimension(110, 25));
		
		btnNormal.setBackground(Color.RED);
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = "normal";
				btnNormal.setBackground(Color.RED);
				btnFog.setBackground(null);
				btnTorch.setBackground(null);
			}
		});
		
		btnFog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = "fog";
				btnNormal.setBackground(null);
				btnFog.setBackground(Color.RED);
				btnTorch.setBackground(null);
			}
		});
		
		btnTorch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = "torch";
				btnNormal.setBackground(null);
				btnFog.setBackground(null);
				btnTorch.setBackground(Color.RED);
			}
		});
		
		
		//level buttons -------------------------------------------------------------------------------------------------------------
		JLabel lblLevel = new JLabel("Challenges:");
		lblLevel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblLevel.setForeground(Color.WHITE);
		
		JButton btnLevel0 = new JButton("Tutorial");
		btnLevel0.setPreferredSize(new Dimension(90, 25));
		btnLevel0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(0);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel1 = new JButton(" Level 1 ");
		btnLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(1);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel2 = new JButton(" Level 2 ");
		btnLevel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(2);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel3 = new JButton(" Level 3 ");
		btnLevel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(3);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel4 = new JButton(" Level 4 ");
		btnLevel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(4);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel5 = new JButton(" Level 5 ");
		btnLevel5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(5);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel6 = new JButton(" Level 6 ");
		btnLevel6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(6);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel7 = new JButton(" Level 7 ");
		btnLevel7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(7);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel8 = new JButton(" Level 8 ");
		btnLevel8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(8);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel9 = new JButton(" Level 9 ");
		btnLevel9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(9);
				new Game(frame,p,map,themeSel,mode);
			}
		});
		
		JButton btnLevel10 = new JButton("Level 10");
		btnLevel10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(10);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel11 = new JButton("Level 11");
		btnLevel11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(11);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel12 = new JButton("Level 12");
		btnLevel12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(12);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel13 = new JButton("Level 13");
		btnLevel13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(13);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel14 = new JButton("Level 14");
		btnLevel14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(14);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel15 = new JButton("Level 15");
		btnLevel15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(15);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel16 = new JButton("Level 16");
		btnLevel16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(16);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel17 = new JButton("Level 17");
		btnLevel17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(17);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel18 = new JButton("Level 18");
		btnLevel18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(18);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel19 = new JButton("Level 19");
		btnLevel19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(19);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel20 = new JButton("Level 20");
		btnLevel20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(20);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel21 = new JButton("Level 21");
		btnLevel21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(21);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel22 = new JButton("Level 22");
		btnLevel22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(22);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel23 = new JButton("Level 23");
		btnLevel23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(23);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel24 = new JButton("Level 24");
		btnLevel24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(24);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnLevel25 = new JButton("Level 25");
		btnLevel25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(25);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		//level buttons------------------------------------------------------------------------------------------------------------
		
		JLabel autoMap = new JLabel("Generated Map:");
		autoMap.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		autoMap.setForeground(Color.WHITE);
		
		JButton btnAuto1 = new JButton("Noob");
		btnAuto1.setPreferredSize(new Dimension(100, 25));
		btnAuto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(101);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnAuto2 = new JButton("Easy");
		btnAuto2.setPreferredSize(new Dimension(100, 25));
		btnAuto2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(102);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnAuto3 = new JButton("Moderate");
		btnAuto3.setPreferredSize(new Dimension(100, 25));
		btnAuto3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(103);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnAuto4 = new JButton("Challenge");
		btnAuto4.setPreferredSize(new Dimension(100, 25));
		btnAuto4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(104);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JButton btnAuto5 = new JButton("Difficult");
		btnAuto5.setPreferredSize(new Dimension(100, 25));
		btnAuto5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(menuMusic == null)) menuMusic.close();
				frame.remove(level);
				map.setLevel(105);
				new Game(frame,p,map,themeSel,mode);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		
		
		//below is the layout:
		GridBagConstraints gbc_lblMode = new GridBagConstraints();
		gbc_lblMode.insets = new Insets(0, 0, 8, 5);
		gbc_lblMode.gridx = 0;
		gbc_lblMode.gridy = 0;
		background.add(lblMode, gbc_lblMode);
		GridBagConstraints gbc_btnNormal = new GridBagConstraints();
		gbc_btnNormal.insets = new Insets(0, 0, 8, 5);
		gbc_btnNormal.gridx = 0;
		gbc_btnNormal.gridy = 1;
		background.add(btnNormal, gbc_btnNormal);
		GridBagConstraints gbc_btnFog = new GridBagConstraints();
		gbc_btnFog.insets = new Insets(0, 0, 8, 5);
		gbc_btnFog.gridx = 1;
		gbc_btnFog.gridy = 1;
		background.add(btnFog, gbc_btnFog);
		GridBagConstraints gbc_btnTorch = new GridBagConstraints();
		gbc_btnTorch.insets = new Insets(0, 0, 8, 5);
		gbc_btnTorch.gridx = 2;
		gbc_btnTorch.gridy = 1;
		background.add(btnTorch, gbc_btnTorch);
		
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 8, 5);
		gbc_lblLevel.gridx = 0;
		gbc_lblLevel.gridy = 2;
		background.add(lblLevel, gbc_lblLevel);
		GridBagConstraints gbc_btnLevel0 = new GridBagConstraints();
		gbc_btnLevel0.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel0.gridx = 0;
		gbc_btnLevel0.gridy = 3;
		background.add(btnLevel0, gbc_btnLevel0);
		
		GridBagConstraints gbc_btnLevel1 = new GridBagConstraints();
		gbc_btnLevel1.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel1.gridx = 0;
		gbc_btnLevel1.gridy = 4;
		background.add(btnLevel1, gbc_btnLevel1);
		GridBagConstraints gbc_btnLevel2 = new GridBagConstraints();
		gbc_btnLevel2.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel2.gridx = 0;
		gbc_btnLevel2.gridy = 5;
		background.add(btnLevel2, gbc_btnLevel2);
		GridBagConstraints gbc_btnLevel3 = new GridBagConstraints();
		gbc_btnLevel3.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel3.gridx = 0;
		gbc_btnLevel3.gridy = 6;
		background.add(btnLevel3, gbc_btnLevel3);
		GridBagConstraints gbc_btnLevel4 = new GridBagConstraints();
		gbc_btnLevel4.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel4.gridx = 0;
		gbc_btnLevel4.gridy = 7;
		background.add(btnLevel4, gbc_btnLevel4);
		GridBagConstraints gbc_btnLevel5 = new GridBagConstraints();
		gbc_btnLevel5.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel5.gridx = 0;
		gbc_btnLevel5.gridy = 8;
		background.add(btnLevel5, gbc_btnLevel5);
		
		
		GridBagConstraints gbc_btnLevel6 = new GridBagConstraints();
		gbc_btnLevel6.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel6.gridx = 1;
		gbc_btnLevel6.gridy = 4;
		background.add(btnLevel6, gbc_btnLevel6);
		GridBagConstraints gbc_btnLevel7 = new GridBagConstraints();
		gbc_btnLevel7.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel7.gridx = 1;
		gbc_btnLevel7.gridy = 5;
		background.add(btnLevel7, gbc_btnLevel7);
		GridBagConstraints gbc_btnLevel8 = new GridBagConstraints();
		gbc_btnLevel8.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel8.gridx = 1;
		gbc_btnLevel8.gridy = 6;
		background.add(btnLevel8, gbc_btnLevel8);
		GridBagConstraints gbc_btnLevel9 = new GridBagConstraints();
		gbc_btnLevel9.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel9.gridx = 1;
		gbc_btnLevel9.gridy = 7;
		background.add(btnLevel9, gbc_btnLevel9);
		GridBagConstraints gbc_btnLevel10 = new GridBagConstraints();
		gbc_btnLevel10.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel10.gridx = 1;
		gbc_btnLevel10.gridy = 8;
		background.add(btnLevel10, gbc_btnLevel10);
		
		
		GridBagConstraints gbc_btnLevel11 = new GridBagConstraints();
		gbc_btnLevel11.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel11.gridx = 2;
		gbc_btnLevel11.gridy = 4;
		background.add(btnLevel11, gbc_btnLevel11);
		GridBagConstraints gbc_btnLevel12 = new GridBagConstraints();
		gbc_btnLevel12.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel12.gridx = 2;
		gbc_btnLevel12.gridy = 5;
		background.add(btnLevel12, gbc_btnLevel12);
		GridBagConstraints gbc_btnLevel13 = new GridBagConstraints();
		gbc_btnLevel13.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel13.gridx = 2;
		gbc_btnLevel13.gridy = 6;
		background.add(btnLevel13, gbc_btnLevel13);
		GridBagConstraints gbc_btnLevel14 = new GridBagConstraints();
		gbc_btnLevel14.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel14.gridx = 2;
		gbc_btnLevel14.gridy = 7;
		background.add(btnLevel14, gbc_btnLevel14);
		GridBagConstraints gbc_btnLevel15 = new GridBagConstraints();
		gbc_btnLevel15.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel15.gridx = 2;
		gbc_btnLevel15.gridy = 8;
		background.add(btnLevel15, gbc_btnLevel15);
		
		
		GridBagConstraints gbc_btnLevel16 = new GridBagConstraints();
		gbc_btnLevel16.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel16.gridx = 3;
		gbc_btnLevel16.gridy = 4;
		background.add(btnLevel16, gbc_btnLevel16);
		GridBagConstraints gbc_btnLevel17 = new GridBagConstraints();
		gbc_btnLevel17.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel17.gridx = 3;
		gbc_btnLevel17.gridy = 5;
		background.add(btnLevel17, gbc_btnLevel17);
		GridBagConstraints gbc_btnLevel18 = new GridBagConstraints();
		gbc_btnLevel18.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel18.gridx = 3;
		gbc_btnLevel18.gridy = 6;
		background.add(btnLevel18, gbc_btnLevel18);
		GridBagConstraints gbc_btnLevel19 = new GridBagConstraints();
		gbc_btnLevel19.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel19.gridx = 3;
		gbc_btnLevel19.gridy = 7;
		background.add(btnLevel19, gbc_btnLevel19);
		GridBagConstraints gbc_btnLevel120 = new GridBagConstraints();
		gbc_btnLevel120.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel120.gridx = 3;
		gbc_btnLevel120.gridy = 8;
		background.add(btnLevel20, gbc_btnLevel120);
		
		GridBagConstraints gbc_btnLevel121 = new GridBagConstraints();
		gbc_btnLevel121.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel121.gridx = 4;
		gbc_btnLevel121.gridy = 4;
		background.add(btnLevel21, gbc_btnLevel121);
		GridBagConstraints gbc_btnLevel122 = new GridBagConstraints();
		gbc_btnLevel122.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel122.gridx = 4;
		gbc_btnLevel122.gridy = 5;
		background.add(btnLevel22, gbc_btnLevel122);
		GridBagConstraints gbc_btnLevel123 = new GridBagConstraints();
		gbc_btnLevel123.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel123.gridx = 4;
		gbc_btnLevel123.gridy = 6;
		background.add(btnLevel23, gbc_btnLevel123);
		GridBagConstraints gbc_btnLevel124 = new GridBagConstraints();
		gbc_btnLevel124.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel124.gridx = 4;
		gbc_btnLevel124.gridy = 7;
		background.add(btnLevel24, gbc_btnLevel124);
		GridBagConstraints gbc_btnLevel125 = new GridBagConstraints();
		gbc_btnLevel125.insets = new Insets(0, 0, 8, 5);
		gbc_btnLevel125.gridx = 4;
		gbc_btnLevel125.gridy = 8;
		background.add(btnLevel25, gbc_btnLevel125);
		
		
		GridBagConstraints gbc_lb = new GridBagConstraints();
		gbc_lb.insets = new Insets(0, 0, 8, 5);
		gbc_lb.gridx = 0;
		gbc_lb.gridy = 9;
		background.add(autoMap, gbc_lb);
		
		
		GridBagConstraints gbc_btnAuto1 = new GridBagConstraints();
		gbc_btnAuto1.insets = new Insets(0, 5, 8, 5);
		gbc_btnAuto1.gridx = 0;
		gbc_btnAuto1.gridy = 10;
		background.add(btnAuto1, gbc_btnAuto1);
		GridBagConstraints gbc_btnAuto2 = new GridBagConstraints();
		gbc_btnAuto2.insets = new Insets(0, 5, 8, 5);
		gbc_btnAuto2.gridx = 1;
		gbc_btnAuto2.gridy = 10;
		background.add(btnAuto2, gbc_btnAuto2);
		GridBagConstraints gbc_btnAuto3 = new GridBagConstraints();
		gbc_btnAuto3.insets = new Insets(0, 5, 8, 5);
		gbc_btnAuto3.gridx = 2;
		gbc_btnAuto3.gridy = 10;
		background.add(btnAuto3, gbc_btnAuto3);
		GridBagConstraints gbc_btnAuto4 = new GridBagConstraints();
		gbc_btnAuto4.insets = new Insets(0, 5, 8, 5);
		gbc_btnAuto4.gridx = 3;
		gbc_btnAuto4.gridy = 10;
		background.add(btnAuto4, gbc_btnAuto4);
		GridBagConstraints gbc_btnAuto5 = new GridBagConstraints();
		gbc_btnAuto5.insets = new Insets(0, 10, 8, 5);
		gbc_btnAuto5.gridx = 4;
		gbc_btnAuto5.gridy = 10;
		background.add(btnAuto5, gbc_btnAuto5);
		
		
		
		
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(30, 0, 8, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 11;
		background.add(btnBack, gbc_btnBack);
		
		
	}
	


	
}
