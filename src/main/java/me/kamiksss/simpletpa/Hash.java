package me.kamiksss.simpletpa;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Hash {

    private static HashMap<Player, Player> map = new HashMap<Player,Player>();

    public static void put(Player answer, Player ask) {
        map.put(answer, ask);
        System.out.println(map);
    }

    public static Object remove(Player answer){
        return map.remove(answer);
    }

    public static Player get(Player answer){
        return map.get(answer);
    }

    public static boolean containsKey(Player answer){
        return map.containsKey(answer);
    }
    public static boolean containsValue(Player ask){
        return map.containsValue(ask);
    }

}
