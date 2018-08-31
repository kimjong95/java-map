package map.structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyMap implements MyStringMap {
	//
	private int size;
	private Entry[] table;

	private static final int default_prime_ArraySize = 31; // 값을 저장할 배열의 크기를 100으로 설정

	private static final float load_factor = 0.75f;

	private int prime;

	public MyMap() {
		//
		size = 0;
		prime = default_prime_ArraySize;
		table = new Entry[default_prime_ArraySize];
	}

	@Override
	public int size() {
		// Map의 사이즈 반환
		return size;
	}

	@Override
	public boolean empty() {
		//
		return size == 0;
	}

	@Override
	public boolean contains(String key) {
		// key값으로 Map에 매핑된 element가 있는지 확인
		int index = indexOfHash(key.hashCode());

		Entry findEntry = table[index];
		boolean isContains = false;

		while (findEntry.nextEntry != null) {
			if (table[index].key == key) {
				isContains = true;
			}

			findEntry = findEntry.nextEntry;
		}

		return isContains;
	}

	@Override
	public void put(String key, String value) {
		//
		if (key == null) {
			throw new NullPointerException("키값으로 지정할 수 없는 값입니다 :" + key);
		}

		Entry newEntry = new Entry(key, value);
		newEntry.hash = key.hashCode();
		Entry findEntry = table[indexOfHash(newEntry.hash)];
		
		if (findEntry == null) {
			table[indexOfHash(newEntry.hash)] = newEntry;
		} else {
			while (true) {
				if(findEntry == null) {
					Entry saveEntry = table[indexOfHash(newEntry.hash)];
					table[indexOfHash(newEntry.hash)] = newEntry;
					newEntry.nextEntry = saveEntry;
					break;
				}
				if (findEntry.key.equals(key)) {
					findEntry.setValue(value);
				} else {
					findEntry = findEntry.nextEntry;
				}
			}
		}

//		if (findEntry.key.equals(key)) {
//			findEntry.setValue(value);
//		} else {
//			putValue(newEntry);
//		}

		size++;

		if (size > (table.length* load_factor) && ((table.length * 2)) < (2^32)) {
			resize();
		}
	}

	@Override
	public String get(String key) {
		// 지정된 key값에 의해 매핑된 값을 반환 없으면 null
		if (getEntry(key) == null) {
			return null;
		}

		return getEntry(key).value;
	}

	@Override
	public void remove(String key) {
		// key로부터 매핑된 값을 map에서 삭제

		clearInEntry(getEntry(key));
		size--;
	}

	@Override
	public Set<String> keySet() {
		// set이 맵에 포함되고있는 키의 뷰를 반환
		Set<String> keySet = new MySet();
		return keySet;
	}

	@Override
	public Collection<String> values() {
		// 컬렉션이 Map에 포함되어있는 값을 반환
		Collection<String> value = new MyCollection();
		return value;
	}

	@Override
	public void clear() {
		// map을 클리어
		for (Entry entry : table) {
			while (entry != null) {
				Entry nextEntry = entry.nextEntry;
				clearInEntry(entry);

				entry = nextEntry;
			}
		}
		size = 0;
	}

	// private method
	private int indexOfHash(int hash) {
		//
		int index = hash % (prime);
		return index;
	}

	private int prime(int number) {
		//
		int primeNumber = number + 1;

		while (true) {
			if (isPrime(primeNumber) == false) {
				prime = primeNumber;
				return prime;
			}
			primeNumber++;
		}
	}

	private boolean isPrime(int number) {

		boolean isPrime = false;

		for (int i = 2; i < number; i++) {
			// 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
			if (number % i == 0) {
				// 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
				isPrime = true;
				// 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
				break;
			}
		}

		return isPrime;

	}

//	private void putValue(Entry inputEntry) {
//		//
//		Entry findEntry = table[indexOfHash(inputEntry.hash)];
//
//		if (findEntry == null) {
//			table[indexOfHash(inputEntry.hash)] = inputEntry;
//		} else {
//
//			table[indexOfHash(inputEntry.hash)] = inputEntry;
//			inputEntry.nextEntry = findEntry;
//
//		}
//	}

	private Entry getEntry(String key) {
		//
		Entry findEntry;

		int hash = key.hashCode();
		if (table[indexOfHash(hash)] == null) {

		}
		if (table[indexOfHash(hash)].getKey().equals(key)) {
			return table[indexOfHash(hash)];
		} else {
			findEntry = table[indexOfHash(hash)];
			while (true) {
				if (findEntry.nextEntry == null) {
					return null;
				}

				if (findEntry.nextEntry.getKey().equals(key)) {
					return findEntry.nextEntry;
				} else {
					findEntry = findEntry.nextEntry;
				}
			}
		}
	}

	private void resize() {
		//
//		if((table.length * 2) > (2^32)) {
//			return;
//		}
		
		Entry[] oldTable = table;

		int newCapacity = prime(table.length * 2);

		Entry[] newTable = new Entry[newCapacity];

		table = newTable;
		System.out.println("size UP!");
		relocationOfEntry(newTable, oldTable);
		// 재배치 해야함
	}

	private void relocationOfEntry(Entry[] newTable, Entry[] oldTable) {
		//
		for (Entry entry : oldTable) {
			while (entry != null) {

				put(entry.key, entry.value);

				entry = entry.nextEntry;
			}
		}

		// int index = 0;
		// Entry next;
		// Entry findEntry = oldTable[index];
		//
		// while (findEntry != null) {
		// //
		// System.out.println("while1");
		//
		// if (oldTable[index] == null) {
		// index++;
		// continue;
		// }
		// while (findEntry != null) {
		// System.out.println("while2");
		// next = findEntry.nextEntry;
		// if (next != null) {
		// next = findEntry.nextEntry;
		// }
		// this.putValue(findEntry);
		// }
		// }
	}

	private void clearInEntry(Entry entry) {
		//
		entry.hash = 0;
		entry.value = null;
		entry.key = null;
		entry.nextEntry = null;
	}

	private class Entry {
		//
		private String key;
		private int hash;
		private String value;
		private Entry nextEntry;

		public Entry(String newKey, String newValue) {
			//
			key = newKey;
			value = newValue;
			nextEntry = null;
		}

		public String getKey() {
			return key;
		}

//		public String getValue() {
//			return value;
//		}

		public void setValue(String updateValue) {
			this.value = updateValue;
		}

//		public boolean equals(String findValue) {
//			//
//			return (value == findValue);
//		}
//
//		public int hashcode() {
//			//
//			return hash;
//		}
	}

	private class MySet implements Set<String> {

		@Override
		public int size() {
			// 
			return 0;
		}

		@Override
		public boolean isEmpty() {
			//
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// 
			return false;
		}

		@Override
		public Iterator<String> iterator() {
			// 
			return new SetIterator();
		}

		@Override
		public Object[] toArray() {
			// 
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// 
			return null;
		}

		@Override
		public boolean add(String e) {
			// 
			return false;
		}

		@Override
		public boolean remove(Object o) {
			//
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// 
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends String> c) {
			// 
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// 
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// 
			return false;
		}

		@Override
		public void clear() {
			// 

		}

	}

	private class MyCollection implements Collection<String> {
		//

		@Override
		public Iterator<String> iterator() {
			//
			return new ColIterator();
		}

		@Override
		public int size() {
			// 
			return 0;
		}

		@Override
		public boolean isEmpty() {
			//
			return false;
		}

		@Override
		public boolean contains(Object o) {
			//
			return false;
		}

		@Override
		public Object[] toArray() {
			//
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// 
			return null;
		}

		@Override
		public boolean add(String e) {
			// 
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// 
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// 
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends String> c) {
			//
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			//
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			//
			return false;
		}

		@Override
		public void clear() {
			// 
			
		}

		

	}

	private class SetIterator implements Iterator<String> {
		//
		private int index;
		private int iterSize;
		Entry entry;

		public SetIterator() {
			//
			index = 0;
			entry = findFirstEntry();
		}

		@Override
		public boolean hasNext() {
			//
			boolean isHasNext = false;
			if (table.length > iterSize) {
				isHasNext = true;
			}
			return isHasNext;
		}

		@Override
		public String next() {
			//
			Entry findEntry = entry;
			System.out.println(entry.nextEntry==null);
			
			if (entry.nextEntry == null) {
				
				for(int i = index; i<table.length ; i++) {
					
					if(table[index] != null) {
						
						index = i;
						entry = table[index++];
						break;
					}
				}
			} else {
				entry = entry.nextEntry;
			}

			return findEntry.key;
		}

		private Entry findFirstEntry() {
			if (entry == null) {
				for (int i = index; i < table.length; i++) {

					if (table[index] != null) {
						System.out.println(index);
						index = i;
						entry = table[index++];

						break;
					}
				}
			}
			return entry;
		}
	}
	
	private class ColIterator implements Iterator<String> {
		//
		private int index;
		private int iterSize;
		Entry entry;

		public ColIterator() {
			//
			index = 0;
			entry = findFirstEntry();
		}

		@Override
		public boolean hasNext() {
			//
			boolean isHasNext = false;
			if (table.length > iterSize) {
				isHasNext = true;
			}
			return isHasNext;
		}

		@Override
		public String next() {
			//
			Entry findEntry = entry;
			System.out.println(entry.nextEntry==null);
			
			if (entry.nextEntry == null) {
				
				for(int i = index; i<table.length ; i++) {
					
					if(table[index] != null) {
						
						index = i;
						entry = table[index++];
						break;
					}
				}
			} else {
				entry = entry.nextEntry;
			}

			return findEntry.value;
		}

		private Entry findFirstEntry() {
			if (entry == null) {
				for (int i = index; i < table.length; i++) {

					if (table[index] != null) {
						System.out.println(index);
						index = i;
						entry = table[index++];

						break;
					}
				}
			}
			return entry;
		}
	}

}
