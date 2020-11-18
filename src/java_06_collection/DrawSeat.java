package java_06_collection;
/**
 * ������һ����Ӧ��
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class DrawSeat {
	public static void main(String[] args) {
		List<String> nameList = new ArrayList<String>();
		List<String> seatList = new ArrayList<String>();
		String[] name = {"习忠�?","陈龙","吴永�? ","熊婧","王继�?","安小�?"};
		String[] seats = {"seat1","seat2","seat3","seat4","seat5","seat6"};
		for (String string : name) {
			nameList.add(string);
		}
		for (String string : seats) {
			seatList.add(string);
		}
		Map<String, String> map = new HashMap<String, String>();
		while (true) {
			int nameid = (int) (Math.random()*(nameList.size()));
			int seatid = (int) (Math.random()*(seatList.size()));
			
			if (nameList.size()==0&&seatList.size()==0) {
				break;
			}
			map.put(nameList.get(nameid), seatList.get(seatid));
			nameList.remove(nameid);
			seatList.remove(seatid);
		}
		Set<Entry<String, String>> set = map.entrySet();
		for (Iterator<Entry<String, String>> tt=set.iterator();tt.hasNext();) {
			Entry<String, String> temp = tt.next();
			System.out.println(temp.getKey()+"-->"+temp.getValue());
		}
	}
}
