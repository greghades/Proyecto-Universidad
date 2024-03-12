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
  "correo" varchar(25) NOT NULL,
  "sexo" varchar(10) NOT NULL,
  "especialidad" varchar(25),
  "estado" bool,
  PRIMARY KEY ("id_profesor")
);

CREATE TABLE "Estudiantes" (
  "id_estudiante" varchar(25) NOT NULL,
  "id_carrera" varchar(25) NOT NULL,
  "nombre_completo" varchar(30) NOT NULL,
  "edad" integer,
  "correo" varchar(25) NOT NULL,
  "direccion" varchar(25) NOT NULL,
  "sexo" varchar(10) NOT NULL,
  "estado" bool,
  PRIMARY KEY ("id_estudiante"),
  CONSTRAINT "FK_Estudiantes.id_carrera"
    FOREIGN KEY ("id_carrera")
      REFERENCES "Carreras"("id_carrera")
);

CREATE TABLE "Profesor_seccion" (
  "id_profesor_asignatura" varchar(25) NOT NULL,
  "id_profesor" varchar(25) NOT NULL,
  "id_asignatura" varchar(25) NOT NULL,
  PRIMARY KEY ("id_profesor_asignatura"),
  CONSTRAINT "FK_Profesor_seccion.id_profesor"
    FOREIGN KEY ("id_profesor")
      REFERENCES "Profesor"("id_profesor"),
  CONSTRAINT "FK_Profesor_seccion.id_asignatura"
    FOREIGN KEY ("id_asignatura")
      REFERENCES "Asignaturas"("id_asignatura")
);

CREATE TABLE "Secciones" (
  "id_seccion" varchar(25) NOT NULL,
  "id_carrera" varchar(25) NOT NULL,
  "id_profesor" varchar(25) NOT NULL,
  "numero_seccion" integer,
  "limite_estudiantes" integer,
  PRIMARY KEY ("id_seccion"),
  CONSTRAINT "FK_Secciones.id_carrera"
    FOREIGN KEY ("id_carrera")
      REFERENCES "Carreras"("id_carrera"),	
  CONSTRAINT "FK_Secciones.id_profesor"
    FOREIGN KEY ("id_profesor")
      REFERENCES "Profesor"("id_profesor")
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
