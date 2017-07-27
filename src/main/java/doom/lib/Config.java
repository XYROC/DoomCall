package doom.lib;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public HashMap<String, Object> variables;

	private final String configDirectory;

	public Config(final String configDirectory) {
		this.configDirectory = configDirectory;
		this.variables = new HashMap<String, Object>();
		Configuration recipes = new Configuration(new File(configDirectory + "/DoomCall/technology/recipes.cfg"));
		recipes.load();
		variables.put("emfBurnTimeAmplifier",
				recipes.getInt("emfBurnTimeAmplifier", "emf", 1, 1, 255, "amplifies the emf burn time."));
		recipes.save();
		Configuration other = new Configuration(new File(configDirectory + "/DoomCall/technology/other.cfg"));
		other.load();
		variables.put("resourceGeneratorTime", other.getInt("resourceGeneratorTime", "other", 600, 20, 72000, "Time in ticks (20 = 1 second) Max. 1 hour (72.000 ticks)"));
		other.save();
	}

}
