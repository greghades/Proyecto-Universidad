CREATE TABLE "Universidad" (
  "id_universidad" varchar(25) NOT NULL,
  "nombre_universidad" varchar(100) NOT NULL,
  "direccion" varchar(150),
  PRIMARY KEY ("id_universidad")
);

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

CREATE TABLE "Asignaturas" (
  "id_asignatura" varchar(25) NOT NULL,
  "nombre_asignatura" varchar(100) NOT NULL,
  "pre_requisito" varchar(150),
  "credito" integer,
  "retirada" bool,
  PRIMARY KEY ("id_asignatura")
);

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


CREATE TABLE "Secciones" (
  "id_seccion" varchar(25) NOT NULL,
  "id_carrera" varchar(25) NOT NULL,
  "numero_seccion" integer,
  "limite_estudiantes" integer,
  PRIMARY KEY ("id_seccion"),
  CONSTRAINT "FK_Secciones.id_carrera"
    FOREIGN KEY ("id_carrera")
      REFERENCES "Carreras"("id_carrera")
);

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


CREATE TABLE "Periodo_academico" (
  "id_periodo" varchar(25) NOT NULL,
  "nombre_periodo_a" varchar(100) NOT NULL,
  "fecha_inicio" date,
  "fecha_final" date,
  "estado" bool,
  PRIMARY KEY ("id_periodo")
);

CREATE TABLE "Periodo_Asignatura" (
  "id_periodo_Asignatura" varchar(25) NOT NULL,
  "id_periodo" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  PRIMARY KEY ("id_periodo_Asignatura"),
  CONSTRAINT "FK_Periodo_Asignatura.id_periodo"
    FOREIGN KEY ("id_periodo")
      REFERENCES "Periodo_academico"("id_periodo"),
  CONSTRAINT "FK_Periodo_Asignatura.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura")
);


CREATE TABLE "Inscripcion" (
  "id_inscripcion" varchar(25) NOT NULL,
  "id_estudiante" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "id_periodo" varchar(25) NOT NULL,
  "id_seccion" varchar(25) NOT NULL,
  "numero_inscripcion" varchar(100) NOT NULL,
  "fecha_inscripcion" timestamp,
  "estado" bool,
  PRIMARY KEY ("id_inscripcion"),
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

CREATE TABLE "Nota_periodo" (
  "nota_periodo" varchar(25) NOT NULL,
  "id_estudiante" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  "id_periodo" varchar(25) NOT NULL,
  "id_seccion" varchar(25) NOT NULL,
  "nota" integer,
  PRIMARY KEY ("nota_periodo"),
  CONSTRAINT "FK_Nota_periodo.id_estudiante"
    FOREIGN KEY ("id_estudiante")
      REFERENCES "Estudiantes"("id_estudiante"),
  CONSTRAINT "FK_Nota_periodo.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura"),
  CONSTRAINT "FK_Nota_periodo.id_periodo"
    FOREIGN KEY ("id_periodo")
      REFERENCES "Periodo_academico"("id_periodo"),
  CONSTRAINT "FK_Nota_periodo.id_seccion"
    FOREIGN KEY ("id_seccion")
      REFERENCES "Secciones"("id_seccion")
);

INSERT INTO public."Universidad" (id_universidad,nombre_universidad,direccion) VALUES
	 ('0001','UCLA','Carrera 19 con Calle 8. Edificio Rectorado, Barquisimeto Estado Lara. Venezuela');
INSERT INTO public."Decanatos" (id_decanato,id_universidad,nombre_decanato,direccion,estado) VALUES
	 ('1','0001','DCYT','Avenida las Industrias, Barquisimeto 3001, Lara',true);
INSERT INTO public."Carreras" (id_carrera,id_decanato,nombre_carrera,modalidad,estado,duracion) VALUES
	 ('1','1','Ingenieria en Informatica','Presencial',true,5),
	 ('2','1','Ingenieria en Produccion','Presencial',true,5),
	 ('3','1','Licenciatura en Matematicas','Presencial',true,5);
INSERT INTO public."Asignaturas" (id_asignatura,nombre_asignatura,pre_requisito,credito,retirada) VALUES
	 ('1','Matematica I',NULL,4,NULL),
	 ('2','Estructuras Discretas I',NULL,4,NULL),
	 ('3','Técnicas de Estudio ',NULL,2,NULL),
	 ('4','Teoría de la Administración',NULL,4,NULL),
	 ('5','Problemática del Desarrollo',NULL,3,NULL),
	 ('6','Aprendizaje Basado en Proceso',NULL,2,NULL),
	 ('7','Matematica II','1',4,NULL),
	 ('8','Técnicas de Investigación ','3',2,NULL);

INSERT INTO public."Estudiantes" (id_estudiante,id_carrera,nombre_completo,edad,correo,direccion,sexo,estado) VALUES
	 ('28047103','1','Gregori José Yepez Arteaga',22,'gregjose2513@gmail.com','Av.Bolivar Sector Camino Nuevo','Masculino',true),
	 ('28268078','1','Albani Gabriela Barragan Cuenca',22,'1001.28268078.ucla@gmail.com','Cabudare, Barquisimeto','Femenino',true),
	 ('29561929','1','Yaslin Maria Vreugdenhil Torres',22,'1001.29561929.ucla@gmail.com','Yaritagua','Femenino',true),
	 ('28245373','1','Ernesto Manuel Contreras Rodriguez',23,'1001.28245373.ucla@gmail.com','Av.Bolivar Sector Camino Nuevo','Masculino',true),
	 ('27539960','2','Luis Patricio Carrillo Musiala',25,'1001.27539960.ucla@gmail.com','Av 20, Barquisimeto','Masculino',true);
INSERT INTO public."Secciones" (id_seccion,id_carrera,numero_seccion,limite_estudiantes) VALUES
	 ('1','1',1,30),
	 ('2','1',2,30);
INSERT INTO public."Periodo_academico" (id_periodo,nombre_periodo_a,fecha_inicio,fecha_final,estado) VALUES
	 ('1','Semestre I','2023-12-12','2024-06-12',true);
	 
INSERT INTO public."Profesor"(id_profesor, nombre_completo, edad, correo, sexo, especialidad) VALUES 
('P01', 'Dilcia Amaya', 34, 'damaya@gmail.com', 'F', 'Licenciatura en Matematicas'),
('P55', 'Lorena Alvarez', 48, 'alvarezlore@gmail.com', 'F', 'Ingenieria en informatica'),
('P05', 'Jesus Rodriguez', 34, 'jesusito@gmail.com', 'M', 'Licenciatura en Matematicas');

INSERT INTO public."Asignaturas_carrera" (id_asignatura_carrera,id_carrera,id_asignatura) VALUES
('1', '1', '1'), -- Matematica I
('2', '1', '2'), -- Estructuras Discretas I
('3', '1', '3'), -- Técnicas de Estudio
('4', '1', '7'), -- Matematica II (requiere Matematica I)

-- Asignaturas para la carrera 'Ingenieria en Produccion' (id_carrera 2):
('5', '2', '4'), -- Teoría de la Administración
('6', '2', '5'), -- Problemática del Desarrollo
('7', '2', '6'), -- Aprendizaje Basado en Proceso
('8', '2', '8');