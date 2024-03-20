/*
 Ernesto Contreras
28245373

Albani barragán
28268078

Luis Carrillo
27539960

Gregori Yepez 
28047103

Yaslin Vreugdenhil.
29561929
 */

CREATE TABLE "Universidad" (
  "id_universidad" varchar(25) NOT NULL,
  "nombre_universidad" varchar(100) NOT NULL,
  "direccion" varchar(150),
  PRIMARY KEY ("id_universidad")
);

INSERT INTO public."Universidad" (id_universidad,nombre_universidad,direccion) VALUES
    ('UNI-001','UCLA','Carrera 19 con Calle 8. Edificio Rectorado, Barquisimeto Estado Lara. Venezuela');

CREATE TABLE "Decanatos" (
  "id_decanato" varchar(25) NOT NULL,
  "id_universidad" varchar(25) NOT NULL,
  "nombre_decanato" varchar(100) NOT NULL,
  "direccion" varchar(150),
  "estado" bool,
  PRIMARY KEY ("id_decanato"),
  CONSTRAINT "FK_Decanatos.id_universidad"
    FOREIGN KEY ("id_universidad")
      REFERENCES "Universidad"("id_universidad")
);

INSERT INTO public."Decanatos" (id_decanato,id_universidad,nombre_decanato,direccion,estado) VALUES
    ('DEC-001','UNI-001','Decanato de Ciencias y Tecnologia','Avenida las Industrias, Barquisimeto 3001, Lara',true);

CREATE TABLE "Carreras" (
  "id_carrera" varchar(25) NOT NULL,
  "id_decanato" varchar(25) NOT NULL,
  "nombre_carrera" varchar(100) NOT NULL,
  "modalidad" varchar(150),
  "estado" bool,
  "duracion" integer,
  PRIMARY KEY ("id_carrera"),
  CONSTRAINT "FK_Carreras.id_decanato"
    FOREIGN KEY ("id_decanato")
      REFERENCES "Decanatos"("id_decanato")
);

INSERT INTO public."Carreras" (id_carrera,id_decanato,nombre_carrera,modalidad,estado,duracion) VALUES
    ('CAR-001','DEC-001','Ingenieria en Informatica','Presencial',true,10),
    ('CAR-002','DEC-001','Ingenieria en Produccion','Presencial',true,8),
    ('CAR-003','DEC-001','Licenciatura en Matematicas','Presencial',true,8);

CREATE TABLE "Asignaturas" (
  "id_asignatura" varchar(25) NOT NULL,
  "nombre_asignatura" varchar(100) NOT NULL,
  "carga_academica" integer,
  "retirada" bool,
  PRIMARY KEY ("id_asignatura")
);

INSERT INTO public."Asignaturas" (id_asignatura,nombre_asignatura,carga_academica,retirada) VALUES
    ('ASI-001', 'Matematica I', 5, NULL),
    ('ASI-002', 'Estructuras Discretas I', 5, NULL),
    ('ASI-003', 'Sistemas I', 4,NULL),
    ('ASI-004', 'Teoría de la Administración', 3, NULL),
    ('ASI-005', 'Problemática del Desarrollo', 2, NULL),
    ('ASI-006', 'Aprendizaje Basado en Proceso', 3, NULL),
    ('ASI-007', 'Matematica II', 5, NULL),
    ('ASI-008', 'Técnicas de Investigación ', 3, NULL),
    ('ASI-009', 'Programación I', 4,NULL),
    ('ASI-010', 'Programación II', 5,NULL),
    ('ASI-011', 'Bases de Datos', 5,NULL),
    ('ASI-012', 'Algoritmos y Estructuras de Datos', 5,NULL),
    ('ASI-013', 'Estadística I', 4, NULL),
    ('ASI-014', 'Ingenieria Economica', 5,NULL),
    ('ASI-015', 'Inglés I', 3,NULL),
    ('ASI-016', 'Inglés II', 4,NULL);
	
CREATE TABLE "Asignaturas_carrera" (
  "id_asignatura_carrera" varchar(25) NOT NULL,
  "id_carrera" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  PRIMARY KEY ("id_asignatura_carrera"),
  CONSTRAINT "FK_Asignaturas_carrera.id_carrera"
    FOREIGN KEY ("id_carrera")
      REFERENCES "Carreras"("id_carrera"),
  CONSTRAINT "FK_Asignaturas_carrera.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura")
);

INSERT INTO public."Asignaturas_carrera" (id_asignatura_carrera,id_carrera,id_asignatura) VALUES
    ('ACA-001', 'CAR-001', 'ASI-001'),
    ('ACA-002', 'CAR-001', 'ASI-002'),
    ('ACA-003', 'CAR-001', 'ASI-003'),
    ('ACA-004', 'CAR-001', 'ASI-007'),
    ('ACA-005', 'CAR-001', 'ASI-013'),
    ('ACA-006', 'CAR-001', 'ASI-014'),
    ('ACA-007', 'CAR-002', 'ASI-004'),
    ('ACA-008', 'CAR-002', 'ASI-005'),
    ('ACA-009', 'CAR-002', 'ASI-006'),
    ('ACA-010', 'CAR-002', 'ASI-008'),
    ('ACA-011', 'CAR-002', 'ASI-015'),
    ('ACA-012', 'CAR-002', 'ASI-016'),
    ('ACA-013', 'CAR-003', 'ASI-009'),
    ('ACA-014', 'CAR-003', 'ASI-010'),
    ('ACA-015', 'CAR-003', 'ASI-011'),
    ('ACA-016', 'CAR-003', 'ASI-012');

