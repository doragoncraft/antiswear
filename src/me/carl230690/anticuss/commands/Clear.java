 package me.carl230690.anticuss.commands;
 
 import me.carl230690.anticuss.AntiCuss;

import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 
 public class Clear
   implements CommandExecutor
 {
   public AntiCuss plugin;
 
   public Clear(AntiCuss instance)
   {
     this.plugin = instance;
   }
 
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     if (!(sender instanceof Player)) {
       sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
     } else {
       Player p = (Player)sender;
       if ((cmd.getName().equalsIgnoreCase("clearchat")||((cmd.getName().equalsIgnoreCase("ctc")) && 
         (args.length == 0)))) {
         if (!p.hasPermission("anticuss.clear"))
           p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
         else if (p.hasPermission("anticuss.clear")) {
           for (int msgs = 1; msgs <= 100; msgs++) {
        	 Bukkit.broadcastMessage("");}
          {  Bukkit.broadcastMessage(ChatColor.AQUA + "Chat has been cleared by " + sender.getName());
           }
         }
       }
 
     return true;
   }

return false; }}

