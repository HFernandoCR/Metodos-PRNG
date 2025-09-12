# Generación de Números Pseudoaleatorios en Java
> Este repositorio contiene la implementación de dos algoritmos diferentes para la generación de números pseudoaleatorios.
- **Institución:** Instituto Tecnológico de Oaxaca (ITO) 
- **Materia:** Simulación 
- **Profesora:** Martínez Nieto Adelina 
- **Grupo:** 5SB 
- **Fecha:** 11 de Septiembre de 2025 

# Introducción
Los números pseudoaleatorios son valores generados mediante algoritmos matemáticos que imitan el comportamiento de números verdaderamente aleatorios. Son predecibles si se conocen el algoritmo y la semilla, pero su uso es fundamental en áreas como la simulación, criptografía, videojuegos e inteligencia artificial. Existen diversos métodos de generación, como los generadores lineales congruenciales, que varían en velocidad, complejidad y calidad de secuencia.

La actividad incluye:
- Algoritmo Personalizado: Un generador propio que utiliza la hora actual del sistema combinada con fórmulas matemáticas personalizadas
- Algoritmo LCG (Linear Congruential Generator): Implementación del clásico generador congruencial lineal

## Algoritmo Personalizado (`Aleatorio.java`)
Este método genera números pseudoaleatorios dentro de un rango especifico por el usuario.

**Funcionamiento:**
1. Utiliza la hora actual del sistema (horas, minutos y segundos) combinada con una semilla fija (valor: 9) para asegurar la variación de los resultados.
2. Se basa en fórmulas matemáticas diseñadas por el equipo para procesar estos valores y generar un número.
3. Ajusta dinámicamente el rango de dígitos para asegurar que el número final siempre se encuentre dentro de los límites definidos por el usuario.

## Algoritmo LCG (`LCGSimple.java`)
Este es una implementación de uno de los algoritmos más antiguos y conocidos para la generación de secuencias pseudoaleatorias.

**Funcionamiento:**
  - Se basa en la siguiente fórmula matemática:
    $$X_{n+1} = (a \cdot X_n + c) \pmod{m}$$
  - El usuario proporciona una semilla inicial ($X\_0$) y el número de iteraciones (período).
  - El algoritmo aplica la fórmula de forma iterativa para generar el número final.
  - Parámetros utilizados:
    - `a = 1664525` (multiplicador)
    - `c = 1013904223` (incremento)
    - `m = 2³² = 4294967296` (módulo)

## ¿Cómo ejecutar el código?
### Prerrequisitos
- Java instalado el JDK de Java.

### Instrucciones de Ejecución

1. Clonar o descargar el repositorio.
2. Abrir una terminal en el directorio donde se encuentren los archivos.
3. Compilar los archivos.
   ```bash
   javac Aleatorio.java
   javac LCGSimple.java
   ```

4. Ejecutar los programas.
   ```bash
   # Algoritmo personalizado
   java Aleatorio
   
   # Algoritmo LCG
   java LCGSimple
   ```
