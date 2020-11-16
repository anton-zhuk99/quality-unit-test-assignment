package qu.ta;

import qu.ta.model.Question;
import qu.ta.model.ResponseType;
import qu.ta.model.Service;
import qu.ta.service.AppService;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        AppService appService = new AppService(
                "C:\\Users\\Anton\\Documents\\TA_QualityUnit\\test_input1.txt"
        );
        try {
            appService.executeFile();
        } catch (FileNotFoundException e) {
            System.out.println("FAILED! File not found.");
            e.printStackTrace();
        }
    }
}
