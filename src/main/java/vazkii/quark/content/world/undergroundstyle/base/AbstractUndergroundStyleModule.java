package vazkii.quark.content.world.undergroundstyle.base;

import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import vazkii.quark.base.module.QuarkModule;
import vazkii.quark.base.module.config.Config;
import vazkii.quark.base.world.WorldGenHandler;
import vazkii.quark.base.world.WorldGenWeights;

public abstract class AbstractUndergroundStyleModule extends QuarkModule {

	@Config
	public UndergroundStyleConfig generationSettings;

	@Override
	public void construct() {
		generationSettings = getStyleConfig();
	}

	@Override
	public void setup() {
		WorldGenHandler.addGenerator(this, new UndergroundStyleGenerator(generationSettings, getStyleName()), Decoration.UNDERGROUND_DECORATION, WorldGenWeights.UNDERGROUND_BIOMES);
	}
	
	protected abstract String getStyleName();

	protected abstract UndergroundStyleConfig getStyleConfig();

}
