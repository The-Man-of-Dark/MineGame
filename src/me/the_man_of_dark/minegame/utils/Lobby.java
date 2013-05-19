package me.the_man_of_dark.minegame.utils;

import java.util.List;

import me.the_man_of_dark.minegame.minegame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Lobby {

	private static minegame plugin;

	public Lobby(minegame pl) {
		Lobby.plugin = pl;
	}
	
	static public void callNews() {
		if (Players.pls.isEmpty() == true) {
			
		} else {
		List<String> players = Players.pls.get(1);
		for (String pl : players) {
			Player p = Bukkit.getPlayer(pl);
			p.sendMessage("§7§l> §bEs " + ((players.size() == 1) ? "ist" : "sind") + " §a" + players.size() + " §bSpieler in der Lobby");
		}
		}
	}

	public static void callLeave() {
		if (Players.pls.isEmpty() == true) {
			
		} else {
		List<String> players = Players.pls.get(1);
		for (String pl : players) {
			Player p = Bukkit.getPlayer(pl);
			p.sendMessage("§7§l>§b Ein Spieler hat die Lobby verlassen");
		}
		}
	}

	public static void ckeckGame() {
		if (Players.pls.size() > 7) {
			Lobby.setStart();
		}
	}

	public static void setStart() {
		if (Players.pls.isEmpty() == true) {
			
		} else {
		List<String> players = Players.pls.get(1);
		for (String pl : players) {
			Player p = Bukkit.getPlayer(pl);
			p.sendMessage("§7§l>§b§l Das Spiel startet in §6§l25§b§l Sekunden!");
			p.sendMessage(" ");
			p.sendMessage(" ");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		startTimer(24);	
		}		
	}

	private static void startTimer(int i)  {
			Countdown.countdown(i, plugin);
	}
	
}
