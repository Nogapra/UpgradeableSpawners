package me.angeschossen.upgradeablespawners.api.role;

import me.bytesoft.pluginapi.api.roles.settings.SettingType;
import org.jetbrains.annotations.NotNull;

public enum RoleSetting implements me.bytesoft.pluginapi.api.roles.settings.RoleSetting {

    OPEN(0);

    private final int id;

    RoleSetting(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getBypassPermission() {
        return "uspawners.bypass." + toString();
    }

    @Override
    public SettingType getType() {
        return SettingType.ACTION;
    }

    @Override
    public String getTogglePermission() {
        return "uspawners.setting." + toString();
    }

    @Override
    public String getMessageKey() {
        return "noaccess.action";
    }

    public static @NotNull RoleSetting getById(int i) throws IllegalArgumentException {
        for (RoleSetting roleSetting : values()) {
            if (roleSetting.getId() == i) {
                return roleSetting;
            }
        }

        throw new IllegalArgumentException("No RoleSetting with id " + i + " found.");
    }
}
