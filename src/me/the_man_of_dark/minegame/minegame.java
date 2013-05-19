package me.the_man_of_dark.minegame;

import java.util.logging.Logger;

import me.the_man_of_dark.minegame.commands.GameClass;
import me.the_man_of_dark.minegame.listeners.InteractEvent;
import me.the_man_of_dark.minegame.utils.Game;
import me.the_man_of_dark.minegame.utils.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class minegame extends JavaPlugin {

	static Logger log = Bukkit.getLogger();
	
	public void onEnable() {
		log.info("[MineGame] wurde gestartet!");
		log.info("[MineGame] Developed by The_Man_of_Dark");
		
		this.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		new Lobby(this);
		getCommand("g").setExecutor(new GameClass(this));
	}
	public void onDisable() {
		
		Game.stop();
		log.info("[MineGame] wurde gestopt!");
	}
	
}
