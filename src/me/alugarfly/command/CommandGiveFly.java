package me.alugarfly.command;

import me.alugarfly.Item;
import me.alugarfly.SkullAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandGiveFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
            if(cmd.getName().equalsIgnoreCase("givealugarfly")){
                if(args.length == 0){
                    p.sendMessage("§c/givealugarfly <jogador>");
                    return true;
                }
                if(args.length == 1){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target == null){
                        p.sendMessage("§cJogador offline");
                        return true;
                    }
                    ItemStack itemfly = new Item(SkullAPI.getByUrl("http://textures.minecraft.net/texture/1765341353c029e9b655f4f57931ae6adc2c7a73c657945d945a307641d3778")).setDisplayName("§aAlugar §a§lFLY§a por 1 Minuto!").setLore(
                         "§7(Clique para ativar)"
                    ).build();
                    p.getInventory().addItem(itemfly);
                }
            }
        return false;
    }
}
