package br.com.poc.app2.coreH2;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mocker")
public class LoadTableMockController {

    private final MockerService service;

    @GetMapping
    public void loadTable() {
        service.loadTable();
    }

}
