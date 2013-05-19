package me.the_man_of_dark.minegame.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Files {

	static public File locfile = new File("plugins/MineGame/", "locations.yml");
	static public FileConfiguration locs = YamlConfiguration.loadConfiguration(locfile);
	static public File moneyfile = new File("plugins/MineGame/", "money.yml");
	static public FileConfiguration money = YamlConfiguration.loadConfiguration(moneyfile);
	
	static public void loadLocations() {
		try {
			locs.load(locfile);
		} catch (IOException| InvalidConfigurationException e) {
			System.out.println("[MineGame] 'Locations.yml' konnte nicht geladen werden");
		}
	}

	public static FileConfiguration getLocationsFile() {
		loadLocations();
		return locs;
	}

	public static FileConfiguration getMoneyFile() {
		loadMoney();
		return money;
	}

	public static void loadMoney() {
	try {
		money.load(moneyfile);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InvalidConfigurationException e) {
		e.printStackTrace();
	}
	}
	
}
