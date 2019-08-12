package co.kkomang.app.model;

import java.util.HashMap;
import java.util.Map;

public enum Menu {

	INSERT(1), UPDATE(2), DELETE(3), SEARCH(4), SELECT(5), EXIT(9);
	
	public final int value;
	
	private Menu(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
	private static Map<Integer, Menu> map = new HashMap<>();
	
	static {
		for(Menu menu : Menu.values()) {
			map.put(menu.value,  menu);
			
		}
	}
	
	public static Menu valueOf(int option) {
		return (Menu) map.get(option);
	}
}
