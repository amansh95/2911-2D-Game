import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class mapCreator{
	
	private LinkedList<String[][]> templates;
	private static Random rand = new SecureRandom();
	public ArrayList<Integer> boxesmoved;
	public LinkedList<String[][]> oldmaps;
	
	public mapCreator(){
		this.templates = new LinkedList<String[][]>();
		addTemplates();
		this.boxesmoved = new ArrayList<Integer>();
		this.oldmaps = new LinkedList<String[][]>();
	}
	
	public void addTemplates(){
		String[][] template = new String[][] {

    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "W", "W", "W", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.templates.add(template);
    	
    	template = new String[][] {  //Another template
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.templates.add(template);
    	
    	template = new String[][] {  //Another template
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "W", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "W", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "W", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.templates.add(template);
    	
    	template = new String[][] {  //Another template
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "W", "g", "W", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "g", "g", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.templates.add(template);
    	
    	template = new String[][] {  //Another template
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "W", "W", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "W", "g", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "g", "g", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.templates.add(template);
    	
    	
	}
	public String[][] succBox (String[][] map){
		
		
		coords temp = findPlayer(map);
		int x = temp.getX();
		int y = temp.getY();
		int num = 0;
		int num2 = 0;
		int no = 0;
		
		int limit = 10000;
		int box = 0;
		oldmaps.add(cloneMap(map));
		
		while ((map[y-1][x].equals("g") ) || (map[y+1][x].equals("g")) ||(map[y][x-1].equals("g")) || (map[y][x+1].equals("g")) ){
			//System.out.println("test");
			limit--;
			if (limit < 0){
				break;
			}
			num = rand.nextInt(4);
			num2 = rand.nextInt(4);
			//System.out.println(num);
			//System.out.println(num2);
			no = 1;
			
			if (num == 0 || num2 == 0){ //Suck all top
				while (map[y-no][x].equals("g")){
					no--;
				}
				if (map[y-1][x].equals("B")){
					
				}
				else if (map[y-no][x].equals("B")){
					map[y-no][x] = "g";
					map[y-no+1][x] = "B";
					box++;
				}
				
				
			}
			
			no=1;
			
			if (num == 1 || num2 == 1){ //Suck all bottom
				while (map[y+no][x].equals("g")){
					no++;
				}
				if (map[y+1][x].equals("B")){
					
				}
				
				else if (map[y+no][x].equals("B")){
					map[y+no][x] = "g";
					map[y+no-1][x] = "B";
					box++;
				
			}
			}
			no=1;
			
			
			if (num == 2 || num2 == 2){ //Suck all left
				while (map[y][x-no].equals("g")){
					no--;
				}
				if (map[y][x-1].equals("B")){
					
				}
				
				else if (map[y][x-no].equals("B")){
					map[y][x-no] = "g";
					map[y][x-no+1] = "B";
					box++;
				}
				
			}
			no=1;
			
			if (num == 3 || num2 == 3){ //Succ all right
				while (map[y][x+no].equals("g")){
					no++;
				}
				
				if (map[y][x+1].equals("B")){
					
				}
				
				else if (map[y][x+no].equals("B")){
					map[y][x+no] = "g";
					map[y][x+no-1] = "B";
					box++;
				}
				
			}
			no=1;
			
			
			LinkedList<Integer> intlist = new LinkedList<Integer>();
			
			if (map[y-1][x].equals("g")) {
				intlist.add(0);
			}
			
			if (map[y+1][x].equals("g")) {
				intlist.add(1);
			}

			if (map[y][x-1].equals("g")) {
				intlist.add(2);
			}

			if (map[y][x+1].equals("g")) {
				intlist.add(3);
			}
			
			if (intlist.size() == 0){
				break;
			}
			
			num = rand.nextInt(intlist.size());
			
			num2 = intlist.get(num);
			
			if (num2 == 0) {
				map[y][x] = "g";
				map[y-1][x] = "P";
				y--;
			}
			
			else if (num2 == 1) {
				map[y][x] = "g";
				map[y+1][x] = "P";
				y++;
			}

			else if (num2 == 2) {
				map[y][x] = "g";
				map[y][x-1] = "P";
				x--;
			}

			else if (num2 == 3) {
				map[y][x] = "g";
				map[y][x+1] = "P";
				x++;
			}

			
		}
		
		boxesmoved.add(box);
		return map;
	}
	
	
	public void printTemplate(String[][] temp){
	
		for (int i = 0; i < temp.length; i++){
			for (int j = 0; j < temp[i].length; j++){
				if (temp[i][j].equals("W")){
					System.out.print("W ");
				}
				else if (temp[i][j].equals("g")){
					System.out.print("  ");
				}
				
				else if (temp[i][j].equals("B")){
					System.out.print("B ");
				}
				
				else if (temp[i][j].equals("P")){
					System.out.print("P ");
				}
				
				else if (temp[i][j].equals("BT")){
					System.out.print("BT");
				}
				
				else if (temp[i][j].equals("T")){
					System.out.print("T ");
				}
			}
			System.out.println();
		}
	}
	
	//Difficulty is on a scale 1-5 (1,2,3,4,5) 
	
	public LinkedList <String[][]> makeBestMap (int difficulty){
		LinkedList<String[][]> maplist = new LinkedList<String[][]>(); //Linked list containing all the generated maps
		
		for (int i = 0; i < 100; i++){
			String[][] temp = generateMap(difficulty);
			temp = addBoxes(temp, difficulty);
			temp = addPlayer(temp);
			temp = succBox(temp);
			maplist.add(temp);
		}
		
		
		return maplist;
	}
	
	public LinkedList<coords> findBoxPositions(String[][] map){
		
		LinkedList<coords> coords = new LinkedList<coords>();
		
		for (int i = 1; i < map.length - 1; i++){
			for (int j = 1; j < map[i].length - 1; j++){
				if (map[i][j].equals("g")){
					
					if (map[i-1][j].equals("g")){ //Check up case
						if (map[i-2][j].equals("g")){
							coords.add(new coords(j,i)); //xpos is j, ypos is i
						}
					}
					else if (map[i+1][j].equals("g")){ //Check down case
						
						if (map[i+2][j].equals("g")){
							coords.add(new coords(j,i)); //xpos is j, ypos is i
						}
					}
					else if (map[i][j-1].equals("g")){ //Check left case
						
						if (map[i][j-2].equals("g")){
							coords.add(new coords(j,i)); //xpos is j, ypos is i
						}
					}
					else if (map[i][j+1].equals("g")){ //Check right case
						
						if (map[i][j+2].equals("g")){
							coords.add(new coords(j,i)); //xpos is j, ypos is i
						}
					}
				}
			}
		}
		
		return coords;
	}
	
	public String[][] addBoxes (String[][] map, int difficulty){
		
		LinkedList<coords> temp;
		int number;
		int x;
		int y;
		
		switch (difficulty){
		
			case 1: //Add one box
				temp = findBoxPositions(map); //temp contains the co-ordinates of possible boxes
				number = rand.nextInt(temp.size());
				x = temp.get(number).getX();
				y = temp.get(number).getY();
				map[y][x] = "B";
				break;
			
			case 2: //Add two boxes
				temp = findBoxPositions(map);
				
				for (int i = 0; i < 2; i++){
					number = rand.nextInt(temp.size());
					x = temp.get(number).getX();
					y = temp.get(number).getY();
					if (map[y][x].equals("B")){
						i--;
					}
					else {
						map[y][x] = "B";
					}
				}
				
				break;
			
			case 3: //Add three boxes
				temp = findBoxPositions(map);
				
				
				for (int i = 0; i < 3; i++){
					number = rand.nextInt(temp.size());
					x = temp.get(number).getX();
					y = temp.get(number).getY();
					if (map[y][x].equals("B")){
						i--;
					}
					else {
						map[y][x] = "B";
					}
				}
				break;
			
			case 4: //Add 5boxes
				temp = findBoxPositions(map);
				
				
				for (int i = 0; i < 5; i++){
					number = rand.nextInt(temp.size());
					x = temp.get(number).getX();
					y = temp.get(number).getY();
					if (map[y][x].equals("B")){
						i--;
					}
					else {
						map[y][x] = "B";
					}
				}
				break;
			
			case 5: //Add 7 boxes
				temp = findBoxPositions(map);
				
				
				for (int i = 0; i < 7; i++){
					number = rand.nextInt(temp.size());
					x = temp.get(number).getX();
					y = temp.get(number).getY();
					if (map[y][x].equals("B")){
						i--;
					}
					else {
						map[y][x] = "B";
					}
				}
				break;
			
		}
		
		return map;
	}
	
	public LinkedList<coords> findPlayerPositions(String[][] map){
		
		LinkedList<coords> coords = new LinkedList<coords>();
		int counter = 0;
		
		for (int i = 1; i < map.length - 1; i++){
			for (int j = 1; j < map[i].length - 1; j++){
				if (map[i][j].equals("g")){
					
					counter = 0;
					if (map[i-1][j].equals("W") || map[i-1][j].equals("B")){ //Up
						counter++;
						
					}
					
					if (map[i+1][j].equals("W") || map[i+1][j].equals("B")){ //Down
						counter++;
						
					}
					
					if (map[i][j-1].equals("W") || map[i][j-1].equals("B")){ //Left
						counter++;
						
					}
					
					if (map[i][j+1].equals("W") || map[i][j+1].equals("B")){ //Right
						counter++;
						
					}
					
					if (counter <= 2){
						coords.add(new coords(j,i));
					}
				}
			}
		}
		
		return coords;
	}
	
	public String[][] addPlayer (String[][] map){
	
		LinkedList<coords> temp;
		int number;
		int x;
		int y;

		temp = findPlayerPositions(map); //temp contains the co-ordinates of possible player locations
		number = rand.nextInt(temp.size());
		x = temp.get(number).getX();
		y = temp.get(number).getY();
		map[y][x] = "P";
		
		return map;
	}
	
	public coords findPlayer (String[][] map){
		
		coords temp = null;
		
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				if (map[i][j].equals("P"))
					temp = new coords(j,i);
			}
		}
		
		return temp;
	}
	
	public String[][] generateMap (int difficulty){
		
		int number = rand.nextInt(this.templates.size() - 1); //Randomnnly chooses a number between 0 and number of templates - 1
		String[][] temp = cloneMap(this.templates.get(number)); //Get the specified template
		
		//Now start adding chunks on based on difficulty level.
		//Lower difficulty means fewer of the hard chunk type
		//Higher difficulty means more of the hard chunk type
		//Map ground tiles will always be linked
		
		switch (difficulty){
		
		case 1: 
				editMap(temp,1,2); //Add number amounts of easy chunk 1
				editMap(temp,2,2); //Add number amounts of easy chunk 2
				editMap(temp,3,1);
				break;
			
		case 2:
				editMap(temp,1,2); //Add number amounts of easy chunk 1
				editMap(temp,2,2); //Add number amounts of easy chunk 2
				editMap(temp,3,1);
				break;
				
		case 3:
				editMap(temp,1,2); //Add number amounts of easy chunk 1
				editMap(temp,2,2); //Add number amounts of easy chunk 2
				editMap(temp,3,3); //Add number amounts of hard chunk
				break;
				
		case 4:
				editMap(temp,1,0); //Add number amounts of easy chunk 1
				editMap(temp,2,2); //Add number amounts of easy chunk 2
				editMap(temp,3,4); //Add number amounts of hard chunk
				break;
				
		case 5:
				editMap(temp,1,0); //Add number amounts of easy chunk 1
				editMap(temp,2,1); //Add number amounts of easy chunk 2
				editMap(temp,3,6); //Add number amounts of hard chunk
				break;
		}
		
		return temp;
		
		
	}
	
	public void editMap (String[][] map, int chunk, int number){
		
		int xpos;
		int ypos;
		
		switch (chunk){
		
		case 1:

			for (int i = 0; i < number; i++){
				xpos = xposGen();
				ypos = yposGen();
				map = addChunk1(map,xpos,ypos);
			}
			
			break;
			
		case 2:
	
			for (int i = 0; i < number; i++){
				xpos = xposGen();
				ypos = yposGen();
				map = addChunk2(map,xpos,ypos);
			}
			break;

		case 3:
			
			for (int i = 0; i < number; i++){

				xpos = xposGen();
				ypos = yposGen();
				map = addChunk3(map,xpos,ypos);
			}
			break;
		}
		
	}
	
	
	public String[][] superImpose (String[][] oldmap, String[][] newmap){
		for (int i = 0; i < oldmap.length; i++){
			for (int j = 0; j < oldmap[i].length; j++){
				if (oldmap[j][i].equals("B")){
					if (newmap[j][i].equals("B")){
						newmap[j][i] = "BT";
					}
					else if (newmap[j][i].equals("P")) {
						newmap[j][i] = "PT";
					}
					else {
						newmap[j][i] = "T";
					}
				}
			}
		}
		
		return newmap;
	}
	
	public String[][] cloneMap (String[][] map){
		
		String[][] newMap = new String[map.length][map.length];
		
		for (int i = 0; i < map.length; i++){
    		for (int j = 0; j < map[i].length; j++){
    				newMap[i][j] = map[i][j];
    		}
    	}
    	
    	return newMap;
	}
	
	public int xposGen (){
		int num = rand.nextInt(6) + 1;

		return num;
	}
	
	public int yposGen (){
		
		int num = rand.nextInt(6) + 1;
		
		return num;
	}
	
	public String[][] addChunk1(String[][] map, int xpos, int ypos){
		
		map[ypos][xpos] = "g";
		map[ypos][xpos+1] = "g";
		map[ypos+1][xpos] = "g";
		map[ypos+1][xpos+1] = "g";
		map[ypos+2][xpos] = "g";
		map[ypos+2][xpos+1] = "g";
		
		return map;
	}

	public String[][] addChunk2(String[][] map, int xpos, int ypos){
		
		map[ypos][xpos] = "g";
		map[ypos][xpos+1] = "g";
		map[ypos+1][xpos] = "g";
		map[ypos+1][xpos+1] = "g";
		
		return map;
	}
	
	public String[][] addChunk3(String[][] map, int xpos, int ypos){
		
		map[ypos][xpos] = "g";
		map[ypos][xpos+1] = "g";
		map[ypos][xpos+2] = "g";
		map[ypos+1][xpos] = "g";
		map[ypos+1][xpos+1] = "W";
		map[ypos+1][xpos+2] = "g";
		map[ypos+2][xpos] = "g";
		map[ypos+2][xpos+1] = "g";
		map[ypos+2][xpos+2] = "g";

		return map;
	 }

}