package me.alugarfly.command;

import me.alugarfly.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class CommandFly implements CommandExecutor {
    ArrayList<UUID> cd = new ArrayList<>();
    Main m = (Main)Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("alugarfly")) {
                 if (args.length == 0) {
                     p.sendMessage("§c/alugarfly <minutos>");
                 } else if(args.length == 1) {
                         if (args[0].equalsIgnoreCase("1M")) {
                             if (!this.cd.contains(p.getUniqueId())) {
                                 p.sendMessage("§aEpa! você alugou §a§lFLY§a por 1 Minuto!");
                                 p.setAllowFlight(true);
                                 this.cd.add(p.getUniqueId());
                                 (new BukkitRunnable() {
                                     int cooldown = 60;

                                     @Override
                                     public void run() {
                                         if (this.cooldown <= 60) {
                                             this.cooldown--;
                                             if (this.cooldown == 0) {
                                                 p.setAllowFlight(false);
                                                 p.sendMessage("§cSeu §c§lFLY§c acabou!");
                                                 CommandFly.this.cd.remove(p.getUniqueId());
                                                 cancel();
                                             }
                                         }
                                     }
                                 }).runTaskTimer((Plugin) this.m, 0L, 20L);
                             } else {
                                 p.sendMessage("§cVocê ja ativou o seu alugarfly aguarde terminar");
                             }
                         }
                     }
                 }
            return false;
        }
}
