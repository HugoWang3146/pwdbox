package config;

public final class PwdConfig {
    private static PwdConfig config;

    private PwdConfig PWDConfig(){
        return new PwdConfig();
    }

    public PwdConfig getPwdConfig(){
        if(config==null){
            synchronized (PwdConfig.class){
                if(config==null){
                    config=new PwdConfig();
                }
            }
        }
        return config;
    }
}