CREATE TABLE "Profesor" (
  "id_profesor" varchar(25) NOT NULL,
  "nombre_completo" varchar(100) NOT NULL,
  "edad" integer,
  "correo" varchar(50) NOT NULL,
  "sexo" varchar(10) NOT NULL,
  "especialidad" varchar(50),
  "estado" bool,
  PRIMARY KEY ("id_profesor")
);

INSERT INTO public."Profesor"(id_profesor, nombre_completo, edad, correo, sexo, especialidad) VALUES 
    ('PRO-001', 'Dilcia Amaya', 50, 'damaya@ucla.edu.com', 'Femenino', 'Licenciatura en Matematicas'),
    ('PRO-002', 'Lorena Alvarez', 36, 'alvarezlore@ucla.edu.com', 'Femenino', 'Ingenieria en informatica'),
    ('PRO-003', 'Juan Steffano', 25, 'alvarezlore@ucla.edu.com', 'Masculino', 'Ingenieria en informatica'),
    ('PRO-004', 'Pedro Pérez', 42, 'pperez@ucla.edu', 'Masculino', 'Ingeniero en Sistemas'),
    ('PRO-005', 'Ana Castillo', 38, 'acastillo@ucla.edu', 'Femenino', 'Licenciada en Educación'),
    ('PRO-006', 'Juan Garcia', 55, 'jgarcia@ucla.edu', 'Masculino', 'Magíster en Administración'),
    ('PRO-007', 'Maria Rodriguez', 29, 'mrodriguez@ucla.edu', 'Femenino', 'Ingeniera en Informática'),
    ('PRO-008', 'Carlos Moreno', 45, 'cmoreno@ucla.edu', 'Masculino', 'Doctor en Ciencias de la Computación'),
    ('PRO-009', 'Diana Silva', 32, 'dsilva@ucla.edu', 'Femenino', 'Licenciada en Matemáticas'),
    ('PRO-010', 'Francisco López', 50, 'flopez@ucla.edu', 'Masculino', 'Magíster en Ingeniería Eléctrica');

CREATE TABLE "Estudiantes" (
  "id_estudiante" varchar(25) NOT NULL,
  "id_carrera" varchar(25) NOT NULL,
  "nombre_completo" varchar(100) NOT NULL,
  "edad" integer,
  "correo" varchar(100) NOT NULL,
  "direccion" varchar(100) NOT NULL,
  "sexo" varchar(10) NOT NULL,
  "estado" bool,
  PRIMARY KEY ("id_estudiante"),
  CONSTRAINT "FK_Estudiantes.id_carrera"
    FOREIGN KEY ("id_carrera")
      REFERENCES "Carreras"("id_carrera")
);

