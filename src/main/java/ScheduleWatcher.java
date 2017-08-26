import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TimerTask;

/**
 * Watch GPU mining based on nvidia-smi command line installed
 */

/**
 * @author duy.chung
 *
 */
public class ScheduleWatcher extends TimerTask  {

	private static ScheduleWatcher instance = null;	
	private String command = "nvidia-smi --format=csv,noheader --query-gpu=power.draw";
	private Configuration config;
	
	public static ScheduleWatcher getInstance() {
		if (instance == null) {
			instance = new ScheduleWatcher();
		}
		return instance;
	}
	
	public void setConfiguration(Configuration config) {
		this.config = config;
	}
	
		
	@Override
	public void run() {
		try { 
			Process process = Runtime.getRuntime().exec(config.getPath() + File.separator + command);
			InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;            
            while ((line = br.readLine()) != null) {
            	double power = Double.parseDouble(line.replace("W", "").trim());
            	if (power < config.getPowerThreshold()) {
            		System.out.println("Your GPU is running below power threshold, fail minding");
            		System.out.println("Going to restart");
            		reboot();
            	}
            }
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	private void reboot() throws IOException {
		// kick off another .bat/.sh file to reboot
		if (config.getRebootFile().endsWith(".bat")) {		
			Runtime.getRuntime().exec("cmd /c start " + config.getRebootFile());
		} else if (config.getRebootFile().endsWith(".sh")) {
			//TODO	
		}
	}
}
