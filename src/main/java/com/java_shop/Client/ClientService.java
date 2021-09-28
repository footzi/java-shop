package com.java_shop.Client;

import com.java_shop.Client.DTOs.InputAddClientDTO;

public class ClientService {
    public static Client add(InputAddClientDTO inputAddClientDTO) throws Exception {
        boolean isAdded = ClientRepository.getIsAddedByPhone(inputAddClientDTO.getPhone());

        if (!isAdded) {
            Client client = new Client(0, inputAddClientDTO.getName(), inputAddClientDTO.getSurname(), inputAddClientDTO.getAddress(), inputAddClientDTO.getPhone());

            return ClientRepository.add(client);
        } else {
            throw new Exception("Данный клиент уже существует");
        }
    }
}
