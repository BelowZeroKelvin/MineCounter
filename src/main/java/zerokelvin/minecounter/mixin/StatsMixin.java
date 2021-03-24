package zerokelvin.minecounter.mixin;

import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Mixin;
import zerokelvin.minecounter.MineCounterStat;


@Mixin(Stats.class)
public class StatsMixin {

    static {
        MineCounterStat.registerStats();
    }
}
