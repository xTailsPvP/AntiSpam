package de.tails.antispam.antispam;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.tails.antispam.main.Config;

public class SpamListener implements Listener {

	private static HashMap<UUID, Integer> spamdelay = new HashMap<UUID, Integer>();
	private static HashMap<UUID, Integer> cmdspamdelay = new HashMap<UUID, Integer>();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(spamdelay.containsKey(player.getUniqueId())) {
			int now = Integer.valueOf((int) System.currentTimeMillis());
			int old = spamdelay.get(player.getUniqueId());
			if((old - now) > 0) {
				if(!(player.hasPermission("antispam.chatspamm.bypass"))) {
					event.setCancelled(true);
					player.sendMessage(Config.getSpamMessage());
				}
			} else {
				spamdelay.put(player.getUniqueId(), now + (1000 * Config.getSpamDelay()));
			}
		} else {
			spamdelay.put(player.getUniqueId(),
					Integer.valueOf((int) System.currentTimeMillis()) + (1000 * Config.getSpamDelay()));
		}
	}

	@EventHandler
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if(cmdspamdelay.containsKey(player.getUniqueId())) {
			int now = Integer.valueOf((int) System.currentTimeMillis());
			int old = cmdspamdelay.get(player.getUniqueId());
			if((old - now) > 0) {
				if(!(player.hasPermission("antispam.commandspamm.bypass"))) {
					event.setCancelled(true);
					player.sendMessage(Config.getCommandSpamMessage());
				}
			} else {
				cmdspamdelay.put(player.getUniqueId(), now + (1000 * Config.getCommandSpamDelay()));
			}
		} else {
			cmdspamdelay.put(player.getUniqueId(), Integer.valueOf((int) System.currentTimeMillis())
					+ (1000 * Config.getCommandSpamDelay()));
		}
	}
}
