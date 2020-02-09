package sample;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInt extends Remote {
    void tellOthers(MessegeData msg) throws RemoteException;

    void register(ClientInt clientRef) throws RemoteException;

    void unRegister(ClientInt clientRef) throws RemoteException;
}
