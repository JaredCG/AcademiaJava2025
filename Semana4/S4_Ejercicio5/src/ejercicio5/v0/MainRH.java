package ejercicio5.v0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainRH {
	public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
            new Empleado("Carlos", "IT", 4000),
            new Empleado("Ana", "Ventas", 3500),
            new Empleado("Luis", "IT", 5000),
            new Empleado("María", "Ventas", 2800),
            new Empleado("Pedro", "IT", 3200),
            new Empleado("Laura", "Recursos Humanos", 4500)
        );

        //Filtrar empleados con salario > 3000
        List<Empleado> empleadosBienPagados = empleados.stream()
            .filter(e -> e.getSal() > 3500)
            .collect(Collectors.toList());

        System.out.println("Empleados con salario mayor a 3500:");
        empleadosBienPagados.forEach(System.out::println);
        System.out.println();

        //Agrupar empleados por departamento
        Map<String, List<Empleado>> empleadosPorDepartamento = empleados.stream()
            .collect(Collectors.groupingBy(Empleado::getDept));

        System.out.println("Empleados por departamento:");
        empleadosPorDepartamento.forEach((departamento, lista) -> {
            System.out.println(departamento + ": " + lista);
        });
        System.out.println();

        //Obtener el salario promedio por departamento
        Map<String, Double> salarioPromedioPorDepto = empleados.stream()
            .collect(Collectors.groupingBy(Empleado::getDept,
                    Collectors.averagingDouble(Empleado::getSal)));

        System.out.println("Salario promedio por departamento:");
        salarioPromedioPorDepto.forEach((departamento, promedio) -> 
            System.out.println(departamento + ": $" + promedio));
        System.out.println();

        //Obtener el empleado con el salario más alto
        Optional<Empleado> mejorPagado = empleados.stream()
            .max(Comparator.comparingDouble(Empleado::getSal));

        System.out.println("Empleado con el salario más alto:");
        mejorPagado.ifPresent(System.out::println);
        System.out.println();

        //Sumar todos los salarios usando reduce()
        double sumaTotalSalarios = empleados.stream()
            .map(Empleado::getSal)
            .reduce(0.0, Double::sum);

        System.out.println("Suma total de salarios: $" + sumaTotalSalarios);
    }
}
