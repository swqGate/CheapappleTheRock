package cheapapple.cheap_the_rock;

import cheapapple.cheap_the_rock.init.ModBlocks;
import cheapapple.cheap_the_rock.init.ModEntityTypes;
import cheapapple.cheap_the_rock.init.ModItems;
import cheapapple.cheap_the_rock.init.ModSounds;
import cheapapple.cheap_the_rock.world.feature.BocchiRocksFeature;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheapappleTheRock implements ModInitializer {
	public static final String MOD_ID = "cheap_the_rock";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Feature<DefaultFeatureConfig> BOCCHI_ROCKS_FEATURE = new BocchiRocksFeature(DefaultFeatureConfig.CODEC);
	public static final RegistryKey<PlacedFeature> BOCCHI_ROCKS_PLACED_KEY =
			RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "bocchi_rocks_placed"));

	@Override
	public void onInitialize() {
		ModBlocks.init();
		ModItems.init();
		ModEntityTypes.init();
		ModSounds.init();

		Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, "bocchi_rocks_feature"), BOCCHI_ROCKS_FEATURE);
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.PLAINS).or(BiomeSelectors.includeByKey(BiomeKeys.MEADOW)),
				GenerationStep.Feature.VEGETAL_DECORATION,
				BOCCHI_ROCKS_PLACED_KEY
		);

		LOGGER.info("*some mod shyingly loads*");
	}
}