INSERT INTO public."Estudiantes" (id_estudiante,id_carrera,nombre_completo,edad,correo,direccion,sexo,estado) VALUES
    ('28047103','CAR-001','Gregori José Yepez Arteaga',22,'gregjose2513@gmail.com','Av.Bolivar Sector Camino Nuevo','Masculino',true),
    ('28268078','CAR-001','Albani Gabriela Barragan Cuenca',22,'1001.28268078.ucla@gmail.com','Cabudare, Barquisimeto','Femenino',true),
    ('29561929','CAR-001','Yaslin Anabel Vreugdenhil Vasquez',22,'1001.29561929.ucla@gmail.com','Yaritagua','Femenino',true),
    ('28245373','CAR-001','Ernesto Jose Contreras Schiffino',23,'1001.28245373.ucla@gmail.com','Av.Bolivar Sector Camino Nuevo','Masculino',true),
    ('27539960','CAR-002','Luis Daniel Carrillo Salas',25,'1001.27539960.ucla@gmail.com','Av 20, Barquisimeto','Masculino',true),
    ('30276543','CAR-001','Valeria Valentina Rodriguez',21,'vvaler@ucla.edu','Urb. La Joya, Barquisimeto','Femenino',true),
    ('30365432','CAR-001','Oscar David Mendez',22,'omendez@ucla.edu','Urb. La California, Cabudare','Masculino',true),
    ('30454321','CAR-002','Andrea Carolina Garcia',23,'agarcia@ucla.edu','Urb. Santa Monica, Barquisimeto','Femenino',true),
    ('30543210','CAR-002','Miguel Angel Torres',24,'mtorres@ucla.edu','Urb. La Concordia, Cabudare','Masculino',true),
    ('30632109','CAR-003','Mariana Alexandra Silva',22,'masilva@ucla.edu','Urb. Santa Elena, Barquisimeto','Femenino',true),
    ('30721098','CAR-003','Kevin Daniel Pérez',23,'kper@ucla.edu','Urb. La Pradera, Cabudare','Masculino',true),
    ('30810987','CAR-001','Ana Sofia Lopez',21,'aslopez@ucla.edu','Urb. La Granja, Barquisimeto','Femenino',true),
    ('30000007', 'CAR-001', 'Juan Perez', 20, 'juan.perez@ucla.com', 'Calle Principal 123','Masculino',true),
    ('40810988', 'CAR-001', 'Maria Rodriguez', 22, 'maria.rodriguez@ucla.com', 'Avenida Libertador 456','Femenino',true),
    ('50810989', 'CAR-001', 'Luis Gonzalez', 21, 'luis.gonzalez@ucla.com', 'Carrera 7 89','Masculino',true),
    ('60810990', 'CAR-001', 'Ana Martinez', 20, 'ana.martinez@ucla.com', 'Calle 10 11-12','Femenino',true),
    ('70810991', 'CAR-001', 'Carlos Sanchez', 23, 'carlos.sanchez@ucla.com', 'Avenida Bolivar 567','Masculino',true),
    ('80810992', 'CAR-001', 'Laura Ramirez', 22, 'laura.ramirez@ucla.com', 'Urbanizacion Los Mangos','Femenino',true),
    ('90810993', 'CAR-001', 'Diego Hernandez', 21, 'diego.hernandez@ucla.com', 'Calle 20 21-22','Masculino',true),
    ('10081094', 'CAR-001', 'Sofia Gomez', 20, 'sofia.gomez@ucla.com', 'Avenida Sucre 789','Femenino',true),
    ('11081095', 'CAR-001', 'Manuel Alvarez', 22, 'manuel.alvarez@ucla.com', 'Carrera 15 16-17','Masculino',true),
    ('12081096', 'CAR-001', 'Elena Torres', 21, 'elena.torres@ucla.com', 'Calle 30 31-32','Femenino',true),
    ('13081097', 'CAR-001', 'Jorge Castro', 20, 'jorge.castro@ucla.com', 'Avenida Miranda 8910','Masculino',true),
    ('14081098', 'CAR-001', 'Ana Garcia', 23, 'ana.garcia@ucla.com', 'Calle 40 41-42','Femenino',true),
    ('15081099', 'CAR-001', 'Pedro Chavez', 22, 'pedro.chavez@ucla.com', 'Carrera 50 51-52','Masculino',true),
    ('16081100', 'CAR-001', 'Luisa Rivas', 21, 'luisa.rivas@ucla.com', 'Avenida Bolivar 1112','Femenino',true),
    ('17081101', 'CAR-001', 'Miguel Diaz', 20, 'miguel.diaz@ucla.com', 'Calle 60 61-62','Masculino',true),
    ('18081102', 'CAR-001', 'Paula Nuñez', 22, 'paula.nunez@ucla.com', 'Urbanizacion Las Mercedes','Femenino',true),
    ('19081103', 'CAR-001', 'Roberto Herrera', 21, 'roberto.herrera@ucla.com', 'Calle 70 71-72','Masculino',true),
    ('20081104', 'CAR-001', 'Diana Jimenez', 20, 'diana.jimenez@ucla.com', 'Avenida Bolivar 1314','Femenino',true),
    ('21081105', 'CAR-001', 'Gabriel Torres', 23, 'gabriel.torres@ucla.com', 'Calle 80 81-82','Masculino',true),
    ('22081106', 'CAR-001', 'Valentina Suarez', 22, 'valentina.suarez@ucla.com', 'Carrera 90 91-92','Femenino',true),
    ('30820987', 'CAR-002', 'Marcela Sánchez', 19, 'marcela.sanchez@ucla.com', 'Calle San Martín 123','Femenino',true),
    ('40820988', 'CAR-002', 'Luis Hernandez', 20, 'luis.hernandez@ucla.com', 'Avenida Libertador 456','Masculino',true),
    ('50820989', 'CAR-002', 'Gabriela Ramirez', 21, 'gabriela.ramirez@ucla.com', 'Calle 23 de Enero 789','Femenino',true),
    ('60820990', 'CAR-002', 'Ricardo Fernandez', 22, 'ricardo.fernandez@ucla.com', 'Calle 10 de Octubre 11-12','Masculino',true),
    ('70820991', 'CAR-002', 'Fernanda Torres', 23, 'fernanda.torres@ucla.com', 'Avenida Bolivar 567','Femenino',true),
    ('80820992', 'CAR-002', 'Javier Perez', 20, 'javier.perez@ucla.com', 'Urbanizacion Los Mangos','Masculino',true),
    ('90820993', 'CAR-002', 'Carolina Gomez', 21, 'carolina.gomez@ucla.com', 'Calle 24 de Julio 21-22','Femenino',true),
    ('100820994', 'CAR-002', 'Andres Nuñez', 22, 'andres.nuñez@ucla.com', 'Avenida Sucre 789','Masculino',true),
    ('110820995', 'CAR-002', 'Daniela Castro', 20, 'daniela.castro@ucla.com', 'Carrera 18 de Octubre 16-17','Femenino',true),
    ('120820996', 'CAR-002', 'Gustavo Rivas', 21, 'gustavo.rivas@ucla.com', 'Calle 30 de Abril 31-32','Masculino',true),
    ('130820997', 'CAR-002', 'Camila Garcia', 19, 'camila.garcia@ucla.com', 'Avenida Miranda 8910','Femenino',true),
    ('140820998', 'CAR-002', 'Roberto Chavez', 20, 'roberto.chavez@ucla.com', 'Calle 40 de Mayo 41-42','Masculino',true),
    ('150820999', 'CAR-002', 'Patricia Lopez', 21, 'patricia.lopez@ucla.com', 'Carrera 50 de Junio 51-52','Femenino',true),
    ('160821000', 'CAR-002', 'Esteban Hernandez', 22, 'esteban.hernandez@ucla.com', 'Avenida Bolivar 1112','Masculino',true),
    ('170821001', 'CAR-002', 'Laura Torres', 23, 'laura.torres@ucla.com', 'Calle 60 de Julio 61-62','Femenino',true),
    ('180821002', 'CAR-002', 'Francisco Diaz', 20, 'francisco.diaz@ucla.com', 'Urbanizacion Las Mercedes','Masculino',true),
    ('190821003', 'CAR-002', 'Valeria Jimenez', 21, 'valeria.jimenez@ucla.com', 'Calle 70 de Agosto 71-72','Femenino',true),
    ('200821004', 'CAR-002', 'Alberto Suarez', 22, 'alberto.suarez@ucla.com', 'Avenida Bolivar 1314','Masculino',true),
    ('210821005', 'CAR-002', 'Erika Perez', 19, 'erika.perez@ucla.com', 'Calle 80 de Septiembre 81-82','Femenino',true),
    ('220821006', 'CAR-002', 'Juanita Gomez', 20, 'juanita.gomez@ucla.com', 'Carrera 90 de Diciembre 91-92','Femenino',true),
    ('40830987', 'CAR-003', 'Andrés López', 22, 'andres.lopez@ucla.com', 'Calle 25 de Mayo 123','Masculino',true),
    ('50830988', 'CAR-003', 'Isabella Rodriguez', 20, 'isabella.rodriguez@ucla.com', 'Avenida Libertador 789','Femenino',true),
    ('60830989', 'CAR-003', 'Martín García', 21, 'martin.garcia@ucla.com', 'Calle Los Pinos 456','Masculino',true),
    ('70830990', 'CAR-003', 'Valentina Martínez', 19, 'valentina.martinez@ucla.com', 'Carrera 10 de Octubre 11-12','Femenino',true),
    ('80830991', 'CAR-003', 'Sebastián Sánchez', 23, 'sebastian.sanchez@ucla.com', 'Avenida Bolivar 567','Masculino',true),
    ('90830992', 'CAR-003', 'Lucía Pérez', 20, 'lucia.perez@ucla.com', 'Urbanización Los Mangos','Femenino',true),
    ('100830993', 'CAR-003', 'Mateo González', 21, 'mateo.gonzalez@ucla.com', 'Calle 30 de Abril 21-22','Masculino',true),
    ('110830994', 'CAR-003', 'Camila Suárez', 22, 'camila.suarez@ucla.com', 'Avenida Sucre 789','Femenino',true),
    ('120830995', 'CAR-003', 'Juan Torres', 20, 'juan.torres@ucla.com', 'Carrera 15 de Septiembre 16-17','Masculino',true),
    ('130830996', 'CAR-003', 'Valeria Díaz', 21, 'valeria.diaz@ucla.com', 'Calle 40 de Julio 31-32','Femenino',true),
    ('140830997', 'CAR-003', 'Diego Ramírez', 19, 'diego.ramirez@ucla.com', 'Avenida Miranda 8910','Masculino',true),
    ('150830998', 'CAR-003', 'Mariana Gómez', 20, 'mariana.gomez@ucla.com', 'Calle Los Robles 41-42','Femenino',true),
    ('160830999', 'CAR-003', 'Alejandro Pérez', 22, 'alejandro.perez@ucla.com', 'Avenida Bolivar 1112','Masculino',true),
    ('170831000', 'CAR-003', 'Ana María Fernández', 21, 'ana.fernandez@ucla.com', 'Calle Los Almendros 61-62','Femenino',true),
    ('180831001', 'CAR-003', 'Gabriel Jiménez', 23, 'gabriel.jimenez@ucla.com', 'Urbanización Las Mercedes','Masculino',true),
    ('190831002', 'CAR-003', 'Valentina López', 20, 'valentina.lopez@ucla.com', 'Carrera 20 de Noviembre 71-72','Femenino',true),
    ('200831003', 'CAR-003', 'Lucas Martínez', 21, 'lucas.martinez@ucla.com', 'Avenida Bolivar 1314','Masculino',true),
    ('210831004', 'CAR-003', 'María José Rodríguez', 19, 'maria.rodriguez@ucla.com', 'Calle Los Cerezos 81-82','Femenino',true),
    ('220831005', 'CAR-003', 'Joaquín García', 20, 'joaquin.garcia@ucla.com', 'Carrera 30 de Diciembre 91-92','Masculino',true),
    ('230831006', 'CAR-003', 'Valeria Sánchez', 22, 'valeria.sanchez@ucla.com', 'Avenida Los Laureles 1314','Femenino',true);

