import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Plane plane = new Plane();

        final String FILE_PATH = "data/plane.dat";

        FileInputStream inputStream;
        BufferedInputStream bufferedInput;
        ObjectInputStream objectInput;

        try {

            inputStream = new FileInputStream(FILE_PATH);
            bufferedInput = new BufferedInputStream(inputStream);
            objectInput = new ObjectInputStream(bufferedInput);

            try {

                plane = (Plane) objectInput.readObject();

                System.out.println("\n=======================================");
                System.out.println("Se ha guardado correctamente el archivo");
                System.out.println("=======================================\n");

            } catch (IOException e) {
                System.out.println("\nSe ha producido un error en la Entrada/Salida");
                System.out.println("···············································\n");
            } catch (ClassNotFoundException e) {
                System.out.println("\nSe ha producido un error al leer la información");
                System.out.println("·················································\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("\nNo hay informacion previa dentro");
            System.out.println("································\n");
        } catch (IOException e) {
            System.out.println("\nSe ha producido un error en la Entrada/Salida");
            System.out.println("···············································\n");
        }

        FileOutputStream outputFile = null;
        BufferedOutputStream bufferedOutput = null;
        ObjectOutputStream objectOutput = null;

        Scanner scanner = new Scanner(System.in);

        boolean salida = false;

        while (!salida) {

            System.out.println("\n\t==================================");
            System.out.println("\tHola soldado seleccione una opción");
            System.out.println("\t==================================\n");

            System.out.println("1 - Inicializar F18");
            System.out.println("2 - Alternar estado de los flaps ");
            System.out.println("3 - Alternar estado del tren de aterrizaje");
            System.out.println("4 - Armar sistema de eyección");
            System.out.println("5 - Eyectar piloto");
            System.out.println("Q - Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Soldado introduzca el número de litros de combustible");
                    float fuel = scanner.nextFloat();

                    System.out.println("Ahora el apodo del piloto");
                    scanner.nextLine();
                    String pilotName = scanner.nextLine();

                    System.out.println("Por último el número de escuadron");
                    String squad = scanner.nextLine();

                    plane.generateF18(fuel, pilotName, squad);

                    System.out.println("\n\t--------------------------");
                    System.out.println("\tF18 inicializado con exito");
                    System.out.println("\t--------------------------");

                    break;
                case "2":
                    plane.toggleFlaps();
                    break;
                case "3":
                    plane.toggleLandingGear();
                    break;
                case "4":
                    plane.ejectionSystem();
                    break;
                case "5":
                    plane.setSeatOccupation(true);
                    break;
                case "Q":
                    try {

                        outputFile = new FileOutputStream(FILE_PATH);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(plane);

                    } catch (FileNotFoundException e) {
                        System.out.println("\nLa ruta marcada no existe");
                        System.out.println("·························\n");
                    } catch (IOException e) {
                        System.out.println("\nSe ha producido un error en la Entrada/Salida");
                        System.out.println("···············································\n");
                    } finally {
                        try  {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) objectOutput.close();
                            if (outputFile != null) objectOutput.close();
                        } catch (IOException e) {
                            System.out.println("\nNo se ha podido cerrar el archivo");
                            System.out.println("·································\n");
                        }
                    }
                    salida = true;
                    break;
                default:
                    System.out.println("\n-------------------------------------------------");
                    System.out.println("La opción introducida no esta entre las ofrecidas");
                    System.out.println("-------------------------------------------------\n");
            }
        }
    }
}
