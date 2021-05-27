package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Receptionist;
import app.dto.ClientDTO;

public class RegisterClientController {
    //state means when the controller is done
    //so that we can show the ui when its over
    boolean state = false;

    ClientDTO clientDTO;
    Client client;
    String designacao = "designacao";
    Receptionist receptionist;


    private Company company;

    //factory for class ClientDTO
    public ClientDTO createClientDTO(Object args[]){

        clientDTO = new ClientDTO(args[0], args[1], args[2],args[3], args[4], args[5], args[6], args[7]);

        return clientDTO;
    }


    //register ClientDTO to the object company
    public boolean registerClient(ClientDTO clientDTO){
        //we need to retrieve receptionist
        //only him can create Clients

        Client cliente = this.clientdtoToClient(clientDTO);
        company.save(cliente);
        return true;
    }

    //retrieve the receptionist responsible for registering the client
    //in this case it's the authenticated receptionist
    //doing this use case right now
    public Receptionist getReceptionist() {

        return null;
    }

    //get the client that was registered by the receptionist
    public Client getClient(){


        return null;
    }

    //add this client to the company class
    //at the same time validate if there are repetitions
    public boolean saveClient(Client client){

//        for(Client c:clients){
//
//            if(c.equals(client)){
//                return false;
//            }
//
//        }
//        clients.add(client);

        return true;
    }

    //register the client into the AuthFacade so that he can login with his credentials
    public boolean registerUser(ClientDTO clientDTO){

        return true;
    }

    //we send the login info to the client via email
    public boolean sendCredentials(String email, String text){
        //instantiate the mailAdapter and send the message
        //MailAdapter mailAdapter = new MailAdapter();
        //mailAdapter.sendMessage("")
        return true;
    }

    public Client clientdtoToClient(ClientDTO clientdto){


        Client cliente = new Client(clientdto.getName(), clientdto.getTINNumber(), clientdto.getCCNumber(), clientdto.getNHSNumber(), clientdto.getBirthdate(), clientdto.getPhoneNumber(), clientdto.getEmail(), clientdto.getPassword());

        return cliente;
    }
}
