package zerokelvin.minecounter.mixin;


import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.stat.Stat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import zerokelvin.minecounter.MineCounterStat;

@Mixin(ServerStatHandler.class)
public abstract class ServerStatHandlerMixin {
    @Redirect(method = "sendStats", at = @At(value = "INVOKE", target = "Lit/unimi/dsi/fastutil/objects/Object2IntMap;put(Ljava/lang/Object;I)I"), remap = false)
    private int excludeCustomStats(Object2IntMap<Stat<?>> map, Object obj, int value, ServerPlayerEntity player) {
        if (!MineCounterStat.contains((Stat<?>) obj)) {
            return map.put((Stat<?>) obj, value);
        } else {
            return map.defaultReturnValue();
        }
    }
}