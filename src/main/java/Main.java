
import config.PwdOptions;

import org.apache.commons.cli.*;

import service.CryptoService;
import util.AECCrypto;
import util.IOUtil;

public class Main {
    public static void main(String[] args) {

        System.out.print(System.getProperty("user.dir"));

        CommandLineParser parser = new DefaultParser();
        Options options = PwdOptions.getOptions();

        CryptoService cs = new CryptoService(new AECCrypto());

        try {
            CommandLine cmd = parser.parse(options, args);

            String mainPwd = cmd.getOptionValue('p');
            IOUtil.PRINT(mainPwd);

            if (cmd.hasOption('f')) {

                String fileName = cmd.getOptionValue('f');
                IOUtil.PRINT(fileName);


                if (cmd.hasOption('e')) {
                    cs.encryptFile(fileName);
                } else if (cmd.hasOption('d')) {
                    cs.decryptFile(fileName);
                }
            }

            if (cmd.hasOption('k')) {
                String key = cmd.getOptionValue('k');
                IOUtil.PRINT(key);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            IOUtil.PRINT("Unrecognized option");
            PwdOptions.help();
        }
    }


}
