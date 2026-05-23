package cheapapple.cheap_the_rock;

import cheapapple.cheap_the_rock.init.ModBlocks;
import cheapapple.cheap_the_rock.init.ModEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CheapappleTheRockClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.BOCCHI_ROCK, BlockRenderLayer.CUTOUT);
        EntityRendererRegistry.register(ModEntityTypes.BOCCHI_ROCK, FlyingItemEntityRenderer::new);
    }
}
