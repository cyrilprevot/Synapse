package fr.synapsegaming.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Comparateur implements Comparator {
    Map base;

    public Comparateur(Map base) {
        this.base = base;
    }

	@Override
	public int compare(Object a, Object b) {
		if ((Integer)base.get(a) >= (Integer)base.get(b)) {
            return -1;
        } else {
            return 1;
        } 
	}
	
	public TreeMap sortAndResize(int taille){
		TreeMap sorted_map = new TreeMap(this);
		sorted_map.putAll(base);
		while(sorted_map.size()>taille){
			sorted_map.pollLastEntry();
		}
		
		return sorted_map;
	}
	 
}
