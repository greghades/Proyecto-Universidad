SELECT numero_seccion,nombre_asignatura
FROM public."Asignaturas" a,public."Secciones" s, public."Profesor_asignatura_seccion" psa
WHERE psa.id_seccion = s.id_seccion AND
psa.id_asignatura = a.id_asignatura