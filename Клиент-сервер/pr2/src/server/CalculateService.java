package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface CalculateService extends Remote {
    Map<String, String> calculate(List<Double> values) throws RemoteException;
}
