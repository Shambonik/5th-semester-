package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateServiceImpl implements CalculateService {

    private final String x = "x";
    private final String x1 = "x1";
    private final String x2 = "x2";
    private final String err = "error";

    @Override
    public Map<String, String> calculate(List<Double> values) throws RemoteException {
        Map<String, String> resultMap = new HashMap<>();
        double a = values.get(0);
        double b = values.get(1);
        double c = values.get(2);

        double D = Math.pow(b, 2) - 4 * a * c;
        if(D < 0) {
            resultMap.put(err, "Дискриминант меньше нуля");
            return resultMap;
        }
        else if(D == 0) {
            resultMap.put(x, String.valueOf((-b / (2 * a))));
            return resultMap;
        }
        else {
            resultMap.put(x1, String.valueOf((-b - Math.sqrt(D)) / (2 * a)));
            resultMap.put(x2, String.valueOf((-b + Math.sqrt(D)) / (2 * a)));
            return resultMap;
        }
    }

}
