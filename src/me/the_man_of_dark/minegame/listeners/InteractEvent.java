package me.the_man_of_dark.minegame.listeners;

import me.the_man_of_dark.minegame.utils.Game;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEvent implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Game.isGame(p)) {
			ItemMeta meta = p.getInventory().getItemInHand().getItemMeta();
			if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && meta.getDisplayName() == "§a§lMineGun") {
                Arrow arrow = e.getPlayer().launchProjectile(Arrow.class);
                p.getPlayer().playSound(p.getLocation(), Sound.ITEM_BREAK, 10000, 2000);
                arrow.setShooter(e.getPlayer());
                arrow.setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
                p.getInventory().setItemInHand(new ItemStack(Material.AIR));
                p.getInventory().setItemInHand(new ItemStack(Material.BOW));
			}
		}
	}
	
}
