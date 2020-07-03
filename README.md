# No más Accidentabilidad

### *Integrantes*
- **Takeshi Kita** - [takeshidev](https://github.com/takeshidev)
- **Cristóbal Latorre** - [toballatorre](https://github.com/toballatorre)

## Tema:
Construir aplicaciones web dinámicas utilizando el entorno de desarrollo Java.

## Objetivos del proyecto
- Interpretar especificaciones de sistemas utilizando casos de uso para su posterior implementación
- Construir una aplicación web dinámica utilizando el patrón MVC con vistas JSP y controladores Servlets para el despliegue de información.
- Realizar conexión a una base de datos dinámica de acuerdo a las especificaciones entregadas

## Descpripción
### Contexto
En la última década, han aumentado los índices de accidentabilidad, especialmente en las
empresas del rubro industrial, minero y construcción. Las cifras son alarmantes, a pesar de las
leyes y normativas que obligan a las empresas a tomar todas las medidas necesarias para proteger
la vida y salud de los trabajadores. Para dar cumplimiento a la normativa y mantener ambientes
de trabajo seguros, muchas empresas se ven en la obligación de contratar asesoría profesional,
lo cual representa un costo elevado y fomenta la disminución o la no implementación de medidas
necesarias para la seguridad. Muchas de las empresas que han optado por no invertir en asesoría
preventiva, se ven expuestas a aplicación de multas de las entidades fiscalizadoras, gastos por
días perdidos en accidentabilidad, bajas en la producción, alzas en el pago de cotizaciones (al
organismo administrador del seguro de accidentes del trabajo, ley 16.744), entre otros. Además
hay que considerar posibles demandas y pagos de indemnizaciones a los trabajadores y familiares
afectados por accidentes del trabajo. Un grupo de profesionales, ha fundado una compañía de
asesorías en prevención de riesgos laborales y necesita una solución tecnológica que ayude a
administrar los procesos que se deben ejecutar en cada una de las empresas que son clientes de
la compañía. Este servicio finalmente pretende ofrecer una solución completa en prevención de
riesgos para las empresas a un costo razonable, cumpliendo estrictamente todos los procesos
necesarios para dar cumplimiento a la normativa vigente, mejorando los ambientes de trabajo,
la productividad, contribuyendo a un ahorro económico.
### Problema
La empresa no posee un sistema de información que le permita administrar toda la cantidad de
información que se genera, ni controlar las actividades y el recurso humano. Existen problemas
con la planificación de las visitas, generalmente los profesionales están en terreno por lo que no
están disponibles para informarles sus actividades futuras. No existe registro del profesional que
ha estado con mayor actividad ni se sabe dónde está cada uno. Las visitas a terreno a veces no
tienen el efecto indicado por la falta de coordinación con el cliente. Asisten trabajadores que no
tienen que ver con la charla, o bien, no se coordina la ejecución de la capacitación, lo que trae
consigo multas para la empresa. No se tiene un control de los clientes que pagan y los que no, lo
que hace que muchas actividades de los profesionales corran por cuenta de la empresa,
generando desbalances financieros. Las actividades se registran en carpetas lo que dificulta el
seguimiento de las asesorías y el resumen de resultados por empresa. Además, generalmente no
se cumplen ciertas actividades de control de implementación de soluciones y a veces no se ha
cumplido con la dirección del trabajo, lo que genera multas para los clientes, bajando la calidad
del servicio. Los profesionales que han atendido la empresa esporádicamente han variado, no
existiendo un registro de la totalidad de actividades preventivas realizadas y no se tiene certeza
de los avances.
### Solución
Es necesario desarrollar una solución tecnológica que cubra los procesos de negocio descritos y
que proponga una mejora en la gestión, el control, la seguridad, y disponibilidad de información
para la empresa y sus clientes. El sistema debe permitir la planificación de actividades y el control
de ejecución de las mismas, la gestión de clientes, la coordinación entre la empresa, los
profesionales y los clientes para la respuesta temprana ante incidentes de seguridad. Además se
requiere que el sistema genere reportes y estadísticas que ayuden a tomar de decisiones y
mejorar el rendimiento de la empresa, considerando la carga laboral, y la demanda de clientes y
las actividades que cada uno involucra para el cumplimiento de los contratos. Es imprescindible,
mantener comunicación con los profesionales en todo momento, aún en terreno, y darle la
posibilidad de realizar todas sus actividades aun no teniendo conectividad (internet), ya que
muchas empresas se encuentran en zonas donde no hay conexión de ese tipo.
## Desarrollo
### Preparación del proyecto
1. Iniciamos diseñando el diagrama de casos de uso que se proveyó en la asignación del proyecto.
![CasosDeUso](https://github.com/toballatorre/ConsultoriaAccidente/blob/master/WebContent/img/DiagramasModelos/CasosDeUso.jpg)
2. Creamos el diagrama de casos
<img src="https://github.com/toballatorre/ConsultoriaAccidente/blob/master/WebContent/img/DiagramasModelos/DiagramaCasodeUso.jpeg" width="50%">
3. Modelo de Datos
![ModeloDatos]()
4. Secuencias

  <img src="https://github.com/toballatorre/ConsultoriaAccidente/blob/master/WebContent/img/DiagramasModelos/SecuanciaAdmin.jpg" width="30%" align="left"></img>
  <p align="center">
  <img src="https://github.com/toballatorre/ConsultoriaAccidente/blob/master/WebContent/img/DiagramasModelos/SecuenciaCliente.jpg" width="30%"></img>
  </p>
  <img src="https://github.com/toballatorre/ConsultoriaAccidente/blob/master/WebContent/img/DiagramasModelos/SecuenciaProfesional.jpg" width="30%" align="right"></img>
