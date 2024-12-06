import java.util.ArrayList;

public class ClientQueue {
    private ArrayList<Client> clients = new ArrayList<>();
    private ClientListener listener = new ClientListener(){
        @Override
        public void clientAdded(ClientEvent event){
            System.out.println("Client added:" + event.getName());
        }

        @Override
        public void clientPayed(ClientEvent event){
            System.out.println("Client payed:" + event.getName());
        }

        @Override
        public void clientRemoved(ClientEvent event){
            System.out.println("Client removed:" + event.getName());
        }
    };

    public ArrayList<Client> getClients(){
        return clients;
    }


//    public void addClientListener(ClientListener listener) {
//        listeners.add(listener);
//    }
    
    public void enqueue(Client client) {
        clients.add(client);
        var event = new ClientEvent(client);
        listener.clientAdded(event);
    }

    public void pay(Client client) {
        var event = new ClientEvent(client);
        listener.clientPayed(event);
    }
    
    public void dequeue(Client client) {
        clients.remove(client);
        var event = new ClientEvent(client);
        listener.clientRemoved(event);
    }
}