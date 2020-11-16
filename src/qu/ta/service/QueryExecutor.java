package qu.ta.service;

import qu.ta.model.Query;
import qu.ta.persistance.LocalStorage;

import java.util.List;
import qu.ta.model.Record;

public class QueryExecutor {

    private final QueryService queryService;

    public QueryExecutor() {
        queryService = new QueryService();
    }

    public void runQuery(Query query) {
        System.out.println(execute(query) < 0 ? "-" : execute(query));
    }

    private double execute(Query query) {

        int result = 0;
        int n = 0;

        for (Record record:
             LocalStorage.list) {
            if (queryService.checkIfSatisfies(record, query)) {
                result += record.getTime();
                n++;
            }
        }

        return n == 0 ? -1. : result / n;
    }

}
