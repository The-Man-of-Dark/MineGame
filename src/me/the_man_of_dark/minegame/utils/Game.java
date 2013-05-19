package me.the_man_of_dark.minegame.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {

	public static void addGame(Player p) {
		Players.add(p);
		p.teleport(Locations.getLobby());
		p.sendMessage("§7§l> §bDu bist dem Spiel beigetreten!");
		Lobby.callNews();
		checkGame();
	}
	
	private static void checkGame() {
		Lobby.ckeckGame();
	}

	public static boolean isGame(Player p) {
		return Players.isGame(p);
	}

	public static void removeGame(Player p) {
		Players.remove(p);
		Inventar.clear(p);
		p.teleport(p.getWorld().getSpawnLocation());
		p.sendMessage("§7§l>§b Du hast das Spiel verlassen!");
		Lobby.callLeave();
		Lobby.callNews();
	}

	public static void start() {
		for (String players : Players.pls.get(1)) {
			Player p = Bukkit.getPlayer(players);
			Players.setTeams(p);
		}
		Players.teleport();
	}

	public static void stop() {
		for (String players : Players.pls.get(1)) {
			Player p = Bukkit.getPlayer(players);
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage("§7§l>§6§l Das Spiel wurde durch einen Reload unterbrochen!");
			Inventar.clear(p);
			Game.removeGame(p);
			p.teleport(p.getWorld().getSpawnLocation());
		}
	}

	
	
}

