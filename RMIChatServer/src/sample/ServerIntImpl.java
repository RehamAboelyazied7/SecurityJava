package sample;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerIntImpl extends UnicastRemoteObject implements ServerInt {
    List<ClientInt> clients = new ArrayList<ClientInt>();

    public ServerIntImpl() throws RemoteException { }
    @Override
    public void tellOthers(MessegeData msg)  {
        System.out.println("Messge received: "+ msg);
        for(ClientInt clientRef : clients)
        {
            try
            {
                clientRef.receive(msg);
            }
            catch(RemoteException ex)
            {
                System.out.println("Can’t send msg to client!");
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void register(ClientInt clientRef) throws RemoteException {
        clients.add(clientRef);
        System.out.println("Client added");
    }

    @Override
    public void unRegister(ClientInt clientRef) throws RemoteException {
        clients.remove(clientRef);
        System.out.println("Client removed");
    }
}
