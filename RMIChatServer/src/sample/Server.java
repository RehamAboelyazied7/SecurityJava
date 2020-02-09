package sample;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public Server() {
        try {
            ServerIntImpl obj = new ServerIntImpl();
            Registry reg = LocateRegistry.createRegistry(1234);
            reg.rebind("Chat", obj);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        new Server();
    }

}
