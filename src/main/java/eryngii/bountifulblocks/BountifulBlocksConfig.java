package eryngii.bountifulblocks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class BountifulBlocksConfig {
	 //モード判定用変数
	static boolean is1_8Mode;
	static boolean is1_9Mode;
	 public static boolean achievement = true;
	 
	 public static int professionIdMayaMer = 1211;

	public static void preLoad(File file){
		Configuration cfg = new Configuration(file);

		try {
			System.out.println("生成");
			//それぞれの項目追加
			is1_8Mode = cfg.getBoolean("1.8Mode", "General", true, "Whether to add an element of 1.8.");
			is1_9Mode = cfg.getBoolean("1.9mode", "General", true, "Whether to add an element of 1.9.");
			cfg.load();
		}finally{
			cfg.save();
			System.out.println("セーブ");
			

		}
	}
	/*
	  public static void load(Configuration cfgfile)
	    {
		  achievement = cfgfile.get("general", "achievement", achievement).getBoolean(true);
	    }
*/
}