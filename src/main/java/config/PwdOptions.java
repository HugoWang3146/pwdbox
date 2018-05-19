package config;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public final class PwdOptions {

    public static void help() {
        Options options = NestedOptions.OPTIONS;
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar pwdbox -p MAINPASSWORD -f FILE -k KEY", options);
    }

    public static Options getOptions() {
        return NestedOptions.OPTIONS;
    }

    private static class NestedOptions {
        private static final Options OPTIONS = new Options().addOption(
                Option.builder("p")
                        .argName("main password")
                        .desc("The main password")
                        .longOpt("password")
                        .required(true)
                        .hasArg()
                        .build()
        ).addOption(
                Option.builder("k")
                        .argName("target password")
                        .desc("The key of target password")
                        .longOpt("key")
                        .hasArg()
                        .build()
        ).addOption(
                Option.builder("f")
                        .argName("target file")
                        .longOpt("file")
                        .desc("The file to encrypt/decrypt")
                        .hasArg()
                        .build()
        ).addOption(
                Option.builder("e")
                        .argName("encrypt file")
                        .longOpt("encrypt")
                        .desc("Encrypt target file")
                        .build()
        ).addOption(
                Option.builder("d")
                        .argName("decrypt file")
                        .longOpt("decrypt")
                        .desc("Decrypt target file")
                        .build()
        );
    }


}
