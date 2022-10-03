package edu.step.service;

import edu.step.dto.ClientDto;
import edu.step.service.basic.BaseService;

public interface ClientService extends BaseService<ClientDto> {

        Long getAmountClient();

}
