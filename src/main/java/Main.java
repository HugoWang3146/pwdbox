import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import config.PwdConfig;
import config.PwdOptions;
import service.CryptoService;
import service.PwdService;
import util.AECCrypto;
import util.IOUtil;

public class Main {
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        Options options = PwdOptions.getOptions();

        try {
            CommandLine cmd = parser.parse(options, args);
            String mainPwd = cmd.getOptionValue('p');

            PwdConfig.setMainPassword(mainPwd);
            CryptoService cryptoService = new CryptoService(new AECCrypto());
            PwdService pwdService = new PwdService(cryptoService);

            if(cmd.hasOption('h')){
                PwdOptions.help();
            }

            if (cmd.hasOption('e')) {
                String fileName = cmd.getOptionValue('f');
                cryptoService.encryptFile(fileName);
            }

            if (cmd.hasOption('d')) {
                String fileName = cmd.getOptionValue('f');
                cryptoService.decryptFile(fileName);
            }

            if (cmd.hasOption('k')) {
                String key = cmd.getOptionValue('k');
                String password = pwdService.retrievePassword(key);
                IOUtil.PRINT(key);
                IOUtil.PRINT(password);
            }

        } catch (Exception e) {
            e.printStackTrace();
            IOUtil.PRINT("Wrong main password");
            PwdOptions.help();
        }
    }


}
