package br.edu.ifpb.service.Cliente;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.ClienteInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SearchCliente {

    @EJB
    private ClienteInterface clienteInterface;

    public Cliente buscarCPF(String cpf){
        return clienteInterface.searchClientCpf(cpf);
    }

}
