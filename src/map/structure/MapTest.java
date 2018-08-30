package map.structure;

import java.util.Iterator;

public class MapTest {
	//
	public static void main(String[] args) {
		//

		MyMap map = new MyMap();

		int key = 1;

		while (true) {

			if (key == 100) {
				break;
			}
			String strKey = key+"";

			StringBuilder builder = new StringBuilder();
			builder.append("Test");
			builder.append(strKey);

			String newValue = builder.toString();
//			System.out.println(key);
			map.put(strKey, newValue);

			key++;
			
		}	

		key = 1;
		while (true) {
			if (key == 100) {
				break;
			}

			String strKey = key+"";
			
			System.out.println(map.get(strKey));
			key++;
		}
		
		Iterator<String> keyIter = map.keySet().iterator();
		
		int a = 0;
		
//		while(keyIter.hasNext()) {
			System.out.println("반복 " + a + "번째");
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			System.out.println(keyIter.next());
			
//			a++;
//		}
		
//		map.clear();
//		
//		System.out.println(map.size());
//		map.put("1", "Test1");
//		map.put("2", "Test2");
//		map.put("3", "Test3");
//		map.put("4", "Test4");
//		map.put("5", "Test5");
//		map.put("6", "Test6");
//		map.put("7", "Test7");
//		map.put("8", "Test8");
//		map.put("9", "Test9");
//		map.put("10", "Test10");
//		map.put("11", "Test11");
//		map.put("12", "Test12");
//		map.put("13", "Test13");
//		map.put("14", "Test14");
//		map.put("15", "Test15");
//		map.put("16", "Test16");
//		map.put("17", "Test17");
//		map.put("18", "Test18");
//		map.put("19", "Test19");
//		map.put("20", "Test20");
//		map.put("21", "Test21");
//		map.put("22", "Test22");
//		map.put("23", "Test23");
//		map.put("24", "Test24");
//		map.put("25", "Test25");
//		map.put("26", "Test26");
//		map.put("27", "Test27");
//		map.put("28", "Test28");
//		map.put("29", "Test29");
//		map.put("30", "Test30");
//		map.put("31", "Test31");
//		map.put("32", "Test32");
//		map.put("33", "Test33");
//		map.put("34", "Test34");
//		map.put("35", "Test35");
//		map.put("36", "Test36");
//		map.put("37", "Test37");
//		map.put("38", "Test38");
//		map.put("39", "Test39");
//		map.put("40", "Test40");
//		map.put("41", "Test41");
//		map.put("42", "Test42");
//		map.put("43", "Test43");
//		map.put("44", "Test44");
//		map.put("45", "Test45");
//		map.put("46", "Test46");
//		map.put("47", "Test47");
//		map.put("48", "Test48");
//		map.put("49", "Test49");
//		map.put("50", "Test50");
//		map.put("51", "Test51");
//		map.put("52", "Test52");
//		map.put("53", "Test53");
//		map.put("54", "Test54");
//		map.put("55", "Test55");
//		map.put("56", "Test56");
//		map.put("57", "Test57");
//		map.put("58", "Test58");
//		map.put("59", "Test59");
		
		
		
//		System.out.println(map.get("1"));
//		System.out.println(map.get("2"));
//		System.out.println(map.get("3"));
//		System.out.println(map.get("4"));
//		System.out.println(map.get("5"));
//		System.out.println(map.get("6"));
//		System.out.println(map.get("7"));
//		System.out.println(map.get("8"));
//		System.out.println(map.get("9"));
//		System.out.println(map.get("10"));
//		System.out.println(map.get("11"));
//		System.out.println(map.get("12"));
//		System.out.println(map.get("13"));
//		System.out.println(map.get("14"));
//		System.out.println(map.get("15"));
//		System.out.println(map.get("16"));
//		System.out.println(map.get("17"));
//		System.out.println(map.get("18"));
//		System.out.println(map.get("19"));
//		System.out.println(map.get("20"));
//		System.out.println(map.get("21"));
//		System.out.println(map.get("22"));
//		System.out.println(map.get("23"));
//		System.out.println(map.get("24"));
//		System.out.println(map.get("25"));
//		System.out.println(map.get("26"));
//		System.out.println(map.get("27"));
//		System.out.println(map.get("28"));
//		System.out.println(map.get("29"));
//		System.out.println(map.get("30"));
//		System.out.println(map.get("31"));
//		System.out.println(map.get("32"));
//		System.out.println(map.get("33"));
//		System.out.println(map.get("34"));
//		System.out.println(map.get("35"));
//		System.out.println(map.get("36"));
//		System.out.println(map.get("37"));
//		System.out.println(map.get("38"));
//		System.out.println(map.get("39"));
//		System.out.println(map.get("40"));
//		System.out.println(map.get("41"));
//		System.out.println(map.get("42"));
//		System.out.println(map.get("43"));
//		System.out.println(map.get("44"));
//		System.out.println(map.get("45"));
//		System.out.println(map.get("46"));
//		System.out.println(map.get("47"));
//		System.out.println(map.get("48"));
//		System.out.println(map.get("49"));
//		System.out.println(map.get("50"));
//		System.out.println(map.get("51"));
//		System.out.println(map.get("52"));
//		System.out.println(map.get("53"));
//		System.out.println(map.get("54"));
//		System.out.println(map.get("55"));
//		System.out.println(map.get("56"));
//		System.out.println(map.get("57"));
//		System.out.println(map.get("58"));
//		System.out.println(map.get("59"));
		
		
		
//		map.remove("2");
//		
//		System.out.println(map.get("1"));
//		System.out.println(map.get("2"));
//		System.out.println(map.get("3"));
//		System.out.println(map.get("40"));
	}

}
