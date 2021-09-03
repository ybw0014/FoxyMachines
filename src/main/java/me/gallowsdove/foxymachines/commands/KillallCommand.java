package me.gallowsdove.foxymachines.commands;

import io.github.mooy1.infinitylib.commands.SubCommand;
import me.gallowsdove.foxymachines.abstracts.CustomBoss;
import me.gallowsdove.foxymachines.abstracts.CustomMob;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.List;

public class KillallCommand extends SubCommand {
    public KillallCommand() {
        super("killall", "Kills all Custom Mobs from FoxyMachines.", "foxymachines.admin");
    }

    @Override
    public void execute(@Nonnull CommandSender commandSender, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player p) || strings.length != 1) {
            return;
        }

        for (LivingEntity entity : p.getWorld().getLivingEntities()) {
            CustomMob mob = CustomMob.getByEntity(entity);
            if (mob != null) {
                entity.remove();
            }
        }

        CustomBoss.removeBossBars();
    }

    @Override
    public void complete(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) { }
}