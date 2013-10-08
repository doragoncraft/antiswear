/*    */ package me.carl230690.anticuss.commands;
/*    */ 
/*    */ import me.carl230690.anticuss.AntiCuss;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Chat
/*    */   implements CommandExecutor
/*    */ {
/*    */   public AntiCuss plugin;
/*    */ 
/*    */   public Chat(AntiCuss instance)
/*    */   {
/* 16 */     this.plugin = instance;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 21 */     if (!(sender instanceof Player)) {
/* 22 */       sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
/*    */     }
/* 24 */     else if (label.equalsIgnoreCase("chat")) {
/* 25 */       Player player = (Player)sender;
/* 26 */       if (player.hasPermission("anticuss.mute")) {
/* 27 */         if ((args.length == 1) && (args[0].equalsIgnoreCase("on"))) {
/* 28 */           this.plugin.chatMuted = false;
/* 29 */           Bukkit.getServer().broadcastMessage(ChatColor.GREEN + this.plugin.getConfig().getString("chatOnMessage"));
/* 30 */           return true;
/* 31 */         }if ((args.length == 1) && (args[0].equalsIgnoreCase("off"))) {
/* 32 */           this.plugin.chatMuted = true;
/* 33 */           Bukkit.getServer().broadcastMessage(ChatColor.RED + this.plugin.getConfig().getString("chatOffMessage"));
/* 34 */           return true;
/* 35 */         }if (args.length == 0) {
/* 36 */           player.sendMessage(ChatColor.RED + "/chat [on/off]");
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 41 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.commands.Chat
 * JD-Core Version:    0.6.2
 */