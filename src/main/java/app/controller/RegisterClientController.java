package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Receptionist;
import app.dto.ClientDTO;

public class RegisterClientController {

    ClientDTO clientDTO;

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
        company = App.getInstance().getCompany();
        company.save(cliente);
        return true;
    }

    public Client clientdtoToClient(ClientDTO clientdto){

        Client cliente = new Client(clientdto.getName(), clientdto.getTINNumber(), clientdto.getCCNumber(), clientdto.getNHSNumber(), clientdto.getBirthdate(), clientdto.getPhoneNumber(), clientdto.getEmail());

        return cliente;
    }
}
