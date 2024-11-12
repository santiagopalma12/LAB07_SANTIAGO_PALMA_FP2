package Lab_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Videojuego4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            Soldado[][] tablero = new Soldado[10][10];
            ArrayList<Soldado> soldados = new ArrayList<>();
            int vidaTotalEjercito1 = 0, vidaTotalEjercito2 = 0;
            int numeroSoldados = (int) (Math.random() * 11);

            for (int i = 0; i < numeroSoldados; i++) {
                Soldado soldado;
                int vida, fila, columna;
                String ejercito;

                if (i % 2 == 0) {
                    ejercito = "Ejército 1";
                } else {
                    ejercito = "Ejército 2";
                }

                do {
                    vida = (int) (Math.random() * 6) + 1;
                    fila = (int) (Math.random() * 10);
                    columna = (int) (Math.random() * 10);
                    soldado = new Soldado("Soldado" + i, vida, fila, columna, ejercito);
                } while (verificar(tablero, soldado));
                tablero[fila][columna] = soldado;
                soldados.add(soldado);

                if (ejercito.equals("Ejército 1")) {
                    vidaTotalEjercito1 += vida;
                } else {
                    vidaTotalEjercito2 += vida;
                }
            }

            mostrar(tablero);
            soldadoMayorVida(soldados);
            mostrarDatosEjercito(soldados, vidaTotalEjercito1, vidaTotalEjercito2);
            rankingSoldadosBurbuja(soldados);
            rankingSoldadosSeleccion(soldados);
            determinarGanador(vidaTotalEjercito1, vidaTotalEjercito2);

            System.out.println("¿Desea seguir jugando? Ingrese 'si' para continuar o cualquier otra tecla para salir.");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("Saliendo, gracias por jugar.");
        scanner.close();
    }

    public static boolean verificar(Soldado[][] tablero, Soldado soldado) {
        return tablero[soldado.getFila()][soldado.getColumna()] != null;
    }

    public static void mostrar(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("_________| ");
                } else {
                    System.out.print(tablero[i][j].getNombre() + " | ");
                }
            }
            System.out.println();
        }
    }

    public static void soldadoMayorVida(ArrayList<Soldado> soldados) {
        if (soldados.isEmpty()) {
            System.out.println("No hay soldados para determinar el soldado con mayor vida.");
            return;
        }

        Soldado soldadoMayor = soldados.get(0);
        for (Soldado soldado : soldados) {
            if (soldado.getNivelVida() > soldadoMayor.getNivelVida()) {
                soldadoMayor = soldado;
            }
        }
        System.out.println("Soldado con mayor nivel de vida: " + soldadoMayor.getNombre() +
                " (Vida: " + soldadoMayor.getNivelVida() + ")");
    }

    public static void mostrarDatosEjercito(ArrayList<Soldado> soldados, int vidaTotalEjercito1,
            int vidaTotalEjercito2) {
        System.out.println("Vida total del Ejército 1: " + vidaTotalEjercito1);
        System.out.println("Vida total del Ejército 2: " + vidaTotalEjercito2);
    }

    public static void rankingSoldadosBurbuja(ArrayList<Soldado> soldados) {
        Soldado[] soldadosArray = soldados.toArray(new Soldado[0]);
        for (int i = 0; i < soldadosArray.length - 1; i++) {
            for (int j = 0; j < soldadosArray.length - i - 1; j++) {
                if (soldadosArray[j].getNivelVida() < soldadosArray[j + 1].getNivelVida()) {
                    Soldado temp = soldadosArray[j];
                    soldadosArray[j] = soldadosArray[j + 1];
                    soldadosArray[j + 1] = temp;
                }
            }
        }

        System.out.println("Ranking de poder de los soldados (Burbuja):");
        for (Soldado soldado : soldadosArray) {
            System.out.println(soldado.getNombre() + " - Vida: " + soldado.getNivelVida() + " - Ejército: "
                    + soldado.getEjercito());
        }
    }

    public static void rankingSoldadosSeleccion(ArrayList<Soldado> soldados) {
        Soldado[] soldadosArray = soldados.toArray(new Soldado[0]);

        for (int i = 0; i < soldadosArray.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldadosArray.length; j++) {
                if (soldadosArray[j].getNivelVida() > soldadosArray[maxIdx].getNivelVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldadosArray[maxIdx];
            soldadosArray[maxIdx] = soldadosArray[i];
            soldadosArray[i] = temp;
        }

        System.out.println("Ranking de poder de los soldados (Selección):");
        for (Soldado soldado : soldadosArray) {
            System.out.println(soldado.getNombre() + " - Vida: " + soldado.getNivelVida() + " - Ejército: "
                    + soldado.getEjercito());
        }
    }

    public static void determinarGanador(int vidaTotalEjercito1, int vidaTotalEjercito2) {
        if (vidaTotalEjercito1 > vidaTotalEjercito2) {
            System.out.println("¡El Ejército 1 ha ganado!");
        } else if (vidaTotalEjercito1 < vidaTotalEjercito2) {
            System.out.println("¡El Ejército 2 ha ganado!");
        } else {
            System.out.println("¡Empate entre los ejércitos!");
        }
    }
}
