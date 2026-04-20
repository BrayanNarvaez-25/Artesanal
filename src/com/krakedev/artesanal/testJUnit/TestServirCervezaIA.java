package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaIA {

    private static final double DELTA = 0.001;

    @Test
    public void testCaso1_ServicioExitoso_CantidadSuficiente() {
        // Caso 1: Sirve correctamente cuando hay suficiente cerveza
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 1000, "COD001");

        maquina.recargarCerveza(500);

        double valor = maquina.servirCerveza(200);

        // Se valida el cálculo del precio
        assertEquals(10.0, valor, DELTA);

        // Se valida que la cantidad disminuya correctamente
        assertEquals(300, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso2_ServicioExacto_VaciaMaquina() {
        // Caso 2: Sirve exactamente lo disponible y la máquina queda en 0
        Maquina maquina = new Maquina("Heineken", "Premium", 0.2, 1000, "COD002");

        maquina.recargarCerveza(300);

        double valor = maquina.servirCerveza(300);

        assertEquals(60.0, valor, DELTA);
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso3_NoHaySuficienteCerveza() {
        // Caso 3: No debe servir si la cantidad es insuficiente
        Maquina maquina = new Maquina("Corona", "Ligera", 0.08, 1000, "COD003");

        maquina.recargarCerveza(100);

        double valor = maquina.servirCerveza(200);

        // No cobra nada
        assertEquals(0, valor, DELTA);

        // No cambia la cantidad
        assertEquals(100, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso4_MaquinaVacia() {
        // Caso 4: Máquina sin cerveza
        Maquina maquina = new Maquina("Budweiser", "Clásica", 0.07, 1000, "COD004");

        double valor = maquina.servirCerveza(100);

        assertEquals(0, valor, DELTA);
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso5_LlenarMaquina() {
        // Caso 5: Verifica método llenarMaquina con nueva lógica (-200)
        Maquina maquina = new Maquina("Club", "Negra", 0.1, 8000, "COD005");

        maquina.llenarMaquina();

        // 8000 - 200 = 7800
        assertEquals(7800, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso6_RecargaExitosaDentroDelLimite() {
        // Caso 6: Recarga válida dentro del límite permitido
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 8000, "COD006");

        boolean resultado = maquina.recargarCerveza(3000);

        assertTrue(resultado);
        assertEquals(3000, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso7_RecargaFallidaPorExceso() {
        // Caso 7: Recarga que supera el límite (capacidadMax - 200)
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 8000, "COD007");

        maquina.recargarCerveza(7000);

        boolean resultado = maquina.recargarCerveza(1000);

        // Debe fallar
        assertFalse(resultado);

        // No debe cambiar el valor anterior
        assertEquals(7000, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso8_ConstructorSinCapacidadMax() {
        // Caso 8: Verifica constructor con capacidad por defecto (10000)
        Maquina maquina = new Maquina("Club", "Negra", 0.1, "COD008");

        maquina.llenarMaquina();

        // 10000 - 200 = 9800
        assertEquals(9800, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testCaso9_GettersYSetters() {
        // Caso 9: Validar atributos básicos
        Maquina maquina = new Maquina("Inicial", "Desc", 0.1, 1000, "COD009");

        maquina.setNombreCerveza("Nueva");
        maquina.setDescripcion("Nueva desc");
        maquina.setPrecioPorMl(0.2);

        assertEquals("Nueva", maquina.getNombreCerveza());
        assertEquals("Nueva desc", maquina.getDescripcion());
        assertEquals(0.2, maquina.getPrecioPorMl(), DELTA);
        assertEquals("COD009", maquina.getCodigo());
    }
}