CREATE TABLE "Secciones" (
  "id_seccion" varchar(25) NOT NULL,
  "numero_seccion" integer,
  "limite_estudiantes" integer,
  PRIMARY KEY ("id_seccion")
);

INSERT INTO public."Secciones" (id_seccion,numero_seccion,limite_estudiantes) VALUES
    ('SEC-001',1,32),
    ('SEC-002',2,32),
    ('SEC-003',1,32),
    ('SEC-004',2,32),
    ('SEC-005',1,32),
    ('SEC-006',2,32);

CREATE TABLE "Profesor_asignatura_seccion" (
  "id_profesor_asignatura" varchar(25) NOT NULL,
  "id_profesor" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "id_seccion" varchar(25) NOT NULL,
  PRIMARY KEY ("id_profesor_asignatura"),
  CONSTRAINT "FK_Profesor_asignatura_seccion.id_profesor"
    FOREIGN KEY ("id_profesor")
      REFERENCES "Profesor"("id_profesor"),
  CONSTRAINT "FK_Profesor_asignatura_seccion.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura"),
  CONSTRAINT "FK_Profesor_asignatura_seccion.id_seccion"
    FOREIGN KEY ("id_seccion")
      REFERENCES "Secciones"("id_seccion")
);

INSERT INTO public."Profesor_asignatura_seccion" (id_profesor_asignatura, id_profesor, id_asignatura, id_seccion) VALUES
    ('PAS-001', 'PRO-001', 'ASI-001', 'SEC-001'),
    ('PAS-002', 'PRO-001', 'ASI-001', 'SEC-002'),
    ('PAS-003', 'PRO-002', 'ASI-002', 'SEC-003'),
    ('PAS-004', 'PRO-002', 'ASI-002', 'SEC-004'),
    ('PAS-005', 'PRO-003', 'ASI-003', 'SEC-005'),
    ('PAS-006', 'PRO-003', 'ASI-003', 'SEC-006'),

    ('PAS-007', 'PRO-004', 'ASI-004', 'SEC-001'),
    ('PAS-008', 'PRO-004', 'ASI-004', 'SEC-002'),
    ('PAS-009', 'PRO-005', 'ASI-005', 'SEC-003'),
    ('PAS-010', 'PRO-005', 'ASI-005', 'SEC-004'),
    ('PAS-011', 'PRO-006', 'ASI-006', 'SEC-005'),
    ('PAS-012', 'PRO-006', 'ASI-006', 'SEC-006'),

    ('PAS-013', 'PRO-007', 'ASI-007', 'SEC-001'),
    ('PAS-014', 'PRO-007', 'ASI-007', 'SEC-002'),
    ('PAS-015', 'PRO-008', 'ASI-008', 'SEC-003'),
    ('PAS-016', 'PRO-008', 'ASI-008', 'SEC-004'),
    ('PAS-017', 'PRO-009', 'ASI-009', 'SEC-005'),
    ('PAS-018', 'PRO-009', 'ASI-009', 'SEC-006'),

    ('PAS-019', 'PRO-010', 'ASI-010', 'SEC-001'),
    ('PAS-020', 'PRO-010', 'ASI-010', 'SEC-002'),
    ('PAS-021', 'PRO-001', 'ASI-011', 'SEC-003'),
    ('PAS-022', 'PRO-002', 'ASI-011', 'SEC-004'),
    ('PAS-023', 'PRO-003', 'ASI-012', 'SEC-005'),
    ('PAS-024', 'PRO-004', 'ASI-012', 'SEC-006'),

    ('PAS-025', 'PRO-005', 'ASI-013', 'SEC-001'),
    ('PAS-026', 'PRO-006', 'ASI-013', 'SEC-002'),
    ('PAS-027', 'PRO-007', 'ASI-014', 'SEC-003'),
    ('PAS-028', 'PRO-008', 'ASI-014', 'SEC-004'),
    ('PAS-029', 'PRO-009', 'ASI-015', 'SEC-005'),
    ('PAS-030', 'PRO-010', 'ASI-015', 'SEC-006'),
    
    ('PAS-031', 'PRO-001', 'ASI-016', 'SEC-001'),
    ('PAS-032', 'PRO-002', 'ASI-016', 'SEC-002');

