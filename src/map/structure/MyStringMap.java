package map.structure;

import java.util.Collection;
import java.util.Set;

public interface MyStringMap {
	//
	int size();
	boolean empty();
	boolean contains(String key);
	void put(String key, String value); 
	String get(String key);
	void remove(String key);
	Set<String> keySet(); 
	Collection<String> values(); 
	void clear();
}
