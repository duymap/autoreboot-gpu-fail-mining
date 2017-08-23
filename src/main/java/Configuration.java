/**
 * 
 */

/**
 * @author duy.chung
 *
 */
public class Configuration {
	
	private String path;
	private double powerThreshold;
	private String rebootFile;
	
	public Configuration(String path, double powerThreshold, String rebootFile) {
		this.path = path;
		this.powerThreshold = powerThreshold;
		this.rebootFile = rebootFile;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public double getPowerThreshold() {
		return powerThreshold;
	}
	public void setPowerThreshold(double powerThreshold) {
		this.powerThreshold = powerThreshold;
	}

	public String getRebootFile() {
		return rebootFile;
	}

	public void setRebootFile(String rebootFile) {
		this.rebootFile = rebootFile;
	}	
	
}
