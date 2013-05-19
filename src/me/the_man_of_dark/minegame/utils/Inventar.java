package me.the_man_of_dark.minegame.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inventar {

	 public static boolean isEmpty(Player p){
		    for(ItemStack item : p.getInventory().getContents()){
		        if(item != null){
		            if(item.getType() != Material.AIR){
		                return false;
		            }
		        }
		    }
		    for(ItemStack item : p.getInventory().getArmorContents()){
		        if(item != null){
		              if(item.getType() != Material.AIR){
		                  return false;
		              }
		         }
		    }
		    return true;
		 }

	public static void clear(Player p) {
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
	}

}
