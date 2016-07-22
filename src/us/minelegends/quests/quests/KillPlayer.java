package us.minelegends.quests.quests;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import us.minelegends.quests.utilities.ItemStackBuilder;
import us.minelegends.quests.utilities.Quest;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/12/15 under the package us.minelegends.quests.quests
 ***************************************************************************************************/
public class KillPlayer implements Quest {
    @Override
    public String name() {
        return "A not so friendly hello...";
    }

    @Override
    public String description() {
        return "Damage 1 player";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack reward() {
        return new ItemStackBuilder(Material.STONE_SWORD).withName("§cBloody Kitchen Knife").withLore("§7That's not blood... its just... ketchup...").build();
    }
}
