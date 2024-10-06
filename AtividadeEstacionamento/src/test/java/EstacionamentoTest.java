import org.example.entities.Estacionamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstacionamentoTest {

    private Estacionamento estacionamento;

    @BeforeEach
    public void setup() {
        estacionamento = new Estacionamento();
    }

    @Test
    public void testCadastrarVeiculo() {
        estacionamento.cadastrarVeiculo("ABC-1234", "Carro Modelo 1");
        assertFalse(estacionamento.getVeiculos().isEmpty(), "Veículo deveria ser cadastrado com sucesso.");
    }

    @Test
    public void testEstacionamentoCheio() {
        for (int i = 0; i < 50; i++) {
            estacionamento.cadastrarVeiculo("CAR" + i, "Modelo" + i);
        }

        estacionamento.cadastrarVeiculo("EXTRA-9999", "Carro Extra");
        assertEquals(50, estacionamento.getVeiculos().size(), "Não deve cadastrar mais de 50 veículos.");
    }

    @Test
    public void testRegistrarSaidaVeiculo() {
        estacionamento.cadastrarVeiculo("XYZ-9876", "Carro Modelo 2");


        estacionamento.registrarSaida("XYZ-9876");


        assertNull(estacionamento.buscarVeiculo("XYZ-9876"), "Veículo deveria ter sido removido.");
    }

    @Test
    public void testVeiculoNaoEncontrado() {
        estacionamento.cadastrarVeiculo("TEST-1234", "Carro Teste");

        estacionamento.registrarSaida("INEXISTENTE-0000");

        assertNotNull(estacionamento.buscarVeiculo("TEST-1234"), "Veículo não deveria ser removido.");
    }

    @Test
    public void testListarVeiculosEstacionados() {
        estacionamento.cadastrarVeiculo("ABC-1111", "Modelo Teste 1");
        estacionamento.cadastrarVeiculo("DEF-2222", "Modelo Teste 2");

        assertEquals(2, estacionamento.getVeiculos().size(), "Deveria haver 2 veículos estacionados.");
    }
}
