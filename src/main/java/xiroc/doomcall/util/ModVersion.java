package xiroc.doomcall.util;

import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import doom.lib.LogHelper;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;

public class ModVersion {

	public static final String adress = "https://onedrive.live.com/download?cid=A96FC83CE35D80D1&resid=A96FC83CE35D80D1%21337&authkey=ANhVpVy3cRbdldM";

	public static String latest_version = Reference.version;
	public static String v_name = Reference.name;
	private static String id = "0";

	public static void checkForUpdates() {
		new Thread("UpdateChecker") {
			public void run() {
				try {
					URL url = new URL(adress);
					Scanner scanner = new Scanner(url.openStream());
					boolean running = true;
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						if (line == null) {
							running = false;
							break;
						}
						String[] args = line.split("=");
						String name = args[0];
						if (name.equals("[latest]"))
							latest_version = args[1];
						if (name.equals("[name]"))
							v_name = args[1];
						if (name.equals("[id]"))
							id = args[1];
					}
					scanner.close();
					if (isNewVersion(id)) {
						DoomCall.versionType = EnumVersionType.NORMAL;
						LogHelper.log(Level.INFO, "Version check finished: New version available! (" + v_name + " " + latest_version + ")");
					} else {
						DoomCall.versionType = EnumVersionType.LATEST;
						LogHelper.log(Level.INFO, "Version check finished: No newer version available.");
					}
				} catch (Exception e) {
					DoomCall.versionType = EnumVersionType.UNCHECKED;
					LogHelper.log(Level.ERROR, "Version Check Failed! Caused by " + e.toString());
					e.printStackTrace();
				}
			}
		}.start();
	}

	private static boolean isNewVersion(String id) {
		int i = Integer.parseInt(id);
		if (i > Reference.id)
			return true;
		return false;
	}

}
