package me.the_man_of_dark.minegame.utils;

import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Money {

	static public FileConfiguration geld = Files.getMoneyFile();
	
	public static boolean has(Player p, int i) {
		boolean status = false;
		int money = geld.getInt("money." + p.getName());
		if (money >= i) {
			status = true;
		} 
		return status;
	}

	public static void remove(Player p, int i) {
		Files.loadMoney();
		int money = geld.getInt("money." + p.getName());
		geld.set("money." + p.getName(), money-i);
		try {
			geld.save(Files.moneyfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void set(String p, int i) {
		geld.set("money." + p, i);
		try {
			geld.save(Files.moneyfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
