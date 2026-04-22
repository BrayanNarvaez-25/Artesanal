package com.krakedev.NegocioMejorado.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.*;

public class TestNegocioMejoradoJUnit {

    private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        ArrayList<Maquina> maquinas = new ArrayList<>();
        negocio = new NegocioMejorado(maquinas);
    }

    // =========================
    // generarCodigo
    // =========================
    @Test
    public void testGenerarCodigo() {
        String codigo = negocio.generarCodigo();
        assertNotNull(codigo);
        assertTrue(codigo.startsWith("M-"));
    }

    // =========================
    // agregarMaquina
    // =========================
    @Test
    public void testAgregarMaquinaCorrecto() {
        boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia", 0.5);
        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());
    }

    @Test
    public void testAgregarMaquinaCodigoRepetido() {
        // Forzamos un caso donde ya existe una máquina con ese código
        String codigo = "M-1";
        Maquina m = new Maquina("Test", "Test", 0.5, codigo);
        negocio.getMaquinas().add(m);

        // Simulación: usamos ese mismo código directamente
        Maquina recuperada = negocio.recuperarMaquina(codigo);
        assertNotNull(recuperada);
    }

    // =========================
    // recuperarMaquina
    // =========================
    @Test
    public void testRecuperarMaquinaExiste() {
        Maquina m = new Maquina("IPA", "Fuerte", 0.8, "M-50");
        negocio.getMaquinas().add(m);

        Maquina resultado = negocio.recuperarMaquina("M-50");
        assertNotNull(resultado);
    }

    @Test
    public void testRecuperarMaquinaNoExiste() {
        Maquina resultado = negocio.recuperarMaquina("M-999");
        assertNull(resultado);
    }

    // =========================
    // cargarMaquinas
    // =========================
    @Test
    public void testCargarMaquinas() {
        Maquina m = new Maquina("IPA", "Fuerte", 1.0, "M-10");
        negocio.getMaquinas().add(m);

        negocio.cargarMaquinas();

        assertTrue(m.getCantidadActual() > 0);
    }

    // =========================
    // registrarCliente
    // =========================
    @Test
    public void testRegistrarCliente() {
        negocio.registrarCliente("Brayan", "123");

        Cliente c = negocio.buscarClientePorCedula("123");

        assertNotNull(c);
        assertEquals("Brayan", c.getNombre());
        assertEquals(100, c.getCodigo());
    }

    // =========================
    // buscarClientePorCedula
    // =========================
    @Test
    public void testBuscarClientePorCedulaExiste() {
        negocio.registrarCliente("Brayan", "123");

        Cliente c = negocio.buscarClientePorCedula("123");
        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCedulaNoExiste() {
        Cliente c = negocio.buscarClientePorCedula("999");
        assertNull(c);
    }

    // =========================
    // buscarClientePorCodigo
    // =========================
    @Test
    public void testBuscarClientePorCodigoExiste() {
        negocio.registrarCliente("Brayan", "123");

        Cliente c = negocio.buscarClientePorCodigo(100);
        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCodigoNoExiste() {
        Cliente c = negocio.buscarClientePorCodigo(999);
        assertNull(c);
    }

    // =========================
    // consumirCerveza
    // =========================
    @Test
    public void testConsumirCervezaCorrecto() {
        Maquina m = new Maquina("IPA", "Fuerte", 1.0, "M-1");
        negocio.getMaquinas().add(m);
        negocio.cargarMaquinas();

        negocio.registrarCliente("Brayan", "123");

        negocio.consumirCerveza(100, "M-1", 100);

        Cliente c = negocio.buscarClientePorCodigo(100);
        assertTrue(c.getTotalConsumido() > 0);
    }

    @Test
    public void testConsumirCervezaMaquinaNull() {
        negocio.registrarCliente("Brayan", "123");

        negocio.consumirCerveza(100, "M-999", 100);

        Cliente c = negocio.buscarClientePorCodigo(100);
        assertEquals(0, c.getTotalConsumido());
    }

    @Test
    public void testConsumirCervezaClienteNull() {
        Maquina m = new Maquina("IPA", "Fuerte", 1.0, "M-1");
        negocio.getMaquinas().add(m);

        negocio.consumirCerveza(999, "M-1", 100);

        // No debe fallar (solo se ignora)
        assertTrue(true);
    }

    // =========================
    // registrarConsumo
    // =========================
    @Test
    public void testRegistrarConsumo() {
        negocio.registrarCliente("Brayan", "123");

        negocio.registrarConsumo(100, 50);

        Cliente c = negocio.buscarClientePorCodigo(100);
        assertEquals(50, c.getTotalConsumido());
    }

    // =========================
    // consultarValorVendido
    // =========================
    @Test
    public void testConsultarValorVendido() {
        negocio.registrarCliente("Brayan", "123");
        negocio.registrarCliente("Ana", "456");

        negocio.registrarConsumo(100, 50);
        negocio.registrarConsumo(101, 30);

        double total = negocio.consultarValorVendido();

        assertEquals(80, total);
    }
}
