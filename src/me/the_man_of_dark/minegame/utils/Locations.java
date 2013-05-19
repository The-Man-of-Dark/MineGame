package me.the_man_of_dark.minegame.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

public class Locations {

	static public File locfile = new File("plugins/MineGame/", "locations.yml");
	static public FileConfiguration locs = Files.getLocationsFile();
	
	public static Location getLobby() {
		if (locs != null) {
			
			double x = locs.getDouble("lobby.x");
			double y = locs.getDouble("lobby.y");
			double z = locs.getDouble("lobby.z");
			double pitch = locs.getDouble("lobby.pitch");
			double yaw = locs.getDouble("lobby.yaw");
			Location loc = new Location(Bukkit.getWorld("world"), x, y, z, (float) yaw, (float) pitch);
			return loc;
		} else {
			return null;
		}
	}

	public static Location getRot() {
		if (locs != null) {
			
			double x = locs.getDouble("rot.x");
			double y = locs.getDouble("rot.y");
			double z = locs.getDouble("rot.z");
			double pitch = locs.getDouble("rot.pitch");
			double yaw = locs.getDouble("rot.yaw");
			Location loc = new Location(Bukkit.getWorld("world"), x, y, z, (float) yaw, (float) pitch);
			return loc;
		} else {
			return null;
		}
	}

	public static Location getBlau() {
		if (locs != null) {
			
			double x = locs.getDouble("blau.x");
			double y = locs.getDouble("blau.y");
			double z = locs.getDouble("blau.z");
			double pitch = locs.getDouble("blau.pitch");
			double yaw = locs.getDouble("blau.yaw");
			Location loc = new Location(Bukkit.getWorld("world"), x, y, z, (float) yaw, (float) pitch);
			return loc;
		} else {
			return null;
		}
	}

	public static void setLobby(Location loc) {
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double pitch = loc.getPitch();
		double yaw = loc.getYaw();
		
		locs.set("lobby.x", x);
		locs.set("lobby.y", y);
		locs.set("lobby.z", z);
		locs.set("lobby.yaw", yaw);
		locs.set("lobby.pitch", pitch);
		try {
			locs.save(locfile);
			locs.load(locfile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void setRot(Location loc) {
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double pitch = loc.getPitch();
		double yaw = loc.getYaw();
		
		locs.set("rot.x", x);
		locs.set("rot.y", y);
		locs.set("rot.z", z);
		locs.set("rot.yaw", yaw);
		locs.set("rot.pitch", pitch);
		try {
			locs.save(locfile);
			locs.load(locfile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public static void setBlau(Location loc) {
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double pitch = loc.getPitch();
		double yaw = loc.getYaw();
		
		locs.set("blau.x", x);
		locs.set("blau.y", y);
		locs.set("blau.z", z);
		locs.set("blau.yaw", yaw);
		locs.set("blau.pitch", pitch);
		try {
			locs.save(locfile);
			locs.load(locfile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

}
