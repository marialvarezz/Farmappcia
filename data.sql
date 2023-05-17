INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Diabetes', 'Enfermedad metabólica', 'Niveles elevados de azúcar en la sangre', 'Sed excesiva, micción frecuente, cansancio');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Hipertensión', 'Enfermedad cardiovascular', 'Presión arterial alta', 'Dolor de cabeza, mareos, visión borrosa');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Asma', 'Enfermedad respiratoria', 'Inflamación de las vías respiratorias', 'Tos, sibilancias, dificultad para respirar');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Artritis', 'Enfermedad reumática', 'Inflamación de las articulaciones', 'Dolor, rigidez, hinchazón en las articulaciones');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Epilepsia', 'Enfermedad neurológica', 'Actividad cerebral anormal que causa convulsiones', 'Convulsiones, pérdida de conciencia, confusión');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Depresión', 'Enfermedad mental', 'Trastorno del estado de ánimo', 'Tristeza, apatía, pérdida de interés en actividades cotidianas');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Ansiedad', 'Enfermedad mental', 'Trastorno de ansiedad generalizada', 'Preocupación excesiva, nerviosismo, miedo irracional');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Cáncer de mama', 'Enfermedad oncológica', 'Tumor maligno en los tejidos del seno', 'Bulto en el seno, cambios en la textura de la piel, secreción del pezón');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Enfermedad de Parkinson', 'Enfermedad neurológica', 'Trastorno del movimiento', 'Temblores, rigidez, lentitud de movimiento');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Sida', 'Enfermedad infecciosa', 'Infección crónica causada por el VIH', 'Fatiga, fiebre, sudores nocturnos, pérdida de peso');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Osteoporosis', 'Enfermedad ósea', 'Pérdida de densidad ósea', 'Dolor óseo, fracturas frecuentes, postura encorvada');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Enfermedad de Alzheimer', 'Enfermedad neurológica', 'Trastorno neurodegenerativo', 'Pérdida de memoria');
INSERT INTO enfermedades (nombre, tipo, descripcion, sintomas)
VALUES ('Gripe', 'Enfermedad infecciosa', 'Infección viral común que afecta el sistema respiratorio', 'Fiebre, tos, dolor de cabeza');


INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Paracetamol', 'Analgésico y antipirético', 'paracetamol.png', 'Paracetamol', 'Vía oral', 'Dolor de cabeza, fiebre', 'Tomar con comida');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Ibuprofeno', 'Antiinflamatorio no esteroideo', 'ibuprofeno.png', 'Ibuprofeno', 'Vía oral', 'Dolor muscular, dolor de cabeza, fiebre', 'No tomar en ayunas');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Loratadina', 'Antihistamínico', 'loratadina.png', 'Loratadina', 'Vía oral', 'Rinitis, urticaria', 'Tomar antes de dormir');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Omeprazol', 'Inhibidor de la bomba de protones', 'omeprazol.png', 'Omeprazol', 'Vía oral', 'Acidez estomacal', 'Tomar en ayunas');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Acetaminofén', 'Analgésico y antipirético', 'acetaminofen.png', 'Acetaminofén', 'Vía oral', 'Dolor de cabeza, fiebre', 'Tomar con agua');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Clonazepam', 'Benzodiazepina', 'clonazepam.png', 'Clonazepam', 'Vía oral', 'Ansiedad, convulsiones', 'Puede causar somnolencia');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Atorvastatina', 'Inhibidor de la HMG-CoA reductasa', 'atorvastatina.png', 'Atorvastatina', 'Vía oral', 'Reducción del colesterol', 'Tomar antes de dormir');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Metformina', 'Antidiabético oral', 'metformina.png', 'Metformina', 'Vía oral', 'Control de la glucemia', 'Tomar con comida');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Amoxicilina', 'Antibiótico', 'amoxicilina.png', 'Amoxicilina', 'Vía oral', 'Infecciones bacterianas', 'Tomar con agua');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Losartán', 'Antagonista del receptor de angiotensina II', 'losartan.png', 'Losartán', 'Vía oral', 'Control de la presión arterial', 'Tomar antes de dormir');
INSERT INTO medicine (name, description, image, components, administer, efects, misc) VALUES
('Diazepam', 'Medicamento ansiolítico y sedante', 'diazepam.jpg', 'Diazepam 10mg', 'Vía oral', 'Sedación, relajación muscular, disminución de ansiedad', 'Puede causar somnolencia y mareo');

INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuál es su edad?', 'Menor de 18 años', '18 a 25 años', '26 a 35 años', '36 a 50 años', 'Más de 50 años', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Tiene alguna enfermedad crónica?',  'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuántas veces al día come verduras?',  'Nunca', '1 a 2 veces', '3 a 4 veces', '5 o más veces', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuántas veces al día come frutas?',  'Nunca', '1 a 2 veces', '3 a 4 veces', '5 o más veces', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuántas veces a la semana hace ejercicio?', 'Nunca', '1 a 2 veces', '3 a 4 veces', '5 o más veces', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuántas horas al día pasa sentado?',  'Menos de 2 horas', '2 a 4 horas', '4 a 6 horas', 'Más de 6 horas', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Cuántas horas al día duerme?',  'Menos de 5 horas', '5 a 7 horas', '7 a 9 horas', 'Más de 9 horas', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Fuma?',  'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Toma alcohol?',  'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta,  option1, option2, option3, option4, option5, fecha_insert, fecha_update) VALUES ('¿Tiene alergias?',  'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Realiza chequeos médicos periódicamente?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Consume alimentos procesados regularmente?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Sabe identificar los síntomas de un ataque al corazón?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Ha tenido algún episodio de mareo o desmayo?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Consume suplementos vitamínicos regularmente?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Cuántas veces al día cepilla sus dientes?', 'Una vez', 'Dos veces', 'Tres veces', 'Más de tres veces', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Ha sido diagnosticado con diabetes?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Ha experimentado cambios repentinos de peso?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Sufre de insomnio?', 'Sí', 'No', '', '', '', NOW(), NOW());
INSERT INTO questions (pregunta, option1, option2, option3, option4, option5, fecha_insert, fecha_update)
VALUES ('¿Ha tenido alguna cirugía en los últimos 5 años?', 'Sí', 'No', '', '', '', NOW(), NOW());