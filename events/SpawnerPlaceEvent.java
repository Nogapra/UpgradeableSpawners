package me.angeschossen.upgradeablespawners.api.events;

import me.angeschossen.upgradeablespawners.api.blockwork.Spawner;
import me.angeschossen.upgradeablespawners.api.player.SpawnerPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SpawnerPlaceEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final SpawnerPlayer spawnerPlayer;
    private final Spawner spawner;
    private boolean cancelled;

    public SpawnerPlaceEvent(SpawnerPlayer spawnerPlayer, Spawner spawner) {
        this.spawner = spawner;
        this.spawnerPlayer = spawnerPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Spawner getSpawner() {
        return spawner;
    }


    @NotNull
    public SpawnerPlayer getFarmPlayer() {
        return spawnerPlayer;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
