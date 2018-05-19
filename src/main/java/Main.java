import Config.PwdOptions;
import org.apache.commons.cli.*;
import util.IOUtil;

public class Main {
    public static void main(String[] args){

        CommandLineParser parser = new DefaultParser();
        PwdOptions options=PwdOptions.getInstance();

        try{
            CommandLine cmd = parser.parse(options.getOptions(), args);

            String mainPwd=cmd.getOptionValue('p');
            IOUtil.PRINT(mainPwd);

            if(cmd.hasOption('f')){
                String filePath=cmd.getOptionValue('f');
                IOUtil.PRINT(filePath);
            }

            if(cmd.hasOption('k')){
                String key=cmd.getOptionValue('k');
                IOUtil.PRINT(key);
            }

        }catch (ParseException e){
            e.printStackTrace();
            PwdOptions.help();
        }
    }


}
