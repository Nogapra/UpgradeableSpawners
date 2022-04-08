package me.angeschossen.upgradeablespawners.api;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface SpawnerWorld {
    @NotNull World getWorld();

    @NotNull String getName();
}
