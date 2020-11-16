package qu.ta.service;

import qu.ta.model.*;
import qu.ta.model.Record;
import qu.ta.persistance.LocalStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;

public class AppService {

    private final QueryExecutor queryExecutor;
    private final File file;

    public AppService(String path) {
        queryExecutor = new QueryExecutor();
        file = new File(path);
    }

    private void addRecord(Record record) {
        LocalStorage.list.add(record);
    }

    private Service parseService(String s) {
        if (s.equals("*")) {
            return new Service();
        }
        String[] serviceString = s.split("\\.");
        Service service = null;
        if (serviceString.length == 2) {
            service = new Service(
                    Integer.parseInt(serviceString[0]),
                    Integer.parseInt(serviceString[1])
            );
        } else if (serviceString.length == 1) {
            service = new Service(Integer.parseInt(serviceString[0]));
        }
        return service;
    }

    private Question parseQuestion(String s) {
        if (s.equals("*")) {
            return new Question();
        }
        String[] serviceString = s.split("\\.");
        Question question = null;
        if (serviceString.length == 3) {
            question = new Question(
                    Integer.parseInt(serviceString[0]),
                    Integer.parseInt(serviceString[1]),
                    Integer.parseInt(serviceString[2])
            );
        } else if (serviceString.length == 2) {
            question = new Question(
                    Integer.parseInt(serviceString[0]),
                    Integer.parseInt(serviceString[1])
            );
        } else if (serviceString.length == 1) {
            question = new Question(
                    Integer.parseInt(serviceString[0])
            );
        }
        return question;
    }

    private ResponseType parseResponseType(String s) {
        if (s.equals("P")) {
            return ResponseType.FIRST_ANSWER;
        } else if (s.equals("N")) {
            return ResponseType.NEXT_ANSWER;
        } else {
            return null;
        }
    }

    private Date parseDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void executeFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int rows = Integer.parseInt(scanner.nextLine().trim());

        int i = 0;
        while (i < rows) {
            String line = scanner.nextLine();
            String[] ops = line.split(" "); // operands
            if (ops[0].equals("C")) {

                Service service = parseService(ops[1]);
                Question question = parseQuestion(ops[2]);
                ResponseType responseType = parseResponseType(ops[3]);
                Date date = parseDate(ops[4]);
                int time = Integer.parseInt(ops[5]);

                Record record = new Record(
                        service,
                        question,
                        responseType,
                        date,
                        time);
                addRecord(record);

                i++;

            } else if (ops[0].equals("D")) {

                Service service = parseService(ops[1]);
                Question question = parseQuestion(ops[2]);
                ResponseType responseType = parseResponseType(ops[3]);

                String[] fromTo = ops[4].split("-");
                Date from, to;
                if (fromTo.length == 1) {
                    from = parseDate(fromTo[0]);
                    to = new Date();
                } else {
                    from = parseDate(fromTo[0]);
                    to = parseDate(fromTo[1]);
                }

                Query query = new Query(
                        service,
                        question,
                        responseType,
                        from,
                        to
                );

                queryExecutor.runQuery(query);

                i++;

            }
        }
    }

}
