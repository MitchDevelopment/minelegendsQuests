package us.minelegends.quests.quests;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import us.minelegends.quests.utilities.ItemStackBuilder;
import us.minelegends.quests.utilities.Quest;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.quests
 ***************************************************************************************************/
public class CollectApples implements Quest {
    @Override
    public String name() {
        return "2fruity4me";
    }

    @Override
    public String description() {
        return "Collect 5 apples.";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack reward(){
        return new ItemStackBuilder(Material.GOLDEN_APPLE).withAmount(3).build();
    }
}
