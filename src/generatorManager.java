import java.util.Collections;
import java.util.LinkedList;

public class generatorManager {
	
	public String[][] makeMap(int level) {
		mapCreator lmao = new mapCreator();
		LinkedList<String[][]> maps = lmao.makeBestMap(level);
		lmao.superImpose(lmao.oldmaps.get(lmao.boxesmoved.indexOf(Collections.max(lmao.boxesmoved))),maps.get(lmao.boxesmoved.indexOf(Collections.max(lmao.boxesmoved))));
		return maps.get(lmao.boxesmoved.indexOf(Collections.max(lmao.boxesmoved)));
	}
}
