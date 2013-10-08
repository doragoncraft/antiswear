/*    */ package me.carl230690.anticuss.commands;
/*    */ 
/*    */ import me.carl230690.anticuss.AntiCuss;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class AntiCussCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public AntiCuss plugin;
/*    */ 
/*    */   public AntiCussCommand(AntiCuss instance)
/*    */   {
/* 15 */     this.plugin = instance;
/*    */   }
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 19 */     if (!(sender instanceof Player)) {
/* 20 */       sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
/*    */     } else {
/* 22 */       Player p = (Player)sender;
/* 23 */       if ((cmd.getName().equalsIgnoreCase("anticuss")) && 
/* 24 */         (args.length == 0)) {
/* 25 */         p.sendMessage(ChatColor.GRAY + "Commands:");
/* 26 */         p.sendMessage(ChatColor.GRAY + "/anticuss : Help screen!");
/* 27 */         p.sendMessage(ChatColor.GRAY + "/acreload : Reloads AntiCuss config!");
/* 28 */         p.sendMessage(ChatColor.GRAY + "/clearchat : Clears chat!");
/* 29 */         p.sendMessage(ChatColor.GRAY + "/chat [on/off] : Toggles chat!");
/*    */       }
/*    */     }
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.commands.AntiCussCommand
 * JD-Core Version:    0.6.2
 */