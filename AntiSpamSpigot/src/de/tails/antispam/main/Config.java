package de.tails.antispam.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private static File file = new File("plugins/AntiSpam/config.yml");
	private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

	public static void createFile() {
		if(!(file.exists())) {
			config.set("Prefix", "&9[&3AntiSpam&9] ");
			config.set("SpamMessage", "[Prefix]&cBitte unterlasse das Spammen!");
			config.set("NoPerms", "[Prefix]§cDazu hast du keine Rechte!");
			config.set("CommandSpamMessage", "[Prefix]&cBitte unterlasse das Spammen eines Commands!");
			config.set("SpamDelayinSeconds", 3);
			config.set("CommandSpamDelayinSeconds", 1);
			try {
				config.save(file);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getPrefix() {
		return config.getString("Prefix").replace("&", "§");
	}

	public static String getSpamMessage() {
		return config.getString("SpamMessage").replace("&", "§").replace("[Prefix]", getPrefix());
	}

	public static String getCommandSpamMessage() {
		return config.getString("CommandSpamMessage").replace("&", "§").replace("[Prefix]", getPrefix());
	}

	public static Integer getSpamDelay() {
		return config.getInt("SpamDelayinSeconds");
	}

	public static Integer getCommandSpamDelay() {
		return config.getInt("CommandSpamDelayinSeconds");
	}

	public static void setSpamDelay(int delay) {
		config.set("SpamDelayinSeconds", delay);
		try {
			config.save(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void setCommandSpamDelay(int delay) {
		config.set("CommandSpamDelayinSeconds", delay);
		try {
			config.save(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static String getNoperms() {
		return config.getString("NoPerms").replace("&", "§").replace("[Prefix]", getPrefix());
	}
}