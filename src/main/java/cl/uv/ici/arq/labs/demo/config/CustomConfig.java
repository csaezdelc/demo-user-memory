package cl.uv.ici.arq.labs.demo.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import cl.uv.ici.arq.labs.demo.dtos.CredentialDTO;
import lombok.Data;

@ConfigurationProperties(prefix = "main.configuration")
@Component
@Data
public class CustomConfig {

	private String host;
	private int port;
	private CredentialDTO credentials = new CredentialDTO();
	private List<String> principalValues = new ArrayList<String>();
	private Map<String, String> additionalValues=new HashMap<String, String>();
	

}
