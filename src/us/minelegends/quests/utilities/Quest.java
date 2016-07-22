package us.minelegends.quests.utilities;

import org.bukkit.inventory.ItemStack;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.utilities
 ***************************************************************************************************/
public interface Quest {

    public String name();

    public String description();

    public int tier();

    public ItemStack reward();

}
