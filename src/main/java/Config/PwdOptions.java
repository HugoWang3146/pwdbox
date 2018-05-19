package Config;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public final class PwdOptions {
    private static PwdOptions pwdOptions;
    private final Options options;

    private PwdOptions(){
        Options options = new Options();
        options.addOption(Option.builder()
                .argName("p")
                .desc("The main password")
                .longOpt("password")
                .hasArg()
                .build()
        );

        options.addOption(Option.builder()
                .argName("k")
                .desc("The key of target password")
                .longOpt("key")
                .hasArg()
                .build()
        );

        options.addOption(Option.builder()
                .argName("c")
                .longOpt("file")
                .desc("The file to encrypt")
                .hasArg()
                .build()
        );
        this.options=options;
    }

    public static PwdOptions getInstance(){
        return NestedOptions.nestedPwdOptions;
    }

    public static void help(){
        Options options= PwdOptions.getInstance().getOptions();
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "pwdbox", options );
    }

    public Options getOptions() {
        return options;
    }

    private static class NestedOptions{
        private static PwdOptions nestedPwdOptions=new PwdOptions();
    }
}
