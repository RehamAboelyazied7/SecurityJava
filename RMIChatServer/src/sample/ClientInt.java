package sample;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientInt extends Remote {
    void receive(MessegeData msg) throws RemoteException;
}
