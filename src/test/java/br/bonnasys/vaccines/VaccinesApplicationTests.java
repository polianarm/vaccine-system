package br.bonnasys.vaccines;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLOutput;

@ActiveProfiles("test")
@SpringBootTest
class VaccinesApplicationTests {

	@Test
	@DisplayName("Validando acesso ao banco de dados H2")
	void contextLoads() {
		System.out.println();
	}

}
