package me.the_man_of_dark.minegame.utils;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

public class Team {

	static public HashMap<Integer, List<String>> rot = new HashMap<Integer, List<String>>();
	static public HashMap<Integer, List<String>> blau = new HashMap<Integer, List<String>>();
	
	static public List<String> getRot() {
		return rot.get(1);
	}
	
	static public List<String> getBlau() {
		return blau.get(1);
	}

	public static void setRot(Player p) {
		if (rot.isEmpty() == true) {
			List<String> list = Lists.newArrayListWithCapacity(1);
			list.add(p.getName());
			rot.put(1, list);
		} else {
			List<String> list = rot.get(1);
			list.add(p.getName());
			rot.put(1, list);
		}

	}
	
	public static void setBlau(Player p) {
		if (blau.isEmpty() == true) {
			List<String> list = Lists.newArrayListWithCapacity(1);
			list.add(p.getName());
			blau.put(1, list);
		} else {
			List<String> list = blau.get(1);
			list.add(p.getName());
			blau.put(1, list);
		}

	}

	public static String getTeam(Player p) {
		if (blau.isEmpty()) {
			
		} else {
			List<String> list = blau.get(1);
			if (list.contains(p.getName())) {
				return "Blau";
			}
		}
		
		if (rot.isEmpty()) {
			
		} else {
			List<String> list = rot.get(1);
			if (list.contains(p.getName())) {
				return "Rot";
			}
		}
		return null;
	}
}
