SELECT nombre_asignatura, COUNT(s.id_seccion) as Seciones
FROM public."Asignaturas" a, public."Secciones" s, public."Profesor_asignatura_seccion" psa
WHERE psa.id_seccion = s.id_seccion AND
psa.id_asignatura = a.id_asignatura
GROUP BY nombre_asignatura;
