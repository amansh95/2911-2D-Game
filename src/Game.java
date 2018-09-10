import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {
    private JFrame frame;
    private Player player;
    private int theme;
    private String mode;
    private MapManager map = null;
    private Clip wind;
    public Clip celebration;
    public boolean musicToggle = true;
    
    private ImageIcon wall;
    private ImageIcon path;
    private ImageIcon box;
    private ImageIcon target;
    private ImageIcon character;
    private ImageIcon btarget;
    private ImageIcon characterU;
    private ImageIcon characterL;
    private ImageIcon characterR;
    private ImageIcon targetU;
    private ImageIcon targetD;
    private ImageIcon targetL;
    private ImageIcon targetR;
    private ImageIcon fog;

    public Game(JFrame frame, Player p, MapManager map, int themeSel, String mode) {
        this.frame = frame;
        this.map = map;
        this.player = p;
        this.theme = themeSel;
        this.mode = mode;
        setupThumb();
        initializeGame();
    }

    
    private void setupThumb() {
    	if(theme==1) {
    		
    		wall = new ImageIcon("files/wall.png");
    		path = new ImageIcon("files/path.png");
    		box = new ImageIcon("files/box.png");
    		target = new ImageIcon("files/target.png");
    	    character = new ImageIcon("files/character.png");
    	    btarget = new ImageIcon("files/btarget.png");
    	    characterU = new ImageIcon("files/characterU.png");
    	    characterL = new ImageIcon("files/characterL.png");
    	    characterR = new ImageIcon("files/characterR.png");
    	    targetU = new ImageIcon("files/targetU.png");
    	    targetD = new ImageIcon("files/targetD.png");
    	    targetL = new ImageIcon("files/targetL.png");
    	    targetR = new ImageIcon("files/targetR.png");
    	    fog = new ImageIcon("files/fog.png");
    	}
    	else if (theme==2) {
    		wall = new ImageIcon("files/poke_wall.png");
    		path = new ImageIcon("files/poke_path.png");
    		box = new ImageIcon("files/poke_box.png");
    		target = new ImageIcon("files/poke_target.png");
    	    character = new ImageIcon("files/poke_character.png");
    	    btarget = new ImageIcon("files/poke_btarget.png");
    	    characterU = new ImageIcon("files/poke_characterU.png");
    	    characterL = new ImageIcon("files/poke_characterL.png");
    	    characterR = new ImageIcon("files/poke_characterR.png");
    	    targetU = new ImageIcon("files/poke_targetU.png");
    	    targetD = new ImageIcon("files/poke_targetD.png");
    	    targetL = new ImageIcon("files/poke_targetL.png");
    	    targetR = new ImageIcon("files/poke_targetR.png");
    	    fog = new ImageIcon("files/fog.png");
    	}
    	else if (theme==3) {
    		wall = new ImageIcon("files/car_wall.png");
    		path = new ImageIcon("files/car_path.png");
    		box = new ImageIcon("files/car_box.png");
    		target = new ImageIcon("files/car_target.png");
    	    character = new ImageIcon("files/car_character.png");
    	    btarget = new ImageIcon("files/car_btarget.png");
    	    characterU = new ImageIcon("files/car_characterU.png");
    	    characterL = new ImageIcon("files/car_characterL.png");
    	    characterR = new ImageIcon("files/car_characterR.png");
    	    targetU = new ImageIcon("files/car_targetU.png");
    	    targetD = new ImageIcon("files/car_targetD.png");
    	    targetL = new ImageIcon("files/car_targetL.png");
    	    targetR = new ImageIcon("files/car_targetR.png");
    	    fog = new ImageIcon("files/fog.png");
    	}
    	else if (theme==4) {
    		wall = new ImageIcon("files/beach_wall.png");
    		path = new ImageIcon("files/beach_path.png");
    		box = new ImageIcon("files/beach_box.png");
    		target = new ImageIcon("files/beach_target.png");
    	    character = new ImageIcon("files/beach_character.png");
    	    btarget = new ImageIcon("files/beach_btarget.png");
    	    characterU = new ImageIcon("files/beach_characterU.png");
    	    characterL = new ImageIcon("files/beach_characterL.png");
    	    characterR = new ImageIcon("files/beach_characterR.png");
    	    targetU = new ImageIcon("files/beach_targetU.png");
    	    targetD = new ImageIcon("files/beach_targetD.png");
    	    targetL = new ImageIcon("files/beach_targetL.png");
    	    targetR = new ImageIcon("files/beach_targetR.png");
    	    fog = new ImageIcon("files/fog.png");
    	}
    }
    
    
    private void initializeGame() {


        try {
            wind = AudioSystem.getClip();
            wind.open(AudioSystem.getAudioInputStream(new File("files/wind.wav")));
            wind.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception exc) {
            exc.printStackTrace(System.out);
        }



        this.frame.getContentPane().setBackground(Color.DARK_GRAY);
        this.frame.getContentPane().setLayout(null);
        this.frame.getContentPane().requestFocus();//this is the fix to keylistener
        this.frame.getContentPane().addKeyListener(new KeyListenerGame());

        
        JLabel playerName = new JLabel();
        if(!this.player.getName().isEmpty()) {
        	playerName.setText("MASTER:");
        }
        playerName.setFont(new Font("Serif", Font.PLAIN, 14));
        playerName.setForeground (Color.RED);
        JLabel Name = new JLabel(this.player.getName());
		Name.setFont(new Font("Serif", Font.PLAIN, 14));
        Name.setForeground (Color.RED);
        JLabel levelCounter = new JLabel();
        if(this.map.getLevel()<=100) {
        	levelCounter.setText("LEVEL " + this.map.getLevel());
        }
        else {
        	switch (this.map.getLevel()-100) {
        	case 1: levelCounter.setText("NOOB");
        	break;
            case 2: levelCounter.setText("EASY");
            break;
            case 3: levelCounter.setText("MODERATE");
            break;
            case 4: levelCounter.setText("CHALLENGE");
            break;
            case 5: levelCounter.setText("DIFFICULT");
            break;
        	}
        }
		levelCounter.setFont(new Font("Serif", Font.PLAIN, 14));
        levelCounter.setForeground (Color.RED);
        JLabel stepCounter = new JLabel("Steps: " + this.map.steps);
		stepCounter.setFont(new Font("Serif", Font.PLAIN, 14));
        stepCounter.setForeground (Color.RED);
        
        JButton undoBtn = new JButton("Undo(U)");
        JButton resetBtn = new JButton("Reset(R)");
        JButton backBtn = new JButton("Main Menu");
        JButton muteBtn = new JButton("Un/Mute");

        undoBtn.setFont(new Font("Arial", Font.BOLD, 12));
        resetBtn.setFont(new Font("Arial", Font.BOLD, 12));
        backBtn.setFont(new Font("Arial", Font.BOLD, 12));
        muteBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        playerName.setLocation(740, 50);
        Name.setLocation(740, 70);
        levelCounter.setLocation(740, 160);
        stepCounter.setLocation(740, 200);
        undoBtn.setLocation(720, 260);
        resetBtn.setLocation(720, 340);
        muteBtn.setLocation(720, 420);
        backBtn.setLocation(720, 600);

        Name.setSize(80, 40);
        playerName.setSize(80, 40);
        levelCounter.setSize(80, 40);
        stepCounter.setSize(80, 40);
        backBtn.setSize(100, 40);
        undoBtn.setSize(100, 40);
        resetBtn.setSize(100, 40);
        muteBtn.setSize(100,40);


        this.frame.add(playerName);
        this.frame.add(Name);
        this.frame.add(levelCounter);
        this.frame.add(stepCounter);
        this.frame.add(undoBtn);
        this.frame.add(resetBtn);
        this.frame.add(backBtn);
        this.frame.add(muteBtn);

        String[][] array = map.getCurrentMap();
        if(this.mode.equals("fog")) {
        	array = map.fogMap(array);
        }
        else if(this.mode.equals("torch")) {
        	array = map.torchMap(array, "D");
        }

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!(wind==null)) wind.close();
                frame.dispose();
                new Window();
            }
        });

        undoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().requestFocus();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().requestFocus();
            }
        });
        
        
        muteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().requestFocus();
                wind.stop();
                musicToggle ^= true;
                if(musicToggle) {
                	wind.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        });


        int i;
        int j;
        
        for(i=0; i<10; i++) {
            for(j=0;j<10;j++) {
                JLabel thumb = new JLabel();
                if(array[i][j].equals("W")) thumb.setIcon(wall);
                else if(array[i][j].equals("g")) thumb.setIcon(path);
                else if(array[i][j].equals("B")) thumb.setIcon(box);
                else if(array[i][j].equals("T")) thumb.setIcon(target);
                else if(array[i][j].equals("P")) thumb.setIcon(character);
                else if(array[i][j].equals("PT")) thumb.setIcon(targetD);
                else if(array[i][j].equals("BT")) thumb.setIcon(btarget);
                else if(array[i][j].equals("F")) thumb.setIcon(fog);
                thumb.setSize(70,70);
                thumb.setLocation(j*70, i*70);
                this.frame.getContentPane().add(thumb);
            }
        }
        
        if(this.map.getLevel() == 0) {
        	Object[] options = {"Yes",
                    "No (Skip Tutorial)",
        	};
        	
        	int tutorialresponse = JOptionPane.showOptionDialog(frame,
        		    "Welcome to Dungeon Master human.\n" + 
        		    "You are a dungeon keeper, keeping order in your dungeon through re-arranging boxes.\n\n" +
        		    "Do you want to learn how?",
        		    "TUTORIAL",
        		    JOptionPane.YES_NO_OPTION,
        		    JOptionPane.QUESTION_MESSAGE,
        		    new ImageIcon("files/character.png"),
        		    options,
        		    options[0]);
        	
        	if (tutorialresponse == JOptionPane.YES_OPTION){
        		JOptionPane.showMessageDialog(frame,
        			    "Boxes can be moved in the dungeon by pushing against one of its faces.\n" + 
        			    "You cannot pull a box towards you.",
        			    "TUTORIAL",
        			    JOptionPane.INFORMATION_MESSAGE,
        			    new ImageIcon("files/tut1.png"));
        		
        		JOptionPane.showMessageDialog(frame,
        			    "Boxes cannot be pushed in a direction if they have a wall next to them",
        			    "TUTORIAL",
        			    JOptionPane.INFORMATION_MESSAGE,
        			    new ImageIcon("files/tut2.png"));
        		
        		JOptionPane.showMessageDialog(frame,
        			    "Also, boxes cannot be pushed if there is another box behind them",
        			    "TUTORIAL",
        			    JOptionPane.INFORMATION_MESSAGE,
        			    new ImageIcon("files/tut3.png"));
        		
        		JOptionPane.showMessageDialog(frame,
        			    "Push all the boxes into the goal points to complete the dungeon",
        			    "TUTORIAL",
        			    JOptionPane.INFORMATION_MESSAGE,
        			    new ImageIcon("files/tut4.png"));
        		
        		JOptionPane.showMessageDialog(frame,
        			    "Good luck human.",
        			    "TUTORIAL",
        			    JOptionPane.INFORMATION_MESSAGE,
        			    null);

        	}
        }
    }
	
	

	
	
	
	/*
	* Key Listener Class 
	* Jessey Kang
	* 
	* In main need to create a new KeyListenerGame
	* i.e. KeyListenerGame keyListener = new KeyListenerGame();
	* Whenever a key is pressed, keypressed is called. When a key is released, keyreleased is called. When key is typed, keytyped. Don't need to use keytyped or keyreleased for our project
	*/

    public class KeyListenerGame implements KeyListener{

        @Override
        public void keyPressed(KeyEvent event) {

            int key = event.getKeyCode();


            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){ //Move Left. Either Left arrow or A key will work
                map.getMapLinkedList().add(map.cloneMap(map.getCurrentMap()));
                if (!map.checkCollision(map.findPlayer(map.getCurrentMap()), "left")){
                    map.getMapLinkedList().removeLast();
                }
                else {
                	if(musicToggle) {
                	playSound("files/move.wav");
                	}
                }
                update();
                spriteL();

            }

            else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
                map.getMapLinkedList().add(map.cloneMap(map.getCurrentMap()));
                if (!map.checkCollision(map.findPlayer(map.getCurrentMap()), "right")){
                    map.getMapLinkedList().removeLast();
                }

                else {
                	if(musicToggle) {
                	playSound("files/move.wav");
                	}
                }
                update();
                spriteR();
            }


            else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W ){
                map.getMapLinkedList().add(map.cloneMap(map.getCurrentMap()));
                if (!map.checkCollision(map.findPlayer(map.getCurrentMap()), "up")){
                    map.getMapLinkedList().removeLast();
                }
                else {
                	if(musicToggle) {
                	playSound("files/move.wav");
                	}
                }
                update();
                spriteU();
            }

            else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
                map.getMapLinkedList().add(map.cloneMap(map.getCurrentMap()));
                if (!map.checkCollision(map.findPlayer(map.getCurrentMap()), "down")){
                    map.getMapLinkedList().removeLast();
                }
                else {
                	if(musicToggle) {
                	playSound("files/move.wav");
                	}
                }
                update();
                sprite();
            }
            else if ( key == KeyEvent.VK_R){
            	if(!map.getMapLinkedList().isEmpty()) {
            		map.changeMap(map.getMapLinkedList().getFirst());
            		map.getMapLinkedList().clear();
            		map.steps = 0;
            		update();
            		sprite();
            	}
            }

            else if ( key == KeyEvent.VK_U){
                if (!map.getMapLinkedList().isEmpty()){
                    map.changeMap(map.getMapLinkedList().removeLast());
                    map.steps--;
                    update();
                    sprite();
                }

            }


            if(gameFinished()) {
                //Current map is finished
            	if (map.getLevel() == 25){ //Game finished
            		JOptionPane.showMessageDialog(
            			   frame,
            			   "Congratulations adventurer, you have completed all pre-levels.\n" +
            			   "Now, go forth and take on the generated levels.\n" +
            			   "There are infinitely many levels out there for you to challenge\n",
            			   "Finish",
            			   JOptionPane.INFORMATION_MESSAGE);
            		frame.dispose();
            		new Window();
            	}
            	
            	else {
            		int response = JOptionPane.showConfirmDialog(null, "Well done! You've conquered this level, you're the real master!" +
            				"\nClick YES to continue to next level, NO to go back to main menu.", "Confirm",
            				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            		if (response == JOptionPane.NO_OPTION) {
            			wind.stop();
            			if (musicToggle) {
            				if(!(celebration==null)) celebration.close();
            			}
            			frame.dispose();
            			new Window();
            		}
            		else if (response == JOptionPane.YES_OPTION) {
            			if (musicToggle) {
            				if(!(celebration==null)) celebration.close();
            			}
            			map.steps = 0;
            			map.getMapLinkedList().clear();
            			if(map.getLevel()<=100) {
            				map.incrementLevel();
            				map.setLevel(map.getLevel());
            				update();
            				sprite();
            			}
            			else {
            				map.setLevel(map.getLevel());
            				update();
            				sprite();
            			}
            		}
            	}
            }
        }


        @Override
        public void keyReleased(KeyEvent arg0) {
        }

        @Override
        public void keyTyped(KeyEvent arg0) {
        }


        public void update() {//update frame to show a new map
            frame.getContentPane().requestFocus();

            frame.getContentPane().removeAll();
            frame.getContentPane().setLayout(null);




            JLabel playerName = new JLabel();
            if(!player.getName().isEmpty()) {
            	playerName.setText("MASTER:");
            }
            playerName.setFont(new Font("Serif", Font.PLAIN, 14));
            playerName.setForeground (Color.RED);
            JLabel Name = new JLabel(player.getName());
            Name.setFont(new Font("Serif", Font.PLAIN, 14));
            Name.setForeground (Color.RED);
            JLabel levelCounter = new JLabel();
            if(map.getLevel()<=100) {
            	levelCounter.setText("LEVEL " + map.getLevel());
            }
            else {
            	switch (map.getLevel()-100) {
            	case 1: levelCounter.setText("NOOB");
            	break;
                case 2: levelCounter.setText("EASY");
                break;
                case 3: levelCounter.setText("MODARATE");
                break;
                case 4: levelCounter.setText("CHALLENGE");
                break;
                case 5: levelCounter.setText("DIFFICULT");
                break;
            	}
            }
            levelCounter.setFont(new Font("Serif", Font.PLAIN, 14));
            levelCounter.setForeground (Color.RED);
            JLabel stepCounter = new JLabel("Steps: " + map.steps);
            stepCounter.setFont(new Font("Serif", Font.PLAIN, 14));
            stepCounter.setForeground (Color.RED);
            
            JButton undoBtn = new JButton("Undo(U)");
            JButton resetBtn = new JButton("Reset(R)");
            JButton backBtn = new JButton("Main Menu");
            JButton muteBtn = new JButton("Un/Mute");

            undoBtn.setFont(new Font("Arial", Font.BOLD, 12));
            resetBtn.setFont(new Font("Arial", Font.BOLD, 12));
            backBtn.setFont(new Font("Arial", Font.BOLD, 12));
            muteBtn.setFont(new Font("Arial", Font.BOLD, 12));

            playerName.setLocation(740, 50);
            Name.setLocation(740, 70);
            levelCounter.setLocation(740, 160);
            stepCounter.setLocation(740, 200);
            undoBtn.setLocation(720, 260);
            resetBtn.setLocation(720, 340);
            muteBtn.setLocation(720, 420);
            backBtn.setLocation(720, 600);

            
            
            Name.setSize(80, 40);
            playerName.setSize(80, 40);
            levelCounter.setSize(80, 40);
            stepCounter.setSize(80, 40);
            backBtn.setSize(100, 40);
            undoBtn.setSize(100, 40);
            resetBtn.setSize(100, 40);
            muteBtn.setSize(100,40);


            frame.add(playerName);
            frame.add(Name);
            frame.add(levelCounter);
            frame.add(stepCounter);
            frame.add(undoBtn);
            frame.add(resetBtn);
            frame.add(backBtn);
            frame.add(muteBtn);

            resetBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if(!map.getMapLinkedList().isEmpty()) {
                		map.changeMap(map.getMapLinkedList().getFirst());
                		map.getMapLinkedList().clear();
                		map.steps = 0;
                		update();
                		sprite();
                	}
                	else {
                		update();
                		sprite();
                	}
                }
            });

            undoBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!map.getMapLinkedList().isEmpty()){
                        map.changeMap(map.getMapLinkedList().removeLast());
                        map.steps--;
                        update();
                        sprite();
                    }
                    else {
                		update();
                		sprite();
                	}
                }
            });


            backBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if(!(wind==null)) wind.close();
                    frame.dispose();
                    new Window();
                }
            });
       
        
        
            muteBtn.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
	                frame.getContentPane().requestFocus();
	                wind.stop();
	                musicToggle ^= true;
	                if(musicToggle) {
	                	wind.loop(Clip.LOOP_CONTINUOUSLY);
	                }
	            }
	        });
   
        }
	        

        public void sprite() {
            String[][] array = map.getCurrentMap();
            if(mode.equals("fog")) {
            	array = map.fogMap(array);
            }
            else if(mode.equals("torch")) {
            	array = map.torchMap(array, "D");
            }
            for(int i=0; i<10; i++) {
                for(int j=0;j<10;j++) {
                    JLabel thumb = new JLabel();
                    if(array[i][j].equals("W")) thumb.setIcon(wall);
                    else if(array[i][j].equals("g")) thumb.setIcon(path);
                    else if(array[i][j].equals("B")) thumb.setIcon(box);
                    else if(array[i][j].equals("T")) thumb.setIcon(target);
                    else if(array[i][j].equals("P")) thumb.setIcon(character);
                    else if(array[i][j].equals("PT")) thumb.setIcon(targetD);
                    else if(array[i][j].equals("BT")) thumb.setIcon(btarget);
                    else if(array[i][j].equals("F")) thumb.setIcon(fog);
                    thumb.setSize(70,70);
                    thumb.setLocation(j*70, i*70);
                    frame.getContentPane().add(thumb);
                }
            }

            frame.revalidate();
            frame.repaint();
        }

        public void spriteU() {
            String[][] array = map.getCurrentMap();
            if(mode.equals("fog")) {
            	array = map.fogMap(array);
            }
            else if(mode.equals("torch")) {
            	array = map.torchMap(array, "U");
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    JLabel thumb = new JLabel();
                    if (array[i][j].equals("W")) thumb.setIcon(wall);
                    else if (array[i][j].equals("g")) thumb.setIcon(path);
                    else if (array[i][j].equals("B")) thumb.setIcon(box);
                    else if (array[i][j].equals("T")) thumb.setIcon(target);
                    else if (array[i][j].equals("P")) thumb.setIcon(characterU);
                    else if (array[i][j].equals("PT")) thumb.setIcon(targetU);
                    else if (array[i][j].equals("BT")) thumb.setIcon(btarget);
                    else if(array[i][j].equals("F")) thumb.setIcon(fog);
                    thumb.setSize(70, 70);
                    thumb.setLocation(j * 70, i * 70);
                    frame.getContentPane().add(thumb);
                }

                frame.revalidate();
                frame.repaint();
            }
        }

        public void spriteR() {
            String[][] array = map.getCurrentMap();
            if(mode.equals("fog")) {
            	array = map.fogMap(array);
            }
            else if(mode.equals("torch")) {
            	array = map.torchMap(array, "R");
            }
            for(int i=0; i<10; i++) {
                for(int j=0;j<10;j++) {
                    JLabel thumb = new JLabel();
                    if(array[i][j].equals("W")) thumb.setIcon(wall);
                    else if(array[i][j].equals("g")) thumb.setIcon(path);
                    else if(array[i][j].equals("B")) thumb.setIcon(box);
                    else if(array[i][j].equals("T")) thumb.setIcon(target);
                    else if(array[i][j].equals("P")) thumb.setIcon(characterR);
                    else if(array[i][j].equals("PT")) thumb.setIcon(targetR);
                    else if(array[i][j].equals("BT")) thumb.setIcon(btarget);
                    else if(array[i][j].equals("F")) thumb.setIcon(fog);
                    thumb.setSize(70,70);
                    thumb.setLocation(j*70, i*70);
                    frame.getContentPane().add(thumb);
                }
            }

            frame.revalidate();
            frame.repaint();
        }

        public void spriteL() {
            String[][] array = map.getCurrentMap();
            if(mode.equals("fog")) {
            	array = map.fogMap(array);
            }
            else if(mode.equals("torch")) {
            	array = map.torchMap(array, "L");
            }
            for(int i=0; i<10; i++) {
                for(int j=0;j<10;j++) {
                    JLabel thumb = new JLabel();
                    if(array[i][j].equals("W")) thumb.setIcon(wall);
                    else if(array[i][j].equals("g")) thumb.setIcon(path);
                    else if(array[i][j].equals("B")) thumb.setIcon(box);
                    else if(array[i][j].equals("T")) thumb.setIcon(target);
                    else if(array[i][j].equals("P")) thumb.setIcon(characterL);
                    else if(array[i][j].equals("PT")) thumb.setIcon(targetL);
                    else if(array[i][j].equals("BT")) thumb.setIcon(btarget);
                    else if(array[i][j].equals("F")) thumb.setIcon(fog);
                    thumb.setSize(70,70);
                    thumb.setLocation(j*70, i*70);
                    frame.getContentPane().add(thumb);
                }
            }

            frame.revalidate();
            frame.repaint();
        }

        public boolean gameFinished (){
            int Bcount = 0;
            String[][] temp = map.getCurrentMap();
            for (int i = 0; i < temp.length; i++){
                for (int j = 0; j < temp[i].length; j++){
                    if (temp[i][j].equals("B")){
                        Bcount++;
                    }
                }
            }

            if (Bcount != 0){
                return false;
            }

            if(musicToggle) {
            try {
                celebration = AudioSystem.getClip();
                celebration.open(AudioSystem.getAudioInputStream(new File("files/cheering.wav")));
                celebration.start();
            }
            catch(Exception exc) {
                exc.printStackTrace(System.out);
            }
            }
            return true;

        }


        public void playSound(String file) {
            Clip clip;
            try {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(file)));
                clip.start();
            }
            catch(Exception exc) {
                exc.printStackTrace(System.out);
            }
        }

    }





}