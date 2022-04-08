package me.angeschossen.upgradeablespawners.api.events;

import me.angeschossen.upgradeablespawners.api.blockwork.Spawner;
import me.angeschossen.upgradeablespawners.api.player.SpawnerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SpawnerBreakEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final SpawnerPlayer spawnerPlayer;
    private final Spawner spawner;
    private final Reason reason;
    private boolean cancelled;

    public SpawnerBreakEvent(SpawnerPlayer spawnerPlayer, Spawner spawner, Reason reason) {
        super(!Bukkit.isPrimaryThread());

        this.spawner = spawner;
        this.spawnerPlayer = spawnerPlayer;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Spawner getSpawner() {
        return spawner;
    }

    public Reason getReason() {
        return reason;
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
        if (reason == Reason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason = SERVER");
        }

        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public enum Reason {
        ADMIN, PLAYER
    }
}