CREATE TABLE "Periodo_academico" (
  "id_periodo" varchar(25) NOT NULL,
  "nombre_periodo_a" varchar(100) NOT NULL,
  "fecha_inicio" date,
  "fecha_final" date,
  "estado" bool,
  PRIMARY KEY ("id_periodo")
);

INSERT INTO public."Periodo_academico" (id_periodo, nombre_periodo_a, fecha_inicio, fecha_final, estado) VALUES
    ('PER-001', 'Primer Periodo 2024', '2024-04-01', '2024-06-30', true),
    ('PER-002', 'Segundo Periodo 2024', '2024-07-01', '2024-09-30', true),
    ('PER-003', 'Tercer Periodo 2024', '2024-10-01', '2024-12-31', true);

CREATE TABLE "Semestre" (
  "id_semestre" varchar(25) NOT NULL,
  "numero_semestre" integer,
  PRIMARY KEY ("id_semestre")
);

INSERT INTO public."Semestre" (id_semestre, numero_semestre) VALUES
    ('SEM-001', 1),
    ('SEM-002', 2),
    ('SEM-003', 3),
    ('SEM-004', 4),
    ('SEM-005', 5);

CREATE TABLE "Semestre_Asignatura" (
  "id_semestre_asignatura" varchar(25) NOT NULL,
  "id_semestre" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  PRIMARY KEY ("id_semestre_asignatura"),
  CONSTRAINT "FK_Semestre_Asignatura.id_semestre"
    FOREIGN KEY ("id_semestre")
      REFERENCES "Semestre"("id_semestre"),
  CONSTRAINT "FK_Semestre_Asignatura.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura")
);

INSERT INTO public."Semestre_Asignatura" (id_semestre_asignatura, id_semestre, id_asignatura) VALUES
    ('SAS-001', 'SEM-001', 'ASI-001'),
    ('SAS-002', 'SEM-001', 'ASI-002'),
    ('SAS-003', 'SEM-001', 'ASI-003'),
    ('SAS-004', 'SEM-001', 'ASI-004'),
    ('SAS-005', 'SEM-001', 'ASI-005'),
    ('SAS-006', 'SEM-002', 'ASI-006'),
    ('SAS-007', 'SEM-002', 'ASI-007'),
    ('SAS-008', 'SEM-002', 'ASI-008'),
    ('SAS-009', 'SEM-002', 'ASI-009'),
    ('SAS-010', 'SEM-003', 'ASI-010'),
    ('SAS-011', 'SEM-003', 'ASI-011'),
    ('SAS-012', 'SEM-003', 'ASI-012'),
    ('SAS-013', 'SEM-004', 'ASI-013'),
    ('SAS-014', 'SEM-004', 'ASI-014'),
    ('SAS-015', 'SEM-005', 'ASI-015'),
    ('SAS-016', 'SEM-005', 'ASI-016');

CREATE TABLE "Inscripcion" (
  "id_inscripcion" serial primary key,
  "id_estudiante" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "id_periodo" varchar(25) NOT NULL,
  "id_seccion" varchar(25) NOT NULL,
  "estado" bool,
  CONSTRAINT "FK_Inscripcion.id_estudiante"
    FOREIGN KEY ("id_estudiante")
      REFERENCES "Estudiantes"("id_estudiante"),
  CONSTRAINT "FK_Inscripcion.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura"),
  CONSTRAINT "FK_Inscripcion.id_periodo"
    FOREIGN KEY ("id_periodo")
      REFERENCES "Periodo_academico"("id_periodo"),
  CONSTRAINT "FK_Inscripcion.id_seccion"
    FOREIGN KEY ("id_seccion")
      REFERENCES "Secciones"("id_seccion")
);

