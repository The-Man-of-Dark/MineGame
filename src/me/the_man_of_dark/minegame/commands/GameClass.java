package me.the_man_of_dark.minegame.commands;

import me.the_man_of_dark.minegame.minegame;
import me.the_man_of_dark.minegame.utils.Game;
import me.the_man_of_dark.minegame.utils.Inventar;
import me.the_man_of_dark.minegame.utils.Lobby;
import me.the_man_of_dark.minegame.utils.Locations;
import me.the_man_of_dark.minegame.utils.Money;
import me.the_man_of_dark.minegame.utils.Shop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameClass implements CommandExecutor {

	@SuppressWarnings("unused")
	private minegame plugin;

	public GameClass(minegame game) {
		this.plugin = game;
	}


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("g")) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (args.length == 0) {
						p.sendMessage("§b(=)------------ §6MineGame§b ------------(=)");
						p.sendMessage("§6/game join §7|§b Betritt das Spiel!");
						p.sendMessage("§6/game buy <Nummer> §7|§b Kauft ein Item");
						p.sendMessage("§6/game leave§7 |§b Verlässt das Spiel");
						p.sendMessage("§b(=)------------------------------------(=)");
					} else if (args.length == 1) {
						if (args[0].equalsIgnoreCase("join")) {
							if (Game.isGame(p)) {
								p.sendMessage("§7§l>§b Du bist berreits im Spiel!");
							} else {
								if (Inventar.isEmpty(p) == true) {
									Game.addGame(p);
								} else {
									p.sendMessage("§7§l>§b Du musst dein Inventar leeren!");
								}
							}
						} else if (args[0].equalsIgnoreCase("leave")) {
							if (Game.isGame(p)) {
								Game.removeGame(p);
							} else {
								p.sendMessage("§7§l>§b Du bist nicht im Spiel!");
							}
						} else if (args[0].equalsIgnoreCase("start")) {
							if (p.hasPermission("game.start")) {
								p.sendMessage("§7§l>§b Du hast das Spiel gestartet!");
								Lobby.setStart();
							} else {
								p.sendMessage("§cDu hast keine Zugriff auf diesen Befehl!");
							}
						} else if (args[0].equalsIgnoreCase("setlobby")) {
							if (p.hasPermission("game.setlobby")) {
								p.sendMessage("§7§l>§b Du hast die §6Lobby§b gesetzt!");
								Locations.setLobby(p.getLocation());
							} else {
								p.sendMessage("§cDu hast keine Zugriff auf diesen Befehl!");
							}
						} else if (args[0].equalsIgnoreCase("setrot")) {
							if (p.hasPermission("game.setrot")) {
								p.sendMessage("§7§l>§b Du hast Team §6Rot§b gesetzt!");
								Locations.setRot(p.getLocation());
							} else {
								p.sendMessage("§cDu hast keine Zugriff auf diesen Befehl!");
							}
						} else if (args[0].equalsIgnoreCase("setblau")) {
							if (p.hasPermission("game.setblau")) {
								p.sendMessage("§7§l>§b Du hast Team §6Blau§b gesetzt!");
								Locations.setBlau(p.getLocation());
							} else {
								p.sendMessage("§cDu hast keine Zugriff auf diesen Befehl!");
							}
						} else if (args[0].equalsIgnoreCase("buy")) {
							p.sendMessage("§b(=)----------------§6 Artikel§b --------------(=)");
							p.sendMessage("§61 = §bMineGun( Schnellschußbogen )");
							p.sendMessage("§bDerzeit keine weiteren Verfügbar!");
						}
					} else if (args.length == 2) {
						if (args[0].equalsIgnoreCase("buy")) {
							int number = Integer.parseInt(args[1]);
							if (number == 1) {
								if (Game.isGame(p)) {
								if (Money.has(p, 10)) {
									Money.remove(p, 10);
									Shop.giveItem(p, 1);
									p.sendMessage("§7§l> §bDu hast eine §6MineGun§b gekauft!");
								} else {
									p.sendMessage("§7§l>§b Du hast nicht genug Geld!");
								}
							} else {
								p.sendMessage("§7§l>§b Du bist nicht im Spiel!");
							}
						  }
						} 
					} else if (args.length == 3) {
						 if (args[0].equalsIgnoreCase("set")) {
							 if (p.hasPermission("game.set")) {
								 Money.set(args[2], Integer.parseInt(args[1]));
								p.sendMessage("§7§l>§b Du hast das Geld erfolgreich gesetzt!");
							 } else {			
								 p.sendMessage("§cDu hast keine Zugriff auf diesen Befehl!");
							 }
						}
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
				}
		}
		
		return false;
	}
	
}
