-- Insertar marcas
INSERT INTO marca (nombre) VALUES ('NARA');
INSERT INTO marca (nombre) VALUES ('VISA');
INSERT INTO marca (nombre) VALUES ('AMEX');

-- Insertar tarjetas asociadas a las marcas
INSERT INTO tarjeta (card_holder, fecha_vencimiento, numero, marca_id) VALUES ('Matias Batista', '2024-03-01', '1233425435', 1); -- Asociado a NARA
INSERT INTO tarjeta (card_holder, fecha_vencimiento, numero, marca_id) VALUES ('Ricardo Albornoz', '2024-03-01', '546457654756', 2); -- Asociado a VISA
INSERT INTO tarjeta (card_holder, fecha_vencimiento, numero, marca_id) VALUES ('Duarte Minutos', '2027-03-01', '1233425435', 3); -- Asociado a AMEX

-- Insertar operaciones asociadas a las tarjetas
INSERT INTO operacion (monto, tarjeta_id) VALUES (900, 1); -- Asociado a Matias Batista (NARA)
INSERT INTO operacion (monto, tarjeta_id) VALUES (900, 2); -- Asociado a Ricardo Albornoz (VISA)
INSERT INTO operacion (monto, tarjeta_id) VALUES (900, 3); -- Asociado a Duarte Minutos (AMEX)
