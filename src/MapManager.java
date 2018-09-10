import java.util.ArrayList;
import java.util.LinkedList;


public class MapManager {
    private int level;
    private ArrayList<String[][]> mapList;
    private String[][] currentMap;
    private LinkedList<String[][]> mapLinkedList;
    int steps=0;
    

    public MapManager() {
    	this.mapLinkedList = new LinkedList<String[][]>();
    	createAllLevel();
    }
    
    private void createAllLevel() {
    	this.mapList = new ArrayList<String[][]>();
    	
        String[][] level = new String[][] {
    		//This level is rather easy. May be appropriate way to start the game
    		//It also shows that 2 boxes can't be pushed together
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "T", "B", "P", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "B", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "T", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    	level = new String[][] {//lv2
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "T", "B", "B", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "P", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "T", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    	level = new String[][] {//lv3
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "T", "W", "B", "P", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "B", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "W", "g", "g", "T", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    	level = new String[][] {//lv4
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "W", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "T", "W", "B", "P", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "B", "g", "g", "W", "g", "W"},
    		{"W", "g", "g", "g", "W", "W", "g", "T", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "g", "g", "g", "g", "g", "g", "g", "g", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    	level = new String[][] {//lv5
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","g","g","g","W","W","W","W","W","W"},
    		{"W","g","B","g","W","W","W","W","W","W"},
    		{"W","g","B","P","W","W","W","T","W","W"},
    		{"W","W","W","B","W","W","W","T","W","W"},
    		{"W","W","W","g","g","g","g","T","W","W"},
    		{"W","W","g","g","g","W","g","g","W","W"},
    		{"W","W","g","g","g","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	
    	level = new String[][] {//lv6
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","T","T","B","T","T","W","W"},
    		{"W","W","W","T","T","W","T","T","W","W"},
    		{"W","W","W","g","B","B","B","g","W","W"},
    		{"W","W","W","g","g","B","g","g","W","W"},
    		{"W","W","W","g","B","B","B","g","W","W"},
    		{"W","W","W","g","g","W","P","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	
    	level = new String[][] {//lv7
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","g","g","g","g","g","g","W","W","W"},
    		{"W","g","W","B","B","g","g","W","W","W"},
    		{"W","g","T","T","T","W","g","W","W","W"},
    		{"W","W","T","T","T","B","g","W","W","W"},
    		{"W","W","g","W","W","g","B","g","W","W"},
    		{"W","W","B","g","g","B","g","P","W","W"},
    		{"W","W","g","g","W","g","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv8
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","g","g","g","W","W","W","W"},
    		{"W","g","g","g","B","g","B","g","g","W"},
    		{"W","g","B","g","g","g","B","g","P","W"},
    		{"W","W","W","B","B","W","W","W","W","W"},
    		{"W","W","W","g","g","T","T","W","W","W"},
    		{"W","W","W","T","T","T","T","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv9
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
       		{"W","W","W","g","P","W","W","W","W","W"},
       		{"W","W","W","g","B","g","g","W","W","W"},
       		{"W","W","W","W","g","W","g","W","W","W"},
       		{"W","W","T","W","g","W","g","g","W","W"},
       		{"W","W","T","B","g","g","W","g","W","W"},
       		{"W","W","T","g","g","g","B","g","W","W"},
       		{"W","W","W","W","W","W","W","W","W","W"},
       		{"W","W","W","W","W","W","W","W","W","W"},
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv10
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","g","g","W","g","P","W"},
    		{"W","W","W","g","g","g","W","B","g","W"},
    		{"W","W","W","B","g","g","B","g","g","W"},
    		{"W","W","W","g","B","W","W","g","g","W"},
    		{"W","W","W","g","B","g","W","g","W","W"},
    		{"W","T","T","T","T","T","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv11
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","g","g","g","g","W","W"},
    		{"W","W","T","g","B","W","W","g","W","W"},
    		{"W","T","T","B","g","B","g","g","P","W"},
    		{"W","T","T","g","B","g","B","g","W","W"},
    		{"W","W","W","W","W","W","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv12
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","g","g","g","g","W","W"},
    		{"W","W","W","W","B","B","B","g","W","W"},
    		{"W","W","P","g","B","T","T","g","W","W"},
    		{"W","W","g","B","T","T","T","W","W","W"},
    		{"W","W","W","W","W","g","g","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
        level = new String[][] {//lv13
        	{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","T","T","W","W","W","W"},
    		{"W","W","W","W","g","T","W","W","W","W"},
    		{"W","W","W","g","g","B","T","W","W","W"},
    		{"W","W","W","g","B","g","g","W","W","W"},
    		{"W","W","g","g","W","B","B","g","W","W"},
    		{"W","W","g","g","P","g","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv14
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","g","g","g","g","W","W","W"},
    		{"W","W","g","B","g","B","B","g","W","W"},
    		{"W","W","T","T","T","T","T","T","W","W"},
    		{"W","W","g","B","B","g","B","g","W","W"},
    		{"W","W","W","W","g","P","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv15
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","g","g","g","g","W","W","W","W","W"},
    		{"W","g","B","B","B","W","W","W","W","W"},
    		{"W","g","g","W","T","T","W","W","W","W"},
    		{"W","W","g","g","T","T","B","g","W","W"},
    		{"W","W","g","g","P","g","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv16
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","T","T","T","T","g","W","W","W"},
    		{"W","W","W","T","T","T","B","W","W","W"},
    		{"W","g","g","B","W","B","g","B","g","W"},
    		{"W","g","B","B","g","g","W","B","g","W"},
    		{"W","g","g","g","g","W","g","g","g","W"},
    		{"W","W","W","W","g","P","g","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv17
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","T","T","T","T","T","T","W","W","W"},
    		{"W","g","g","B","g","W","g","W","W","W"},
    		{"W","g","B","g","W","g","B","g","W","W"},
    		{"W","W","B","g","B","g","B","g","W","W"},
    		{"W","W","g","g","P","g","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv18
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","T","g","g","P","W","W"},
    		{"W","g","g","B","B","B","g","g","W","W"},
    		{"W","T","W","W","T","W","W","T","W","W"},
    		{"W","g","g","g","B","g","g","g","W","W"},
    		{"W","g","g","B","T","W","g","W","W","W"},
    		{"W","W","W","W","g","g","g","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv19
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
       		{"W","W","W","W","g","P","g","W","W","W"},
       		{"W","W","W","W","B","B","B","W","W","W"},
       		{"W","W","W","W","g","g","g","W","W","W"},
       		{"W","g","g","g","T","g","B","W","W","W"},
       		{"W","g","B","T","B","T","g","T","W","W"},
       		{"W","g","g","W","T","W","T","W","W","W"},
       		{"W","W","W","W","W","W","W","W","W","W"},
       		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv20
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","g","g","T","B","g","W","W","W","W"},
    		{"W","g","T","B","T","B","g","g","W","W"},
    		{"W","g","B","T","B","T","P","g","W","W"},
    		{"W","g","T","B","T","B","g","W","W","W"},
    		{"W","g","g","T","B","g","g","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv21
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","T","g","g","W","W","W"},
    		{"W","g","B","T","B","T","g","g","W","W"},
    		{"W","P","B","W","g","W","B","g","W","W"},
    		{"W","g","B","T","g","T","g","g","W","W"},
    		{"W","W","W","W","B","W","B","g","W","W"},
    		{"W","W","W","T","g","T","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv22
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","g","g","g","g","g","g","g","W"},
    		{"W","g","g","g","W","B","W","B","g","W"},
    		{"W","g","B","B","g","g","T","B","T","W"},
    		{"W","g","P","W","W","W","T","T","T","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv23
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","T","g","T","g","T","W","W","W"},
    		{"W","W","g","B","B","B","g","W","W","W"},
    		{"W","W","T","B","P","B","T","W","W","W"},
    		{"W","W","g","B","B","B","g","W","W","W"},
    		{"W","W","T","g","T","g","T","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
        this.mapList.add(level);
    	level = new String[][] {//lv24
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","g","g","g","g","g","W","W","W"},
    		{"W","W","B","W","W","W","g","g","g","W"},
    		{"W","g","P","g","B","g","g","B","g","W"},
    		{"W","g","T","T","W","g","B","g","W","W"},
    		{"W","W","T","T","W","g","g","g","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"},
    		{"W","W","W","W","W","W","W","W","W","W"}
    	};
    	this.mapList.add(level);
    	level = new String[][] { //lv25
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "W", "W", "W", "W"},
    		{"W", "W", "P", "W", "B", "g", "g", "T", "W", "W"},
    		{"W", "W", "g", "B", "g", "B", "T", "T", "W", "W"},
    		{"W", "W", "g", "B", "g", "T", "W", "W", "W", "W"},
    		{"W", "W", "g", "g", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    	level = new String[][] { //lv26
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "g", "g", "g", "g", "W", "W", "W"},
    		{"W", "W", "W", "T", "W", "W", "B", "W", "W", "W"},
    		{"W", "W", "g", "T", "T", "B", "g", "g", "W", "W"},
    		{"W", "W", "g", "P", "W", "B", "g", "g", "W", "W"},
    		{"W", "W", "g", "g", "g", "g", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
    		{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
    	};
    	this.mapList.add(level);
    	
    }
    
    
    
    
    public LinkedList<String[][]> getMapLinkedList() {
    	return mapLinkedList;
    }
    
    public void changeMap(String[][] map) {
    	this.currentMap = map;
    }
    
    public String[][] getCurrentMap() {
    	return this.currentMap;
    }

    
    public int getLevel() {return this.level;}
    
    public void setLevel(int level) {
    	this.level = level;
    	if(level<=100) {
        	this.currentMap = cloneMap(this.mapList.get(level));
    	}
    	else {
    		this.currentMap = cloneMap(new generatorManager().makeMap(level-100));
    	}
    }
    
    public String[][] cloneMap(String[][] map) {
    	
    	String[][] newMap = new String[map.length][map.length];
    	
    	for (int i = 0; i < map.length; i++){
    		for (int j = 0; j < map[i].length; j++){
    				newMap[i][j] = map[i][j];
    		}
    	}
    	
    	return newMap;
    }
    
    
    
    public Integer [] findPlayer(String[][] map){
        Integer[] temp = new Integer[2];
        temp[0] = -1;
        temp[1] = -1;
        
        	for (int i = 0; i < map.length; i++){
        		for (int j = 0; j < map[i].length; j++){
        			if (map[i][j].equals("P") || map[i][j].equals("PT")){
        				temp[0] = j;
        				temp[1] = i;
        				return temp;
        			}
        		}
        	}
        	
        return temp;
	}
    
    //Pass in U, D, L, R
    public String[][] torchMap (String[][] oldmap, String direction){
    	
    	String[][] torchmap = new String[][] {
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
    		{"D", "D", "D", "D", "D", "D", "D", "D", "D", "D"}
    	};
    	
    	Integer[] position = findPlayer(oldmap);
    	
    	int x = position[0];
    	int y = position[1];
    	
    	torchmap[y][x] = oldmap[y][x];
    	
    	if (direction.equals("U")){
    		torchmap[y-1][x-1] = oldmap[y-1][x-1];
    		torchmap[y-1][x] = oldmap[y-1][x];
    		torchmap[y-1][x+1] = oldmap[y-1][x+1];
    		
    		if (y != 1){
    			torchmap[y-2][x] = oldmap[y-2][x];
    			torchmap[y-2][x-1] = oldmap[y-2][x-1];
    			torchmap[y-2][x+1] = oldmap[y-2][x+1];
    		
    			if ( x == 1){
        			torchmap[y-2][x+2] = oldmap[y-2][x+2];
        		}
        		
        		else if ( x == 8){
        			torchmap[y-2][x-2] = oldmap[y-2][x-2];
        		}
        		
        		else {
        			torchmap[y-2][x+2] = oldmap[y-2][x+2];
        			torchmap[y-2][x-2] = oldmap[y-2][x-2];
        		}
    		}
    		
    		
    		
    	}
    	
    	else if (direction.equals("D")){
    		torchmap[y+1][x-1] = oldmap[y+1][x-1];
    		torchmap[y+1][x] = oldmap[y+1][x];
    		torchmap[y+1][x+1] = oldmap[y+1][x+1];
    		
    		if (y != 8){
    			torchmap[y+2][x] = oldmap[y+2][x];
    			torchmap[y+2][x-1] = oldmap[y+2][x-1];
    			torchmap[y+2][x+1] = oldmap[y+2][x+1];
    			
    			if ( x == 1){
        			torchmap[y+2][x+2] = oldmap[y+2][x+2];
        		}
        		
        		else if ( x == 8){
        			torchmap[y+2][x-2] = oldmap[y+2][x-2];
        		}
        		else {
        			torchmap[y+2][x+2] = oldmap[y+2][x+2];
        			torchmap[y+2][x-2] = oldmap[y+2][x-2];
        		}
    		}
    		
    	}
    	
    	else if (direction.equals("L")){
    		torchmap[y-1][x-1] = oldmap[y-1][x-1];
    		torchmap[y][x-1] = oldmap[y][x-1];
    		torchmap[y+1][x-1] = oldmap[y+1][x-1];
    		
    		if (x != 1){
    			torchmap[y-1][x-2] = oldmap[y-1][x-2];
    			torchmap[y][x-2] = oldmap[y][x-2];
    			torchmap[y+1][x-2] = oldmap[y+1][x-2];
    			
        		if ( y == 1){
        			torchmap[y+2][x-2] = oldmap[y+2][x-2];
        		}
        		
        		else if ( y == 8){
        			torchmap[y-2][x-2] = oldmap[y-2][x-2];
        		}
        		else {
        			torchmap[y+2][x-2] = oldmap[y+2][x-2];
        			torchmap[y-2][x-2] = oldmap[y-2][x-2];
        		}
    		}
    		

    	}
    	
    	else if (direction.equals("R")){
    		torchmap[y-1][x+1] = oldmap[y-1][x+1];
    		torchmap[y][x+1] = oldmap[y][x+1];
    		torchmap[y+1][x+1] = oldmap[y+1][x+1];
    		
    		if (x != 8){
    			torchmap[y-1][x+2] = oldmap[y-1][x+2];
    			torchmap[y][x+2] = oldmap[y][x+2];
    			torchmap[y+1][x+2] = oldmap[y+1][x+2];
    			
        		if ( y == 1){
        			torchmap[y+2][x+2] = oldmap[y+2][x+2];
        		}
        		
        		else if ( y == 8){
        			torchmap[y-2][x+2] = oldmap[y-2][x+2];
        		}
        		else {
        			torchmap[y+2][x+2] = oldmap[y+2][x+2];
        			torchmap[y-2][x+2] = oldmap[y-2][x+2];
        		}
    		}
    	}
    	
    	return torchmap;
    }

    public String[][] fogMap (String[][] oldmap){
    	
    	String[][] foggedmap = new String[][] {
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"},
    		{"F", "F", "F", "F", "F", "F", "F", "F", "F", "F"}
    	};
    	
    	Integer[] position = findPlayer(oldmap);
    	
    	int x = position[0];
    	int y = position[1];
    	
    	foggedmap[y-1][x-1] = oldmap[y-1][x-1];
    	foggedmap[y-1][x] = oldmap[y-1][x];
    	foggedmap[y-1][x+1] = oldmap[y-1][x+1];
    	foggedmap[y][x-1] = oldmap[y][x-1];
    	foggedmap[y][x] = oldmap[y][x];
    	foggedmap[y][x+1] = oldmap[y][x+1];
    	foggedmap[y+1][x-1] = oldmap[y+1][x-1];
    	foggedmap[y+1][x] = oldmap[y+1][x];
    	foggedmap[y+1][x+1] = oldmap[y+1][x+1];
    	
    	
    	return foggedmap;
    }
    
    public boolean checkCollision(Integer [] coordinate, String direction) {
    	int dx=0,dy=0;
    	int x = coordinate[0];
    	int y = coordinate[1];
    	if (direction.equals("left")) {
    		dx = -1;
    	}
    	else if (direction.equals("right")) {
    		dx = 1;
    	}
    	else if (direction.equals("down")) {
    		dy = 1;
    	}
    	else if (direction.equals("up")) {
    		dy = -1;
    	}
    	
    	if (this.currentMap[y+dy][x+dx].equals("W")) return false ;
  
    	else if (this.currentMap[y+dy][x+dx].equals("g")) {
    		if(this.currentMap[y][x].equals("PT")) {
    	   		this.currentMap[y+dy][x+dx] = "P";
        		this.currentMap[y][x] = "T";
    		}
    		else{
    		this.currentMap[y+dy][x+dx] = "P";
    		this.currentMap[y][x] = "g";
    		}
    		this.steps++;
    	}
    	
    	else if ( this.currentMap[y+dy][x+dx].equals("T")) {
    		if(this.currentMap[y][x].equals("PT")) {
        		this.currentMap[y+dy][x+dx] = "PT";
        		this.currentMap[y][x] = "T";
    		}
    		else {
    		this.currentMap[y+dy][x+dx] = "PT";
    		this.currentMap[y][x] = "g";
    		}
    		this.steps++;
    	}
    	
    	else if (this.currentMap[y+dy][x+dx].equals("B") || this.currentMap[y+dy][x+dx].equals("BT")) {

    		if(this.currentMap[y+2*dy][x+2*dx].equals("B") || this.currentMap[y+2*dy][x+2*dx].equals("W") || this.currentMap[y+2*dy][x+2*dx].equals("BT")) return false ;
  
    		else {
    			if(this.currentMap[y][x].equals("PT")) {
    				if(this.currentMap[y+dy][x+dx].equals("B")) {
        				if(this.currentMap[y+2*dy][x+2*dx].equals("T")) {
        					this.currentMap[y][x] = "T";
        					this.currentMap[y+dy][x+dx] = "P";
        					this.currentMap[y+2*dy][x+2*dx] = "BT";
        				}
        				else {
        					this.currentMap[y][x] = "T";
        					this.currentMap[y+dy][x+dx] = "P";
        					this.currentMap[y+2*dy][x+2*dx] = "B";
        				}
        			}	
        			
        			else {
        				if(this.currentMap[y+2*dy][x+2*dx].equals("T")) {
        					this.currentMap[y][x] = "T";
        					this.currentMap[y+dy][x+dx] = "PT";
        					this.currentMap[y+2*dy][x+2*dx] = "BT";
        				}
        				else {
        					this.currentMap[y][x] = "T";
        					this.currentMap[y+dy][x+dx] = "PT";
        					this.currentMap[y+2*dy][x+2*dx] = "B";
        				}
        			}
    				
    			}
    			else {
    			if(this.currentMap[y+dy][x+dx].equals("B")) {
    				if(this.currentMap[y+2*dy][x+2*dx].equals("T")) {
    					this.currentMap[y][x] = "g";
    					this.currentMap[y+dy][x+dx] = "P";
    					this.currentMap[y+2*dy][x+2*dx] = "BT";
    				}
    				else {
    					this.currentMap[y][x] = "g";
    					this.currentMap[y+dy][x+dx] = "P";
    					this.currentMap[y+2*dy][x+2*dx] = "B";
    				}
    			}	
    			
    			else {
    				if(this.currentMap[y+2*dy][x+2*dx].equals("T")) {
    					this.currentMap[y][x] = "g";
    					this.currentMap[y+dy][x+dx] = "PT";
    					this.currentMap[y+2*dy][x+2*dx] = "BT";
    				}
    				else {
    					this.currentMap[y][x] = "g";
    					this.currentMap[y+dy][x+dx] = "PT";
    					this.currentMap[y+2*dy][x+2*dx] = "B";
    				}
    			}
    			
    		}
    			this.steps++;
    		}
    		

    	}
    	else if (this.currentMap[y+dy][x+dx].equals("T")) {
    		if(this.currentMap[y][x].equals("PT")) {
        		this.currentMap[y+dy][x+dx] = "PT";
        		this.currentMap[y][x] = "T";
    		}
    		else {
    		this.currentMap[y+dy][x+dx] = "PT";
    		this.currentMap[y][x] = "g";
    		}
    		this.steps++;
    	}
        return true;
    	
    }
    
    /*
     * Returns true if we can change it.
     * False if we can't change it
     */
    
    public boolean incrementLevel() {
    	if (level+1 < this.mapList.size()){
    		level++;
    		return true;
    	}
    	
    	return false;
    	
    }
    
    /*
     * Return true if the game is finished
     * False if the game is not finished
     * B is a box 
     * */
    
    
    
}