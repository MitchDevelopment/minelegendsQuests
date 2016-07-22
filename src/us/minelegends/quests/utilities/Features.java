package us.minelegends.quests.utilities;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/6/15 under the package us.minelegends.customenchants.utilities
 ***************************************************************************************************/
public class Features {

    public static void sendTitle(Player Player, Integer FadeInTime, Integer StayTime, Integer FadeOutTime, String Title, String Subtitle)
    {
        PlayerConnection connection = ((CraftPlayer)Player).getHandle().playerConnection;

        PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, FadeInTime.intValue(), StayTime.intValue(), FadeOutTime.intValue());
        connection.sendPacket(packetPlayOutTimes);
        if (Subtitle != null)
        {
            Subtitle = Subtitle.replaceAll("%player%", Player.getDisplayName());
            Subtitle = ChatColor.translateAlternateColorCodes('&', Subtitle);
            IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Subtitle + "\"}");
            PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
            connection.sendPacket(packetPlayOutSubTitle);
        }
        if (Title != null)
        {
            Title = Title.replaceAll("%player%", Player.getDisplayName());
            Title = ChatColor.translateAlternateColorCodes('&', Title);
            IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Title + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
            connection.sendPacket(packetPlayOutTitle);
        }
    }

    public static void sendTabTitle(Player Player, String Header, String Footer)
    {
        if (Header == null)
        {
            Header = "";
        }
        Header = ChatColor.translateAlternateColorCodes('&', Header);
        if (Footer == null)
        {
            Footer = "";
        }
        Footer = ChatColor.translateAlternateColorCodes('&', Footer);

        Header = Header.replaceAll("%player%", Player.getDisplayName());
        Footer = Footer.replaceAll("%player%", Player.getDisplayName());

        PlayerConnection connection = ((CraftPlayer)Player).getHandle().playerConnection;
        IChatBaseComponent tabTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Header + "\"}");
        IChatBaseComponent tabFoot = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Footer + "\"}");
        PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabTitle);
        try
        {
            Field field = headerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(headerPacket, tabFoot);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.sendPacket(headerPacket);
        }
    }

    public static void sendActionBar(Player Player, String Message)
    {
        CraftPlayer CraftPlayer = (CraftPlayer)Player;
        IChatBaseComponent ChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + Message + "\"}");
        PacketPlayOutChat PacketPlayOutChat = new PacketPlayOutChat(ChatBaseComponent, (byte)2);
        CraftPlayer.getHandle().playerConnection.sendPacket(PacketPlayOutChat);
    }

}
