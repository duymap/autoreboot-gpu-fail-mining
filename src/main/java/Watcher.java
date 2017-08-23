import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;

/**
 * 
 */

/**
 * @author duy.chung
 *
 */
public class Watcher {

	public static void main(String[] str) {
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);
			
			// nvidia-smi-path
			String path = prop.get("nvidia-smi-path").toString();
			// threshold
			double power = Double.parseDouble(prop.get("power-threshold").toString());
			String rebootFile = prop.get("reboot-file").toString();
			
			Timer time = new Timer(); 
			ScheduleWatcher sw = ScheduleWatcher.getInstance();			
			sw.setConfiguration(new Configuration(path, power, rebootFile));
			time.schedule(sw, 0, 2000); 
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
