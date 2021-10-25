package client;

import server.CalculateService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClientMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String UNIQUE_BIND_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(2727);
        CalculateService calculateService = (CalculateService) registry.lookup(UNIQUE_BIND_NAME);

        List<Double> values = new ArrayList<>();
        System.out.println("Дано выражение ax^2 + bx + c = 0");
        System.out.print("a = ");
        values.add(scanner.nextDouble());
        System.out.print("b = ");
        values.add(scanner.nextDouble());
        System.out.print("c = ");
        values.add(scanner.nextDouble());

        Map<String, String> calculationResult = calculateService.calculate(values);

        for(Map.Entry<String, String> entry: calculationResult.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

}
