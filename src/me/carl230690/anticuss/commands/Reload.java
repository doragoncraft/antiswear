/*    */ package me.carl230690.anticuss.commands;
/*    */ 
/*    */ import me.carl230690.anticuss.AntiCuss;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Reload
/*    */   implements CommandExecutor
/*    */ {
/*    */   public AntiCuss plugin;
/*    */ 
/*    */   public Reload(AntiCuss instance)
/*    */   {
/* 15 */     this.plugin = instance;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 19 */     if (!(sender instanceof Player)) {
/* 20 */       sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
/*    */     } else {
/* 22 */       Player p = (Player)sender;
/* 23 */       if ((cmd.getName().equalsIgnoreCase("acreload")) && 
/* 24 */         (args.length == 0)) {
/* 25 */         if (!p.hasPermission("anticuss.reload")) {
/* 26 */           p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
/* 27 */         } else if (p.hasPermission("anticuss.reload")) {
/* 28 */           this.plugin.reloadConfig();
/* 29 */           this.plugin.saveConfig();
/* 30 */           p.sendMessage(ChatColor.GREEN + "AntiCuss config reloaded!");
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 35 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.commands.Reload
 * JD-Core Version:    0.6.2
 */