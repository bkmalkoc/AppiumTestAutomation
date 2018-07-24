package bkm;

import bkm.locator.model.OnBoardingActivity;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class YamlConfigRunner {

    public static void main(String[] args) throws IOException {
//        if (args.length != 1) {
//            return;
//        }

        Yaml yaml = new Yaml();
        try {
            Path path = Paths.get("C:\\Users\\Burak\\workspace\\AppiumTest\\src\\bkm\\locator", "Elements.yml");
            InputStream in = Files.newInputStream(path);
            OnBoardingActivity config = yaml.loadAs(in, OnBoardingActivity.class);
            System.out.println(config.getGetStartedButton());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
