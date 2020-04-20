package de.tails.antispam.antispam;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.tails.antispam.main.Config;

public class SlowChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender.hasPermission("antispam.command"))) {
			sender.sendMessage(Config.getNoperms());
			return true;
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("chat")) {
				if(isInteger(args[1])) {
					int delay = Integer.parseInt(args[1]);
					Config.setSpamDelay(delay);
					sender.sendMessage(Config.getPrefix() + "§aDer Delay wurde erfolgreich angepasst!");
					return true;
				} else {
					sender.sendMessage(Config.getPrefix() + "§cBitte verwende gültige Werte!");
					return true;
				}
			} else if(args[0].equalsIgnoreCase("command") || args[0].equalsIgnoreCase("cmd")) {
				if(isInteger(args[1])) {
					int delay = Integer.parseInt(args[1]);
					Config.setCommandSpamDelay(delay);
					sender.sendMessage(Config.getPrefix() + "§aDer Delay wurde erfolgreich angepasst!");
					return true;
				} else {
					sender.sendMessage(Config.getPrefix() + "§cBitte verwende gültige Werte!");
					return true;
				}
			} else {
				sender.sendMessage(Config.getPrefix()
						+ "§4Bitte verwende §c/slowchat chat/command <zeit in sekunden>");
			}
		} else {
			sender.sendMessage(
					Config.getPrefix() + "§4Bitte verwende §c/slowchat chat/command <zeit in sekunden>");
			return true;
		}
		return false;
	}

	public Boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}