package helper;
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

import java.io.File;

import com.kms.katalon.core.configuration.RunConfiguration;
import java.io.FileInputStream;
import java.util.Properties;
import com.github.javafaker.Faker;
import java.util.Random;

import com.github.javafaker.Faker;
import com.kms.katalon.core.configuration.RunConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;





@SuppressWarnings("unused")
public class MessageLoader {

    Properties forgot;
    Properties register;
    Properties signin;

    public MessageLoader() {

        forgot = new Properties();
        register = new Properties();
        signin = new Properties();

        File forgotFile = new File(RunConfiguration.getProjectDir() + "/Include/config/forgotPassword.properties");
        File registerFile = new File(RunConfiguration.getProjectDir() + "/Include/config/Register.properties");
        File signinFile = new File(RunConfiguration.getProjectDir() + "/Include/config/signin.properties");

        try {
            FileInputStream f = new FileInputStream(forgotFile);
            FileInputStream r = new FileInputStream(registerFile);
            FileInputStream s = new FileInputStream(signinFile);

            forgot.load(f);
            register.load(r);
            signin.load(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public String getForgotMessage(String key) {
        return forgot.getProperty(key);
    }

    public String getRegisterMessage(String key) {
        return register.getProperty(key);
    }

    public String getSigninMessage(String key) {
        return signin.getProperty(key);
    }
}