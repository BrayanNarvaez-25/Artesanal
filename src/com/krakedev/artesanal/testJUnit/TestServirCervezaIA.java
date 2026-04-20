package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaIA {

    // Margen de error para comparar valores double
    private static final double DELTA = 0.001;

    @Test
    public void testServirCerveza_ExitoConPrimerConstructor() {
        // Se valida que la máquina sirva correctamente cuando hay suficiente cerveza
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 1000);

        maquina.recargarCerveza(500); // Se cargan 500 ml

        double valor = maquina.servirCerveza(200);

        // Se valida el valor a pagar (200 * 0.05 = 10)
        assertEquals(10.0, valor, DELTA);

        // Se valida que la cantidad actual disminuya correctamente (500 - 200 = 300)
        assertEquals(300, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCerveza_ExitoConSegundoConstructor() {
        // Se valida que funcione correctamente usando el constructor sin capacidad explícita
        Maquina maquina = new Maquina("Club", "Negra", 0.1);

        maquina.recargarCerveza(1000);

        double valor = maquina.servirCerveza(500);

        // Valor esperado: 500 * 0.1 = 50
        assertEquals(50.0, valor, DELTA);

        // Cantidad restante: 1000 - 500 = 500
        assertEquals(500, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCerveza_SinSuficienteCerveza() {
        // Se valida que no sirva nada si no hay suficiente cerveza
        Maquina maquina = new Maquina("Corona", "Ligera", 0.08, 1000);

        maquina.recargarCerveza(100); // Solo hay 100 ml

        double valor = maquina.servirCerveza(200); // Se pide más de lo disponible

        // Debe retornar 0
        assertEquals(0, valor, DELTA);

        // La cantidad actual NO debe cambiar
        assertEquals(100, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCerveza_CantidadExactaDisponible() {
        // Se valida que funcione correctamente cuando se sirve exactamente lo disponible
        Maquina maquina = new Maquina("Heineken", "Premium", 0.2, 1000);

        maquina.recargarCerveza(300);

        double valor = maquina.servirCerveza(300);

        // Valor esperado: 300 * 0.2 = 60
        assertEquals(60.0, valor, DELTA);

        // Debe quedar en 0
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCerveza_SinCervezaInicial() {
        // Se valida el comportamiento cuando la máquina está vacía
        Maquina maquina = new Maquina("Budweiser", "Clásica", 0.07, 1000);

        double valor = maquina.servirCerveza(100);

        // No debe servir nada
        assertEquals(0, valor, DELTA);

        // Sigue en 0
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }
}