-- Insercion de registros de inscripcion para 67 estudiantes, excluyendo al equipo
INSERT INTO public."Inscripcion"(id_estudiante, id_asignatura, id_periodo, id_seccion, estado) VALUES 
    ('30276543', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('30276543', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('30276543', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('30276543', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('30365432', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('30365432', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('30365432', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('30365432', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('30454321', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('30454321', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('30454321', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('30454321', 'ASI-012', 'PER-001', 'SEC-004', false),

    ('30543210', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('30543210', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('30543210', 'ASI-015', 'PER-001', 'SEC-003', false),
    ('30543210', 'ASI-016', 'PER-001', 'SEC-004', false),

    ('30632109', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('30632109', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('30632109', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('30632109', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('30721098', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('30721098', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('30721098', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('30721098', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('30810987', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('30810987', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('30810987', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('30810987', 'ASI-012', 'PER-001', 'SEC-004', false),

    ('30000007', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('30000007', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('30000007', 'ASI-015', 'PER-001', 'SEC-003', false),
    ('30000007', 'ASI-016', 'PER-001', 'SEC-004', false),

    ('40810988', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('40810988', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('40810988', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('40810988', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('50810989', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('50810989', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('50810989', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('50810989', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('60810990', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('60810990', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('60810990', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('60810990', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('70810991', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('70810991', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('70810991', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('70810991', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('80810992', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('80810992', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('80810992', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('80810992', 'ASI-012', 'PER-001', 'SEC-004', false),

    ('90810993', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('90810993', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('90810993', 'ASI-015', 'PER-001', 'SEC-003', false),
    ('90810993', 'ASI-016', 'PER-001', 'SEC-004', false),

    ('10081094', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('10081094', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('10081094', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('10081094', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('11081095', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('11081095', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('11081095', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('11081095', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('12081096', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('12081096', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('12081096', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('12081096', 'ASI-012', 'PER-001', 'SEC-004', false),

    ('13081097', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('13081097', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('13081097', 'ASI-015', 'PER-001', 'SEC-003', false),
    ('13081097', 'ASI-016', 'PER-001', 'SEC-004', false),

    ('14081098', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('14081098', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('14081098', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('14081098', 'ASI-004', 'PER-001', 'SEC-004', false),

    ('15081099', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('15081099', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('15081099', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('15081099', 'ASI-008', 'PER-001', 'SEC-004', false),

    ('16081100', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('16081100', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('16081100', 'ASI-003', 'PER-001', 'SEC-003', false),

    ('17081101', 'ASI-004', 'PER-001', 'SEC-001', false),
    ('17081101', 'ASI-005', 'PER-001', 'SEC-002', false),
    ('17081101', 'ASI-006', 'PER-001', 'SEC-003', false),

    ('18081102', 'ASI-007', 'PER-001', 'SEC-001', false),
    ('18081102', 'ASI-008', 'PER-001', 'SEC-002', false),
    ('18081102', 'ASI-009', 'PER-001', 'SEC-003', false),

    ('19081103', 'ASI-010', 'PER-001', 'SEC-001', false),
    ('19081103', 'ASI-011', 'PER-001', 'SEC-002', false),
    ('19081103', 'ASI-012', 'PER-001', 'SEC-003', false),

    ('20081104', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('20081104', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('20081104', 'ASI-015', 'PER-001', 'SEC-003', false),

    ('21081105', 'ASI-016', 'PER-001', 'SEC-001', false),
    ('21081105', 'ASI-001', 'PER-001', 'SEC-002', false),
    ('21081105', 'ASI-002', 'PER-001', 'SEC-003', false),

    ('22081106', 'ASI-003', 'PER-001', 'SEC-001', false),
    ('22081106', 'ASI-004', 'PER-001', 'SEC-002', false),
    ('22081106', 'ASI-005', 'PER-001', 'SEC-003', false),

    ('30820987', 'ASI-006', 'PER-001', 'SEC-001', false),
    ('30820987', 'ASI-007', 'PER-001', 'SEC-002', false),
    ('30820987', 'ASI-008', 'PER-001', 'SEC-003', false),

    ('40820988', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('40820988', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('40820988', 'ASI-011', 'PER-001', 'SEC-003', false),

    ('50820989', 'ASI-012', 'PER-001', 'SEC-001', false),
    ('50820989', 'ASI-013', 'PER-001', 'SEC-002', false),
    ('50820989', 'ASI-014', 'PER-001', 'SEC-003', false),

    ('60820990', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('60820990', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('60820990', 'ASI-003', 'PER-001', 'SEC-003', false),

    ('70820991', 'ASI-004', 'PER-001', 'SEC-001', false),
    ('70820991', 'ASI-005', 'PER-001', 'SEC-002', false),
    ('70820991', 'ASI-006', 'PER-001', 'SEC-003', false),

    ('80820992', 'ASI-007', 'PER-001', 'SEC-001', false),
    ('80820992', 'ASI-008', 'PER-001', 'SEC-002', false),
    ('80820992', 'ASI-009', 'PER-001', 'SEC-003', false),

    ('90820993', 'ASI-010', 'PER-001', 'SEC-001', false),
    ('90820993', 'ASI-011', 'PER-001', 'SEC-002', false),
    ('90820993', 'ASI-012', 'PER-001', 'SEC-003', false),

    ('100820994', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('100820994', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('100820994', 'ASI-015', 'PER-001', 'SEC-003', false),

    ('110820995', 'ASI-016', 'PER-001', 'SEC-001', false),
    ('110820995', 'ASI-001', 'PER-001', 'SEC-002', false),
    ('110820995', 'ASI-002', 'PER-001', 'SEC-003', false),

    ('120820996', 'ASI-003', 'PER-001', 'SEC-001', false),
    ('120820996', 'ASI-004', 'PER-001', 'SEC-002', false),
    ('120820996', 'ASI-005', 'PER-001', 'SEC-003', false),

    ('130820997', 'ASI-006', 'PER-001', 'SEC-001', false),
    ('130820997', 'ASI-007', 'PER-001', 'SEC-002', false),
    ('130820997', 'ASI-008', 'PER-001', 'SEC-003', false),

    ('140820998', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('140820998', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('140820998', 'ASI-011', 'PER-001', 'SEC-003', false),

    ('150820999', 'ASI-012', 'PER-001', 'SEC-001', false),
    ('150820999', 'ASI-013', 'PER-001', 'SEC-002', false),
    ('150820999', 'ASI-014', 'PER-001', 'SEC-003', false),

    ('160821000', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('160821000', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('160821000', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('160821000', 'ASI-004', 'PER-001', 'SEC-004', false),
    ('160821000', 'ASI-005', 'PER-001', 'SEC-005', false),

    ('170821001', 'ASI-006', 'PER-001', 'SEC-001', false),
    ('170821001', 'ASI-007', 'PER-001', 'SEC-002', false),
    ('170821001', 'ASI-008', 'PER-001', 'SEC-003', false),
    ('170821001', 'ASI-009', 'PER-001', 'SEC-004', false),
    ('170821001', 'ASI-010', 'PER-001', 'SEC-005', false),

    ('180821002', 'ASI-011', 'PER-001', 'SEC-001', false),
    ('180821002', 'ASI-012', 'PER-001', 'SEC-002', false),
    ('180821002', 'ASI-013', 'PER-001', 'SEC-003', false),
    ('180821002', 'ASI-014', 'PER-001', 'SEC-004', false),
    ('180821002', 'ASI-015', 'PER-001', 'SEC-005', false),

    ('190821003', 'ASI-016', 'PER-001', 'SEC-001', false),
    ('190821003', 'ASI-001', 'PER-001', 'SEC-002', false),
    ('190821003', 'ASI-002', 'PER-001', 'SEC-003', false),
    ('190821003', 'ASI-003', 'PER-001', 'SEC-004', false),
    ('190821003', 'ASI-004', 'PER-001', 'SEC-005', false),

    ('200821004', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('200821004', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('200821004', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('200821004', 'ASI-008', 'PER-001', 'SEC-004', false),
    ('200821004', 'ASI-009', 'PER-001', 'SEC-005', false),

    ('210821005', 'ASI-010', 'PER-001', 'SEC-001', false),
    ('210821005', 'ASI-011', 'PER-001', 'SEC-002', false),
    ('210821005', 'ASI-012', 'PER-001', 'SEC-003', false),
    ('210821005', 'ASI-013', 'PER-001', 'SEC-004', false),
    ('210821005', 'ASI-014', 'PER-001', 'SEC-005', false),

    ('220821006', 'ASI-015', 'PER-001', 'SEC-001', false),
    ('220821006', 'ASI-016', 'PER-001', 'SEC-002', false),
    ('220821006', 'ASI-001', 'PER-001', 'SEC-003', false),
    ('220821006', 'ASI-002', 'PER-001', 'SEC-004', false),
    ('220821006', 'ASI-003', 'PER-001', 'SEC-005', false),

    ('40830987', 'ASI-004', 'PER-001', 'SEC-001', false),
    ('40830987', 'ASI-005', 'PER-001', 'SEC-002', false),
    ('40830987', 'ASI-006', 'PER-001', 'SEC-003', false),
    ('40830987', 'ASI-007', 'PER-001', 'SEC-004', false),
    ('40830987', 'ASI-008', 'PER-001', 'SEC-005', false),

    ('50830988', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('50830988', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('50830988', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('50830988', 'ASI-012', 'PER-001', 'SEC-004', false),
    ('50830988', 'ASI-013', 'PER-001', 'SEC-005', false),

    ('60830989', 'ASI-014', 'PER-001', 'SEC-001', false),
    ('60830989', 'ASI-015', 'PER-001', 'SEC-002', false),
    ('60830989', 'ASI-016', 'PER-001', 'SEC-003', false),
    ('60830989', 'ASI-001', 'PER-001', 'SEC-004', false),
    ('60830989', 'ASI-002', 'PER-001', 'SEC-005', false),

    ('70830990', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('70830990', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('70830990', 'ASI-003', 'PER-001', 'SEC-003', false),

    ('80830991', 'ASI-004', 'PER-001', 'SEC-001', false),
    ('80830991', 'ASI-005', 'PER-001', 'SEC-002', false),
    ('80830991', 'ASI-006', 'PER-001', 'SEC-003', false),

    ('90830992', 'ASI-007', 'PER-001', 'SEC-001', false),
    ('90830992', 'ASI-008', 'PER-001', 'SEC-002', false),
    ('90830992', 'ASI-009', 'PER-001', 'SEC-003', false),

    ('100830993', 'ASI-010', 'PER-001', 'SEC-001', false),
    ('100830993', 'ASI-011', 'PER-001', 'SEC-002', false),
    ('100830993', 'ASI-012', 'PER-001', 'SEC-003', false),

    ('110830994', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('110830994', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('110830994', 'ASI-015', 'PER-001', 'SEC-003', false),

    ('120830995', 'ASI-016', 'PER-001', 'SEC-001', false),
    ('120830995', 'ASI-001', 'PER-001', 'SEC-002', false),
    ('120830995', 'ASI-002', 'PER-001', 'SEC-003', false),

    ('130830996', 'ASI-003', 'PER-001', 'SEC-001', false),
    ('130830996', 'ASI-004', 'PER-001', 'SEC-002', false),
    ('130830996', 'ASI-005', 'PER-001', 'SEC-003', false),

    ('140830997', 'ASI-006', 'PER-001', 'SEC-001', false),
    ('140830997', 'ASI-007', 'PER-001', 'SEC-002', false),
    ('140830997', 'ASI-008', 'PER-001', 'SEC-003', false),

    ('150830998', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('150830998', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('150830998', 'ASI-011', 'PER-001', 'SEC-003', false),

    ('160830999', 'ASI-012', 'PER-001', 'SEC-001', false),
    ('160830999', 'ASI-013', 'PER-001', 'SEC-002', false),
    ('160830999', 'ASI-014', 'PER-001', 'SEC-003', false),

    ('170831000', 'ASI-001', 'PER-001', 'SEC-001', false),
    ('170831000', 'ASI-002', 'PER-001', 'SEC-002', false),
    ('170831000', 'ASI-003', 'PER-001', 'SEC-003', false),
    ('170831000', 'ASI-004', 'PER-001', 'SEC-004', false),
    ('170831000', 'ASI-005', 'PER-001', 'SEC-005', false),
    ('170831000', 'ASI-006', 'PER-001', 'SEC-006', false),

    ('180831001', 'ASI-007', 'PER-001', 'SEC-001', false),
    ('180831001', 'ASI-008', 'PER-001', 'SEC-002', false),
    ('180831001', 'ASI-009', 'PER-001', 'SEC-003', false),
    ('180831001', 'ASI-010', 'PER-001', 'SEC-004', false),
    ('180831001', 'ASI-011', 'PER-001', 'SEC-005', false),
    ('180831001', 'ASI-012', 'PER-001', 'SEC-006', false),

    ('190831002', 'ASI-013', 'PER-001', 'SEC-001', false),
    ('190831002', 'ASI-014', 'PER-001', 'SEC-002', false),
    ('190831002', 'ASI-015', 'PER-001', 'SEC-003', false),
    ('190831002', 'ASI-016', 'PER-001', 'SEC-004', false),
    ('190831002', 'ASI-001', 'PER-001', 'SEC-005', false),
    ('190831002', 'ASI-002', 'PER-001', 'SEC-006', false),

    ('200831003', 'ASI-003', 'PER-001', 'SEC-001', false),
    ('200831003', 'ASI-004', 'PER-001', 'SEC-002', false),
    ('200831003', 'ASI-005', 'PER-001', 'SEC-003', false),
    ('200831003', 'ASI-006', 'PER-001', 'SEC-004', false),
    ('200831003', 'ASI-007', 'PER-001', 'SEC-005', false),
    ('200831003', 'ASI-008', 'PER-001', 'SEC-006', false),

    ('210831004', 'ASI-009', 'PER-001', 'SEC-001', false),
    ('210831004', 'ASI-010', 'PER-001', 'SEC-002', false),
    ('210831004', 'ASI-011', 'PER-001', 'SEC-003', false),
    ('210831004', 'ASI-012', 'PER-001', 'SEC-004', false),
    ('210831004', 'ASI-013', 'PER-001', 'SEC-005', false),
    ('210831004', 'ASI-014', 'PER-001', 'SEC-006', false),

    ('220831005', 'ASI-015', 'PER-001', 'SEC-001', false),
    ('220831005', 'ASI-016', 'PER-001', 'SEC-002', false),
    ('220831005', 'ASI-001', 'PER-001', 'SEC-003', false),
    ('220831005', 'ASI-002', 'PER-001', 'SEC-004', false),
    ('220831005', 'ASI-003', 'PER-001', 'SEC-005', false),
    ('220831005', 'ASI-004', 'PER-001', 'SEC-006', false),

    ('230831006', 'ASI-005', 'PER-001', 'SEC-001', false),
    ('230831006', 'ASI-006', 'PER-001', 'SEC-002', false),
    ('230831006', 'ASI-007', 'PER-001', 'SEC-003', false),
    ('230831006', 'ASI-008', 'PER-001', 'SEC-004', false),
    ('230831006', 'ASI-009', 'PER-001', 'SEC-005', false),
    ('230831006', 'ASI-010', 'PER-001', 'SEC-006', false);

-- Creacion de la tabla nota estudiante
CREATE TABLE "Nota_estudiante" (
  "id_nota_estudiante" serial primary key,
  "id_estudiante" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "id_seccion" varchar(25) NOT NULL,
  "nota" float,
  CONSTRAINT "FK_Nota_estudiante.id_estudiante"
    FOREIGN KEY ("id_estudiante")
      REFERENCES "Estudiantes"("id_estudiante"),
  CONSTRAINT "FK_Nota_estudiante.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura"),
  CONSTRAINT "FK_Nota_estudiante.id_seccion"
    FOREIGN KEY ("id_seccion")
      REFERENCES "Secciones"("id_seccion")
);

-- Primero, asignamos notas aleatorias a los estudiantes existentes
INSERT INTO public."Nota_estudiante" (id_estudiante, id_asignatura, id_seccion, nota)
SELECT ins.id_estudiante, ins.id_asignatura, ins.id_seccion, FLOOR(RANDOM() * 20) + 1
FROM public."Inscripcion" ins;

-- Asignar notas más altas a algunos estudiantes específicos para garantizar que al menos 30 tengan promedios superiores a 16
UPDATE public."Nota_estudiante" ne
SET nota = FLOOR(RANDOM() * 5) + 16  -- Genera notas aleatorias entre 16 y 20
WHERE ne.id_estudiante IN (
    SELECT id_estudiante
    FROM public."Estudiantes"
    ORDER BY RANDOM()
    LIMIT 30  -- Selecciona 30 estudiantes al azar
);