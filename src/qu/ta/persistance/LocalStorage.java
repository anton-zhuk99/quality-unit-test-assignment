package qu.ta.persistance;

import java.util.ArrayList;
import java.util.List;

import qu.ta.model.Record;

public class LocalStorage {

    public static List<Record> list;

    static {
        list = new ArrayList<>();
    }

}
