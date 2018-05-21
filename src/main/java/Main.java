import config.PwdOptions;
import org.apache.commons.cli.CommandLine;
import service.CryptoService;
import service.PwdService;
import util.AECCrypto;
import util.IOUtil;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;

public class Main {
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        Options options = PwdOptions.getOptions();

        CryptoService cryptoService = new CryptoService(new AECCrypto());
        PwdService pwdService = new PwdService(cryptoService);

        try {
            CommandLine cmd = parser.parse(options, args);
            String mainPwd = cmd.getOptionValue('p');

            if (cmd.hasOption('f')) {
                String fileName = cmd.getOptionValue('f');
                IOUtil.PRINT(fileName);

                if (cmd.hasOption('e')) {
                    cryptoService.encryptFile(fileName);
                } else if (cmd.hasOption('d')) {
                    cryptoService.decryptFile(fileName);
                }
            }

            if (cmd.hasOption('k')) {
                String key = cmd.getOptionValue('k');
                String password = pwdService.retrievePassword(key);

                IOUtil.PRINT(key);
                IOUtil.PRINT(password);
            }

        } catch (Exception e) {
            e.printStackTrace();
            IOUtil.PRINT("Unrecognized option");
            PwdOptions.help();
        }
    }


}
