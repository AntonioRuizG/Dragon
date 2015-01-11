package minecraftPlugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DragonPlugin extends JavaPlugin{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("dragon")){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Location playerLocation = player.getLocation();
				Location brushLocation = player.getLocation();
				dibujarDragon(playerLocation, brushLocation);
				Bukkit.getServer().broadcastMessage("dragonActivo");
				return true;
			}
		}
		return false;
	}

	private void dibujarDragon(Location playerLocation, Location brushLocation) {
		ArrayList<Vec3> dragon = DragonGenerator.getDragon();
		for(Vec3 v:dragon){
			brushLocation.setX(v.x+playerLocation.getX());
			brushLocation.setY(v.y+playerLocation.getY());
			brushLocation.setZ(v.z+playerLocation.getZ());
			
		}
	}
}
