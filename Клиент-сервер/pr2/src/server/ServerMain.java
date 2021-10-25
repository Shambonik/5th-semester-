package server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    private static final String UNIQUE_BIND_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        CalculateService calculateService = new CalculateServiceImpl();

        Registry registry = LocateRegistry.createRegistry(2727);

        Remote stub = UnicastRemoteObject.exportObject(calculateService, 0);
        registry.bind(UNIQUE_BIND_NAME, stub);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
