package me.angeschossen.upgradeablespawners.api.role;

import me.bytesoft.pluginapi.api.roles.settings.SettingType;
import org.jetbrains.annotations.NotNull;

public enum ManagementSetting implements me.bytesoft.pluginapi.api.roles.settings.ManagementSetting {

    DELETE(0, false),
    EDIT(1, true);


    private final int id;
    public final boolean regionMembers;

    ManagementSetting(int id, boolean regionMembers) {
        this.regionMembers = regionMembers;
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
        return SettingType.MANAGEMENT;
    }

    @Override
    public String getTogglePermission() {
        return "uspawners.setting." + toString();
    }

    @Override
    public String getMessageKey() {
        return "noaccess.edit";
    }


    public static @NotNull ManagementSetting getById(int i) throws IllegalArgumentException {
        for (ManagementSetting managementSetting : values()) {
            if (managementSetting.getId() == i) {
                return managementSetting;
            }
        }

        throw new IllegalArgumentException("Could not find ManagementSetting with id " + i + ".");
    }
}
