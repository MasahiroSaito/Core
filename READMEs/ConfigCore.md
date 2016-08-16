## 使い方①

```java
public class Config {
    
    public Config(File configFile) {
        super(configFile);
    }
    
    @Override
	protected void setConfigs() {
		add("DEBUG", false);
	}
	
	public static boolean isDebug() {
		return (boolean) config.get("DEBUG");
	}
}
```

## 使い方② (static)

```java
public class Config extends ConfigCore {
	private static Config config;

	public Config(File configFile) {
		super(configFile);
	}

	@Override
	protected void setConfigs() {
		add("DEBUG", false);
	}

	public static void load(File configFile) {
		config = new Config(configFile);
	}
	
	public static boolean isDebug() {
		return (boolean) config.get("DEBUG");
	}
}
```