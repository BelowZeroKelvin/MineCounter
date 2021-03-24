package zerokelvin.minecounter;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stat;
import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;
import zerokelvin.minecounter.mixin.StatsAccessor;

import java.util.Set;

public abstract class MineCounterStat {
    public static Identifier MINE_COUNTER = null;

    private static Set<String> stats = Sets.newHashSet();

    public static void registerStats() {
        addStat(MINE_COUNTER = StatsAccessor.callRegister("mine_counter", StatFormatter.DEFAULT));
    }

    public static void addStat(Identifier stat) {
        stats.add(stat.toString());
    }

    public static void onPlayerMineFinish(PlayerEntity player, Block block) {
        player.increaseStat(MINE_COUNTER, 1);
    }

    public static boolean contains(Stat<?> stat) {
        return stats.contains(stat.getValue().toString());
    }

}
