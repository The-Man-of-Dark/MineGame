package me.the_man_of_dark.minegame.utils;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

public class Players {

	static public HashMap<Integer, List<String>> pls = new HashMap<Integer, List<String>>();
	static boolean st = false;
	public static void add(Player p) {
		if (pls.isEmpty() == false) {
			List<String> pll = pls.get(1);
			pll.add(p.getName());
			pls.put(1, pll);
		} else {
			List<String> pll = Lists.newArrayListWithCapacity(1);
			pll.add(p.getName());
			pls.put(1, pll);
		}
	}

	public static boolean isGame(Player p) {
		boolean status = false;
		if (pls.containsKey(1) == true) {
			List<String> list = pls.get(1);
			if (list.contains(p.getName())) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}
		return status;
	}

	public static void remove(Player p) {
		if (pls.isEmpty() == true) {
			
		} else {
			List<String> list = pls.get(1);
			list.remove(p.getName());
			pls.put(1, list);
		}
	}

	public static void setTeams(Player p) {
		if (st == false) {
			Team.setRot(p);
			p.getInventory().setHelmet(new ItemStack(Material.REDSTONE_BLOCK));
			st = true;
		} else {
			Team.setBlau(p);
			p.getInventory().setHelmet(new ItemStack(Material.LAPIS_BLOCK));
			st = false;
		}
	}

	public static void teleport() {
		if (Team.rot.isEmpty() == true) {
		} else {
		for (String rot_players : Team.rot.get(1)) {
			Player p = Bukkit.getPlayer(rot_players);
			p.teleport(Locations.getRot());
		}
		}
		if (Team.blau.isEmpty() == true) {
			
		} else {
		for (String blau_players : Team.blau.get(1)) {
			Player p = Bukkit.getPlayer(blau_players);
			p.teleport(Locations.getBlau());
		}
		}
	}
	
}
