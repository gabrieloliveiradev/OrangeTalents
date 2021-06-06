package br.com.zup.orangetalents.orangetalents.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "veiculo", url = "https://parallelum.com.br/fipe/api/v1")
@Component
public interface VeiculoClient {

	@GetMapping("/carros/marcas/{marca}/modelos/{modelo}/anos/{ano}")
	public VeiculoClientResponse consultarVeiculo(@PathVariable("marca") String marca,
											@PathVariable("modelo") String modelo,
											@PathVariable("ano") String ano);
}
