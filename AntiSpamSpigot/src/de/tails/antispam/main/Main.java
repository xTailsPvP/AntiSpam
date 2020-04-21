package de.tails.antispam.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.tails.antispam.antispam.SlowChat;
import de.tails.antispam.antispam.SpamListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Config.createFile();
		getCommand("slowchat").setExecutor(new SlowChat());
		Bukkit.getPluginManager().registerEvents(new SpamListener(), this);
		Bukkit.getConsoleSender().sendMessage(Config.getPrefix() + "§aAntiSpam wurde aktiviert!");
		Bukkit.getConsoleSender().sendMessage("§6Plugin by DyePlugins: https://dyeplugins.net");
		Bukkit.getConsoleSender().sendMessage("§6Source Code: https://github.com/xTailsPvP/AntiSpam");
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Config.getPrefix() + "§cAntiSpam wurde deaktiviert!");
		Bukkit.getConsoleSender().sendMessage("§6Plugin by DyePlugins: https://dyeplugins.net");
		Bukkit.getConsoleSender().sendMessage("§6Source Code: https://github.com/xTailsPvP/AntiSpam");
	}
}