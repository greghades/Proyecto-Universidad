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
    ('30810987','CAR-001','Ana Sofia Lopez',21,'aslopez@ucla.edu','Urb. La Granja, Barquisimeto','Femenino',true);

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
  "nombre_semestre" varchar(25) NOT NULL,
  PRIMARY KEY ("id_semestre")
);

INSERT INTO public."Semestre" (id_semestre, nombre_semestre) VALUES
    ('SEM-001', 'Semestre I'),
    ('SEM-002', 'Semestre II'),
    ('SEM-003', 'Semestre III'),
    ('SEM-004', 'Semestre IV'),
    ('SEM-005', 'Semestre V');

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

CREATE TABLE "Nota_estudiante" (
  "id_nota_estudiante" serial primary key,
  "id_estudiante" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "nota" float,
  CONSTRAINT "FK_Nota_estudiante.id_estudiante"
    FOREIGN KEY ("id_estudiante")
      REFERENCES "Estudiantes"("id_estudiante"),
  CONSTRAINT "FK_Nota_estudiante.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura")
);