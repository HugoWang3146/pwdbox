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
                        .argName("mainPassword")
                        .desc("The main password")
                        .longOpt("password")
                        .required(true)
                        .hasArg(true)
                        .build()
        ).addOption(
                Option.builder("k")
                        .argName("targetKey")
                        .desc("The key of target password")
                        .longOpt("key")
                        .hasArg(true)
                        .build()
        ).addOption(
                Option.builder("f")
                        .argName("targetFile")
                        .desc("The file to encrypt/decrypt")
                        .longOpt("file")
                        .hasArg(true)
                        .build()
        ).addOption(
                Option.builder("e")
                        .argName("encryptFile")
                        .desc("Encrypt target file")
                        .longOpt("encrypt")
                        .hasArg(true)
                        .build()
        ).addOption(
                Option.builder("d")
                        .argName("decryptFile")
                        .desc("Decrypt target file")
                        .longOpt("decrypt")
                        .hasArg(true)
                        .build()
        ).addOption(
                Option.builder("l")
                        .longOpt("list")
                        .desc("List all account name")
                        .hasArg(false)
                        .build()
        ).addOption(
                Option.builder("h")
                        .longOpt("help")
                        .desc("Help")
                        .hasArg(false)
                        .build()
        );
    }


}
